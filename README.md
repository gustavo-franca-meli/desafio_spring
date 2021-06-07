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
 

### US0003 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0004 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0005 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0006 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0007 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0008 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0009 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0010 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0011 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor

### US0012 - Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor
