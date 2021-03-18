FROM gradle:6.5.1-jdk11 as build

USER root


COPY --chown=gradle:gradle . /git/for_lab
WORKDIR  /git/for_lab
RUN gradle build --stacktrace

FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8080

ENV LD_LIBRARY_PATH /usr/lib
COPY --from=build /git/for_lab/vpn/build/libs/*.jar app.jar
CMD java -Xmx100m -jar /app.jar