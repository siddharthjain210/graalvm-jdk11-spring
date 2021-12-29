FROM redhat/ubi8
USER root
RUN yum -y update
RUN yum --disableplugin=subscription-manager -y install java-11-openjdk java-11-openjdk-devel
RUN yum --disableplugin=subscription-manager -y install maven
RUN mkdir /var/app
COPY src /var/app/src
ADD pom.xml /var/app/pom.xml
RUN mvn -f /var/app/pom.xml install

CMD ["java", "-version"]