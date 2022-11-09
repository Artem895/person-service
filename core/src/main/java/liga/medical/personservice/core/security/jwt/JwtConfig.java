package liga.medical.personservice.core.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtTokenPrivider jwtTokenPrivider;


    public JwtConfig(JwtTokenPrivider jwtTokenPrivider) {
        this.jwtTokenPrivider = jwtTokenPrivider;
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JwtTokenFilter jwtTokenFilter=new JwtTokenFilter(jwtTokenPrivider);
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
