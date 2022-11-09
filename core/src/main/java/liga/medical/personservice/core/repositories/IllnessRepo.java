package liga.medical.personservice.core.repositories;

import liga.medical.personservice.core.model.IllnessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepo extends JpaRepository<IllnessModel,Long> {
}
