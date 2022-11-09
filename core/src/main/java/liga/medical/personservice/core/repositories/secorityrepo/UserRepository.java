package liga.medical.personservice.core.repositories.secorityrepo;

import liga.medical.personservice.core.model.mysecuritymodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
