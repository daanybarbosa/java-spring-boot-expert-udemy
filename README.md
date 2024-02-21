# RESTFul API's com Spring Web

- Implementar uma RESTFul API de um sistema completo
- Mapear recursos e subrecursos REST utilizando os preceitos RESTFul
- Tratar erros de forma simples e bem especificada
- Realizar operações POST, DELETE, GET, PUT, PATCH e retornar códigos de Status apropriados
- Trabalhar com o Lombok project
- Utilizar Spring Boot DevTools

## Bando de Dados - H2
- http://localhost:8080/h2-console
- username: sa
- password: password

## URL

#### helloCliente
- http://localhost:8080/api/clientes/hello/{nome}
- Exemplo: http://localhost:8080/api/clientes/hello/Fulano

#### Exibir cliente
- http://localhost:8080/api/clientes/{id}
- Exemplo: http://localhost:8080/api/clientes/1
- Retorno: 
```
{
  "id": 1,
  "nome": "Fulano",
  "pedidos": []
}
```
