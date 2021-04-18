# MyRetail: 
https://github.com/saichaitanyav/microServiceApp is the my retail application which fetches products with price information , developed with spring boot micro services, java , maven, postgres.

Publishes  REST API endpoints,  for creating/updating/retrieving products with price. 

Technologies Used:

| Technology    | Version       |
| ------------- | ------------- |
| Java          | 8  |
| SpringBoot    | 2.3.9|
|Postgres       | 13|
|Maven          |3.6.3


## Steps to run the project 
Pre-requisite:  Install Postgres, maven, JDK, JRE,Postman
1. Clone this project   and clone the config server at https://github.com/saichaitanyav/config-server
2. In Product-service, update the application.yml with the port number of your local port and DB details of the postgres.
3. In Price-service, update the application.yml with the port number of your local port and DB details of the postgres
4. Config server is accessed at https://github.com/saichaitanyav/config-server/
5. Run the below microservices either using the command line jar (or) by spring boot run command
    1. product-service,
    2. price-service, 
    3. cloud-gateway, 
        a. circuitbreaker and fall back methods implemented.
    5. service-registry,
    6. hystrix-dashboard,
    7. config-server
7. In postman, access the endpoints through cloud API gateway port number(9191) and can be accessed through http://localhost:9191/products ,http://localhost:9191/price

End points: 
- GET:  /products/{id}  retreives product with price details  
- GET: /products/product/{id} retreive single product details if found  
- POST: /products/ creates new product  


GET /products/{id}
* Example response:

{
    "id": 16752456, 
    "name": "The plasma screen Big-test",
    "current_price": {
        "value": 13.4,
        "currency_code": "USD"
    },
}
 





