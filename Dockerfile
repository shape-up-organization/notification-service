FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY build/libs/notification-service-0.0.1.jar notification.jar
ENV MONGO_URI=mongodb://localhost:27018/notification
EXPOSE 7002
ENTRYPOINT ["java", "-jar", "notification.jar"]