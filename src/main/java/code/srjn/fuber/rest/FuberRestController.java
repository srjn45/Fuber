package code.srjn.fuber.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(path = "/ride/book", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public @ResponseBody Response bookRide(@RequestBody Ride ride) {
		Response response = new Response();
		if (cabService.bookRide(ride) != null) {
			response.setStatus(true);
			response.setPayload(ride);
		} else {
			response.setStatus(false);
			response.setMessage("No Cab Found");
		}
		return response;
	}

	@RequestMapping(path = "/ride/start", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public @ResponseBody Response startRide(@RequestBody Ride ride) {
		Response response = new Response();
		response.setStatus(true);
		response.setPayload(cabService.startRide(ride.getOtp()));
		return response;
	}

}
