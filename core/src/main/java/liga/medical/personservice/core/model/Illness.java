package liga.medical.personservice.core.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.sql.Date;
import java.sql.Time;

@Data
public class Illness {

    private long id;


    private long medicalCardId;
    private long typeId;
    private char heaviness;
    private Time appearanceDttm;
    private Date recoveryDt;
    @MappedCollection(idColumn = "medical_card_id")
    private MedicalCard medicalCard;


}