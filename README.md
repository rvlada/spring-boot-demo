# spring-boot-demo
Simple demo for Spring Boot deployable to Heroku

[![Build Status](https://travis-ci.org/rvlada/spring-boot-demo.svg?branch=master)](https://travis-ci.org/rvlada/spring-boot-demo)

This is a simple Spring Boot application which uses Spring, Postgres/HSQLDB, Rest, jQuery and Bootstrap. You can see it live here (it's deployed to free dyno on Heroku, and it might be slow at start):

[https://peaceful-taiga-63635.herokuapp.com/](https://peaceful-taiga-63635.herokuapp.com/)

## Deploying on Heroku
The main idea about this demo was testing Spring Boot with Heroku, so it is easily deployable following this [Heroku tutorial](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku).
Default database is set to Postgres, so make sure you activate your Heroku Postgres add-on.
If you want to use in-memory database, you can build application using 'in-memory-db' maven profile (there is short explanation how to use custom build command with Procfile in tutorial).

## Running the application locally
The easiest way to get this app running is to build it using `mvn clean install -Pin-memory-db` (which starts the app with in memory HSQLDB), and then running it by `java -jar target/spring-boot-demo-1.0-SNAPSHOT.jar`.
Spring Boot wraps Tomcat inside, so the app is deployed to `locahost:8080`.

*Hibernate is configured to drop and re-create tables on each deploy (which destroys all the data). If you wish to change it, you can modify `spring.jpa.hibernate.ddl-auto` property in application.properties file.*
