
FROM adoptopenjdk/openjdk11:alpine
COPY . /usr/app/
WORKDIR /usr/app
RUN ls
ADD target/Secret-Service-0.01-bin.zip /usr/app/
RUN unzip Secret-Service-0.01-bin.zip
RUN ls
WORKDIR /usr/app/Secret-Service-0.01/bin
RUN ls 
CMD sh secret-service.sh start