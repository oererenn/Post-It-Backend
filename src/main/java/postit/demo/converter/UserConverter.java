package postit.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import postit.demo.dto.UserCommunityDto;
import postit.demo.dto.UserDto;
import postit.demo.model.CommunityModel;
import postit.demo.model.UserModel;
import postit.demo.repository.CommunityRepository;
import postit.demo.repository.UserRepository;

@Component
public class UserConverter {
    private UserRepository userRepository;
    private CommunityRepository communityRepository;

    @Autowired
    public UserConverter(UserRepository userRepository, CommunityRepository communityRepository) {
        this.userRepository = userRepository;
        this.communityRepository = communityRepository;
    }

    public UserModel dtoToEntity(UserDto dto){
        UserModel userModel = new UserModel();
        userModel.setEmail(dto.getDtoEmail());
        userModel.setPassword(dto.getDtoPassword());

        return userModel;
    }

    public UserModel dtoToEntityUpdate(UserDto userDto, Long id) {

        UserModel userModel = userRepository.findById(id).orElseThrow();
        userModel.setEmail(userDto.getDtoEmail());
        userModel.setUsername(userDto.getDtoUsername());

        return userModel;
    }

    public UserModel dtoToEntityUserCommunity(UserCommunityDto userCommunityDto){

        CommunityModel communityModel = communityRepository.findById(userCommunityDto.getCommunityId()).orElseThrow();
        UserModel userModel = userRepository.findById(userCommunityDto.getUserId()).orElseThrow();
        if(!userModel.getCommunities().contains(communityModel)){
            userModel.getCommunities().add(communityModel);
            communityModel.setMemberCount(communityModel.getMemberCount() + 1);
        }else{
            userModel.getCommunities().remove(communityModel);
            communityModel.setMemberCount(communityModel.getMemberCount() - 1);
        }
        communityRepository.save(communityModel);

        return userModel;
    }
}
