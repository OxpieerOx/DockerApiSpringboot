FROM ubuntu:18.04
RUN apt-get update -y
RUN apt-get install -y openjdk-17-jre-headless
WORKDIR /app
COPY . /app
ENTRYPOINT ["java", "-jar"]
CMD ["./target/ApiAnuncioAlbergue-1.jar"]
