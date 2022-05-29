FROM openjdk:8-jre-alpine3.9
# copy the packaged jar file into our docker image
COPY target/GesF-1.0.jar /demo.jar
# set the startup command to execute the jar
CMD ["java", "-jar", "/demo.jar"]
