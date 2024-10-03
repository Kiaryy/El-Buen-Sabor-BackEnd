FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
COPY demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080