# rabbit_start

To run this test application with docker you have to follow these steps:
  1. Create jar file: 
          mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
          
  2. Create image for spring app via Dockerfile:
          docker build -t sumeriancore/spring-app-rabbit .
    
  3. Run docker-compose file to create related containers:
          docker-compose up
  
  4. Test your application via Postman:
           POST http://localhost:8081/emit
           
           something like:
           
           {
              "key" : "info.listener",
              "message" : "info.message"
            }
            
