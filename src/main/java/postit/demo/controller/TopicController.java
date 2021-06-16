package postit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import postit.demo.converter.TopicConverter;
import postit.demo.dto.TopicDto;
import postit.demo.model.TopicModel;
import postit.demo.service.TopicService;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    private TopicService topicService;

    private TopicConverter topicConverter;

    @Autowired
    public TopicController(TopicService topicService, TopicConverter topicConverter) {
        this.topicService = topicService;
        this.topicConverter = topicConverter;
    }


    @GetMapping(value = "/api/topics")
    public List<TopicModel> getTopics(){

        return topicService.getTopics();
    }

    @GetMapping(value = "/api/topics/{id}")
    public Optional<TopicModel> getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @PostMapping(value = "/api/topics")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addTopic(@RequestBody TopicDto topicDto){
        topicService.addTopic(topicConverter.dtoToEntity(topicDto));
    }

    @PutMapping(value = "/api/topics/{id}")
    public void updateTopic(@RequestBody TopicDto topicDto,@PathVariable Long id){
        topicService.updateTopic(topicConverter.dtoToEntityUpdate(topicDto,id));
    }

    @DeleteMapping( value = "/api/topics/{id}")
    public void deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
    }
}
