package postit.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import postit.demo.dto.CommentDto;
import postit.demo.model.*;
import postit.demo.repository.CommentRepository;
import postit.demo.repository.PostRepository;
import postit.demo.repository.UserRepository;

import java.time.Instant;

@Component
public class CommentConverter {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;

    @Autowired
    public CommentConverter(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public CommentModel dtoToEntity(CommentDto dto){

        PostModel postModel = postRepository.findById(dto.getPostId()).orElseThrow();
        UserModel userModel = userRepository.findById(dto.getUserId()).orElseThrow();

        CommentModel commentModel = new CommentModel();
        commentModel.setCreatedAt(Instant.now());
        commentModel.setUser(userModel);
        commentModel.setPost(postModel);
        commentModel.setText(dto.getText());

        return commentModel;
    }

    public CommentModel dtoToEntityUpdate(CommentDto dto,Long id){

        CommentModel commentModel =commentRepository.findById(id).orElseThrow();
        commentModel.setText(dto.getText());


        return commentModel;
    }
}
