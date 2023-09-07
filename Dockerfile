FROM gradle:8.3-jdk11

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
ENV DATABASE_URL=jdbc:mariadb://mariadb:3306/groomthon

COPY . .
RUN echo "systemProp.http.proxyHost=krmp-proxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" > /root/.gradle/gradle.properties
RUN gradle wrapper

RUN ./gradlew clean build

EXPOSE 8080

CMD ["java", "-jar", "/usr/app/build/libs/goormthon-0.0.1-SNAPSHOT.jar"]
