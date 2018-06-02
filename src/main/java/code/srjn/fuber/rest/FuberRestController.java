package code.srjn.fuber.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import code.srjn.fuber.domain.CabType;
import code.srjn.fuber.domain.Location;
import code.srjn.fuber.domain.Ride;
import code.srjn.fuber.model.Response;
import code.srjn.fuber.service.CabService;

@RestController
@RequestMapping("/api")
public class FuberRestController {

	@Autowired
	CabService cabService;

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Response index() {
		Response response = new Response();
		response.setStatus(true);
		response.setMessage("Server is up & running.");
		return response;
	}

	@RequestMapping(path = "/book", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Response bookRide() {
		Response response = new Response();
		response.setStatus(true);
		response.setMessage("Book Ride.");
		Ride ride = new Ride();
		ride.setCabType(CabType.ALL);
		ride.setPickupLocation(new Location(3, 6));
		response.setPayload(cabService.bookRide(ride));
		return response;
	}

}
