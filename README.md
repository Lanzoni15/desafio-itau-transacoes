# 💳 Desafio Itaú – Controle de Transações

Sistema back-end para controle e análise de transações financeiras, desenvolvido como parte de um desafio técnico da vaga de estágio do Itaú.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL (desenvolvimento)
- H2 (testes locais)
- Maven
- Lombok

---

## ⚙️ Funcionalidades

- Cadastro de novas transações
- Consulta de todas as transações por ID do usuário
- Cálculo de estatísticas: soma, média, quantidade, maior e menor transação
- Respostas JSON organizadas e informativas
- Banco de dados MySQL com estrutura relacional
- Possibilidade de migrar para banco em memória (H2) para testes

---

## 📂 Estrutura da API

src <br>
├── controller <br>
│ └── TransacaoController.java <br>
├── dto <br>
│ └── TransacaoDTO.java <br>
├── entity <br>
│ └── Transacao.java <br>
├── repository <br>
│ └── TransacaoRepository.java <br>
├── service <br>
│ └── TransacaoService.java <br>
└── application.properties <br>


---

## 🧪 Endpoints

### 🔸 POST `/transacoes`
Cadastrar nova transação.

```json
{
  "idUsuario": 1,
  "valor": 150.75
}
```

### 🔸 GET /transacoes/{idUsuario}
Listar todas as transações de um usuário.

### 🔸 GET /transacoes/estatisticas/{idUsuario}
Retorna:

- media
- soma
- quantidade
- maior valor
- menor valor

### ▶️ Como rodar o projeto localmente
1. Clone o repositório:
```
git clone https://github.com/Lanzoni15/desafio-itau-transacoes.git
cd desafio-itau-transacoes
```

2. Configure o banco:

- Altere as credenciais no application.properties
- Ou mude para H2 (exemplo já no código)

3. Execute o projeto:
```
./mvnw spring-boot:run
```

### 🔍 Exemplo de resposta /estatisticas/1

```
{
  "media": 102.58,
  "soma": 512.9,
  "quantidade": 5,
  "maiorValor": 150.75,
  "menorValor": 50.00
}
```

### 📌 Observações
<b> Este projeto foi desenvolvido em ambiente de estudo e avaliação técnica. Caso tenha sugestões de melhoria ou queira entrar em contato, fique à vontade! <b>

### 👨‍💻 Desenvolvido por
<b> Arthur Lanzoni <b> <br>
📍 São Paulo - SP <br>
🔗 GitHub: @Lanzoni15 <br>
🔗 LinkedIn: https://www.linkedin.com/in/arthur-lanzoni-a838b721a/
