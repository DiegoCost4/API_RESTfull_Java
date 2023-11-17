# Projeto Folha de Pagamento

## Descrição

O projeto **Folha de Pagamento** é uma aplicação de API Restful desenvolvida em Spring Boot e Java. Ela oferece operações CRUD (Create, Read, Update, Delete) para o gerenciamento de funcionários e usuários. A principal finalidade desta aplicação é ser consumida em projetos web, desktop e mobile, integrando-se a um sistema abrangente de folha de pagamento.

## Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Java](https://www.java.com/)
- [PostgreSQL](https://www.postgresql.org/)
- [JPA](https://spring.io/projects/spring-data-jpa)
- [JDBC](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)
- 
## Endpoints da API

### Funcionários

#### FuncionarioController

**Endpoint para Listar Todos os Funcionários:**

- Método: `GET`
- URL: `/api/funcionarios`

**Endpoint para Obter um Funcionário por ID:**

- Método: `GET`
- URL: `/api/funcionarios/{id}`

**Endpoint para Criar um Novo Funcionário:**

- Método: `POST`
- URL: `/api/funcionarios`

**Endpoint para Atualizar um Funcionário Existente:**

- Método: `PUT`
- URL: `/api/funcionarios/{id}`

**Endpoint para Excluir um Funcionário:**

- Método: `DELETE`
- URL: `/api/funcionarios/{id}`

## Exemplos de Requisições

A seguir, estão alguns exemplos práticos de como realizar requisições para a sua API, incluindo operações CRUD para funcionários e usuários. Certifique-se de ajustar os dados de exemplo de acordo com a estrutura real da sua API.

### Requisição GET - Listar Todos os Funcionários

GET /api/funcionarios
## Requisição POST - Criar Novo Funcionário

POST /api/funcionarios
Content-Type: application/json

{
  "id": 1,
  "name": "Diego",
  "cpf": 15478965478,
  "adress": "rua teste",
  "phone": "11665874585",
  "office": "Desenvolvedor FullStack",
  "salary": 4500.0,
  "observation": "Contratacao PJ"
}

## Resposta
{
  "id": 1,
  "name": "Diego",
  "cpf": 15478965478,
  "adress": "rua teste",
  "phone": "11665874585",
  "office": "Desenvolvedor FullStack",
  "salary": 4500.0,
  "observation": "Contratacao PJ"
}
## Estrutura do Projeto

O backend foi desenvolvido utilizando o framework Spring Boot. A estrutura do projeto está organizada da seguinte forma:

```plaintext
projeto-apirestfull
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.exemplo.apirestfull
│   │   │   │   ├── controller
│   │   │   │   │   ├── FuncionarioController.java
│   │   │   │   │   └── UsuarioController.java
│   │   │   │   ├── model
│   │   │   │   │   ├── Funcionario.java
│   │   │   │   │   └── Usuario.java
│   │   │   │   ├── repository
│   │   │   │   │   ├── FuncionarioRepository.java
│   │   │   │   │   └── UsuarioRepository.java
│   │   │   │   └── service
│   │   │   │       ├── FuncionarioService.java
│   │   │   │       └── UsuarioService.java
│   │   │   └── ProjetoFolhaPagamentoApplication.java
│   │   └── resources
│   │       └── application.properties
└── pom.xml


