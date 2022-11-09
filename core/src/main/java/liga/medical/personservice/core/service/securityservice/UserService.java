package liga.medical.personservice.core.service.securityservice;



import liga.medical.personservice.core.model.mysecuritymodel.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findbyusername(String username);

    User findbyid(long id);

    void delete(long id);
}
