package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surnoi.FusionIQ.FusionIQ.data.Fusion;

import java.util.Optional;
@Repository
public interface FusionRepo extends JpaRepository<Fusion,Long> {
    Optional<Fusion> findById(long id);
}

