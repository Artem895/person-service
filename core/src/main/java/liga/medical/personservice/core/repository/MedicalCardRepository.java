package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.MedicalCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCardRepository extends CrudRepository<MedicalCard, Long> {
}
