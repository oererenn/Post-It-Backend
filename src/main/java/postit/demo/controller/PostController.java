package postit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import postit.demo.converter.PostConverter;
import postit.demo.dto.PostDto;
import postit.demo.model.CommentModel;
import postit.demo.model.PostModel;
import postit.demo.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private PostService postService;


    private PostConverter postConverter;

    @Autowired
    public PostController(PostService postService, PostConverter postConverter) {
        this.postService = postService;
        this.postConverter = postConverter;
    }

    @GetMapping(value = "/api/posts")
    public List<PostModel> getPosts(){

        return postService.getPosts();
    }

    @GetMapping(value = "/api/posts/{id}")
    public Optional<PostModel> getPost(@PathVariable Long id){
        return postService.getPost(id);
    }


    @PostMapping(value = "/api/posts",consumes = {"multipart/form-data"})
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    @ResponseBody
    public void addPost(@RequestPart("data") PostDto postDto, @Nullable @RequestPart("file") MultipartFile file){

        postService.addPost(postConverter.dtoToEntity(postDto),file);
    }

    @GetMapping(value = "/api/posts/user/{id}")
    public List<PostModel> getUserPosts(@PathVariable Long id){
        return postService.getPostsByUserId(id);
    }

    @GetMapping(value = "/api/posts/community/{id}")
    public List<PostModel> getCommunityPosts(@PathVariable Long id){
        return postService.getPostsByCommunityId(id);
    }

    @GetMapping(value = "/api/posts/comment/{id}")
    public List<CommentModel> getPostComments(@PathVariable Long id){
        return postService.getPostComments(id);
    }



    @PutMapping( value = "/api/posts/{id}")
    public void updatePost(@RequestBody PostDto postDto,@PathVariable Long id){
        postService.updatePost(postConverter.dtoToEntityUpdate(postDto,id));
    }

    @DeleteMapping( value = "/api/posts/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }


    @GetMapping("/api/{id}/image/download")
    public byte[] downloadPostImage(@PathVariable("id") Long id){
        return postService.downloadPostImage(id);
    }
}
