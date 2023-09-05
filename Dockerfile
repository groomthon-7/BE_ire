FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.3.1-jdk17

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build/libs/*.jar application.jar

EXPOSE 8080

CMD ["java", "-jar", "application.jar"]