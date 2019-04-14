FROM tomcat:8.0

WORKDIR /usr/local/tomcat/webapps
ADD ./target/gandalf.war .
