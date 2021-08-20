# HOW TO RUN
# docker build --rm -f "Dockerfile" -t nome:tag "."
# docker run -it --rm --name nome nome:tag
# Cria uma imagem para fazer o build do seu projeto
FROM maven:3-openjdk-11-slim as Build
COPY . /workspace
WORKDIR /workspace
RUN mvn clean package
# Cria uma imagem para rodar o projeto
FROM openjdk:11-jre-slim
ARG JAR_FILE=/workspace/target/*.jar
COPY --from=Build ${JAR_FILE} app.jar
ENV PORT=8080
EXPOSE ${PORT}
ENTRYPOINT ["java","-Xmx512m","-Dserver.port=${PORT}","-jar","/app.jar"]