FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# sudo docker build -t iticjobs:1.0 .
# sudo docker image list
# sudo docker run -p 8080:8080 --name nomcontainer -d -t iticjobs:1.0
# docker stop nomcontainer
# docker start nomcontainer
# docker stats
# docker logs -f nomcontainer
# docker rm nomcontainer
# docker login
# docker tag iticjobs:1.0 talego/iticjobs:1.0
# docker push talego/iticjobs:1.0

# Desde el server:
# sudo docker run -p 8080:8080 --name nomcontainer -d -t talego/iticjobs:1.0