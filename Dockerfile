FROM rhel8-openjdk11-graal-native-base
USER root

RUN mkdir /var/app
COPY . /var/app/
RUN  cd  /var/app \ 
    && ./mvnw -Pnative -DskipTests package
RUN chmod +x /var/app/entrypoint.sh
RUN chmod +x /var/app/target/demo-0.0.1-SNAPSHOT-exec.jar
CMD [ "java", "-DspringAot=true", "-jar", "/var/app/target/demo-0.0.1-SNAPSHOT-exec.jar"]