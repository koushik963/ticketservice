# Ticketing Service
Simple REST based ticket service API that facilitates three services such as the discovery, temporary hold, and final reservation 
of seats within a high-demand performance venue.

## Assumptions:
1. This whole ticket service deals with all the tickets of a single event. No other events are considered.
2. Application will book tickets giving max priority to max levels and least priority then to min levels
3. Initially DB is loaded with sample data. 
4. Initially only 6 seats are available.

## Tech Stack
* Spring MVC, REST
* MySQL 5.7
* Tomcat 7

## Pre-requisites
* maven - 3.x
* JDK - 1.8
* cURL

## Steps for running the application from command line

### DB Scripts
Run this DB script in MySQL, it will create schema with some sample data. 
```
	src/main/resources/schemaAndData.sql 

#### Build and Run tests
	mvn clean install

#### Run Server
	mvn tomcat7:deploy

```
### APIs:

-	Request: POST /spring-rest/api/availableSeats
````
curl -H "Content-Type: application/json" -X POST -d [1] http://localhost:8080/spring-rest/api/availableSeats
-- Response:
		6

- 	Request: POST /spring-rest/api/findAndHoldSeats
````
curl -H "Content-Type: application/json" -X POST -d {"{"noOfSeats":"1","minLevels":["1"],"maxLevels":["4"],"customerEmail":"test2@example.com"}"} http://localhost:8080/spring-rest/api/availableSeats
- Response: 
		{
			"id": 10,
			"customerEmail": "test2@example.com",
			"holdDate": 1467038541754,
			"seats": [
				{
					"id": 2,
					"seatNo": 2,
					"status": 1
				}
			]
		}
				
- 	Request: POST /spring-rest/api/reserveSeats
````
curl -H "Content-Type: application/json" -X POST -d {"id":"8","customerEmail":"test2@example.com"} http://localhost:8080/spring-rest/api/availableSeats
- Response:
	968986222226113
