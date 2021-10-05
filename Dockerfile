FROM openjdk:11
ADD target/Safari-webstore-008-0.0.1-SNAPSHOT.jar Safari-webstore-008-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","Safari-webstore-008-0.0.1-SNAPSHOT.jar"]
