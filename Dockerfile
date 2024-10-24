# Etapa de build
FROM ubuntu:latest AS build

# Atualiza os pacotes e instala o JDK 21
RUN apt-get update && apt-get install openjdk-21-jdk -y

# Define o diretório de trabalho
WORKDIR /app

# Copia todo o conteúdo do projeto para o diretório de trabalho
COPY . .

# Instala o Maven e constrói o projeto
RUN apt-get install maven -y && mvn clean install

# Etapa final para rodar a aplicação
FROM openjdk:21-jdk-oracle

# Exponha a porta em que a aplicação estará rodando
EXPOSE 8080

# Copia o arquivo JAR da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Define o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]