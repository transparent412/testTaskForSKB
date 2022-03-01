FROM openjdk:11-jdk-oracle

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/sms-service

COPY ${JAR_FILE} /opt/sms-service/app.jar

EXPOSE 9002
ENTRYPOINT ["java","-jar","/opt/sms-service/app.jar"]

