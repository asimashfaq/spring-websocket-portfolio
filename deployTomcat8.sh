

mvn -U -DskipTests clean package

rm -rf /opt/tomcat/webapps/spring-websocket-portfolio*

cp target/spring-websocket-portfolio.war /opt/tomcat/webapps/

/opt/tomcat/bin/startup.sh
