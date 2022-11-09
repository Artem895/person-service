package liga.medical.personservice.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contact")
@AllArgsConstructor
@NoArgsConstructor
public class ContactModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "profile_link")
    private String profileLink;

}
