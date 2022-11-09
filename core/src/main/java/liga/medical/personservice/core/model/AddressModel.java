package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "contact_id")
    private Long contactId;
    @Column(name = "country_id")
    private Long countryId;
    @Column(name = "sity")
    private String sity;
    @Column(name = "index")
    private int index;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private String building;
    @Column(name = "flat")
    private String flat;

}
