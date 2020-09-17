# Documentaçao Filme Flix

## Utilizaçao:

Gerar Imagem Docker:

```jsx
docker build -f Dockerfile -t filme-flix-api:1.0.0 .
```

Gerar container da aplicaçao:

```jsx
docker run -p 8090:8090 -e "MONGODB_URI=<AQUI_VC_COLOCA_A_SUA_CONEXAO_MONGODB>" filme-flix-api:1.0.0
```

Para acessar a documentaçao SWAGGER:

```jsx
http://<IP>:<PORTA>/swagger-ui.html
```

## Para continuar o desenvolvimento:

Acessar src\main\resources\application.properties e definir valor default em:

```jsx
spring.data.mongodb.uri=${MONGODB_URI}
```

Para:

```jsx
spring.data.mongodb.uri=${MONGODB_URI:<AQUI_VC_COLOCA_A_SUA_CONEXAO_MONGODB>}
```

## Gerar pacote para implantaçao:

```jsx
mvn install -DskipTests
```

# Melhorias pendentes:

- Melhorar estrutura de exceptions
- Adicionar heranças para diminuir repetição de codigo quando a aplicação crescer
- Incluir JWT ou OAuth2 para adicionar segurança a API
- Adicionar lógica de testes automáticos para realização de testes de regressão
- Outras melhorias
