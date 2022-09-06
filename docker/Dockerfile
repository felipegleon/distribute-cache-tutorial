
FROM maven:3.8.6-openjdk-8

COPY distribute-cache-0.0.1-SNAPSHOT.jar /home/distribute-cache-0.0.1-SNAPSHOT.jar

RUN ["chmod", "+x", "/docker-entrypoint.sh"]

CMD ["java","-jar","/home/distribute-cache-0.0.1-SNAPSHOT.jar"]