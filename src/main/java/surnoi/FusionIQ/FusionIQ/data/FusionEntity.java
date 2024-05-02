package surnoi.FusionIQ.FusionIQ.data;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class FusionEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String First_name;
    private String Last_name;
    private String Email;
    private String Phone;
    private String Applying_for;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Time_submission;

    public FusionEntity() {
        super();
    }

    public FusionEntity(Long id, String first_name, String last_name, String email, String phone, String applying_for, Date time_submission) {
        super();
        this.id = id;
        this.First_name = first_name;
        this.Last_name = last_name;
        this.Email = email;
        this.Phone = phone;
        this.Applying_for = applying_for;
        this.Time_submission = time_submission;
    }
    public Date getTime_submission() {
        return Time_submission;
    }
    public void setTime_submission(Date time_submission) {
        Time_submission = time_submission;
    }
    @PrePersist
    private void onCreate(){
        Time_submission = new Date();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirst_name() {
        return First_name;
    }
    public void setFirst_name(String first_name) {
        First_name = first_name;
    }
    public String getLast_name() {
        return Last_name;
    }
    public void setLast_name(String last_name) {
        Last_name = last_name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getApplying_for() {
        return Applying_for;
    }
    public void setApplying_for(String applying_for) {
        Applying_for = applying_for;
    }
    @Override
    public String toString() {
        return "FusionEntity [id=" + id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", Email=" + Email
                + ", Phone=" + Phone + ", Applying_for=" + Applying_for + ", Time_submission=" + Time_submission +"]";
    }
}

