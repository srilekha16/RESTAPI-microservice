# RESTAPI-microservice
Spring boot REST API microservice
## Table of Contents:<br />
1.[Database Tables](#Database--Tables)<br />
2.[Technologies Used](#Technologies--Used)<br />
3.[Swagger UI](#Swagger--UI)<br />
4.[Code Description](#Code--Description)<br />
5.[Custom Logging: Log4j2](#Custom--Logging--Log4j2)<br />
6.[Exception Handling](#Exception--Handling)<br />
7.[Health Check Endpoint](#Health--Check--Endpoint)<br />
8.[Test Cases](#Test--Cases)<br />
Method 1 - CalculateRewardPoints<br />
           TC-1: Returns reward points when amount spend is provided.<br />
           TC-2: Exception occurs when user does not provide required amount spent by the customer as a parameter.<br />
           TC-3: Exception occurs when amount spent provided is negative.<br />
                      
Method 2 - GetRewardSummaryAll<br />
           TC-1: Calculates and returns reward points of three months and total reward points of the customer when id is provided.<br />
           TC-2: Exception occurs when id parameter in request body for POST request is missing..<br />
          


## Database Tables:
The Database using is inmemory H2 DB, Here's the picture of the console of H2 DB.
<img width="958" alt="consoleofdb" src="https://user-images.githubusercontent.com/110694480/183493791-afddf51c-62dc-4258-bb2d-fd15b12810c7.PNG">

Table1: Transactionlist
        
    All the customer related and their respective transactions related data will be stored in his table.
<img width="716" alt="db" src="https://user-images.githubusercontent.com/110694480/183492071-e8a4e3c3-9a32-46f0-942a-7f15841c483b.PNG">

## Technologies Used:
It inludes <br />
    * Spring Boot framewrok with Java.<br />
    * Inmemory H2 Database.<br />
    * RESTful web service with Spring Boot, along with Spring JPA.<br />
Tools: Spring tool suite(STS)<br />
 
      Controller picture:
 <img width="887" alt="technolgies" src="https://user-images.githubusercontent.com/110694480/183495271-d053734c-fbe6-4076-bd32-15da60fd6b74.PNG">
 
     Repository picture: CRUD
  <img width="899" alt="repo" src="https://user-images.githubusercontent.com/110694480/183495778-9dfd169a-8d41-476f-b356-ee20178ca1a0.PNG">
  
  ## Swagger UI
  Here's the Swagger UI picture for the application. It consists of GET and POST mappings. It is implemented in the project using OpenAPI 3.0.<br />
  GET request is used to take amount spent as input and calculates and returns reward points as output.<br />
  POST request is used to take id of customer as input in request body, get required data of customer with provided id from Database and calculates three months and total reward points of the customer and returns it as result.<br />
  POST mapping is used when dealing with customer id as it is more secure than the GET request, because the parameters are stored neither in the browser history nor in the web server logs and they are not part of the URL, in this way we can secure the id of the customer as it is not part of the URL.<br />
        
         
  <img width="944" alt="swagger2" src="https://user-images.githubusercontent.com/110694480/183498083-4cf3e5f0-d834-413d-ac09-c1c8d95184b1.PNG">
  
  ## Code Description
  Retailer2CustomerAPI project is a microservice, built using Java-based Spring framework and it's features like actuator, Auto-configuration. The application runs on Apache Tomcat server.
  
     These are the components of the application present in src/main/java/com/retailer2customer.
  ![image](https://user-images.githubusercontent.com/110694480/183500492-83a96278-c7fa-4314-9dd3-3a5808f30a30.png)
     
      1.Controller
        * This contains RESTController class which is reponsible for mapping the user requests to defined request handler method.<br />
        * It contains two mappings GET and POST. GET request is used to take amount spent as input and calculates and returns reward points as output.<br />
        * POST request is used to take id of customer as input in request body, get required data of customer with provided id from Database and calculates three months and total reward points of the customer and returns it as result.<br />
        * POST mapping is used when dealing with customer id as it is more secure than the GET request, because the parameters are stored neither in the browser history nor in the web server logs and they are not part of the URL, in this way we can secure the id of the customer as it is not part of the URL.<br />
        
      2.Entity
        *This contains entites for Database. 
        
      3.Error Handler.
         *This contains classes which are responsible for Exception handling of the app. <br />
         * It contains a global exception handler class which handles all the exceptions that occur in the RESTController classes.
      
      4.Model
        * This contains all Java POJO classes required for the application.
         
      5.Repository
        * This contains Data Repositories related logic.
         
      6.Service
        * This contains bussiness reated logic for the application.
         
      7.Retailer2CustomerApplication.java
         * It is the main class of the application.
          
          
  ## Custom Logging: Log4j2 
    * Logging is implemented in the project using log4j2.<br /> * Here's the confiuration file.<br />
    * Implemented Rolling log files with Time based policy which is 1 day
   <img width="882" alt="log" src="https://user-images.githubusercontent.com/110694480/183504510-c9262150-7723-46dc-83a8-f296d26c645f.PNG">
   
   
   ## Exception Handling
    * Exception Handling is implemented by creating User defined Exceptions, extending RsponseEntityExceptionHandler (A convenient base class for @ControllerAdvice classes that wish to provide centralized exception handling across all @RequestMapping methods through @ExceptionHandler methods.
    This base class provides an @ExceptionHandler method for handling internal Spring MVC exceptions and returns a ResponseEntity object.)
   <img width="873" alt="exceptionclass" src="https://user-images.githubusercontent.com/110694480/183505983-255fbc58-4027-4575-8c85-2fe87d1d03cf.PNG">

   ## Health Check Endpoint    
    This has been implemented using spring boot starter actuator. It returns status as UP which indicates application is healthy and running without any interruption
   <img width="957" alt="healthendpoint" src="https://user-images.githubusercontent.com/110694480/183506512-0b5070c9-78a2-43ea-ba7d-ac24bc482196.PNG">

  ## Test Cases
  Method 1 - CalculateRewardPoints-GET Request<br />
   TC-1: Returns reward points when amount spend is provided.<br />
   Amount spent=110, Resulted reward points=70<br />
           <img width="792" alt="get_working" src="https://user-images.githubusercontent.com/110694480/183507645-50d9d5d5-c3fd-479b-b147-4ce00ed1f77c.PNG">
           
   TC-2: Exception occurs when user does not provide required amount spent by the customer as a parameter i.e when the value of amount spent parameter is missing.
   Missing amounts spent. <br />
           <img width="795" alt="getreq_missingparam" src="https://user-images.githubusercontent.com/110694480/183508377-a92f0827-d185-4d00-be10-688bf3c2e0ba.PNG">

   TC-3: Exception occurs when amount spent provided is negative.<br />
           <img width="798" alt="get_negative" src="https://user-images.githubusercontent.com/110694480/183508500-b4347381-74f6-4513-82da-5b6938c5484e.PNG">
           
           
           
   Method 2 - GetRewardSummaryAll-POST Request<br />
    TC-1: Calculates and returns reward points of three months and total reward points of the customer when id is provided.<br />
    Given id is 2.<br />
   <img width="781" alt="customerbyid" src="https://user-images.githubusercontent.com/110694480/183509082-34ae4ad9-0ee1-498c-9381-7cda7ac7462e.PNG">

   
   TC-2: Exception occurs when id parameter in request body for POST request is missing. <br /> 
   Id parameter is missing.<br />
            <img width="791" alt="customerbyidmissingexception" src="https://user-images.githubusercontent.com/110694480/183509210-9b6b3330-8776-4b8b-9816-a9f6fb3d381b.PNG">




  

 


