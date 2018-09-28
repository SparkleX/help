FROM java:8
ADD / /b1_webclient
WORKDIR /b1_webclient
ENV b1_jdbc_url jdbc:sap://10.58.1.118:30015/?user=SYSTEM&password=manager
ENV b1_svcl_url https://10.58.1.118:50000

#RUN chmod 777 /home/entry.sh
#ENTRYPOINT ["sh", "entry.sh"]
#VOLUME /b1_webclient
#RUN apt-get update && apt-get install -y dos2unix
#RUN dos2unix /home/entry.sh
#RUN apt-get --purge remove -y dos2unix && rm -rf /var/lib/apt/lists/*
CMD ["bash", "entry.sh"]
#CMD java -jar name.jar
EXPOSE 8888