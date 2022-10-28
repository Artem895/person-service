package liga.medical.personservice.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.personservice.core.listener.RabbitMqListener;
import liga.medical.personservice.core.mapping.MessageMapper;
import liga.medical.personservice.core.mapping.PersonMapper;
import liga.medical.personservice.core.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);
    private final MessageMapper messageMapper;
    private final PersonMapper personMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public MessageService(MessageMapper messageMapper, ObjectMapper objectMapper, PersonMapper personMapper, ObjectMapper objectMapper1) {
        this.messageMapper = messageMapper;
        this.personMapper = personMapper;
        this.objectMapper = objectMapper1;
    }
    public void saveMessageDaily(String message) throws JsonProcessingException {
        Message messageModel=objectMapper.readValue(message, Message.class);
        messageMapper.insertMessageDaily(messageModel.getMessage(),messageModel.getPatient(),messageModel.getHelthstatus());
        logger.info("Втставил сообщение в таблшицу daily");
        personMapper.setpersonhelthstatus(messageModel.getPatient(),messageModel.getHelthstatus());
        logger.info("обнавил состаяние пациента");
    }
    public void saveMessageAllert(String message) throws JsonProcessingException {
        Message messageModel=objectMapper.readValue(message, Message.class);
        messageMapper.insertMessageAlert(messageModel.getMessage(),messageModel.getPatient(),messageModel.getHelthstatus());
        logger.info("Втставил сообщение в таблшицу alert");
        personMapper.setpersonhelthstatus(messageModel.getPatient(),messageModel.getHelthstatus());
        logger.info("обнавил состаяние пациента");
    }
    public void saveMessageError(String message) throws JsonProcessingException {
        Message messageModel=objectMapper.readValue(message, Message.class);
        messageMapper.insertMessageError(messageModel.getMessage(),messageModel.getPatient(),messageModel.getHelthstatus());
        logger.info("Втставил сообщение в таблшицу error");
        personMapper.setpersonhelthstatus(messageModel.getPatient(),messageModel.getHelthstatus());
        logger.info("обнавил состаяние пациента");
    }
}
