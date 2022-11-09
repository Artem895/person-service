package liga.medical.personservice.core.repositories;

import liga.medical.personservice.core.model.MecalCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCardRepo extends JpaRepository<MecalCardModel,Long> {
}
