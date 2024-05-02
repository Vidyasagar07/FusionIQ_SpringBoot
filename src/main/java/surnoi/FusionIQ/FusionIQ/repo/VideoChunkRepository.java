package surnoi.FusionIQ.FusionIQ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import surnoi.FusionIQ.FusionIQ.data.VideoChunk;

import java.util.List;

public interface VideoChunkRepository extends JpaRepository<VideoChunk, Long> {
    List<VideoChunk> findByVideoIdOrderBySequenceNumber(Long videoId);
}
