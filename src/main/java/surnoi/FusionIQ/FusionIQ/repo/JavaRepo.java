package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surnoi.FusionIQ.FusionIQ.data.Java;

import java.util.Optional;

@Repository
public interface JavaRepo extends JpaRepository<Java,Long> {
    Optional<Java> findById(long id);
    Optional<Java> deleteById(long id);
}
