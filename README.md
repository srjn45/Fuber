# Fuber
füber, an on call taxi service.


## Description

- Fuber have a fleet of cabs maintained list in memory in availableCabs list

- whenever a user books a cab the closest cab in the selected category is assigned to him and a OTP is returned.

- the cab is removed from the availableCabs list and is held by the rides object in the rideMap. 

- on cab arrival driver will insert that OTP which will start the ride

- at the end of the ride driver will click the end ride button and the drop location and distance traveled will be submitted.

- cab will be returned to the available cabs list

## Cab Types

- cabs can be of 2 types NORMAL & PINK

- user can select perticular or all type to find a cab.

## Ride Status

- when user finds a cab the Ride status is SEARCHING.

- when the cab is booked the status change to ON_THE_WAY.

- after entering OTP status change to STRATED.

- and after end ride the status change to ENDED.

## GUI

- A rough GUI is provided to test the REST APIs.

- In real app the location will be fetched from GPS but for now user enters the coordinates manually.

- ypu can see available cabs and active rides on the screen.

- there are two forms one for user from which cab can be booked.

- other form is for cabby to enter otp.

- at the end cabby have to click on end ride to to generate final fare.

- for now cabby have to manually enter Location n distance.

## Formulas

- to calculate smallest distance pythagoras theorem is used.

- to calc fare 2 times the distance(km) traveled and for PINK cabs extra 5 dogecoin. 

## Build

- to build and run execute build.bat or build.sh file.

- first angular is build and the build files are kept in static folder under resources.

- after that java is build using gradle and then the jar is executed using java -jar command.

- Note: for first time after clone or whenever package.json is updated you will need to run npm install inside FuberGUI folder


## Problem n Solution Provided

> You have a fleet of cabs at your disposal, and each cab has a location, determined by it’s latitude and longitude.

- all the available cabs are maintained in availablecabs List

- cab contains info like licensePlateNumber, cabType and location

> A customer can call one of your taxis by providing their location, and you must assign the nearest taxi to the customer.

> Some customers are particular that they only ride around in pink cars, for hipster reasons. You must support this ability.

- customer can call the cab bay selecting cab type (ALL, NORMAL, PINK) and providing there location

- the nearest cab in the selected category is assigned. this cab is removed from the availableCabs List.

> When the cab is assigned to the customer, it can no longer pick up any other customers

- as the cab no longer exist in the availableCabs list so it can not be booked.

- only the available cabs can be booked.

> If there are no taxis available, you reject the customer's request.

- if no cab is available in the selected category then No Cab Available message is returned.

> The customer ends the ride at some location. The cab waits around outside the customer’s house, and is available to be assigned to another customer.

- instead of providing this feature to customer we have provided it ti cabby. As after analyzing current system in place if this feature resides with cabby it will be better, as customer can end the ride sooner before reaching the destination (which can lead to conflicts) whereas a cabby will not like to lose money and will end the ride only on reaching the destination.

- after ending the ride cab stands by at the new location for new booking.

> When the customer ends the ride, log the total amount the customer owes. The price is 1 dogecoin per minute, and 2 dogecoin per kilometer. Pink cars cost an additional 5 dogecoin.

- the total fare is calculated, on the basis of distance travelled during the ride.

- Cab rate : 2 dogecoins/km

- for PINK cab extra 5 dogecoins are charged.

> HTML front end showing me all the cars available

- both available cabs and current active rides are listed on GUI.

- also book, start and end ride forms are provided to test the REST apis.