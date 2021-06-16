package postit.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostDtoTest {

    @Test
    void getTitle() {
        PostDto postDto = new PostDto();
        postDto.setTitle("test");
        assertEquals(postDto.getTitle(),"test");
    }

    @Test
    void setTitle() {
        PostDto postDto = new PostDto();
        postDto.setTitle("test");
        assertEquals(postDto.getTitle(),"test");
    }

    @Test
    void getDescription() {
        PostDto postDto = new PostDto();
        postDto.setDescription("test");
        assertEquals(postDto.getDescription(),"test");
    }

    @Test
    void setDescription() {
        PostDto postDto = new PostDto();
        postDto.setDescription("test");
        assertEquals(postDto.getDescription(),"test");
    }

    @Test
    void getUserId() {
        PostDto postDto = new PostDto();
        postDto.setUserId(5L);
        assertEquals(postDto.getUserId(),5L);
    }

    @Test
    void setUserId() {
        PostDto postDto = new PostDto();
        postDto.setUserId(5L);
        assertEquals(postDto.getUserId(),5L);
    }

    @Test
    void getCommunityId() {
        PostDto postDto = new PostDto();
        postDto.setCommunityId(5L);
        assertEquals(postDto.getCommunityId(),5L);
    }

    @Test
    void setCommunityId() {
        PostDto postDto = new PostDto();
        postDto.setCommunityId(5L);
        assertEquals(postDto.getCommunityId(),5L);
    }
}