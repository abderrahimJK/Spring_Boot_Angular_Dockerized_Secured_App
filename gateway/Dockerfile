FROM openjdk:21-oracle
VOLUME /tmp
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway-service.jar
ENTRYPOINT ["java","-jar","/gateway-service.jar"]