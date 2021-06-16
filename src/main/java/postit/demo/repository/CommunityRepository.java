package postit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import postit.demo.model.CommunityModel;

public interface CommunityRepository extends JpaRepository<CommunityModel, Long> {
}
