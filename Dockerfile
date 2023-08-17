FROM openjdk:17
EXPOSE 9090
ADD target/quick-analytics-0.0.1-SNAPSHOT.jar quick-analytics
ENTRYPOINT ["java","-jar","/quick-analytics"]

FROM postgres
ENV POSTGRES_USER romansulymka
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB analytics
COPY init.sql /quick-analytics/