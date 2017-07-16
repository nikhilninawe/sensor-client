package service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class SubscribeService {
	
	private static Logger logger = LoggerFactory.getLogger(SubscribeService.class);
	
	@RequestMapping(value="/update/{sensorId}/{temperature:.+}", method = RequestMethod.POST)
	public String receiveUpdate(@PathVariable String sensorId,
					     @PathVariable Double temperature){
		logger.info("Temperature {} updated for sensor {}",temperature, sensorId);
		return "Success";
	}
	
	@RequestMapping(value="/ping", method = RequestMethod.GET)
	public String ping(){
		return "Success";
	}
}
