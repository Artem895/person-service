package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.RabbItMqModel;
import org.springframework.stereotype.Component;
import rabbitdto.RabbitMqDto;

@Component
public class MessageMapper {
    public  RabbItMqModel dtoToModel(RabbitMqDto rabbitMqDto){
        System.out.println(rabbitMqDto);
        RabbItMqModel rabbItMqModel=new RabbItMqModel();
        rabbItMqModel.setPersonDtId(rabbitMqDto.getId());
        rabbItMqModel.setDescription(rabbitMqDto.getDescription());
        rabbItMqModel.setMessageType(rabbitMqDto.getMessageType());
        return  rabbItMqModel;
    }
}
