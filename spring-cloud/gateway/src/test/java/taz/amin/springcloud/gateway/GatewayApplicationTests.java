package taz.amin.springcloud.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT,
		properties = {
				"eureka.client.enabled=false",
				"spring.cloud.config.enabled=false"})
class GatewayApplicationTests {

	@Test
	void contextLoads() {
	}

}
