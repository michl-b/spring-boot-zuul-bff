# Sample for Zuul usage with integrated BFF Pattern Controller

## eureka
Netfilx Eureka Discovery Server

## zuul
Netfilx Zuul Proxy Server

## product
Spring Boot RESTful service for a simple sample
- gives a simple Product object as JSON 

## customer
Spring Boot RESTful service for a simple sample
- gives a simple Customer object as JSON

## Check Results

[http://localhost:8071/] Eureka Server

[http://localhost:8081/mappings] Zuul Server mappings

[http://localhost:8082/api/product/detail] Product Service direct - detail
[http://localhost:8081/product/api/product/detail] Product Service via Zuul - detail

[http://localhost:8083/api/customer/info] Customer Service direct - info
[http://localhost:8081/customer/api/customer/info] Customer Service via Zuul - info

[http://localhost:8081/bff/product/detail] Call Zuul for aggregated info
