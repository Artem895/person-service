package liga.medical.personservice.core.service.securityservice.impl;


import liga.medical.personservice.core.model.mysecuritymodel.Role;
import liga.medical.personservice.core.model.mysecuritymodel.Status;
import liga.medical.personservice.core.model.mysecuritymodel.User;
import liga.medical.personservice.core.repositories.secorityrepo.RoleRepository;
import liga.medical.personservice.core.repositories.secorityrepo.UserRepository;
import liga.medical.personservice.core.service.securityservice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleuser=roleRepository.findByName("USER");
        List<Role> userRoles=new ArrayList<>();
        userRoles.add(roleuser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        User regidteredUser=userRepository.save(user);
        log.info("Regitered succesfull",regidteredUser);
        return regidteredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("Наудено ",result.size());
        return result;
    }

    @Override
    public User findbyusername(String username) {
        System.out.println("вошел в поиск юзеров");
        User result=userRepository.findByUsername(username);
        log.info("нащел",result);
        return result;
    }

    @Override
    public User findbyid(long id) {
        User result =userRepository.findById(id).orElse(null);
        if(result==null){
            log.warn("не нашел такого юзера ");
        }
        log.info("find by id");
        return result;
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
        log.info("удалил");
    }
}
