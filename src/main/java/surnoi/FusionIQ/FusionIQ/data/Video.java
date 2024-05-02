package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @Lob
//    @Column(length = 1000 * 1024 * 1024) // 1000 MB
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
    public Video() {
    }
    public Video(Long id, String name, byte[] data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UploadEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}



