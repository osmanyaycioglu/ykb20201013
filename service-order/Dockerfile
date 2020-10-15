FROM openjdk:8-jdk-alpine
WORKDIR /order
COPY target/service-order-1.0.0.jar service-order-1.0.0.jar
EXPOSE 10000
ENV JAVA_PARM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${JAVA_PARM} service-order-1.0.0.jar" ]

