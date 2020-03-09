FROM java:8
EXPOSE 8089

VOLUME /tmp
ADD internal-control.jar  /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
