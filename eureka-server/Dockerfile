FROM openjdk:11-jdk-oracle

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/eureka-server

COPY ${JAR_FILE} /opt/eureka-server/app.jar

EXPOSE 8761
ENTRYPOINT ["java","-jar","/opt/eureka-server/app.jar"]

