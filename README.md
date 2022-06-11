# ombudsman-crud

A simple crud web system for a company's ombudsman department

![](/src/doc/web-system.gif)

## What's inside 🤔
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Jar Packaging
- Spring Core
- Spring Data (Hibernate, SQL Server)
- [Thymleaf](https://thymeleaf.org)
- Javascript (Jquery & Ajax)

## Functionality of each page 🛠️
- Index ( Ajax GET Request )
- Manifestation ( Insert, Update, Delete Select & Excel export) 
- Protesters ( Insert, Update, Delete Select )
- Protests ( Insert, Update, Delete Select )
- Types of Manifestation ( Insert, Update, Delete Select )
- Tags ( Insert, Update, Delete Select )


## Database configuration ⚙️
Create a SQL SERVER database and add the connection string to `/resources/application.properties`.  
The default ones are :

```properties
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.url=jdbc:sqlserver://your_ip_address:1521;databaseName=YOUR_DATABASE_NAME
spring.datasource.username=your_usename_]
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Executing the project ▶️
Run the project through the IDE and access the following address in your browser [http://localhost:8080](http://localhost:8080)
