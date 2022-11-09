package liga.medical.personservice.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import liga.medical.personservice.core.model.mysecuritymodel.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private long id;
    private String username;
    private String lastname;
    private String firstname;
    private String email;

    public User toUser(){
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        return user;
    }
    public static UserDto fromUser(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
