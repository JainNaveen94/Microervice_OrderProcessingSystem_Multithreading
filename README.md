# Microervice_OrderProcessingSystem_Multithreading

It is a MicroService Backend Application or RestAPI Application which Basically Process the Order 
either a Single Order or Multiple Orders At the Same Time.

# Some Important Service in this are ::

1. #ProductService => For Product Fetching, Quantity Updation, Adding Product etc.
2. #PaymentService => For Payment Detail Fetching and updation of Payment.
3. #UserService => For User Detail Fetching.
4. #OrderService => for Order Fetching anf Generate Orders & related Products.
5. #OrderProcessingService => For Process the Single Order or multiple Order at the same Time.



The Specility Of this Application is that, here i can Perform Concurrent Programming in OrderProcessing Service to Process the Orders
and their related task concurrently by multiple Threads.


I had also Provide SQL Command File For Initially Setup the Data to Process the Result.


Here My DB Details are ::

DB Name :: MySQL

User :: admin ( But you can change it as per your DB UserName in application.properties of every services except OrderProcessing Service )

Pass :: admin ( But you can change it as per your DB Password in application.properties of every services except OrderProcessing Service )


Please Note ::

All Services required Configration are available in their application.properties file so change it as per your Requirement.

For Any Futher Help if you need in it then just Message me on Git, i will Provide Solution for it.

Thanks 
