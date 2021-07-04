# image
FROM java:8
# author
MAINTAINER wys
# copy the jar to the image
ADD ./target/RestSpingboot-1.0-SNAPSHOT.jar /RestSpingboot-1.0-SNAPSHOT.jar
# portal
EXPOSE 8080 8080
# cmd when image to container
ENTRYPOINT ["java","-jar","/RestSpingboot-1.0-SNAPSHOT.jar"]

# run cmd
# 1、 docker build -t house:v7 .
# 2、 docker run -d -p 8080:8080 house:v7