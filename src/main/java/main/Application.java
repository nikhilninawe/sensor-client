package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"service", "updates", "com.test.manager"})
public class Application{
	
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
		String sensorId = System.getProperty("sensor");
		String serverPort = System.getProperty("server.port");
		restTemplate.postForObject("http://localhost:8090/sensor/subscribe/" + "localhost:"+ serverPort  + "/" + sensorId,
                null, String.class);
	}
}
