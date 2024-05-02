package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surnoi.FusionIQ.FusionIQ.data.Devops;

import java.util.Optional;

@Repository
public interface DevRepo extends JpaRepository<Devops,Long> {
    Optional<Devops> findById(long id);
}
