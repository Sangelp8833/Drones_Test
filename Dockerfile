FROM openjdk:8-jdk-alpine
RUN mkdir /app
EXPOSE 8080
COPY /applications/app-service/build/libs/*.jar /app/applications.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/applications.jar"]