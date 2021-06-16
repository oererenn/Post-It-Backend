package postit.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import postit.demo.dto.CommunityDto;
import postit.demo.model.CommunityModel;
import postit.demo.model.TopicModel;
import postit.demo.repository.CommunityRepository;
import postit.demo.repository.TopicRepository;

import java.time.Instant;


@Component
public class CommunityConverter {

private TopicRepository topicRepository;
private CommunityRepository communityRepository;

    @Autowired
    public CommunityConverter(TopicRepository topicRepository, CommunityRepository communityRepository) {
        this.topicRepository = topicRepository;
        this.communityRepository = communityRepository;
    }


    public CommunityModel dtoToEntity(CommunityDto dto){

        TopicModel topicModel = topicRepository.findById(dto.getTopicId()).orElseThrow();

        CommunityModel communityModel = new CommunityModel();
        communityModel.setCreatedAt(Instant.now());
        communityModel.setDescription(dto.getDescription());
        communityModel.setName(dto.getName());
        communityModel.setTopic(topicModel);

        return communityModel;
    }

    public CommunityModel dtoToEntityUpdate(CommunityDto dto,Long id){

        CommunityModel communityModel =communityRepository.findById(id).orElseThrow();
        communityModel.setDescription(dto.getDescription());
        communityModel.setName(dto.getName());

        return communityModel;
    }

}
