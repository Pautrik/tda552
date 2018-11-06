FROM debian:sid

ARG gradle_version=4.10.2

RUN apt-get update && \
    apt-get install -y openjdk-11-jdk-headless wget unzip

WORKDIR /tmp

RUN wget "https://services.gradle.org/distributions/gradle-${gradle_version}-bin.zip" && \
    unzip -d /opt gradle-${gradle_version}-bin.zip

ENV PATH "$PATH:/opt/gradle-${gradle_version}/bin"