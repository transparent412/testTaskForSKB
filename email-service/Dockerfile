FROM openjdk:11-jdk-oracle

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/email-service

COPY ${JAR_FILE} /opt/email-service/app.jar

EXPOSE 9001
ENTRYPOINT ["java","-jar","/opt/email-service/app.jar"]

