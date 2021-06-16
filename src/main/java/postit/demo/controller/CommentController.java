package postit.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import postit.demo.converter.CommentConverter;
import postit.demo.dto.CommentDto;
import postit.demo.model.CommentModel;
import postit.demo.service.CommentService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CommentController {


    private CommentService commentService;


    private CommentConverter commentConverter;

    @Autowired
    public CommentController(CommentService commentService, CommentConverter commentConverter) {
        this.commentService = commentService;
        this.commentConverter = commentConverter;
    }


    @GetMapping(value = "/api/comments")
    public List<CommentModel> getComments(){

        return commentService.getComments();
    }

    @GetMapping(value = "/api/comments/{id}")
    public Optional<CommentModel> getComment(@PathVariable Long id){
        return commentService.getComment(id);
    }

    @PostMapping(value = "/api/comments")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public void addComment(@RequestBody CommentDto commentDto){

        commentService.addComment(commentConverter.dtoToEntity(commentDto));
    }

    @PutMapping(value = "/api/comments/{id}")
    public void updateComment(@RequestBody CommentDto commentDto, @PathVariable Long id){
        commentService.updateComment(commentConverter.dtoToEntityUpdate(commentDto,id));
    }

    @DeleteMapping(value = "/api/comments/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
