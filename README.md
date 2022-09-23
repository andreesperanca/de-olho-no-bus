<h1 align="center">:oncoming_bus: DE OLHO NO BUS :oncoming_bus: </h1>

Tabela de conteúdos
=================
<!--ts-->
   * [Fotos](#screenshots-camera)
   * [Sobre](#sobre-book)
   * [Tecnologias](#tecnologias-rocket)
   * [Funções](#funções-hammer_and_wrench)
   * [Como rodar o projeto](#como-rodar-o-projeto-game_die) 
   * [Autor](#autor) 
<!--te-->

## Screenshots :camera: 
<h1 align="center">
  <img style="border-radius: 50%;" src="./assets/buscarPorLinhas.png" width="250px;" alt=""/>
  <img style="border-radius: 50%;" src="./assets/buscarParadas.png" width="250px;" alt=""/>
  <img style="border-radius: 50%;" src="./assets/detalhesLinhas.png" width="250px;" alt=""/>
  <img style="border-radius: 50%;" src="./assets/detalhesParadas.png" width="250px;" alt=""/>
  <img style="border-radius: 50%;" src="./assets/previsoes.png" width="250px;" alt=""/>
  <img style="border-radius: 50%;" src="./assets/favoritos.png" width="250px;" alt=""/>
  </h1>

## Sobre :book:
O aplicativo é capaz de trazer ao usuário informações relevantes das linhas e paradas de ônibus do Estado de São Paulo.

## Funções :hammer_and_wrench:
- [x] Buscar linhas por nome/número.
- [x] Detalhes de linhas e todas as paradas da mesma.
- [x] Mostrar no mapa as últimas localizações das linhas.
- [x] Previsões de chegada das linhas em cada ponto de parada.
- [x] Informa se as linhas tem suporte para PCDs.
- [x] Opção de favoritar linhas.
- [x] Buscar paradas por código de linha, nome/endereço ou código de corredor.
- [x] Detalhes de paradas e todas as linhas que passam por ela.
- [x] Mostrar no mapa as paradas.
- [x] Opção de favoritar paradas.

## Técnicas 🛠 
- [x] Integração REST com Retrofit + OkHttpClient.
- [x] Arquitetura MVVM.
- [x] Jetpack Components (ViewModel, LiveData, LifeCycle, Room, Data Binding, Navigation)
- [x] Injeção de dependências com Hilt.
- [x] Room para persistência de dados local;
- [x] Navigation Component para sistema de navegação de telas;
- [x] Higher Orders Functions.
- [x] Generics.
- [x] Inline Functions.

## Tecnologias :rocket:
As seguintes ferramentas foram utilizadas no desenvolvimento do projeto:
- [Kotlin](https://kotlinlang.org/)
- [Google Maps](https://mapsplatform.google.com/)
- [Retrofit](https://square.github.io/retrofit/)
- [OkHttpClient](https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/)

## Como rodar o projeto :game_die:
Será necessário ter duas chaves de apis: <br />
CHAVE DE API DO OLHO VIVO que pode ser obtida [AQUI.](https://www.sptrans.com.br/desenvolvedores/api-do-olho-vivo-guia-de-referencia/) <br />
CHAVE DE API GOOGLE MAPS que pode ser obtida [AQUI.](https://mapsplatform.google.com/) <br />

Para rodar o aplicativo será necessário abri-lo no Android Studio, mas antes colocar suas chaves de api. <br />

Chave da API DO OLHO VIVO -> em com.andreesperanca.deolhonobus.util.ConstantsProject substitua da seguinte forma: <br />
const val API_KEY = "SUA_API_KEY" <br />

Chave do Google Maps -> em local.properties substitua da seguinte forma:  <br />
MAPS_API_KEY = SUA_API_KEY <br />

## Autor
Feito por André Esperança!

Contatos :
[![Linkedin Badge](https://img.shields.io/badge/-André-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/andr%C3%A9-esperan%C3%A7a-34021a235/)](https://www.linkedin.com/in/andr%C3%A9-esperan%C3%A7a-34021a235/) 
[![Gmail Badge](https://img.shields.io/badge/-andreluizesperancacorreia@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:andreesperanca2010@gmail.com)](mailto:andreluizesperancacorreia@gmail.com)

<a href="https://github.com/andreesperanca">
 <br /> 
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/andreesperanca" width="100px;" alt=""/>
 <br />
  <a href="https://github.com/andreesperanca" title="">André Esperança</a>

