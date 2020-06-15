## Exercise number 03.RESTful Webservices_Project Case Study_Updated
## Part 2

### Problem statement: 
check [part one](https://github.com/mancio/301JavaMicro) 

### Jar executable file
[Here](https://github.com/mancio/301JavaMicro_part2/tree/master/build) you
can fine the executable jar version of the microservice. This jar include all
the springboot classes and tomcat. It is ready to use.
Just execute ```java -jar {filename}```

### Docker
The Dockerfile in the main directory can be executed to build a container
that run the microservice.

To see all the containers installed locally type
```docker ps -a```

To build the container go in the Dockerfile directory and type 
```docker build -t ImageName:TagName dockerfile_dir```

to execute a container in local type ```docker run -p 8080:8080 ImageName:TagName```

### Cache Management
```@EnableCaching``` Is used to enable Cache. This is used to save time during 
employees searching. The cache is free only after employees deletion due to the
changing of the table entries.

### What to do now:
Implement:
* Implement Authentication using OAuth2 framework to enable social logins - Facebook, Twitter, Gmail etc.,
* Implement security policies for APIs of your application
* Deploy Spring Boot services using Docker containers
* Use Apache/Spring Kafka to implement Microservices communications and Enable user activities
* Use Spring Cache and Spring Boot to perform CRUD operations
* Build Microservice applications using Spring Cloud and Netflix OSS 

