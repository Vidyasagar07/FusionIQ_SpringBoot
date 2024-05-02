package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mulesoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String batchNo;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    //    private String syllabusStatus;
    private String course;
    private long phoneNumber;
    private String email;
    private String gender;
    private String dateOfJoining;
    private String basics;
    private String ramlStatus;
    private String batchprocessingStatus;
    private String errorhandlingStatus;
    private String apileadconnectivityStatus;
    private String restapiStatus;
    private String activeMQintegrationStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getBasics() {
        return basics;
    }

    public void setBasics(String basics) {
        this.basics = basics;
    }

    public String getRamlStatus() {
        return ramlStatus;
    }

    public void setRamlStatus(String ramlStatus) {
        this.ramlStatus = ramlStatus;
    }

    public String getBatchprocessingStatus() {
        return batchprocessingStatus;
    }

    public void setBatchprocessingStatus(String batchprocessingStatus) {
        this.batchprocessingStatus = batchprocessingStatus;
    }

    public String getErrorhandlingStatus() {
        return errorhandlingStatus;
    }

    public void setErrorhandlingStatus(String errorhandlingStatus) {
        this.errorhandlingStatus = errorhandlingStatus;
    }

    public String getApileadconnectivityStatus() {
        return apileadconnectivityStatus;
    }

    public void setApileadconnectivityStatus(String apileadconnectivityStatus) {
        this.apileadconnectivityStatus = apileadconnectivityStatus;
    }

    public String getRestapiStatus() {
        return restapiStatus;
    }

    public void setRestapiStatus(String restapiStatus) {
        this.restapiStatus = restapiStatus;
    }

    public String getActiveMQintegrationStatus() {
        return activeMQintegrationStatus;
    }

    public void setActiveMQintegrationStatus(String activeMQintegrationStatus) {
        this.activeMQintegrationStatus = activeMQintegrationStatus;
    }

    public Mulesoft(long id, String batchNo, String firstName, String lastName, String userName, String password, String course, long phoneNumber, String email, String gender, String dateOfJoining, String basics, String ramlStatus, String batchprocessingStatus, String errorhandlingStatus, String apileadconnectivityStatus, String restapiStatus, String activeMQintegrationStatus) {
        this.id = id;
        this.batchNo = batchNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.dateOfJoining = dateOfJoining;
        this.basics = basics;
        this.ramlStatus = ramlStatus;
        this.batchprocessingStatus = batchprocessingStatus;
        this.errorhandlingStatus = errorhandlingStatus;
        this.apileadconnectivityStatus = apileadconnectivityStatus;
        this.restapiStatus = restapiStatus;
        this.activeMQintegrationStatus = activeMQintegrationStatus;
    }

    public Mulesoft() {
        super();
    }

    @Override
    public String toString() {
        return "Mulesoft{" +
                "id=" + id +
                ", batchNo='" + batchNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", course='" + course + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", basics='" + basics + '\'' +
                ", ramlStatus='" + ramlStatus + '\'' +
                ", batchprocessingStatus='" + batchprocessingStatus + '\'' +
                ", errorhandlingStatus='" + errorhandlingStatus + '\'' +
                ", apileadconnectivityStatus='" + apileadconnectivityStatus + '\'' +
                ", restapiStatus='" + restapiStatus + '\'' +
                ", activeMQintegrationStatus='" + activeMQintegrationStatus + '\'' +
                '}';
    }
}
