# API CRUD de pessoas

Esta é uma API RESTful de CRUD para gerenciar informações de pessoas com contatos. Foi desenvolvida usando o framework Spring Boot, PostgreSQL como banco de dados.

## Configuração

Certifique-se de ter a [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) instalada.

### Banco de Dados

1. Instale o PostgreSQL e crie um banco de dados chamado `people`.
2. Configure as informações de conexão com o banco de dados no arquivo `application.properties` ou `application.yml`, localizado no diretório `src/main/resources`. Por exemplo:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/people
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Executando a aplicação

1. Abra o projeto.
2. Certifique-se de ter as extensões do Spring Boot instaladas (como `Spring Boot Tools`).
3. Execute a aplicação através da opção de build e run disponível na IDE ou execute o seguinte comando no terminal:

```
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Endpoints

A API possui os seguintes endpoints:

- `GET /api/person`: Retorna todas as pessoas cadastradas.
- `GET /person/{id}`: Retorna os detalhes de uma pessoa específica.
- `POST /person`: Cria uma nova pessoa.
- `PUT /person/{id}`: Atualiza os dados de uma pessoa existente.
- `DELETE /person/{id}`: Remove uma pessoa existente.

Os dados são enviados e retornados no formato JSON.

