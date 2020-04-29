
FROM adoptopenjdk/openjdk11:alpine
COPY . /usr/app/
WORKDIR /usr/app
RUN ls
ADD target/Resource-Service-0.01-bin.zip /usr/app/
RUN unzip Resource-Service-0.01-bin.zip
RUN ls
WORKDIR /usr/app/Resource-Service-0.01/bin
RUN ls 
CMD sh resources-service-daemon.sh start