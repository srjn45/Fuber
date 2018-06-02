import { Component } from '@angular/core';
import { FuberService } from './service/fuber.service';
import { Cab } from './model/cab';
import { Ride } from './model/ride';
import { Location } from './model/location';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public cabs: Cab[] = [];
  public rides: Ride[] = [];


  constructor(private fuberService: FuberService) {
    this.loadAvailableCabs();
    this.loadRides();
  }

  loadAvailableCabs() {
    this.fuberService.getAvailableCabs().subscribe(res => {
      if (res.status) {
        this.cabs = res.payload;
      }
    });
  }

  loadRides() {
    this.fuberService.getRides().subscribe(res => {
      if (res.status) {
        this.rides = res.payload;
      }
    });
  }

  bookRide(form) {
    console.log(form);
    let ride = new Ride(null, null, null, form.cabType, new Location(form.latitude, form.longitude), null, null, null);
    this.fuberService.bookRide(ride).then(res => {
      if (res.status) {
        this.loadAvailableCabs();
        this.loadRides();
      } else {
        alert(res.message);
      }
    });
  }
  startRide(form) {
    console.log(form);
    let ride = new Ride(form.otp, null, null, null, null, null, null, null);
    this.fuberService.startRide(ride).then(res => {
      if (res.status) {
        this.loadAvailableCabs();
        this.loadRides();
      }
    });
  }
  endRide(form: any, ride: Ride) {
    console.log(form);
    ride.distance = form.distance;
    ride.dropLocation = new Location(form.latitude, form.longitude);
    this.fuberService.endRide(ride).then(res => {
      if (res.status) {
        this.loadAvailableCabs();
        this.loadRides();
        alert(res.message);
      }
    });
  }

}
