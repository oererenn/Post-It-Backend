package postit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import postit.demo.model.ERole;
import postit.demo.model.RoleModel;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(ERole name);
}
