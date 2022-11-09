package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rabbitdto.MessageType;
import rabbitdto.RabbitMqDto;

import javax.persistence.*;

@Table(name = "signals")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbItMqModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "person_data_id")
    private Long personDtId;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private MessageType messageType;
}
