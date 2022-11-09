package liga.medical.personservice.core.config;

import liga.medical.personservice.core.security.jwt.JwtTokenFilter;
import liga.medical.personservice.core.security.jwt.JwtTokenPrivider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenPrivider jwtTokenPrivider;


    private static final String ADMIN_ENDPOINT="/v1/admin/**";
    private static final String LOGIN_ENDPOINT="/v1/auth/login/**";
    private static  final String MEDICAL_USER_ENDPOINT="/v1/medical/find/**";
    private static  final String MEDICAL_ADMIN_ENDPOINT="/v1/medical/add/**";


    @Autowired
    public SecurityConfig(JwtTokenPrivider jwtTokenPrivider) {
        this.jwtTokenPrivider = jwtTokenPrivider;

    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtTokenFilter jwtTokenFilter=new JwtTokenFilter(jwtTokenPrivider);
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers(MEDICAL_USER_ENDPOINT).hasRole("USER")
                .antMatchers(MEDICAL_ADMIN_ENDPOINT).hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}
