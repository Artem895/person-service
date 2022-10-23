package liga.medical.personservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("liga.medical.personservice")
public class PersonServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApp.class, args);
    }
}
