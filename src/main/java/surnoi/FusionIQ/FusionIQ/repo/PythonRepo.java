package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surnoi.FusionIQ.FusionIQ.data.Python;

import java.util.Optional;

@Repository
public interface PythonRepo extends JpaRepository<Python,Long> {
    Optional<Python> findById(long id);
    Optional<Python> deleteById(long id);
}
