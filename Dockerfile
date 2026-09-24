FROM gradle:8.14-jdk21-alpine AS build
WORKDIR /app
COPY . .
RUN  gradle build --no-daemon


FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build  /app/build/libs/*.jar /app/javanauta-cadastro-usuario.jar
EXPOSE 8080
CMD ["java" , "-jar", "/app/javanauta-cadastro-usuario.jar"]