package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import surnoi.FusionIQ.FusionIQ.data.Contact;
import surnoi.FusionIQ.FusionIQ.data.Video;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Optional<Video> findById(long id);
}
