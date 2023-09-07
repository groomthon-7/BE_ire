FROM openjdk:11-jre

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build/libs/*.jar application.jar

EXPOSE 8080
ENV DATABASE_URL=jdbc:mariadb://mariadb/groomthon

CMD ["java", "-jar", "application.jar"]
