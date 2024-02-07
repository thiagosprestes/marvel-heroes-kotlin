<h1 align="center">
<br>
  <img src=".github/logo.png" width="auto" height="70" alt="marvel-heroes-app">
<br>
<br>
Marvel Heroes App
</h1>

<p align="center">Aplicativo simples que lista personagens da Marvel e suas informações como biografia, níveis de habilidade e participações em filmes.</p>

<div>
  <img src=".github/cover.png" alt="marvel-heroes-app">
</div>

# 📋 Índice

- [Telas](#-Telas)
- [Sobre o projeto](#-Sobre-o-projeto)
- [Tecnologias utilizadas](#-Tecnologias-utilizadas)
- [Rodando o projeto](#-Rodando-o-projeto)
  - [Pré-requisitos](#-Pré-requisitos)
  - [Rodando o server](#-Rodando-o-server)
  - [Rodando o aplicativo mobile](#-Rodando-o-aplicativo-mobile)

## 🎨 Telas

<img src="marvel-heroes-app.gif" alt="marvel-heroes-app">

## 📃 Sobre o projeto

Aplicativo proposto como desafio pela <a href="https://umpontoseis.com/" target="_blank">umpontoseis</a> no site de desafios <a href="https://devchallenge.now.sh" target="_blank">DevChallenge</a> onde objetivo é desenvolver um app que liste alguns personagens da Marvel e suas caracteristicas, tudo isso seguindo o design proposto proposto e utilizando os dados fornecidos.

## 🛠 Tecnologias utilizadas

- K **Kotlin** — Aplicativo mobile
- 📱 **Jetpack compose** — UI
- 📡 **Retrofit** — Chamadaas para a API
- 💉 **Hilt** — Injeção de dependência
- 🛳️ **HilNavCompose** — Navegação
- 🕛 **Coroutines** — Chamadas assincronas
- 🖼️ **Coil** — Carregamento e manipulação de imagens vindas da API

## 🚀 Rodando o projeto

### Pré-requisitos

- Git
- NodeJS

Antes de rodarmos o app precisamos rodar o contéudo da pasta server, é uma pasta com estrutura simples onde estão concentrados os arquivos responsáveis por simular uma API com JSON Server

### 💻 Rodando o server

Clone o repositório

```bash

# Clona o repositório
git clone https://github.com/thiagosprestes/Marvel-heroes-kotlin.git

```

Navegue até a pasta do projeto clonado e execute os comandos abaixo

```bash

# Entra na pasta do server
cd server


# Troque a linha SEU_ENDEREÇO_DE_IP pelo endereço de IP do seu computador

# Inicia o server
npx json-server application.json --host SEU_ENDEREÇO_DE_IP -p 3333

# Acesse http://localhost:3333 para acessar o servidor caso deseje

```

### 📱 Rodando o aplicativo mobile

1 - Abra a pasta raiz do projeto no Android Studio
2 - Localize o arquivo `local.properties`
3 - Adicione a seguinte linha:
`BASE_URL="http://SEU_ENDEREÇO_DE_IP:3333/"`
4 - Rode o app
