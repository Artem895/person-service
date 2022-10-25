package liga.medical.personservice.core.model;


import lombok.Data;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Data
public class Address {

    private long id;

    private long contactId;
    private long countryId;
    private String city;
    private  int index;
    private String street;
    private String building;
    private String flat;
    @MappedCollection(idColumn = "contact_id")
    private Contact contact;





}
