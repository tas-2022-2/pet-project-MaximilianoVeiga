# Trabalho de JPA

## Requisitos

- Java 17
- Maven 3.8.1
- Docker 20.10.8 (opcional)

## Instruções

1. Clone o repositório para sua máquina

2. Instale o PostgreSQL e crie um banco de dados chamado `jpa-trab`. Voce pode utilizar o docker para instalar o PostgreSQL. Para isso, execute o comando abaixo:

```bash
docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres
```

3. Execute o comando abaixo para criar o banco de dados:

```bash
docker exec -it postgres-db createdb jpa-trab
```

4. Após criar o banco de dados, insira as configurações no arquivo de persistencia chamado `persistence.xml`:

```xml
<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/jpa-trab"/>
<property name="javax.persistence.jdbc.user" value="postgres"/>
<property name="javax.persistence.jdbc.password" value="docker"/>
```

5. Pronto, agora você pode executar o projeto.
