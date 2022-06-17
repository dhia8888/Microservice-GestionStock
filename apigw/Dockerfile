FROM  openjdk:8
EXPOSE 8054
ADD /target/apigw-0.0.1-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]