
FROM adoptopenjdk/openjdk11:alpine
COPY . /usr/app/
WORKDIR /usr/app
RUN ls
ADD target/API-Service-0.01-bin.zip /usr/app/
RUN unzip API-Service-0.01-bin.zip
RUN ls
WORKDIR /usr/app/API-Service-0.01/bin
RUN ls 
CMD sh api-service.sh start