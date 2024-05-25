package com.example.marvelapp.core.di

import com.example.marvelapp.BuildConfig
import com.example.marvelapp.core.data.api.CharacterService
import com.example.marvelapp.features.home.domain.datasource.CharactersDataSource
import com.example.marvelapp.features.home.data.datasource.CharactersDataSourceImpl
import com.example.marvelapp.features.home.data.repository.CharactersRepositoryImpl
import com.example.marvelapp.features.home.domain.repository.CharactersRepository
import com.example.marvelapp.features.home.domain.useCase.GetCharactersUseCase
import com.example.marvelapp.features.home.domain.useCase.GetCharactersUseCaseImpl
import com.example.marvelapp.features.home.presentation.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): CharacterService {
        return retrofit.create(CharacterService::class.java)
    }

    @Provides
    @Singleton
    fun providesCharactersDataSource(apiService: CharacterService): CharactersDataSource {
        return CharactersDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesHomeRepository(homeDataSource: CharactersDataSource): CharactersRepository {
        return CharactersRepositoryImpl(homeDataSource)
    }

    @Provides
    @Singleton
    fun providesGetCharactersUseCase(charactersRepository: CharactersRepository): GetCharactersUseCase {
        return GetCharactersUseCaseImpl(charactersRepository)
    }

    @Provides
    @Singleton
    fun providesHomeViewModel(getCharactersUseCase: GetCharactersUseCase): HomeViewModel {
        return HomeViewModel(getCharactersUseCase)
    }
}