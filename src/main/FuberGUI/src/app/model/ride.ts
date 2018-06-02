import { Location } from "./location";
import { User } from "./user";
import { Cab } from "./cab";

export class Ride {

    constructor(
        public otp: number,
        public user: User,
        public cab: Cab,
        public cabType: string,
        public pickupLocation: Location,
        public dropLocation: Location,
        public status: String,
        public distance: number
    ) {

    }
}
