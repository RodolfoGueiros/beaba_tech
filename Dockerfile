# Use a imagem oficial do Maven para compilar o projeto
FROM maven:3.8.5-openjdk-21 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie os arquivos de configuração e dependências do Maven
COPY . .

# Execute o Maven para compilar o projeto
RUN mvn clean package -DskipTests

# Use a imagem do OpenJDK para executar a aplicação
FROM openjdk:21-jdk-alpine

# Copie o JAR gerado pela etapa anterior de build
COPY --from=build /app/target/*.jar app.jar

# Defina o comando de entrada para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]