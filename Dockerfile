FROM redhat/ubi8
USER root
RUN yum -y update
RUN yum --disableplugin=subscription-manager -y install java-11-openjdk java-11-openjdk-devel



# RUN yum --disableplugin=subscription-manager -y install maven
RUN mkdir /var/app
COPY . /var/app/

RUN yum install -y wget
ARG VERSION=21.3.0

RUN wget https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-$VERSION/graalvm-ce-java11-linux-amd64-$VERSION.tar.gz  
RUN mkdir -p /opt/graalvm \
    && tar -xvzf graalvm-ce-java11-linux-amd64-$VERSION.tar.gz -C /opt/graalvm
RUN rm graalvm-ce-java11-linux-amd64-$VERSION.tar.gz
ENV PATH=/opt/graalvm/graalvm-ce-java11-21.3.0/bin:$PATH
RUN gu install native-image
RUN native-image --version
RUN java -version

RUN  cd  /var/app \ 
    && ./mvnw install
RUN chmod +x /var/app/entrypoint.sh
ENTRYPOINT [ "/var/app/entrypoint.sh" ]