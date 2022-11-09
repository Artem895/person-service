package liga.medical.personservice.core.repositories;

import liga.medical.personservice.core.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<ContactModel,Long> {
}
