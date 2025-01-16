FROM debian:bookworm-slim

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    wget \
    ca-certificates \
    gnupg \
    openjdk-17-jdk \
    curl

RUN rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

COPY target/*.jar /app/app.jar

WORKDIR /app

CMD ["java", "-jar","/app/app.jar"]