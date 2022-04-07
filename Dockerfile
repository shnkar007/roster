FROM openjdk:11
#ARG JAR_FILE=/target/complaintredressal-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} compapp.jar
#ENTRYPOINT ["java","-jar","/complaintredressal.jar"]
EXPOSE 8082
ADD /target/roster-0.0.1-SNAPSHOT.jar roster.jar
ENTRYPOINT ["java","-jar","roster.jar"]