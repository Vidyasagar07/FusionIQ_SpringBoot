package surnoi.FusionIQ.FusionIQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import surnoi.FusionIQ.FusionIQ.data.Video;
import surnoi.FusionIQ.FusionIQ.data.VideoChunk;
import surnoi.FusionIQ.FusionIQ.repo.VideoChunkRepository;
import surnoi.FusionIQ.FusionIQ.repo.VideoRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video saveVideo(MultipartFile file) throws IOException {
        Video video = new Video();
        video.setName(file.getOriginalFilename());
        video.setData(file.getBytes());
        return videoRepository.save(video);
    }

    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

}


