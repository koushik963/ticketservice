# Ticketing Service
Simple REST based ticket service API that facilitates three services such as the discovery, temporary hold, and final reservation 
of seats within a high-demand performance venue.

## Assumptions:
1. This whole ticket service deals with all the tickets of a single event. No other events are considered.


1. Multi-event booking support available, but data pre-populated for a single event in db.
2. H2(db) is pre-populated with minimal data for one event for running integration tests. 
3. For every new event, a db script will be run to pre-populate db(seat_hold table) with 
available seats. No separate count is maintained for keeping track of total seats.
4. No payment/purchase flow implemented.
5. Service decides the best seat to reserve depending on the availability, no choice given to the user.
6. Customer details are not maintained in the system except for customer email.
7. No user registration flow implemented.
8. No User Interface provided.
9. Schema designed to support multi-event ticket booking simultaneously. Service methods
not provided.

## Notes
1. APIs provided for accessing ticketing service methods(details in 'APIs' section).
2. In-memory db, embedded tomcat used for the application.


## Tech Stack
* Spring MVC, REST
* MySQL
* Tomcat

## Pre-requisites
* maven - 3.x
* JDK - 1.8

## Steps for running the application

#### Build and Run tests
	mvn clean install

#### Run Server
	mvn tomcat:deploy
	
### DB Scripts
DB scripts are available here 
```
	src/main/resources/schema.sql - DDLs
	src/main/resources/data.sql - Test data
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
-- Response: 
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
-- Response:
	968986222226113
