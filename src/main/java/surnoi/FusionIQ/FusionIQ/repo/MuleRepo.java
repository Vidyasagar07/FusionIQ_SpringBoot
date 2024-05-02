package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surnoi.FusionIQ.FusionIQ.data.Mulesoft;

import java.util.Optional;

@Repository
public interface MuleRepo extends JpaRepository<Mulesoft,Long> {
    Optional<Mulesoft> findById(long id);
}
