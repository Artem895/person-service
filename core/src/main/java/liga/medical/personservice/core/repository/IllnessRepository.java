package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Illness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends CrudRepository<Illness, Long> {
}
