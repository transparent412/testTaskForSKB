FROM openjdk:11-jdk-oracle

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/gateway-service

COPY ${JAR_FILE} /opt/gateway-service/app.jar


EXPOSE 8762
ENTRYPOINT ["java","-jar","/opt/gateway-service/app.jar"]
