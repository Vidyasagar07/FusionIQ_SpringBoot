package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class Candidates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String batchNo;
    private String firstName;
    private String lastName;
    private String userName;
    private String gender;
    private String password;
    private String syllabusStatus;
    private String course;
    private long completedSteps;
    private long currentStep;
    private long phoneNumber;
    private long alternateNo;
    private String email;
    private String houseNo;
    private String city;
    private String pinCode;
    private String state;
    private String yearOfCompletion;
    private String university;
    private String branch;
    private String cgpa;
    private String dateOfJoin;
    private String dateOfBirth;

    public Candidates(){

    }

    public Candidates(long id, String batchNo, String firstName, String lastName, String userName, String gender, long alternateNo, String password, String syllabusStatus, String course, long completedSteps, long currentStep, long phoneNumber, String email, String houseNo, String city, String pinCode, String state, String yearOfCompletion, String university, String branch, String cgpa, String dateOfJoin, String dateOfBirth) {
        this.id = id;
        this.gender = gender;
        this.alternateNo = alternateNo;
        this.batchNo = batchNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.syllabusStatus = syllabusStatus;
        this.course = course;
        this.completedSteps = completedSteps;
        this.currentStep = currentStep;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.houseNo = houseNo;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.yearOfCompletion = yearOfCompletion;
        this.university = university;
        this.branch = branch;
        this.cgpa = cgpa;
        this.dateOfJoin = dateOfJoin;
        this.dateOfBirth = dateOfBirth;
    }

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

    public String getSyllabusStatus() {
        return syllabusStatus;
    }

    public void setSyllabusStatus(String syllabusStatus) {
        this.syllabusStatus = syllabusStatus;
    }

    public String getCourse() {
        return course;
    }

    public long getCompletedSteps() {
        return completedSteps;
    }

    public void setCompletedSteps(long completedSteps) {
        this.completedSteps = completedSteps;
    }

    public long getCurrentSteps() {
        return currentStep;
    }

    public void setCurrentStep(long currentStep) {
        this.currentStep = currentStep;
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

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYearOfCompletion() {
        return yearOfCompletion;
    }

    public void setYearOfCompletion(String yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getAlternateNo() {
        return alternateNo;
    }

    public void setAlternateNo(long alternateNo) {
        this.alternateNo = alternateNo;
    }

    @Override
    public String toString() {
        return "Candidates{" +
                "id=" + id +
                ", batchNo='" + batchNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", syllabusStatus='" + syllabusStatus + '\'' +
                ", course='" + course + '\'' +
                ", completedSteps=" + completedSteps +
                ", currentStep=" + currentStep +
                ", phoneNumber=" + phoneNumber +
                ", alternateNo=" + alternateNo +
                ", email='" + email + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", yearOfCompletion='" + yearOfCompletion + '\'' +
                ", university='" + university + '\'' +
                ", branch='" + branch + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", dateOfJoin='" + dateOfJoin + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
