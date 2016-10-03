

mvn -U -DskipTests clean package

rm -rf /Library/Tomcat//webapps/spring-websocket-portfolio*

cp target/spring-websocket-portfolio.war /Library/Tomcat//webapps/

/Library/Tomcat//bin/startup.sh
