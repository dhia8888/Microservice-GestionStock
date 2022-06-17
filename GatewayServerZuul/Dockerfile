FROM openjdk:8
EXPOSE 8803
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} GatewayServerZuul-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "GatewayServerZuul-0.0.1-SNAPSHOT.jar" ]