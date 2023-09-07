FROM openjdk:11-jre

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY /build/libs/*.jar .

EXPOSE 8080
ENV DATABASE_URL=jdbc:mariadb://mariadb:3306/groomthon

CMD ["java", "-jar", "goormthon-0.0.1-SNAPSHOT.jar"]
