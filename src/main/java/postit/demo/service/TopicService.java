package postit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postit.demo.model.TopicModel;
import postit.demo.repository.TopicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public List<TopicModel> getTopics()
    {
        List<TopicModel> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<TopicModel> getTopic(Long id){

        return topicRepository.findById(id);
    }

    public void updateTopic(TopicModel topic){
        topicRepository.save(topic);
    }

    public void addTopic(TopicModel topic){
        topicRepository.save(topic);
    }


    public void deleteTopic(Long id){
        topicRepository.deleteById(id);
    }
}
