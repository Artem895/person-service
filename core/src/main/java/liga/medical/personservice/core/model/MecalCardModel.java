package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "medical_card")
@AllArgsConstructor
@NoArgsConstructor
public class MecalCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_status")
    private char clientStatus;
    @Column(name = "med_status")
    private char medStatus;
    @Column(name = "registry_dt")
    private Date registryDt;
    @Column(name = "coment")
    private String coment;
}
