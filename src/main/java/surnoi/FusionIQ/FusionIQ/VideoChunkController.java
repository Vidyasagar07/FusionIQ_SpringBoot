package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import surnoi.FusionIQ.FusionIQ.data.VideoChunk;
import surnoi.FusionIQ.FusionIQ.service.VideoChunkService;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/chunk")
public class VideoChunkController {
    @Autowired
    private VideoChunkService videoChunkService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        // Split the video file into chunks
        List<byte[]> chunks = splitVideoIntoChunks(file);

        // Save the chunks in the database
        Long videoId = generateVideoId(); // Generate a unique ID for the video
        videoChunkService.saveVideoChunks(videoId, chunks);

        return ResponseEntity.ok("Video uploaded successfully with ID: " + videoId);
    }

    // Methods to split the video into chunks and generate video ID
    // Implement these methods according to your requirements
    private List<byte[]> splitVideoIntoChunks(MultipartFile file) {
        List<byte[]> chunks = new ArrayList<>();
        try {
            byte[] fileData = file.getBytes();
            // Split the video into chunks (you can implement your logic here)
            // For demonstration purposes, let's just split it into two equal chunks
            int chunkSize = fileData.length / 2;
            byte[] chunk1 = new byte[chunkSize];
            byte[] chunk2 = new byte[fileData.length - chunkSize];
            System.arraycopy(fileData, 0, chunk1, 0, chunkSize);
            System.arraycopy(fileData, chunkSize, chunk2, 0, fileData.length - chunkSize);
            chunks.add(chunk1);
            chunks.add(chunk2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chunks;
    }

    private Long generateVideoId() {
        // Generate a UUID (Universally Unique Identifier) as a unique video ID
        UUID uuid = UUID.randomUUID();
        // Convert UUID to a long value
        long id = uuid.getMostSignificantBits() & Long.MAX_VALUE;
        return id;
    }
    @GetMapping("/stream/{id}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable Long id) {
        byte[] videoData = videoChunkService.getVideoData(id);
        if (videoData != null) {
            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(videoData));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", "video.mp4");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/chunks/{videoId}")
    public ResponseEntity<List<VideoChunk>> getVideoChunks(@PathVariable Long videoId) {
        List<VideoChunk> videoChunks = videoChunkService.getVideoChunks(videoId);
        if (!videoChunks.isEmpty()) {
            return ResponseEntity.ok(videoChunks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
