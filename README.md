# Gandalf (WebService)

WebService do e commerce Gandalf para integração com o aplicativo [mobile](https://github.com/DavidWashington833/PI-4-AppMobile.git)

## Getting Started

Esse projeto foi desenvolvido no NetBeans, recomendamos usar essa IDE

### Examples
#### (GET) http://gandalf.azurewebsites.net/gandalf/rest/produto
##### Reponse
```javascript
[
    {
        "idProduto": 0,
        "nomeProduto": "",
        "precProduto": 0.00,
        "descontoPromocao": 0.00,
        "qtdMinEstoque": 0,
        "imagem": ""
    }
    ...
]
```
#### (GET) http://gandalf.azurewebsites.net/gandalf/rest/produto/{id}
##### Reponse
```javascript
{
  "idProduto": 0,
  "nomeProduto": "",
  "precProduto": 0.00,
  "descontoPromocao": 0.00,
  "qtdMinEstoque": 0,
  "imagem": "",
  "descProduto": ""
}
```
#### (GET) http://localhost:8080/Gandalf/rest/produto/categoria/{id}
##### Reponse
```javascript
[
  {
    "idProduto": 0,
    "nomeProduto": "",
    "precProduto": 0.00,
    "descontoPromocao": 0.00,
    "qtdMinEstoque": 0,
    "imagem": ""
  }
  ...
]
```
#### (GET) http://localhost:8080/Gandalf/rest/produto/like/{text}
##### Reponse
```javascript
[
    {
        "idProduto": 0,
        "nomeProduto": "",
        "precProduto": 0.00,
        "descontoPromocao": 0.00,
        "qtdMinEstoque": 0,
        "imagem": ""
    }
    ...
]
```
#### (GET) http://localhost:8080/Gandalf/rest/cliente/authentic/{email}/{password}
##### Reponse
```javascript
[
  {
    "idCliente": 0,
    "nomeCompletoCliente": "",
    "emailCliente": "",
    "senhaCliente": "",
    "cpfcliente": "",
    "celularCliente": "",
    "telComercialCliente": "",
    "telResidencialCliente": "",
    "dtNascCliente": "",
    "recebeNewsLetter": true
  }
  ...
]
```
#### (POST) http://localhost:8080/Gandalf/rest/cliente/
##### Request
```javascript
{
    "nomeCompletoCliente": "",
    "emailCliente": "",
    "senhaCliente": "",
    "cpfcliente": "",
    "celularCliente": "",
    "telComercialCliente": "",
    "telResidencialCliente": "",
    "dtNascCliente": "",
    "recebeNewsLetter": true
}
```
##### Reponse
```javascript
{
    "idCliente": 0,
    "nomeCompletoCliente": "",
    "emailCliente": "",
    "senhaCliente": "",
    "cpfcliente": "",
    "celularCliente": "",
    "telComercialCliente": "",
    "telResidencialCliente": "",
    "dtNascCliente": "",
    "recebeNewsLetter": true
}
```
#### (GET) http://localhost:8080/Gandalf/rest/categoria/
##### Reponse
```javascript
[
    { 
        "idCategoria": 0, 
        "nomeCategoria": "" 
    }
  ...
]
```

### Prerequisites

O que você precisa para desenvolver

```
Java 7
Maven
Apache Tomcat 8.5
```
