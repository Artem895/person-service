package liga.medical.personservice.core;


import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("liga.medical.personservice")
@EnableRabbit
public class PersonServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApp.class, args);
    }
}
