package postit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import postit.demo.converter.UserConverter;
import postit.demo.dto.UserCommunityDto;
import postit.demo.dto.UserDto;
import postit.demo.model.CommunityModel;
import postit.demo.model.UserModel;
import postit.demo.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private UserService userService;
    private UserConverter userConverter;

    @Autowired
    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }


    @GetMapping(value = "/api/users")
    public List<UserModel> getUsers(){

        return userService.getUsers();
    }

    @GetMapping(value = "/api/users/{id}")
    public Optional<UserModel> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping( value = "/api/users")
    public void addUser(@RequestBody UserDto userDto){
        userService.addUser(userConverter.dtoToEntity(userDto));
    }

    @PutMapping( value = "/api/users/{id}")
    public void updateUser(@RequestBody UserDto userDto,@PathVariable Long id){
        userService.updateUser(userConverter.dtoToEntityUpdate(userDto,id));
    }

    @DeleteMapping( value = "/api/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PostMapping(value = "/api/users/community")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public void addUserToCommunity(@RequestBody UserCommunityDto userCommunityDto){
        userService.addUserToCommunity(userConverter.dtoToEntityUserCommunity(userCommunityDto));
    }

    @GetMapping(value = "/api/users/{id}/communities")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public List<CommunityModel> getUserCommunities(@PathVariable Long id){
        return userService.getUserCommunities(id);
    }


}
