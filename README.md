# Sistema de Gerenciamento Hospitalar API

## Sobre o Projeto

Este projeto consiste no desenvolvimento de uma API REST para gerenciamento hospitalar utilizando a plataforma Spring Boot. O sistema foi criado com o objetivo de permitir o cadastro e gerenciamento de pacientes, médicos, consultas e internações, centralizando as informações de forma organizada e segura.

A aplicação segue os princípios da arquitetura REST, utilizando banco de dados relacional PostgreSQL para armazenamento persistente dos dados e Spring Security para controle de acesso aos recursos da API.

---

## Objetivos

O sistema foi desenvolvido para atender aos seguintes objetivos:

- Cadastrar pacientes.
- Cadastrar médicos.
- Registrar consultas médicas.
- Registrar internações hospitalares.
- Consultar informações cadastradas.
- Atualizar registros existentes.
- Remover registros quando necessário.
- Garantir segurança no acesso aos endpoints da aplicação.

---

## Tecnologias Utilizadas

As principais tecnologias empregadas no desenvolvimento foram:

| Tecnologia | Versão |
|------------|---------|
| Java | 21 |
| Spring Boot | 3.5.16 |
| Spring Web | 3.5.16 |
| Spring Data JPA | 3.5.16 |
| Spring Security | 3.5.16 |
| PostgreSQL | 17 |
| Maven | 3.9+ |
| JUnit 5 | Última versão compatível |
| H2 Database | Ambiente de testes |

---

## Estrutura do Projeto

O projeto está organizado seguindo o padrão de camadas recomendado pelo Spring Boot:

```text
src
├── main
│   ├── java
│   │   └── com.rodrigomoro.atspring_boot
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── model
│   │       ├── dto
│   │       ├── security
│   │       └── config
│   └── resources
│       └── application.properties
│
└── test
    └── java
        └── integration
```

---

## Modelo de Dados

### Paciente

Representa os pacientes cadastrados no sistema.

**Atributos:**

- id
- nome
- cpf
- dataNascimento
- telefone
- email

---

### Médico

Representa os profissionais responsáveis pelos atendimentos.

**Atributos:**

- id
- nome
- crm
- especialidade

---

### Consulta

Representa os atendimentos realizados entre pacientes e médicos.

**Atributos:**

- id
- dataConsulta
- observacoes
- paciente
- medico

---

### Internação

Representa os períodos de internação hospitalar dos pacientes.

**Atributos:**

- id
- dataEntrada
- dataAlta
- motivo
- paciente

---

## Configuração do Banco de Dados

O sistema utiliza PostgreSQL como banco de dados principal.

### Criação do Banco

```sql
CREATE DATABASE hospital_db;
```

### Configuração da Aplicação

Arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/hospital_db
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Segurança

O projeto utiliza Spring Security para proteção dos endpoints.

As funcionalidades implementadas incluem:

- Autenticação de usuários.
- Controle de acesso.
- Proteção contra acessos não autorizados.
- Integração com testes automatizados.

---

## Endpoints Principais

### Pacientes

| Método | Endpoint | Descrição |
|----------|----------|------------|
| GET | /pacientes | Listar pacientes |
| GET | /pacientes/{id} | Buscar paciente por ID |
| POST | /pacientes | Cadastrar paciente |
| PUT | /pacientes/{id} | Atualizar paciente |
| DELETE | /pacientes/{id} | Excluir paciente |

---

### Médicos

| Método | Endpoint |
|----------|----------|
| GET | /medicos |
| GET | /medicos/{id} |
| POST | /medicos |
| PUT | /medicos/{id} |
| DELETE | /medicos/{id} |

---

### Consultas

| Método | Endpoint |
|----------|----------|
| GET | /consultas |
| GET | /consultas/{id} |
| POST | /consultas |
| PUT | /consultas/{id} |
| DELETE | /consultas/{id} |

---

### Internações

| Método | Endpoint |
|----------|----------|
| GET | /internacoes |
| GET | /internacoes/{id} |
| POST | /internacoes |
| PUT | /internacoes/{id} |
| DELETE | /internacoes/{id} |

---

## Testes

Foram desenvolvidos testes automatizados para validação das funcionalidades da API.

### Tipos de Testes

- Testes de integração.
- Testes dos controladores REST.
- Testes de segurança.
- Testes utilizando banco H2 em memória.

### Execução dos Testes

```bash
mvn test
```

---

## Execução da Aplicação

### Compilar o projeto

```bash
mvn clean package
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

ou

```bash
java -jar target/atspring-boot-0.0.1-SNAPSHOT.jar
```

---

## Resultados Obtidos

Durante o desenvolvimento foi possível aplicar conceitos importantes da disciplina, incluindo:

- Desenvolvimento de APIs REST.
- Persistência de dados com JPA e Hibernate.
- Integração com PostgreSQL.
- Segurança com Spring Security.
- Arquitetura em camadas.
- Testes automatizados.
- Boas práticas de desenvolvimento com Spring Boot.

O sistema atende aos requisitos propostos para gerenciamento hospitalar, oferecendo uma estrutura organizada, escalável e preparada para futuras evoluções.

---

## Autor

**Rodrigo Moro Francisco da Silva**

Trabalho desenvolvido para a disciplina de Desenvolvimento de Aplicações Web utilizando Java, Spring Boot e PostgreSQL.
