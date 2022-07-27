FROM openjdk:17
ADD /target/docker_demo-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]
