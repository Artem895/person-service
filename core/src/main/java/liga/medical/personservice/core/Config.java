package liga.medical.personservice.core;

import liga.medical.personservice.core.model.PersonData;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.util.Random;

@Configuration
public class Config {
    Random random = new Random();

    @Bean
    public ApplicationListener<BeforeSaveEvent> idGenerator() {
        return event -> {
            var entity = event.getEntity();
            long id = random.nextInt(10000);

            if (entity instanceof PersonData) {
                ((PersonData) entity).setId(id);
            }
        };
    }
}