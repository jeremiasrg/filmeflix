FROM openjdk:8
ADD target/filme-flix-api.jar filme-flix-api.jar
EXPOSE 8090
ENTRYPOINT [ "java", "-jar", "filme-flix-api.jar"]
ENV MONGODB_URI ''