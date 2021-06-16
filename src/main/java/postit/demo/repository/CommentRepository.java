package postit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import postit.demo.model.CommentModel;


import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    List<CommentModel> findByPostId(Long id);
}
