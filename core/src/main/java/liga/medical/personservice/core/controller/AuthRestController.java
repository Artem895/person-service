package liga.medical.personservice.core.controller;


import liga.medical.personservice.core.dto.AuthRequestDto;
import liga.medical.personservice.core.model.mysecuritymodel.User;
import liga.medical.personservice.core.security.jwt.JwtTokenPrivider;
import liga.medical.personservice.core.service.securityservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/auth/")
public class AuthRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenPrivider jwtTokenPrivider;
    private final UserService userService;

    @Autowired
    public AuthRestController(AuthenticationManager authenticationManager, JwtTokenPrivider jwtTokenPrivider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenPrivider = jwtTokenPrivider;
        this.userService = userService;
    }
    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findbyusername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenPrivider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

}
