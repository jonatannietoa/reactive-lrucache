FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD /target/reactive-lrucache-1.0.0-SNAPSHOT app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]