# Desafio-spring

O objetivo deste desafio é aplicar os conteúdos dados até o momento durante o Programa de aceleração MeLi (Git, Java e Spring), com a finalidade de poder implementar uma API REST a partir de um enunciado proposto, uma especificação de requisitos e documentação anexada.

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

### US0005 - Cadastrar uma nova publicação

```
POST /products/newpost/
```

Exemplo de Corpo do Envio : 
````json
{
"userId": "b4c40a44-3c57-465d-b173-2f70665b35ee",
"idPost" : "41096fb7-62f8-4f58-b183-53f3dbec50",
"detail":{
    "productId" : "b4c40a44-3c57-465d-b173-2f70665b35ee",
    "productName" : "Cadeira Gamer",
    "type" : "Gamer",
    "brand" : "Racer",
    "color" : "Red & Black",
    "notes" : "Special Edition"
},
"category" : 100,
"price" : 1500.50
}



````
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o usuário |
| idPost | UUID | UUID que identifica o post |
| detail | Produto | dados do produto |
| productId | UUID | UUID de identificação de cada um dos produtos associados a uma publicação |
| productName | String | Sequência de caracteres que representa o nome de um produto|
| type | String | Sequência de caracteres que representa o tipo de um produto |
| brand | String | Sequência de caracteres que representa a marca de um produto |
| color | String | Sequência de caracteres que representa a cor de um produto |
| notes | String | Sequência de caracteres para colocar notas ou observações de um produto |
| category | Integer | Identificador usado para saber a categoria à qual um produto pertence. Por exemplo: 100: cadeiras, 58: teclados |
| price | Double | Preço do produto |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 201 | CREATED | sucesso na criação|
| 400 | BAD REQUEST | UUID mal formatado ou já existe |
| 404 | NOT_FOUND | usuário não encontrado |


Para mais informações sobre o código acessa a issue #6

### US0006 - Obter uma lista das publicações feitas pelos vendedores que um usuário segue nas últimas duas semanas (para isso, ter em conta ordenação por data, a maioria das publicações recentes primeiro).

