FROM openjdk:8-jdk-alpine
EXPOSE 8080
# the final jar with spring and tomcat included is inside build folder
ARG JAR_FILE=build/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]