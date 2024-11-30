package az.ingress.unittest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class UnitTestApplication implements CommandLineRunner {

	public static void main(String[] args) {


		SpringApplication.run(UnitTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Test2 t=new Test1();
		System.out.println("salam");
		System.out.println(t.a);
	}
}
