FROM openjdk:21-slim
EXPOSE 8080
RUN mkdir /home/app
RUN mkdir /home/app/properties

WORKDIR /home/app/properties
COPY resources/docker/application.properties .

WORKDIR /home/app
COPY target/opaque-questionengine-0.0.1-SNAPSHOT.jar .

CMD ["java", "--add-opens", "java.base/jdk.internal.misc=ALL-UNNAMED", "-Dspring.profiles.active=prod", "-Dspring.config.location=/home/app/properties/application.properties", "-jar", "opaque-questionengine-0.0.1-SNAPSHOT.jar"]
