# xbook
Just a test project to demonstrate a specific technology stack for an Up-Work tender

#### Easy to deploy based on:
Spring Boot + Spring Security + Ebean + Liquibase + Postgres

#### Setup Config expected under:
user.home + /xbook/conf/conf.xml (See resources folder for sample)
Config handling can be found in de.xbook.services.SystemEnvironment

#### Startup with:
mvn clean package && java -jar target/xbook-0.0.1-SNAPSHOT.jar
