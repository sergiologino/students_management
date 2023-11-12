# image of java 17
FROM openjdk:17-oracle
# work dir of app in docker container
WORKDIR /app
# copying of jar file of application to container
COPY build/libs/studentmanagement-0.0.1-SNAPSHOT.jar app.jar
# command to run app
CMD ["java", "-jar","app.jar"]

