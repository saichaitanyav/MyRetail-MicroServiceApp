# MyRetail: 
Publishes  REST API endpoints,  for creating/updating/retrieving products with price. 

Technologies Used:

| Technology    | Version       |
| ------------- | ------------- |
| Java          | 8  |
| SpringBoot    | 2.3.9|
|Postgres       | 13|
|Maven          |3.6.3


## Steps to run the project 
Pre-requisite:  Install Postgres, maven, JDK, JRE,
1. Clone the project  
2. Update the `application.yaml` file under resources directory with  Postgres details.  
3. Run the application this will bring up the application and can be accessed via below URL:  

To retrive all products use this endpoint (application gateway) -http://localhost:9191/products

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
 





