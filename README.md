# Email-Service-Spring
 A Restful web service to send Emails via SMTP using Spring Boot.
 
How to use?

1 - Setup your SMTP server and username/password in the Application.properties file.
2 - When you run the application, an apache service is running, if it says port 8080 is blocked, change it in this line also in Application.properties:
server.port = 9090
3 - run the app.

Note: this package is using Javamail, https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/mail/javamail/package-summary.html
