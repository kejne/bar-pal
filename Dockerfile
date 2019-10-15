FROM openjdk:11-slim
VOLUME /tmp
ARG JAR_FILE
COPY build/libs/barpal-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","/app.jar","--spring.config.location=classpath:/application.yml,classpath:/application-docker.yml"]
