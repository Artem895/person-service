package liga.medical.personservice.core.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthExeption extends AuthenticationException {
    public JwtAuthExeption(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthExeption(String msg) {
        super(msg);
    }
}

