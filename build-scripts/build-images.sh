#!/bin/bash

function build_basic() {
  JAR_FILE=$1
  APP_NAME=$2

  docker build -f ./build-scripts/docker/Dockerfile \
    --build-arg JAR_FILE=${JAR_FILE} \
    -t ${APP_NAME}:latest .
}

APP_VERSION=0.0.1-SNAPSHOT

# Building the app
cd ..

echo "Building JAR files"
mvn clean package -DskipTests

echo "Building Docker images"
build_basic ./discovery-service/target/discovery-service-${APP_VERSION}.jar application/discovery-service
build_basic ./examinator/target/examinator-${APP_VERSION}.jar application/examinator
build_basic ./java_quiz/target/java_quiz-${APP_VERSION}.jar application/provider-java-quiz
build_basic ./kubernetes/target/kubernetes-${APP_VERSION}.jar application/provider-kubernetes-question