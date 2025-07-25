🚀 Desafio Itaú – Microsserviço de Transações
---------------------------------------------

Este projeto foi desenvolvido como solução para o desafio técnico da vaga **Java Júnior - Itaú**, com o objetivo de construir um microsserviço para controle e análise de transações financeiras por cliente.

### 🛠 Tecnologias Utilizadas

*   **Java 17**
    
*   **Spring Boot 3**
    
*   **Spring Data JPA**
    
*   **H2 Database (em memória)**
    
*   **Swagger/OpenAPI**
    
*   **Maven**
    

### 📦 Funcionalidades Implementadas

*   ✅ Cadastro de transações financeiras
    
*   ✅ Consulta de transações por clientId
    
*   ✅ Resumo das transações de um cliente:
    
    *   Quantidade de transações
        
    *   Valor total
        
    *   Valor médio
        
    *   Maior e menor valor
        
*   ✅ Documentação automática com Swagger
    
*   ✅ Banco de dados em memória para testes simples e rápidos
    

### 🧪 Como Rodar Localmente

1.  **Clone o repositório:**

```
git clone https://github.com/Lanzoni15/desafio-itau-transacoes.git cd desafio-itau-transacoes
```

1.  **Compile o projeto com Maven:**
    
```
/mvnw clean install 
```

1.  **Execute a aplicação:**

```
/mvnw spring-boot:run
```
1.  **Acesse os endpoints:**
    

*   Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    
*   Console do banco H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    
    *   JDBC URL: jdbc:h2:mem:desafioitau
        
    *   User: sa | Password: _(vazio)_
        

### 📌 Exemplos de Requisição

#### 🔹 Cadastro de transação

POST /api/transacoes
```
{    
"clientId": 123,
"valor": 250.75  
}
```

#### 🔹 Buscar transações por cliente

GET /api/transacoes/123

#### 🔹 Obter resumo por cliente

GET /api/transacoes/resumo/123

### 📁 Estrutura do Projeto

src/  <br>
├── main/ <br>
├── java/com/itau/transacoes  <br>
├── controller  <br>
├── model  <br>
├── repository  <br>
│   └── service <br> 
│   └── resources/<br> 
│   └── application.properties<br>


📎 Observações

*   Este projeto foi desenvolvido com foco didático e demonstração de habilidades técnicas.
    
*   Pode ser facilmente adaptado para uso com bancos de dados como MySQL ou PostgreSQL.
    

![Java](https://img.shields.io/badge/Java-17-blue)  <br>
![SpringBoot](https://img.shields.io/badge/SpringBoot-3.0-brightgreen)  <br>

### 👨‍💻 Autor

**Arthur Lanzoni**
