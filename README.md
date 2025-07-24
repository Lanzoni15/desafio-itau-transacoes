# API de Transações - Desafio Itaú

API REST desenvolvida em Java com Spring Boot para gerenciar transações financeiras em tempo real, incluindo funcionalidades de criação, limpeza e cálculo de estatísticas agregadas.

---

## 🛠 Tecnologias Utilizadas

- Java 17+
- Spring Boot (Web, Validation)
- Lombok (redução de boilerplate)
- Jakarta Validation (Bean Validation API)
- Maven (gerenciamento de dependências)
- JUnit / Mockito (para testes — opcional, se tiver)

---

## 📦 Descrição do Projeto

Este projeto consiste em uma API que permite:

- Registrar transações financeiras com valor e timestamp;
- Obter estatísticas em tempo real das transações registradas (soma, média, mínimo, máximo e quantidade);
- Limpar o conjunto de transações armazenadas.

A API valida as entradas, rejeitando transações com valores negativos ou datas futuras.

---

## 🚀 Funcionalidades / Endpoints

| Método | Endpoint                   | Descrição                                   | Resposta                   |
|--------|----------------------------|---------------------------------------------|----------------------------|
| POST   | `/transacoes`              | Adiciona uma nova transação validada         | 201 Created / 400 Bad Request |
| GET    | `/transacoes/estatistica`  | Retorna estatísticas agregadas das transações | 200 OK                     |
| DELETE | `/transacoes`              | Remove todas as transações                    | 200 OK                     |

---

## 📄 Modelos de Dados (DTOs)

- **TransacaoDTO**

```json
{
  "valor": 123.45,
  "dataHora": "2025-07-24T15:30:00Z"
}
```
```json
{
  "count": 10,
  "sum": 1000.00,
  "avg": 100.00,
  "min": 50.00,
  "max": 200.00
}
```
## 🎯 Como Executar Localmente

1. Clone o repositório:

```bash
git clone https://github.com/seuusuario/seurepositorio.git
cd seurepositorio
```
2. Compile e execute a aplicação com Maven Wrapper:
```bash
./mvnw spring-boot:run
```
3. A API estará disponível em:
```bash
http://localhost:8080/transacoes
```
## 📞 Contato
Arthur Lanzoni — LinkedIn — seuemail@exemplo.com
