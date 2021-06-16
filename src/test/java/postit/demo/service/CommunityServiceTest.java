package postit.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.CommunityModel;
import postit.demo.repository.CommunityRepository;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class CommunityServiceTest {

    @Autowired
    private CommunityService CommunityService;

    @MockBean
    private CommunityRepository mockCommunityRepository;


    @Test
    void getCommunities() {
        CommunityService.getCommunities();
        verify(mockCommunityRepository,times(1)).findAll();
    }

    @Test
    void getCommunity() {
        CommunityModel CommunityModel = new CommunityModel();
        CommunityModel.setId(5L);

        CommunityService.getCommunity(CommunityModel.getId());
        verify(mockCommunityRepository,times(1)).findById(CommunityModel.getId());
    }

    @Test
    void updateCommunity() {
        CommunityModel CommunityModel = mock(CommunityModel.class);
        CommunityService.updateCommunity(CommunityModel);
        verify(mockCommunityRepository).save(CommunityModel);
    }

    @Test
    void addCommunity() {
        CommunityModel CommunityModel = mock(CommunityModel.class);
        CommunityService.addCommunity(CommunityModel);
        verify(mockCommunityRepository).save(CommunityModel);

    }

    @Test
    void deleteCommunity() {
        CommunityModel CommunityModel = mock(CommunityModel.class);
        CommunityService.deleteCommunity(CommunityModel.getId());
        verify(mockCommunityRepository).deleteById(CommunityModel.getId());
    }


}