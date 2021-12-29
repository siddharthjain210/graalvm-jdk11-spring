FROM redhat/ubi8
USER root
RUN yum -y update
RUN yum --disableplugin=subscription-manager -y install java-11-openjdk java-11-openjdk-devel
# RUN yum --disableplugin=subscription-manager -y install maven
RUN mkdir /var/app
COPY . /var/app/
RUN  cd  /var/app \ 
    && ./mvnw install
ENTRYPOINT [ "/var/app/entrypoint.sh" ]