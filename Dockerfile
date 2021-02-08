FROM openjdk:12
VOLUME /tmp
EXPOSE 8002
ADD ./target/springboot-products-items-0.0.1-SNAPSHOT.jar products-items.jar
ENTRYPOINT ["java","-jar","/products-items.jar"]