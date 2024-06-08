# Desafio Técnico - Backend: PicPay Simplificado

Olá! 👋 Meu nome é Nando Gabriel e esta é minha solução para o desafio técnico do PicPay Simplificado.

## Visão Geral

Neste projeto, desenvolvi uma aplicação backend de acordo com o desafio proposto pelo PicPay Simplificado, seguindo os requisitos fornecidos no desafio. Optei por utilizar Java devido à minha experiência prévia e para prática da linguagem.

[Link do repositório](https://github.com/PicPay/picpay-desafio-backend)

## Tecnologias Utilizadas

- **Java Spring Boot**: Para o desenvolvimento da aplicação.
- **MySQL**: Banco de dados relacional para armazenamento das informações.

## Principais Escolhas e Considerações

- **Framework Escolhido**: Optei por utilizar Spring Boot devido à sua robustez e ecossistema.
- **Padrões de Design**: Utilizei padrões de design como Factory Method e Builder para construções dos meus objetos.

## Como Executar o Projeto

### Execução com Docker

1. **Pré-requisitos**:
    - Docker instalado na máquina.

2. **Passos**:
    - Clone o repositório:
      ```bash
      git clone https://github.com/PicPay/picpay-desafio-backend.git
      cd picpay-desafio-backend
      ```
    - Execute o comando para iniciar os containers:
      ```bash
      docker-compose up
      ```

### Execução Local (Desenvolvimento)

1. **Pré-requisitos**:
    - Java 17 instalado.
    - MySQL 8 instalado e configurado.

2. **Passos**:
    - Clone o repositório:
      ```bash
      git clone https://github.com/PicPay/picpay-desafio-backend.git
      cd picpay-desafio-backend
      ```
    - Configure o banco de dados MySQL com as credenciais apropriadas no arquivo `src/main/resources/application-dev.properties`.
    - Rode o script picpay.sql dentro da pasta `docker-entrypoint-initdb.d` para criar as tabelas.
    - Execute o projeto usando um IDE (como IntelliJ ou Eclipse) ou via linha de comando:
      ```bash
      ./mvnw spring-boot:run
      ```

### Alteração de Ambiente (Produção vs Desenvolvimento)

A mudança entre os ambientes de produção e desenvolvimento é feita dentro do arquivo `application.properties`.

- **Para Produção**:
  Configure para utilizar o perfil de produção.
  ```properties
  spring.profiles.active=prod

- **Para Desenvolvimento**:
  Configure para utilizar o perfil de produção.
  ```properties
  spring.profiles.active=dev

## Pontos de Melhoria

Durante o desenvolvimento, identifiquei alguns pontos que poderiam ser melhorados:

- Criação de microservices para tratar envios de E-MAIL e SMS
- Usar um sistema de menssgeria (RABBITMQ ou KAFKA) para comunicar com serviço de e-mail


## Contato

Se tiver alguma dúvida ou feedback sobre minha solução, fique à vontade para entrar em contato comigo pelo email eng.nandogabriel@gmail.com ou pelo meu perfil do [LinkedIn](https://www.linkedin.com/in/nando-gabriel/).