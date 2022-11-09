package liga.medical.personservice.core.repositories;

import liga.medical.personservice.core.model.PersonDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDataRepo extends JpaRepository<PersonDataModel,Long> {
    PersonDataModel findById(long id);
}
