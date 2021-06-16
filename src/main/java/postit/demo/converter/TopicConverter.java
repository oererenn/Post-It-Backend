package postit.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import postit.demo.dto.TopicDto;
import postit.demo.model.TopicModel;
import postit.demo.repository.TopicRepository;

@Component
public class TopicConverter {

    private TopicRepository topicRepository;

    @Autowired
    public TopicConverter(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public TopicModel dtoToEntity(TopicDto dto){

        TopicModel topicModel = new TopicModel();
        topicModel.setName(dto.getName());

        return topicModel;
    }

    public TopicModel dtoToEntityUpdate(TopicDto dto,Long id){

        TopicModel topicModel = topicRepository.findById(id).orElseThrow();
        topicModel.setName(dto.getName());

        return topicModel;
    }
}
