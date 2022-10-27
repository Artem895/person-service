package liga.medical.personservice.core.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.personservice.core.config.RabbitConfig;
import liga.medical.personservice.core.service.MessageService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {

    private final MessageService messageService;

    private static final String allerttable="allert_table";
    private static final String dailytable="daily_table";
    private static final String errortable="error_table";

    @Autowired
    public RabbitMqListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @RabbitListener(queues = RabbitConfig.ALERT_QUEUE)
    public void listenalert(String message) throws JsonProcessingException {
        messageService.saveMessage(message,allerttable);

    }
    @RabbitListener(queues = RabbitConfig.DAILY_QUEUE)
    public void listendaily(String message) throws JsonProcessingException {
        messageService.saveMessage(message,dailytable);

    }
    @RabbitListener(queues = RabbitConfig.ERROR_QUEUE)
    public void listenerror(String message) throws JsonProcessingException {
        messageService.saveMessage(message,errortable);
    }
}
