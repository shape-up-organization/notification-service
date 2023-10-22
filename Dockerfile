FROM openjdk:17-jdk-slim
VOLUME /tmp

ENV POSTGRES_URL=jdbc:postgresql://postgresdb:5432/shapeup-notification
ENV POSTGRES_PASSWORD=shapeup-notification
ENV POSTGRES_USER=shapeup-notification
ENV MAIL_HOST=smtp.gmail.com
ENV MAIL_PORT=587
ENV MAIL_USERNAME=shapeupnotification@gmail.com
ENV MAIL_PASSWORD=csnetdtfzniapnje
COPY build/libs/notification-service-0.0.1.jar notification.jar

EXPOSE 7002
ENTRYPOINT ["java", "-jar", "notification.jar"]