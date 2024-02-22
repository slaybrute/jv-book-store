FROM openjdk:17-jdk
WORKDIR jv-book-store
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} book-store.jar
RUN java -Djarmode=layertools -jar book-store.jar extract

FROM openjdk:17-jdk
WORKDIR jv-book-store
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
EXPOSE 8080
