package liga.medical.personservice.core.security.jwt;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtTokenFilter extends GenericFilterBean {

    private  JwtTokenPrivider jwtTokenPrivider;


    public JwtTokenFilter(JwtTokenPrivider jwtTokenPrivider) {
        this.jwtTokenPrivider = jwtTokenPrivider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            String token=jwtTokenPrivider.resolveToken((HttpServletRequest) servletRequest);
            if(token!=null&& jwtTokenPrivider.validateToken(token)){
                Authentication authentication= jwtTokenPrivider.getAuthentication(token);
                    if(authentication!=null)
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
            filterChain.doFilter(servletRequest,servletResponse);
            }
    }

