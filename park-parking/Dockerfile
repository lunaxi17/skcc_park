#FROM maven:3.5-jdk-8
#ADD target/donate-user-0.0.1-SNAPSHOT.jar donate-user-0.0.1-SNAPSHOT.jar
#EXPOSE 11001
#ENTRYPOINT ["java", "-jar", "donate-user-0.0.1-SNAPSHOT.jar"]

# select image
FROM maven:3.5-jdk-8

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies for offline use
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package

# set the startup command to run your binary
CMD ["java", "-jar", "./target/park-parking-0.0.1-SNAPSHOT.jar"]
