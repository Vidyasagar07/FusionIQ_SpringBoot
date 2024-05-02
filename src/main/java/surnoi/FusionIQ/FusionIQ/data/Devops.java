package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Devops {
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
    private String devopsautomationStatus;
    private String devopsarchitectureStatus;
    private String devopspipeStatus;
    private String devtoolsStatus;
    private String terraformStatus;

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

    public String getDevopsautomationStatus() {
        return devopsautomationStatus;
    }

    public void setDevopsautomationStatus(String devopsautomationStatus) {
        this.devopsautomationStatus = devopsautomationStatus;
    }

    public String getDevopsarchitectureStatus() {
        return devopsarchitectureStatus;
    }

    public void setDevopsarchitectureStatus(String devopsarchitectureStatus) {
        this.devopsarchitectureStatus = devopsarchitectureStatus;
    }

    public String getDevopspipeStatus() {
        return devopspipeStatus;
    }

    public void setDevopspipeStatus(String devopspipeStatus) {
        this.devopspipeStatus = devopspipeStatus;
    }

    public String getDevtoolsStatus() {
        return devtoolsStatus;
    }

    public void setDevtoolsStatus(String devtoolsStatus) {
        this.devtoolsStatus = devtoolsStatus;
    }

    public String getTerraformStatus() {
        return terraformStatus;
    }

    public void setTerraformStatus(String terraformStatus) {
        this.terraformStatus = terraformStatus;
    }

    public Devops(long id, String batchNo, String firstName, String lastName, String userName, String password, String course, long phoneNumber, String email, String gender, String dateOfJoining, String basics, String ramlStatus, String devopsautomationStatus, String devopsarchitectureStatus, String devopspipeStatus, String devtoolsStatus, String terraformStatus) {
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
        this.devopsautomationStatus = devopsautomationStatus;
        this.devopsarchitectureStatus = devopsarchitectureStatus;
        this.devopspipeStatus = devopspipeStatus;
        this.devtoolsStatus = devtoolsStatus;
        this.terraformStatus = terraformStatus;
    }

    public Devops() {
        super();
    }

    @Override
    public String toString() {
        return "Devops{" +
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
                ", devopsautomationStatus='" + devopsautomationStatus + '\'' +
                ", devopsarchitectureStatus='" + devopsarchitectureStatus + '\'' +
                ", devopspipeStatus='" + devopspipeStatus + '\'' +
                ", devtoolsStatus='" + devtoolsStatus + '\'' +
                ", terraformStatus='" + terraformStatus + '\'' +
                '}';
    }
}
