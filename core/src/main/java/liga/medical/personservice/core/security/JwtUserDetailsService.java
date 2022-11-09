package liga.medical.personservice.core.security;


import liga.medical.personservice.core.model.mysecuritymodel.User;
import liga.medical.personservice.core.security.jwt.JwtUser;
import liga.medical.personservice.core.security.jwt.JwtUserFactory;
import liga.medical.personservice.core.service.securityservice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =userService.findbyusername(username);
        if(user==null){
            throw new UsernameNotFoundException("Нет такого ");
        }
        JwtUser jwtUser= JwtUserFactory.create(user);
        log.info("превратили в сприногоовго юзера");
        System.out.println(jwtUser);
        return jwtUser;
    }
}
