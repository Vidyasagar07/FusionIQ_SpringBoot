package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import surnoi.FusionIQ.FusionIQ.data.Candidates;

import java.util.Optional;

public interface CandidateRepo extends JpaRepository<Candidates,Long> {
    Optional<Candidates> findByUserNameAndPassword(String userName, String password);
}
