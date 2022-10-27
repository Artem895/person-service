package liga.medical.personservice.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private static final String HOST="localhost";

    public static final String DAILY_QUEUE="daily queue";
    public static final String ALERT_QUEUE="alert queue";
    public static final String ERROR_QUEUE="error queue";


    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(HOST);
    }
    @Bean
    public AmqpAdmin ampqAdmin(){
        return new RabbitAdmin(connectionFactory());
    }
    @Bean
    public RabbitTemplate rabbitTamplate(){
        return new RabbitTemplate(connectionFactory());
    }
}
