package postit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postit.demo.model.CommunityModel;
import postit.demo.model.UserModel;
import postit.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<UserModel> getUsers()
    {
        List<UserModel> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


    public Optional<UserModel> getUser(Long id){

        return userRepository.findById(id);
    }

    public void updateUser(UserModel user){
        userRepository.save(user);
    }

    public UserModel addUser(UserModel user){
        return userRepository.save(user);
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserModel addUserToCommunity(UserModel user){
        return userRepository.save(user);
    }

    public List<CommunityModel> getUserCommunities(Long id) {
        UserModel userModel = userRepository.findById(id).orElseThrow();
        return userModel.getCommunities();
    }
}
