package az.ingress.unittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class UnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestApplication.class, args);
	}

}
