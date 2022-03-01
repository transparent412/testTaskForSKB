FROM openjdk:11-jdk-oracle

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/push-service

COPY ${JAR_FILE} /opt/push-service/app.jar

EXPOSE 9003
ENTRYPOINT ["java","-jar","/opt/push-service/app.jar"]
