package liga.medical.personservice.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.personservice.core.listener.RabbitMqListener;
import liga.medical.personservice.core.mapper.MessageMapper;
import liga.medical.personservice.core.model.RabbItMqModel;
import liga.medical.personservice.core.repositories.RabbitMqMessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitdto.RabbitMqDto;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);
    private final RabbitMqMessageRepo rabbitMqMessageRepo;
    private final ObjectMapper objectMapper;
    private final MessageMapper messageMapper;

    @Autowired
    public MessageService(RabbitMqMessageRepo rabbitMqMessageRepo, ObjectMapper objectMapper, MessageMapper messageMapper) {
        this.rabbitMqMessageRepo = rabbitMqMessageRepo;
        this.objectMapper = objectMapper;
        this.messageMapper = messageMapper;
    }
    public void saveMessage(String message) throws JsonProcessingException {
        RabbitMqDto messageDto=objectMapper.readValue(message, RabbitMqDto.class);
        RabbItMqModel messageModel=messageMapper.dtoToModel(messageDto);
        rabbitMqMessageRepo.save(messageModel);
    }

}
