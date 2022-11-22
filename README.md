# TAS - Pet Project

## Requirements

- Java 17
- Maven 3.8.1
- Docker 20.10.8 (optional)

## Instructions

1. Clone the repository to your machine

2. Install PostgreSQL and create a database called `jpa-trab`. You can use docker to install PostgreSQL. To do this, run the command below:

```bash
docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres
```

3. Run the command below to create the database:

```bash
docker exec -it postgres-db createdb jpa-trab
```

4. After creating the database, enter the settings in the persistence file called `persistence.xml`:

```xml
<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/jpa"/>
<property name="javax.persistence.jdbc.user" value="postgres"/>
<property name="javax.persistence.jdbc.password" value="docker"/>
```

5. Done, now you can run the project.