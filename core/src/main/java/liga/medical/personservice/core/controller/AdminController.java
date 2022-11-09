package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.UserDto;
import liga.medical.personservice.core.model.mysecuritymodel.User;
import liga.medical.personservice.core.service.securityservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/admin/")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<UserDto> findUserByid(@PathVariable(name = "id") long id){
        User user=userService.findbyid(id);
        if (user==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto res=UserDto.fromUser(user);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }


}
