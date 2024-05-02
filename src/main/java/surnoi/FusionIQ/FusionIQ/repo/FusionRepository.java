package surnoi.FusionIQ.FusionIQ.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.springboot.entity.FusionEntity;
import surnoi.FusionIQ.FusionIQ.data.FusionEntity;

public interface FusionRepository extends JpaRepository<FusionEntity, Long> {
    Optional<FusionEntity> findById(Long id);
    Optional<FusionEntity> deleteById(long id);
}

