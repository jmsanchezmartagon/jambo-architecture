FROM alpine:latest
RUN apk update && apk add openjdk21 bash
RUN mkdir -p /opt/app
WORKDIR /opt/app
ENTRYPOINT ["java", "-jar", "music-0.0.1-SNAPSHOT.jar"]