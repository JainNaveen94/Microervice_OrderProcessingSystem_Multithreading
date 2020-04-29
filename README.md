# Microservice_OrderProcessingSystem_Multithreading

***It is a MicroService Backend Application or RestAPI Application which Basically Process the Order 
either a Single Order or Multiple Orders At the Same Time.***

## Some Important Service in this are ::

  1. **ProductService** => For Product Fetching, Quantity Updation, Adding Product etc.
  2. **PaymentService** => For Payment Detail Fetching and updation of Payment.
  3. **UserService** => For User Detail Fetching.
  4. **OrderService** => for Order Fetching anf Generate Orders & related Products.
  5. **OrderProcessingService** => For Process the Single Order or multiple Order at the same Time.
  6. **EurekaNamingService** => Naming Service for Other Services Registery and Discovery Purpose.
  7. **ZuulAPIGatewayService** => API Gateway Provided by Netflix to route the Requested Service from it.
  
### Port Address For The Services

| **Service Name**  | **URL:Port Address** |
| ------------- | ------------- |
| **ProductService**  | http://localhost:9000  |
| **PaymentService**  | http://localhost:5000  |
| **UserService**  | http://localhost:6000  |
| **OrderService**  | http://localhost:7000  |
| **OrderProcessingService**  | http://localhost:8000  |
| **EurekaService**  | http://localhost:8761  |
| **APIGateway**  | http://localhost:8765  |

The Specility Of this Application is that, here i can Perform **Concurrent Programming in OrderProcessing Service** to Process the Orders
and their related task concurrently by multiple Threads.

I had also Provide [SQL Command File](/SQL Commands.txt) For Initially Setup the Data to Process the Result.


## Here My DB Details are ::

  1. **DB Name ::** MySQL
  2. **User ::** admin ( But you can change it as per your DB UserName in **application.properties** of every services except OrderProcessing Service )
  3. **Pass ::** admin ( But you can change it as per your DB Password in **application.properties** of every services except OrderProcessing Service )


## Please Note ::
  1. All Services required Configration are available in **application.properties** file so change it as per your Requirement.
  2. For Any Futher Help if you need in it then just Message me on Git, i will Provide Solution for it.

### Thanks 
