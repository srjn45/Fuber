package code.srjn.fuber.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import code.srjn.fuber.model.Response;

@RestController
@RequestMapping("/api")
public class FuberRestController {

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Response index() {
		Response response = new Response();
		response.setStatus(true);
		response.setMessage("Server is up & running.");
		return response;
	}

}
