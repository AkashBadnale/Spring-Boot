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

# activemq-producer-example & activemq-consumer-example


<h3> Basics of ActiveMQ & JMS </h3> 

ActiveMQ is an open source protocol developed by Apache which functions as an implementation of message-oriented middleware (MOM). 
Its basic function is to send messages between different applications, 
but includes additional features like STOMP, JMS, and OpenWire. It supports enterprise features and a high number of transport protocols.

Written in Java, ActiveMQ translates messages from sender to receiver. It can connect multiple clients and servers and allows messages to be held in queue, 
instead of requiring both the client and server to be available simultaneously in order to communicate. 
Messaging can still happen even if one application is temporarily indisposed.

In order to send or receive messages through JMS, we need a connection to JMS provider, obtain session, create destination creation, 
the JMS API involved becomes too verbose and repetitive. JmsTemplate is a helper class that simplifies receiving and sending of messages through JMS and gets rid of the boilerplate code.

JmsTemplate simplifies the development efforts on constructing the message to send or processing messages that are received through synchronous JMS access code.

** ---------------------------------------

<h3> ActiveMQ Installation & running steps </h3>

Download zip from here https://activemq.apache.org/download.html, unzip it - go to bin folder and run .bat file
You will see web console at http://localhost:8161.
The default username is admin, and the password is admin.
Click on the Manage ActiveMQ broker link to open the ActiveMQ console window

** ---------------------------------------

<h3> Creating a Producer application </h3>

@Configuration: This annotation marks the class as a configuration class and adds it to the Spring application context.
MessageConverter: We are using MappingJackson2MessageConverter, and the target type is of Text format. The DTO object sent to the message queue in the JSON text format.
TypeId: An id that should match both on the consumer and producer side. We can set any value as TypeID.

Spring framework provides a JmsTemplate that we can use to publish the message to the ActiveMQ message queue.
The convertAndSend() method serializes the object and sends it to the message queue.

spring.activemq.in-memory: Value is set to false, as we are using external ActiveMQ server.
spring.activemq.broker-url: ActiveMQ broker URL.
Set the Username and password if any is using the spring.activemq.user and spring.activemq.password configuration properties.
activemq.destination: A queue/topic name to which the data is published.

Run the application - using postman/any tool -
POST - http://localhost:9093 - { "name" : "anything", "id" : 1 }

Go to ActiveMQ console window, you will see the a queue is produced. And waiting to be consumed.

** ---------------------------------------

<h3> Creating a producer application </h3>

Run the application, you will see on the console the consumed queue's message.

** ---------------------------------------
