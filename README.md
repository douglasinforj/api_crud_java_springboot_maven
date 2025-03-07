# API de Cadastro de Pessoas com Spring Boot

## Descrição
Esta é uma API REST desenvolvida em Java com Spring Boot para gerenciar um cadastro de pessoas com os seguintes campos:
- Nome
- Telefone
- Email
A API permite operações CRUD (Create, Read, Update, Delete) para manipulação de registros no banco de dados.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.2
- Spring Data JPA
- Banco de Dados H2
- Lombok (para reduzir código boilerplate)
- Maven (gerenciamento de dependências)

## Estrutura do Projeto
`
springboot-pessoas-api
│── src
│   ├── main
│   │   ├── java/com/example/pessoas
│   │   │   ├── controller
│   │   │   │   ├── PessoaController.java
│   │   │   ├── model
│   │   │   │   ├── Pessoa.java
│   │   │   ├── repository
│   │   │   │   ├── PessoaRepository.java
│   │   │   ├── service
│   │   │   │   ├── PessoaService.java
│   │   │   ├── PessoasApplication.java
│   ├── resources
│   │   ├── application.properties
│── pom.xml
│── README.md

`

## Configuração do Banco de Dados
A API está configurada para usar o banco H2 em memória para testes.

- Arquivo: src/main/resources/application.properties
`
spring.datasource.url=jdbc:h2:mem:pessoasdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

`