# 🤝 Relaciona

Sistema de Gestão de Relacionamento com Clientes (CRM) desenvolvido com **Java + Spring Boot**, com o objetivo de centralizar informações de clientes, organizar oportunidades de negócio e otimizar o processo comercial de uma empresa.

---

## 📋 Sobre o Projeto 

O **Relaciona** é uma aplicação de CRM (Customer Relationship Management) desenvolvida para auxiliar empresas no gerenciamento de clientes e oportunidades de negócio.

O sistema permite o cadastro, consulta, atualização e remoção de registros, proporcionando um controle mais eficiente das informações comerciais.

Entre as funcionalidades estão o gerenciamento de clientes, oportunidades de venda e usuários do sistema, facilitando o acompanhamento do relacionamento com clientes e do processo de negociação.

---

## 🎯 Objetivos

- Centralizar informações dos clientes;
- Facilitar o gerenciamento de oportunidades de negócio;
- Organizar os dados dos usuários do sistema;
- Otimizar o acompanhamento do processo comercial;
- Disponibilizar uma API REST para integração com outras aplicações.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| ☕ Java | Linguagem de programação |
| 🌱 Spring Boot | Framework principal |
| 🗄️ Spring Data JPA | Persistência de dados |
| 🔥 Hibernate | ORM |
| 🐬 MySQL | Banco de dados |
| 🌐 Tomcat | Servidor de aplicação |
| 📦 Maven | Gerenciador de dependências |
| 🔧 Git | Controle de versão |
| 🐙 GitHub | Hospedagem do projeto |

---

## 🏛️ Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```text
Controller
     ↓
Repository
     ↓
Banco de Dados (MySQL)
     ↓
   Model
```

---

# 📊 Banco de Dados

**db_relaciona**

Nosso banco de dados foi desenvolvido utilizando o SGBD **MySQL**.

A seguir estão as tabelas utilizadas no sistema.

---

## 📌 Tabela: tb_cliente

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | BIGINT | Identificador único do cliente |
| nomeCompleto | VARCHAR(100) | Nome completo do cliente |
| email | VARCHAR(255) | E-mail do cliente |
| cpf | VARCHAR(11) | CPF do cliente |
| cnpj | VARCHAR(255) | CNPJ do cliente |
| tipoPessoa | VARCHAR(255) | Tipo do cliente |
| dataNascimento | DATE | Data de Nascimento do cliente |

---

## 📌 Tabela: tb_oportunidade

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | BIGINT | Identificador único da oportunidade |
| titulo | VARCHAR(50) | Nome da oportunidade |
| valorEstimado | DECIMAL | Valor estimado da negociação |
| status | VARCHAR(50) | Situação da oportunidade |

---

## 📌 Tabela: tb_usuario

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | BIGINT | Identificador único do usuário |
| nome | VARCHAR(255) | Nome do usuário |
| email | VARCHAR(255) | E-mail |
| senha | VARCHAR(255) | Senha criptografada |
| foto | VARCHAR(5000) | URL da foto de perfil |
| cargo | VARCHAR(25) | Cargo do usuário |
| status | BOOLEAN | Usuário ativo ou inativo |
| dataCadastro | DATE | Data de cadastro |

---

## 📈 Diagrama Entidade-Relacionamento

*Adicionar imagem do DER aqui.*

```markdown
![Tabela Cliente][Tabela Oportunidade][Tabela Usuario](https://cdn.discordapp.com/attachments/1509621329492447330/1530267678608986112/modeloPI2_2.png)
```

---

## 📂 Estrutura do Projeto

```text
src
├── model
├── repository
├── controller
```

---

## ⚙️ Como executar o projeto

### Clone o repositório

```bash
git clone https://github.com/OctaDev1/Relaciona
```

### Entre na pasta

```bash
cd relaciona
```

### Configure o banco de dados

Crie um banco chamado:

```text
db_relaciona
```

Configure o arquivo:

```text
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_relaciona
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Executando

Execute a classe principal do Spring Boot:

```text
RelacionaApplication.java
```

Ou pelo Maven:

```bash
mvn spring-boot:run
```

---



## 📌 Funcionalidades

- Cadastro de clientes
- Consulta de clientes
- Atualização de clientes
- Exclusão de clientes
- Cadastro de oportunidades
- Gerenciamento do status das oportunidades
- Cadastro de usuários
- API REST
- Integração com banco de dados MySQL

---

## 🛠️ Futuras Implementações

### 🤖 Inteligência Artificial

- IA para priorização de clientes, analisando os dados e identificando quais possuem maior probabilidade de fechar negócio.

### 🔔 Automação

- Follow-up inteligente com notificações como:
  - "Você não fala com este cliente há 10 dias."
  - "Retorne o contato hoje."

### ♿ Acessibilidade

- Modo de alto contraste.
- Navegação por teclado.
- Ajuste do tamanho da fonte.
- Compatibilidade com leitores de tela.


---

## 👥 Equipe

O **Relaciona** foi desenvolvido pela equipe **OctaDev**, formada por estudantes do Bootcamp Java Full Stack da Generation Brasil, com foco na aplicação de boas práticas de desenvolvimento de software, metodologias ágeis e construção de APIs REST utilizando Java e Spring Boot.

### Desenvolvedores

- Felipe Oliveira Lopes
- Gabriel José Alegre
- Giovanna Karolline Menezes Ribeiro
- Guilherme Oliveira
- João Vitor Diniz Alves
- Juliana Macedo
- Maryane Praxedes Alves da Silva
- Thiago José Nascimento Versiani

---

## 📄 Licença

Este projeto possui finalidade acadêmica e de aprendizado.

