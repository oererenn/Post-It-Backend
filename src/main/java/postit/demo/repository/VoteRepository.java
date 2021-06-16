package postit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import postit.demo.model.VoteModel;

import java.util.List;

public interface VoteRepository extends JpaRepository<VoteModel, Long> {
    List<VoteModel> findByUserId(Long id);
}
