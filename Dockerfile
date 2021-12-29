FROM redhat/ubi8
USER root
RUN yum -y update
RUN yum --disableplugin=subscription-manager -y install java-11-openjdk java-11-openjdk-devel
# RUN yum --disableplugin=subscription-manager -y install maven
RUN mkdir /var/app
COPY src /var/app/src
COPY pom.xml /var/app/pom.xml
COPY .mvn /var/app/.mvn
COPY mvnw /var/app/
RUN  cd /var/app/ \
    && ./mvnw -f /var/app/pom.xml install

CMD ["java", "-version"]