FROM openjdk:8-jdk

ADD exam-luis-0.0.1-SNAPSHOT.jar exam-luis-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /exam-luis-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://spring-demo-mongo/doodle","-Djava.security.egd=file:/dev/./urandom","-jar","/exam-luis-0.0.1-SNAPSHOT.jar"]