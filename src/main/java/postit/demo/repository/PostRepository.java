package postit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import postit.demo.model.PostModel;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {
    List<PostModel> findByUserId(Long id);
    List<PostModel> findByCommunityId(Long id);
}
