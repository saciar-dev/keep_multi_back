FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/KeepSmilingBack-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} keep-smiling-back.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "keep-smiling-back.jar"]