# SpringBukiAPI
API RESTful em Spring Boot com Segurança, JPA, Hibernate e MySQL
## Descrição:

Esta API RESTful foi desenvolvida em Spring Boot, utilizando Spring Security para autenticação e autorização de usuários, JPA e Hibernate para acesso a dados e MySQL como banco de dados.
## Funcionalidades:

- Autenticação: Login com base em username e password.
- Autorização: Controle de acesso a recursos da API através de roles.
- CRUD: Operações básicas de CRUD (Create, Read, Update, Delete) em entidades.
- Validação: Validação de entrada de dados com mensagens de erro personalizadas.
## Tecnologias:

Spring Boot: Framework para desenvolvimento de APIs em Java.
Spring Security: Framework para autenticação e autorização de usuários.
JPA: Interface de abstração para acesso a dados.
Hibernate: Implementação JPA para mapeamento objeto-relacional.
MySQL: Banco de dados relacional.
## Pré-requisitos:

Java 17 ou superior
Maven 3.8 ou superior
MySQL 8.0 ou superior
Instalação:

Clone o repositório:
```
git clone https://github.com/IsaqueCruzDev/SpringBukiAPI.git
```

Instale as dependências:
```
mvn clean install
```

## Configure o banco de dados:
Crie um banco de dados MySQL com o nome "springboot".
Edite o arquivo application.properties e configure as informações de conexão com o banco de dados.
```
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

Inicie a API:
```
mvn spring-boot:run
```

Uso da API:

A API está disponível na porta 8080.
Utilize o endpoint /auth/login para realizar a autenticação e obter um token de acesso.
Inclua o token de acesso no cabeçalho Authorization de suas requisições para recursos protegidos.
Exemplo de requisição:

curl -X GET \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VybmFtZSIsInJvbGVzIjpbIkFkbWluaXN0cmF0b3IiXSwiaWF0IjoxNjQ0NTIxNzM2LCJleHAiOjE2NDQ1MjUzMzZ9.s1234567890" \
  http://localhost:8080/user
  
Licença:

Esta API está licenciada sob a licença Apache 2.0.
