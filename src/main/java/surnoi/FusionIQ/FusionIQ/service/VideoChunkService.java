package surnoi.FusionIQ.FusionIQ.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import surnoi.FusionIQ.FusionIQ.data.VideoChunk;
import surnoi.FusionIQ.FusionIQ.repo.VideoChunkRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class VideoChunkService {
    private final VideoChunkRepository videoChunkRepository;

    public VideoChunkService(VideoChunkRepository videoChunkRepository) {
        this.videoChunkRepository = videoChunkRepository;
    }
    public VideoChunk saveVideoChunks(MultipartFile file) throws IOException {
        VideoChunk video = new VideoChunk();
//        video.setName(file.getOriginalFilename());
        video = videoChunkRepository.save(video);
        video = videoChunkRepository.findById(video.getId()).orElse(null);
        if (video == null) {
            // Handle error if the video entity is not found
            throw new IllegalStateException("Failed to save video. Video entity not found.");
        }

        // Split the file into chunks
        byte[] fileData = file.getBytes();
        int chunkSize = 1024 * 1024; // 1MB chunk size (adjust as needed)
        int totalChunks = (int) Math.ceil((double) fileData.length / chunkSize);

        // Save each chunk to the database
        for (int i = 0; i < totalChunks; i++) {
            int offset = i * chunkSize;
            int length = Math.min(chunkSize, fileData.length - offset);
            byte[] chunkData = Arrays.copyOfRange(fileData, offset, offset + length);

            VideoChunk chunk = new VideoChunk();
            chunk.setVideoId(video.getId()); // Set the video ID for the chunk
            chunk.setSequenceNumber(i);
            chunk.setData(chunkData);
            videoChunkRepository.save(chunk);
        }

        return video;
    }

    public List<VideoChunk> getVideoChunks(Long videoId) {
        return videoChunkRepository.findByVideoIdOrderBySequenceNumber(videoId);
    }
    public VideoChunk getVideoChunkById(Long id) {
        return videoChunkRepository.findById(id).orElse(null);
    }
    private List<byte[]> splitVideoIntoChunks(MultipartFile file) throws IOException {
        byte[] fileData = file.getBytes();
        int chunkSize = 1024 * 1024; // 1MB chunk size (adjust as needed)
        int totalChunks = (int) Math.ceil((double) fileData.length / chunkSize);

        // Save each chunk to the database
        List<byte[]> chunks = new ArrayList<>();
        for (int i = 0; i < totalChunks; i++) {
            int offset = i * chunkSize;
            int length = Math.min(chunkSize, fileData.length - offset);
            byte[] chunkData = Arrays.copyOfRange(fileData, offset, offset + length);
            chunks.add(chunkData);
        }
        return chunks;
    }
    public void saveVideoChunks(Long videoId, List<byte[]> chunks) {
        int sequenceNumber = 0;
        for (byte[] chunkData : chunks) {
            VideoChunk chunk = new VideoChunk();
            chunk.setVideoId(videoId);
            chunk.setSequenceNumber(sequenceNumber++);
            chunk.setData(chunkData);
            videoChunkRepository.save(chunk);
        }
    }

    public byte[] getVideoData(Long videoId) {
        List<VideoChunk> chunks = videoChunkRepository.findByVideoIdOrderBySequenceNumber(videoId);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (VideoChunk chunk : chunks) {
            try {
                outputStream.write(chunk.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream.toByteArray();
    }

    // Other methods for managing video chunks
}
