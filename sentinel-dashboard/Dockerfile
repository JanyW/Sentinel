FROM openjdk:8u201-alpine3.9

MAINTAINER janyw@foxmail.com

ENV APOLLO_API_URL default
ENV APOLLO_API_TOKEN bdefault
ENV APOLLO_API_APPID default
ENV APOLLO_API_ENV default
ENV APOLLO_API_CLUSTER default
ENV APOLLO_API_NS default
ENV APOLLO_API_NS default

ADD target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT java -Dapollo.api.url=$APOLLO_API_URL -Dapollo.api.token=$APOLLO_API_TOKEN -Dapollo.api.appId=$APOLLO_API_APPID \
 -Dapollo.api.env=$APOLLO_API_ENV -Dapollo.api.cluster=$APOLLO_API_CLUSTER -Dapollo.api.namespace=$APOLLO_API_NS \
 -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard \
 -jar app.jar