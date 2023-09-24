Feature: Validate the Simplebooks application End-End points  
@Authenticate
Scenario: verify authentication to fetch the token

Given Authentication baseurl along with body

When Execute the authenticate "/api-clients/" which provides accessToken

Then Verifying the accessToken and staus code is 201 in the response

And verify the accessToken in the response

Scenario: verify to create a order in the simplebooks application

Given creating order by using Authentication baseurl along with body 

When While creating a orders "/orders" this will helps to create a order

Then Verifying the accessToken order details and staus code is 201 in the response

And verify the orderId in the response
