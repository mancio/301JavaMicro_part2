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

To build the container go in the Dockerfile directory and type 
```docker build -t ImageName:TagName dockerfile_dir```

to execute container in local type ```docker run -p 8000:8080 ImageName:TagName```

### What to do now:
Implement:
* OAuth2
* JWT
* Okta
* Doker
* ecc...

