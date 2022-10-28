package liga.medical.personservice.core.config;

import liga.medical.personservice.core.mapping.MessageMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiquiConfig {

    private final MessageMapper messageMapper;

    public LiquiConfig(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

}

