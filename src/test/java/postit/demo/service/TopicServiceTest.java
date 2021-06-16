package postit.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.TopicModel;
import postit.demo.repository.TopicRepository;


import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;



@RunWith(SpringRunner.class)
@SpringBootTest
class TopicServiceTest {
    @Autowired
    private TopicService TopicService;

    @MockBean
    private TopicRepository mockTopicRepository;


    @Test
    void getTopics() {
        TopicService.getTopics();
        verify(mockTopicRepository,times(1)).findAll();
    }

    @Test
    void getTopic() {
        TopicModel TopicModel = new TopicModel();
        TopicModel.setId(5L);

        TopicService.getTopic(TopicModel.getId());
        verify(mockTopicRepository,times(1)).findById(TopicModel.getId());
    }

    @Test
    void updateTopic() {
        TopicModel TopicModel = mock(TopicModel.class);
        TopicService.updateTopic(TopicModel);
        verify(mockTopicRepository).save(TopicModel);
    }

    @Test
    void addTopic() {
        TopicModel TopicModel = mock(TopicModel.class);
        TopicService.addTopic(TopicModel);
        verify(mockTopicRepository).save(TopicModel);

    }

    @Test
    void deleteTopic() {
        TopicModel TopicModel = mock(TopicModel.class);
        TopicService.deleteTopic(TopicModel.getId());
        verify(mockTopicRepository).deleteById(TopicModel.getId());
    }
}