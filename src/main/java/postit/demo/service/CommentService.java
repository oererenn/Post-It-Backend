package postit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postit.demo.model.CommentModel;
import postit.demo.repository.CommentRepository;
import postit.demo.repository.PostRepository;
import postit.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;


    private PostRepository postRepository;

    private UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    public List<CommentModel> getComments()
    {
        List<CommentModel> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }

    public Optional<CommentModel> getComment(Long id){

        return commentRepository.findById(id);
    }

    public void updateComment(CommentModel comment){
        commentRepository.save(comment);
    }

    public void addComment(CommentModel commentModel){
        commentRepository.save(commentModel);

    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }

}
