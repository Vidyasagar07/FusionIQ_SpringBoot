package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Student;
    private String Batch;
    private String CourseName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudent() {
        return Student;
    }
    public void setStudent(String student) {
        Student = student;
    }
    public String getBatch() {
        return Batch;
    }
    public void setBatch(String batch) {
        Batch = batch;
    }
    public String getCourseName() {
        return CourseName;
    }
    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
    public Course(Long id, String student, String batch, String courseName) {
        this.id = id;
        this.Student = student;
        this.Batch = batch;
        this.CourseName = courseName;
    }
    public Course() {
        super();
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Student='" + Student + '\'' +
                ", Batch='" + Batch + '\'' +
                ", CourseName='" + CourseName + '\'' +
                '}';
    }
}

