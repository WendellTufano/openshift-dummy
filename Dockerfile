# Usando a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven para o container
COPY target/*.jar app.jar

# Expõe a porta que a aplicação utilizará
EXPOSE 8080

# Comando para rodar o Spring Boot dentro do container
ENTRYPOINT ["java", "-jar", "app.jar"]
