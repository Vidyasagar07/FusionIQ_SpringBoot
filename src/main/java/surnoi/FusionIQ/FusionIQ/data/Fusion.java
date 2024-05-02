package surnoi.FusionIQ.FusionIQ.data;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
public class Fusion  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String Fullname;
    private String Email;
    private long Phone;
    private String Applying_for;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Time_submission;

    @PrePersist
    private void onCreate(){
        Time_submission = new Date();
    }
    @Override
    public String toString() {
        return "Fusion{" +
                "id=" + id +
                ", Fullname='" + Fullname + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone=" + Phone +
                ", Applying_for='" + Applying_for + '\'' +
                ", Time_submission='" + Time_submission + '\'' +
                '}';
    }
    public Fusion() {
        super();
    }
    public Fusion(Long id, String fullname, String email, long phone, String applying_for, Date time_submission) {
        this.id = id;
        this.Fullname = fullname;
        this.Email = email;
        this.Phone = phone;
        this.Applying_for = applying_for;
        this.Time_submission = time_submission;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullname() {
        return Fullname;
    }
    public void setFullname(String fullname) {
        Fullname = fullname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public long getPhone() {
        return Phone;
    }
    public void setPhone(long phone) {
        Phone = phone;
    }
    public String getApplying_for() {
        return Applying_for;
    }
    public void setApplying_for(String applying_for) {
        Applying_for = applying_for;
    }
    public Date getTime_submission() {
        return Time_submission;
    }
    public void setTime_submission(Date time_submission) {
        Time_submission = time_submission;
    }
}

