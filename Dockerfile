FROM debian:buster

RUN apt-get update && \
    apt-get install -y openjdk-11-jdk-headless junit gradle
