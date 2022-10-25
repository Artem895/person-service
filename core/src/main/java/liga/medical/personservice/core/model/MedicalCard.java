package liga.medical.personservice.core.model;

import lombok.Data;

import java.sql.Date;

@Data
public class MedicalCard {

    private long id;
    private char clientStatus;
    private char medStatus;
    private Date registryDt;
    private String comment;


}
