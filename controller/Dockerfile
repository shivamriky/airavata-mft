
FROM adoptopenjdk/openjdk11:alpine
COPY . /usr/app/
WORKDIR /usr/app
RUN ls
ADD target/MFT-Controller-0.01-bin.zip /usr/app/
RUN unzip MFT-Controller-0.01-bin.zip
RUN ls
WORKDIR /usr/app/MFT-Controller-0.01/bin
RUN ls 
CMD sh controller-daemon.sh start