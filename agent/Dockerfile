
FROM adoptopenjdk/openjdk11:alpine
COPY . /usr/app/
WORKDIR /usr/app
RUN ls
ADD target/MFT-Agent-0.01-bin.zip /usr/app/
RUN unzip MFT-Agent-0.01-bin.zip
RUN ls
WORKDIR /usr/app/MFT-Agent-0.01/bin
RUN ls 
CMD sh agent-daemon.sh start