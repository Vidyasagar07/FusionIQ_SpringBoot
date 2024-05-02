package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.*;

import java.util.Arrays;
@Entity
public class VideoChunk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long videoId; // Foreign key to the Video entity

    private int sequenceNumber; // Sequence number of the chunk

    @Lob
//    @Column(length = 1048576)
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    public VideoChunk(Long id, Long videoId, int sequenceNumber, byte[] data) {
        this.id = id;
        this.videoId = videoId;
        this.sequenceNumber = sequenceNumber;
        this.data = data;
    }

    public VideoChunk() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VideoChunk{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", sequenceNumber=" + sequenceNumber +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
