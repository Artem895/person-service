package liga.medical.personservice.core.repositories.secorityrepo;

import liga.medical.personservice.core.model.mysecuritymodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
