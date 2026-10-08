FROM eclipse-temurin:25-jre-alpine

RUN addgroup -S app \
    && adduser -S app -G app -H -s /sbin/nologin \
    && mkdir -p /opt/app \
    && chown app:app /opt/app

WORKDIR /opt/app

COPY --chown=app:app --chmod=0440 \
    build/libs/plants-api-0.0.1-SNAPSHOT.jar ./app.jar

USER app:app

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]