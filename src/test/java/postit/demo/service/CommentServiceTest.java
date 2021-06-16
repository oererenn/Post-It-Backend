package postit.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.CommentModel;
import postit.demo.repository.CommentRepository;



import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
@RunWith(SpringRunner.class)
@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentService CommentService;

    @MockBean
    private CommentRepository mockCommentRepository;



    @Test
    void getComments() {
        CommentService.getComments();
        verify(mockCommentRepository,times(1)).findAll();
    }

    @Test
    void getComment() {
        CommentModel CommentModel = new CommentModel();
        CommentModel.setId(5L);

        CommentService.getComment(CommentModel.getId());
        verify(mockCommentRepository,times(1)).findById(CommentModel.getId());
    }

    @Test
    void updateComment() {
        CommentModel CommentModel = mock(CommentModel.class);
        CommentService.updateComment(CommentModel);
        verify(mockCommentRepository).save(CommentModel);
    }

    @Test
    void addComment() {

        CommentModel CommentModel = mock(CommentModel.class);
        CommentService.addComment(CommentModel);
        verify(mockCommentRepository).save(CommentModel);

    }

    @Test
    void deleteComment() {
        CommentModel CommentModel = mock(CommentModel.class);
        CommentService.deleteComment(CommentModel.getId());
        verify(mockCommentRepository).deleteById(CommentModel.getId());
    }
}