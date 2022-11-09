package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "person_data")
@AllArgsConstructor
@NoArgsConstructor
public class PersonDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_dt")
    private Date bdate;
    @Column(name = "age")
    private int age;
    @Column(name = "sex")
    private char sex;
    @Column(name = "contact_id")
    private Long contactId;
    @Column(name = "medical_card_id")
    private Long mkId;
    @Column(name = "parent_id")
    private Long parentId;

}
