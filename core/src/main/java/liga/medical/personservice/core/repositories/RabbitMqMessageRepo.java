package liga.medical.personservice.core.repositories;

import liga.medical.personservice.core.model.RabbItMqModel;
import org.springframework.data.jpa.repository.JpaRepository;
import rabbitdto.RabbitMqDto;

public interface RabbitMqMessageRepo extends JpaRepository<RabbItMqModel,Long> {

}
