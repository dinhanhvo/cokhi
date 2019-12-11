ECHO OFF
call mvn clean package install
copy target\polls-0.0.1-SNAPSHOT.jar deploy\
java -jar deploy\polls-0.0.1-SNAPSHOT.jar