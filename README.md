# Desafio-spring

breve descrição sobre o desafio

## como rodar o projeto
1. Clonar o projeto 
```
 git clone git@github.com:gustavo-franca-meli/desafio_spring.git
```
2. rodar o projeto pelo intelij

## Casos de Uso 

### US0001 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor
```
POST /users/{userId}/follow/{userIdToFollow}
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | Número que identifica o usuário atual |
| userIdToFollow | UUID | Número que identifica o usuário a seguir |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao Seguir Vendedor |
| 400 | BAD REQUEST | UUID mal formatado, vendedor não encontrado, Usuário não encontrado |
| 409 | CONFLICT | acontece quando um usuário tenta seguir um vendedor que está seguindo |

Veja a documentação detalhada desta feature aqui [Documentação e exemplos US001](https://documenter.getpostman.com/view/15968976/TzY6AEv4)

Para mais informações sobre o código acessa a issue #2

### US0002 - Obter o resultado do número de usuários que seguem um determinado
vendedor

```
GET /users/{sellerId}/followers/count/
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o vendedor |

Retorno :

````json
 {
"userId": "2ad3e5ce-d33e-4100-ad12-434667745aff",
"userName": "vendedor1",
"followersCount": 35
}
````

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | sucesso na requisição retornando o  json |
| 400 | BAD REQUEST | UUID mal formatado |
| 404 | NOT_FOUND | vendedor não encontrado |

Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o vendedor |
| userName | String | nome do Vendedor |
| followersCount | Integer | quantidade de Seguidores |

Para mais informações sobre o código acessa a issue #3
 

### US0003 - Obter uma lista de todos os usuários que seguem um determinado vendedor (quem me segue?)

```
GET /users/{{sellerId}}/followers/list
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o vendedor) |

Retorno :

````json
{
  "userId": "b4c40a44-3c57-465d-b173-2f70665b35ee",
  "userName": "seller3",
  "followers": [
    {
      "userId": "ed25f504-569f-4300-944b-e19484f55f28",
      "userName": "user3"
    },
    {
      "userId": "3a45db9b-a4de-4fe1-8f2f-7345dc603a3b",
      "userName": "seller4"
    },
    {
      "userId": "d313bf73-cc50-403e-a63c-ccb7a0ffc7a7",
      "userName": "user4"
    }
  ]
}
````

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | sucesso na requisição retornando o  json |
| 400 | BAD REQUEST | UUID mal formatado |
| 404 | NOT_FOUND | vendedor não encontrado |

Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| sellerId | UUID | UUID que identifica o vendedor |
| userName | String | nome do Usuário |
| followers | List<User> | lista de usuário que seguem o vendedor |


Para mais informações sobre o código acessa a issue #4

### US0004 - Obter uma lista de todos os vendedores que um determinado usuário segue (quem estou seguindo?)

```
GET /users/{{userId}}/followed/list
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o usuário |

Retorno :

````json
{
  "userId": "3aa1cbf6-89ea-4c4b-9a3b-fcff490bc9b6",
  "userName": "user1",
  "followed": [
    {
      "userId": "2c8efdf8-ea86-44da-93b7-0a1e4486794d",
      "userName": "seller1"
    }
  ]
}
````

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | sucesso na requisição retornando o  json |
| 400 | BAD REQUEST | UUID mal formatado |
| 404 | NOT_FOUND | usuário não encontrado |

Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o Usuário |
| userName | String | nome do Usuário |
| followed | List<Seller> | lista de vendedores que o usuário segue |


Para mais informações sobre o código acessa a issue #5

### US0005 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor


### US0006 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0007 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0008 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0009 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0010 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0011 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0012 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor
