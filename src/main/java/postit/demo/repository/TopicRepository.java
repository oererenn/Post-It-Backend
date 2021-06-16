package postit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import postit.demo.model.TopicModel;

public interface TopicRepository extends JpaRepository<TopicModel, Long> {
}
