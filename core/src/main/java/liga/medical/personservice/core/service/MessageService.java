package liga.medical.personservice.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.personservice.core.listener.RabbitMqListener;
import liga.medical.personservice.core.mapper.MessageMapper;
import liga.medical.personservice.core.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);
    private final MessageMapper messageMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public MessageService(MessageMapper messageMapper, ObjectMapper objectMapper) {
        this.messageMapper = messageMapper;
        this.objectMapper = objectMapper;
    }
    public void saveMessage(String message,String table_name) throws JsonProcessingException {

        messageMapper.insertMessage(objectMapper.readValue(message, Message.class),table_name);
        logger.info("Втставил сообщение в таблшицу : "+ table_name);

    }
}
