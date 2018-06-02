# Fuber
füber, an on call taxi service.


## Description

> Fuber have a fleet of cabs maintained list in memory in availableCabs list

> whenever a user books a cab the closest cab in the selected category is assigned to him and a OTP is returned.

> the cab is removed from the availableCabs list and is held by the rides object in the rideMap. 

> on cab arrival driver will insert that OTP which will start the ride

> at the end of the ride driver will click the end ride button and the drop location and distance traveled will be submitted.

> cab will be returned to the available cabs list

## Cab Types

> cabs can be of 2 types NORMAL & PINK

> user can select perticular or all type to find a cab.

## Ride Status

> when user finds a cab the Ride status is SEARCHING.

> when the cab is booked the status change to ON_THE_WAY.

> after entering OTP status change to STRATED.

> and after end ride the status change to ENDED.

## GUI

> A rough GUI is provided to test the REST APIs.

> In real app the location will be fetched from GPS but for now user enters the coordinates manually.

> ypu can see available cabs and active rides on the screen.

> there are two forms one for user from which cab can be booked.

> other form is for cabby to enter otp.

> at the end cabby have to click on end ride to to generate final fare.

> for now cabby have to manually enter Location n distance.

## Formulas

> to calculate smallest distance pythagoras theorem is used.

> to calc fare 2 times the distance(km) traveled and for PINK cabs extra 5 dogecoin. 