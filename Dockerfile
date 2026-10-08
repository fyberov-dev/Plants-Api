FROM eclipse-temurin:25-jre-alpine

RUN addgroup -S app && adduser -S app -G app -H -s /sbin/nologin

RUN mkdir /opt/app && chown app:app /opt/app
WORKDIR /opt/app

COPY --chown=app:app build/libs/plants-api-0.0.1-SNAPSHOT.jar /opt/app/app.jar
RUN chmod 0440 /opt/app/app.jar

USER app:app

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]