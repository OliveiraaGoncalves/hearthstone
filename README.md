# Hearthstone



## Índice

- [Visão Geral](#visão-geral)
- [Principais Características](#principais-características)
- [Pré-requisitos](#pré-requisitos)

## Visão Geral

O projeto "Hearthstone" é uma aplicação Android que tem como objetivo demonstrar a aplicação dos princípios da Clean Architecture em um projeto modularizado, fazendo uso do JetPack Navigation e interações HTTP. Inspirado no popular jogo de cartas "Hearthstone", este aplicativo é uma representação simplificada que permite aos usuários explorar cartas e personagens do jogo.

## Principais Características:

**Clean Architecture:** O projeto Hearthstone é desenvolvido seguindo a Clean Architecture, uma abordagem que busca separar as preocupações e responsabilidades do código em camadas distintas: apresentação (UI), casos de uso (Use Cases), domínio (Entidades e Regras de Negócio) e dados (Gateways de Interface Externa). Essa arquitetura limpa promove a escalabilidade, manutenibilidade e testabilidade do aplicativo.

<img width="894" alt="Captura de Tela 2023-08-12 às 10 22 56" src="https://github.com/OliveiraaGoncalves/hearthstone/assets/20058035/bfd79052-960e-4178-a24d-7b22bd19e3a2">


**Modularização:** O aplicativo Hearthstone é dividido em módulos independentes, cada um representando um componente ou funcionalidade específica. Essa modularização permite o desenvolvimento paralelo de diferentes partes do aplicativo, facilitando a colaboração entre equipes e a reutilização de código.

<img width="844" alt="Captura de Tela 2023-08-05 às 10 59 24" src="https://github.com/OliveiraaGoncalves/hearthstone/assets/20058035/9597aa95-43ff-4bec-be39-44a95becae9f">

**JetPack Navigation:** O projeto utiliza o componente de navegação do JetPack para gerenciar a navegação entre as diferentes telas e fragmentos do aplicativo de forma simples e declarativa. Isso garante uma experiência de usuário fluída e coerente durante a interação com o aplicativo.

**Interações HTTP:** O aplicativo Hearthstone interage com uma API RESTful para obter informações sobre cartas e personagens do jogo. Essas interações HTTP são realizadas de forma organizada, seguindo as boas práticas de comunicação com serviços externos.

## Pré-requisitos

Ter o ambiente de desenvolvimento configurado localmente utilizando java-11+

clonar repo:

```bash
git clone https://github.com/OliveiraaGoncalves/hearthstone.git
