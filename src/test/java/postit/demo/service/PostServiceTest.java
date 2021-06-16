package postit.demo.service;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import postit.demo.model.PostModel;
import postit.demo.repository.PostRepository;

import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository mockPostRepository;


    @Test
    void getPosts() {
        postService.getPosts();
        verify(mockPostRepository,times(1)).findAll();
    }

    @Test
    void getPost() {
        PostModel postModel = mock(PostModel.class);
        postService.getPost(postModel.getId());
        verify(mockPostRepository).findById(postModel.getId());
    }

    @Test
    void updatePost() {
        PostModel postModel = mock(PostModel.class);
        postService.updatePost(postModel);
        verify(mockPostRepository).save(postModel);
    }

    @Test
    void addPost() {
        PostModel postModel = mock(PostModel.class);
        MultipartFile multipartFile = null;
        postService.addPost(postModel,multipartFile);
        verify(mockPostRepository).save(postModel);
    }

    @Test
    void deletePost() {
        PostModel postModel = mock(PostModel.class);
        postService.deletePost(postModel.getId());
        verify(mockPostRepository).deleteById(postModel.getId());
    }
}