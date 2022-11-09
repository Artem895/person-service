package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "illness")
@AllArgsConstructor
@NoArgsConstructor
public class IllnessModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "medical_card_id")
    private Long mkId;
    @Column(name = "type_id")
    private Long typeId;
    @Column(name = "heaviness")
    private char heaviness;
    @Column(name = "appearance_data")
    private Date apDt;
    @Column(name = "recovery_dt")
    private Date recDt;
}
