FROM openjdk:11
RUN mkdir -p /Users/user-svc/
ADD user-service-0.0.1-SNAPSHOT.jar /Users/user-svc/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh