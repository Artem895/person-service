package liga.medical.personservice.core.repositories;

import liga.medical.personservice.core.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressModel,Long> {
}
