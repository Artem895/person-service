package liga.medical.personservice.core;

import liga.medical.personservice.core.mapping.MessageMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;


@SpringBootApplication
@ComponentScan("liga.medical.personservice")
@EnableRabbit
public class PersonServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApp.class, args);
    }
}
