FROM autocorrection:17
MAINTAINER Melanie
COPY target/Melanie-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]