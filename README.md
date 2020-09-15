# Spring-Boot
Spring Boot different examples

# End users 
Is a simple project which has Person related API's like create a person & get a person based on email
This uses Postgresql as a database, swagger configuration: 
```
localhost:9091/swagger-ui.html
```

# Send Mail
Is a spring boot thymeleaf working example> These runs on 9092 port.
To Test use 
```
POST localhost:9092/getdetails
```
RequestBody as 
```
{
   "name":"Your Name",
   "age" xx,
   "Country":Your Country",
   "email":"Mail to which you want to send notification"
}
```
