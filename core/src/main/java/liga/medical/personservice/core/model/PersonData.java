package liga.medical.personservice.core.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.sql.Date;

@Data
public class PersonData {
    private long id;

    private String lastname;
    private String firstname;
    private Date birthday;
    private long age;
    private String sex;
    private long contactId;
    private long medicalcardIid;
    private long parentId;
    @MappedCollection(idColumn = "contact_id")
    private Contact contact;
    @MappedCollection(idColumn = "medical_card_id")
    private MedicalCard medicalCard;
    @MappedCollection(idColumn = "parent_id")
    private PersonData personData;
}