```
GET /products/followed/{userId}/list
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o usuário |

Retorno :

```json
{
    "userId": "3a45db9b-a4de-4fe1-8f2f-7345dc603a3b",
    "posts": [
        {
            "userId": "41096fb7-62f8-4f58-b183-053f3dbec325",
            "idPost": "b4c40a44-3c57-465d-b173-2f70665b35ee",
            "detail": {
                "productId": "b4c40a44-3c57-465d-b173-2f70665b35ee",
                "productName": "Cadeira Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "postedAt": "2021-06-02T15:32:08.795233",
            "category": 100,
            "price": 1500.5
        },
        {
            "userId": "41096fb7-62f8-4f58-b183-053f3dbec324",
            "idPost": "b4c40a44-3c57-465d-b173-2f70665b35ee",
            "detail": {
                "productId": "b4c40a44-3c57-465d-b173-2f70665b35ee",
                "productName": "Cadeira Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "postedAt": "2021-06-02T15:32:03.001853",
            "category": 100,
            "price": 1500.5
        },
        {
            "userId": "41096fb7-62f8-4f58-b183-053f3dbec316",
            "idPost": "b4c40a44-3c57-465d-b173-2f70665b35ee",
            "detail": {
                "productId": "b4c40a44-3c57-465d-b173-2f70665b35ee",
                "productName": "Cadeira Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "postedAt": "2021-06-02T15:28:08.810266",
            "category": 100,
            "price": 1500.5
        }
]
}
````

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | sucesso na requisição retornando o  json |
| 400 | BAD REQUEST | UUID mal formatado |
| 404 | NOT_FOUND | usuário não encontrado |

Para mais informações sobre o código acessa a issue #9
### US0007 - Ser capaz de realizar a ação de “Deixar de seguir” (parar de seguir) um determinado vendedor.
```
POST /users/{userId}/unfollow/{userIdToUnfollow}
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | Número que identifica o usuário atual |
| userIdToUnfollow | UUID | Número que identifica o usuário a deixar de seguir |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao deixar de Seguir Vendedor |
| 400 | BAD REQUEST | UUID mal formatado |
| 404 | NOT_FOUND |  vendedor não encontrado ou Usuário não encontrado |
| 409 | CONFLICT | acontece quando um usuário tenta deixar de seguir um vendedor que não está seguindo |


Para mais informações sobre o código acessa a issue #11


### US0008 - Ordem alfabética crescente e decrescente
Habilitado em :
```
GET
/users/{UserID}/followers/list
/users/{UserID}/followed/list
```

GET Exemplos:
```
/users/{UserID}/followers/list?order=name_asc
/users/{UserID}/followers/list?order=name_desc
/users/{UserID}/followed/list?order=name_asc
/users/{UserID}/followed/list?order=name_desc
```
Parametros da Query :

| Tipo | Valor | Descrição |
| ----------- | ---- | --------- |
| order | name_asc |  Alfabético crescente |
| order | name_desc |  Alfabético decrescente |

Para mais informações sobre o código acessa a issue #13

### US0009 - Classificar por data crescente e decrescente

Habilitado em :
```
GET
/products/followed/{userId}/list
/products/{sellerId}/list
```

GET Exemplos:
```
/products/followed/{userId}/list?order=date_asc
/products/followed/{userId}/list?order=date_desc
/products/{sellerId}/list?order=date_asc
/products/{sellerId}/list?order=date_desc
```
Parametros da Query:

| Tipo | Valor | Descrição |
| ----------- | ---- | --------- |
| order | date_asc |   crescente (do mais antigo para o mais novo |
| order | date_desc |  decrescente (do mais novo ao mais antigo |

Para mais informações sobre o código acessa a issue #15

### US0010 - Realizar a publicação de um novo produto promocional

```
POST /products/newpromopost
```
Exemplo de Corpo do Envio :

```json
{
"userId": "3a45db9b-a4de-4fe1-8f2f-7345dc603a3b",
"idPost" : "41096fb7-62f8-4f58-b183-53f3dbec40",
"detail":{
    "productId" : "b4c40a44-3c57-465d-b173-2f70665b35ee",
    "productName" : "Cadeira Gamer",
    "type" : "Gamer",
    "brand" : "Racer",
    "color" : "Red & Black",
    "notes" : "Special Edition"
},
"category" : 100,
"price" : 1500.50,
"discount" : 0.25
}

```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o usuário |
| idPost | UUID | UUID que identifica o post |
| detail | Produto | dados do produto |
| productId | UUID | UUID de identificação de cada um dos produtos associados a uma publicação |
| productName | String | Sequência de caracteres que representa o nome de um produto|
| type | String | Sequência de caracteres que representa o tipo de um produto |
| brand | String | Sequência de caracteres que representa a marca de um produto |
| color | String | Sequência de caracteres que representa a cor de um produto |
| notes | String | Sequência de caracteres para colocar notas ou observações de um produto |
| category | Integer | Identificador usado para saber a categoria à qual um produto pertence. Por exemplo: 100: cadeiras, 58: teclados |
| price | Double | Preço do produto |
| discount | Double | Caso um produto esteja em promoção, defina o valor do desconto |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 201 | CREATED | sucesso na criação|
| 400 | BAD REQUEST | UUID mal formatado ou já existe |
| 404 | NOT_FOUND | vendedor não encontrado |



obs : Data automaticamente inclusa ao gerar o post , por isso não precisa ser passada pela request.

Para mais informações sobre o código acessa a issue #17


### US0011 - Obtenha o quantidade de produtos promocionais de um vendedor específico
```
GET /products/{userId}/countPromo/
```
Retorno :
```json
{
"userId" : 1569,
"userName": "vendedor1",
"promoProductsCount": 23
}
```


| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 201 | CREATED | sucesso na criação|
| 400 | BAD REQUEST | UUID mal formatado ou já existe |
| 404 | NOT_FOUND | vendedor não encontrado |


Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o Usuário |
| userName | String | nome do Usuário |
| promoProductsCount | Integer | Quantidade numérica de produtos em promoção de deter minado usuário. |

Para mais informações sobre o código acessa a issue #18

### US0012 - Obter uma lista de todos os produtos promocionais de um vendedor específico

```
GET /products/{sellerId}/list/
```

Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| sellerId | UUID | UUID que identifica o vendedor |

Retorno :
```json 
{
    "userId": 1569,
    "userName": "vendedor1",
    "posts": [
        {
            "id_post": 18,
            "date": "29-04-2021",
            "detail": {
                "product_id": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": "100",
            "price": 15000.50,
            "discount": 0.25
        },
        {
            "id_post": 32,
            "date": "01-05-2021",
            "detail": {
                "product_id": 62,
                "productName": "Headset RGB Inalámbrico",
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería"
            },
            "category": "120",
            "price": 2800.69,
            "discount": 0.10
        }
    ]
}
```


| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | sucesso na requisição retornando o  json |
| 400 | BAD REQUEST | UUID mal formatado |
| 404 | NOT_FOUND | vendedor não encontrado |

Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| userId | UUID | UUID que identifica o Usuário |
| userName | String | nome do Usuário |
| post | List<Post> | lista de vendedores que o usuário segue |


Para mais informações sobre o código acessa a issue #19
