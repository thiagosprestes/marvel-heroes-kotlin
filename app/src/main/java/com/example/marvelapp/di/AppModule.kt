package com.example.marvelapp.di

import com.example.marvelapp.AppConstants
import com.example.marvelapp.data.api.ApiService
import com.example.marvelapp.data.datasource.CharactersDataSource
import com.example.marvelapp.data.datasource.CharactersDataSourceImpl
import com.example.marvelapp.ui.repository.HomeRepository
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }

        httpClient.apply {
            readTimeout(60, TimeUnit.SECONDS)
        }

        val moshi =
            Moshi.Builder().add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
                .build()

        return Retrofit.Builder()
            .baseUrl(AppConstants.APP_BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesCharactersDataSource(apiService: ApiService): CharactersDataSource {
        return CharactersDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesHomeRepository(homeDataSource: CharactersDataSource): HomeRepository {
        return HomeRepository(homeDataSource)
    }
}