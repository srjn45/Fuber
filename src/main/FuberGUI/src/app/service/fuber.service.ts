import { Injectable } from '@angular/core';

import { Http } from "@angular/http";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map'

import { Response } from "../model/response";
import { Ride } from '../model/ride';

@Injectable()
export class FuberService {

  constructor(private http: Http) { }

  getAvailableCabs(): Observable<Response> {
    return this.http.get("/api/cabs").map(res => res.json() as Response);
  }

  getRides(): Observable<Response> {
    return this.http.get('/api/rides').map(res => res.json() as Response);
  }

  bookRide(ride: Ride): Promise<Response> {
    return this.http.post('/api/ride/book', ride).map(res => res.json() as Response).toPromise();
  }

  startRide(ride: Ride): Promise<Response> {
    return this.http.post('/api/ride/start', ride).map(res => res.json() as Response).toPromise();
  }

  endRide(ride: Ride): Promise<Response> {
    return this.http.post('/api/ride/end', ride).map(res => res.json() as Response).toPromise();
  }

}
