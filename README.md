## Exercise number 03.RESTful Webservices_Project Case Study_Updated
## Part 2

### Problem statement: 
check [part one](https://github.com/mancio/301JavaMicro) 

### Jar executable file
You can build a full working .jar by using the ```packege``` comand of maven.
This jar include all the springboot classes and tomcat. It is ready to use.
Just execute ```java -jar {filename}```

### Docker
The Dockerfile in the main directory can be executed to build a container
that run the microservice.

To see all the containers installed locally type
```docker ps -a```

To build the container go in the Dockerfile directory and type 
```docker build -t ImageName:TagName dockerfile_dir```
example ```docker build -t 301micro:0.1 .```

to execute a container in local type ```docker run -p 8080:8080 ImageName:TagName```
example ```docker run -p 8080:8080 301micro:0.1```

### Cache Management
```@EnableCaching``` Is used to enable Cache. This is used to save time during 
employees searching. The cache is free only after employees deletion due to the
changing of the table entries.

### Connected projects
This Microservice is part of an Architecture consisting in 3 Microservices:
 * [The edge](https://github.com/mancio/edge-service) is the entry point of the system. The user send the request to the edge.
 * The edge ask to the user to authenticate by using okta. After verify the identity,
 it authenticate to the core microservice [301javamicro](https://github.com/mancio/301JavaMicro_part2)
 * [MyEurekaService](https://github.com/mancio/MyEurekaService) is the service discovery able to track the status of both the services.

### Links
* [How to build microservices](https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot)
* [How to implement social auth with okta](https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth)
