FROM openjdk:8

COPY . /usr/src/trola-micro

WORKDIR /usr/src/trola-micro

CMD java -cp module-webservices/target/classes:module-webservices/target/dependency/* com.kumuluz.ee.EeApplication

EXPOSE 8080
