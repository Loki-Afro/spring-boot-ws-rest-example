spring-boot-ws-rest-example
===========================

Sample Spring Boot project, that inculedes a SOAP-Service and static HTML content. This project is also ready for a REST-Service in Spring-Boot style.


This project exists because i struggelded a lot with spring boot when I wanted to have a static html site and in the same tomcat a SOAP Service.

### What you will get
- SOAP Person-Service in a spring-boot project
- Second DispatcherServlet for static HTML content (could be a REST Servlet as well...)
- A nice template ;)


#### Building from source
After executing the following command you shoudl have a jar that can run everywhere in your target folder.
```mvn clean install```


### Let the project run
Will spring-boot tell to execute the application.
```mvn spring-boot:run```
What is happening now? With the power of spring-boot this will run a tomcat listening to port 8080, by default.
So simply go to http://localhost:8080/ to see your static-HTML content
The SOAP Service - wsdl is available through http://localhost:8080/ws/person-service.wsdl
You can throw the SOAP requests against this URL: http://localhost:8080/ws/ (for exmaple with SOAP UI) 

###Have Fun
