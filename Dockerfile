FROM openjdk:11

WORKDIR /app

COPY target/api-green-heart-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8443

COPY greenheart2.p12 /home/ubuntu/chave/greenheart2.p12

ENV AZURE_USER=admin-3adsb-grupo07
ENV AZURE_PASSWORD=#urubu100
ENV MERCADOPAGO_TOKEN=TEST-3225178416011289-031221-2bb3996731fe2b4386a3516cd1aba448-397254742

CMD ["java", "-jar", "app.jar"]
