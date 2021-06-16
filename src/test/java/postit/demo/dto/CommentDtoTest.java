package postit.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentDtoTest {

    @Test
    void getText() {
        CommentDto commentDto = new CommentDto();
        commentDto.setText("test");
        assertEquals(commentDto.getText(),"test");
    }

    @Test
    void setText() {
        CommentDto commentDto = new CommentDto();
        commentDto.setText("test");
        assertEquals(commentDto.getText(),"test");
    }

    @Test
    void getPostId() {
        CommentDto commentDto = new CommentDto();
        commentDto.setPostId(5L);
        assertEquals(commentDto.getPostId(),5L);
    }

    @Test
    void setPostId() {
        CommentDto commentDto = new CommentDto();
        commentDto.setPostId(5L);
        assertEquals(commentDto.getPostId(),5L);
    }

    @Test
    void getUserId() {
        CommentDto commentDto = new CommentDto();
        commentDto.setUserId(5L);
        assertEquals(commentDto.getUserId(),5L);
    }

    @Test
    void setUserId() {
        CommentDto commentDto = new CommentDto();
        commentDto.setUserId(5L);
        assertEquals(commentDto.getUserId(),5L);
    }
}