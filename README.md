## **Desafio de Programação Itaú Unibanco 🚀**

Este projeto é uma API REST desenvolvida como parte do desafio técnico proposto pelo Itaú Unibanco. O objetivo é avaliar a capacidade de construir um software bem estruturado, funcional e de alta qualidade utilizando Java e Spring Boot.

**Objetivo:** Criar uma API REST que recebe transações financeiras, calcula e retorna estatísticas com base nas transações recebidas, seguindo boas práticas de desenvolvimento, testes automatizados e organização do código. A aplicação deve atender às restrições técnicas propostas, como não utilizar banco de dados ou cache externos.

## **Requisitos do Desafio:**

*   Projeto hospedado em repositório público (GitHub ou GitLab).
    
*   Não utilizar forks.
    
*   Pelo menos 3 commits (um para cada endpoint).
    
*   Nomes e padrões dos endpoints exatamente conforme especificação.
    
*   Comunicação exclusivamente via JSON.
    
*   Armazenamento em memória (sem banco de dados ou cache externo).
    
*   Validação das regras de negócio.
    
*   Retorno dos status HTTP apropriados.
    

## **Endpoints Implementados:**

POST /transacao  
Recebe uma transação no formato JSON com os campos `valor` (maior ou igual a zero) e `dataHora` (não pode estar no futuro). Ambos são obrigatórios.  
Respostas esperadas:

*   201 Created: Transação aceita.
    
*   422 Unprocessable Entity: Dados inválidos.
    
*   400 Bad Request: JSON mal formatado.
    

DELETE /transacao  
Remove todas as transações armazenadas.  
Resposta esperada:

*   200 OK: Transações removidas com sucesso.
    

GET /estatistica  
Retorna as estatísticas das transações feitas nos últimos 60 segundos (count, sum, avg, min e max).  
Se não houver transações, retorna todos os valores como zero.  
Resposta esperada:

*   200 OK: Retorno com estatísticas atualizadas.
    

## **Tecnologias Utilizadas:**

*   Java 17
    
*   Spring Boot 3
    
*   Maven
    
*   JUnit 5 + MockMvc
    
*   Swagger/OpenAPI
    

## **Como Executar o Projeto:**

1.  Clone o repositório: git clone [https://github.com/Lanzoni15/desafio-itau-transacoes.git](https://github.com/Lanzoni15/desafio-itau-transacoes.git)
    
2.  Acesse a pasta do projeto: cd desafio-itau-transacoes
    
3.  Execute a aplicação: ./mvnw spring-boot:run
    

A API estará disponível em: [http://localhost:8080](http://localhost:8080)

**Como Executar os Testes:**  
Execute o comando ./mvnw test para rodar todos os testes automatizados. Eles cobrem os endpoints e as regras de negócio, garantindo o correto funcionamento da aplicação.

## **Observações:**

*   Nenhuma persistência externa é utilizada; os dados são armazenados apenas em memória.
    
*   Todas as transações são perdidas ao reiniciar a aplicação.
    
*   Certifique-se de enviar requisições no formato correto para evitar erros de validação.
    

## **Autor:** Arthur Lanzoni
