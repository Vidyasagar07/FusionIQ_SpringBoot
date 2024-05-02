package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Java {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String batchNo;
    private String firstName;
    private String lastName;
    private String gender;
    private String userName;
    private String password;
    private String course;
    private Long phoneNumber;
    private String email;
    private String dateOfJoining;
    private String javaBasicsStatus;
    private String oopsStatus;
    private String exceptionHandlingStatus;
    private String collectionsStatus;
    private String multithreadingStatus;
    private String ioStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getJavaBasicsStatus() {
        return javaBasicsStatus;
    }

    public void setJavaBasicsStatus(String javaBasicsStatus) {
        this.javaBasicsStatus = javaBasicsStatus;
    }

    public String getOopsStatus() {
        return oopsStatus;
    }

    public void setOopsStatus(String oopsStatus) {
        this.oopsStatus = oopsStatus;
    }

    public String getExceptionHandlingStatus() {
        return exceptionHandlingStatus;
    }

    public void setExceptionHandlingStatus(String exceptionHandlingStatus) {
        this.exceptionHandlingStatus = exceptionHandlingStatus;
    }

    public String getCollectionsStatus() {
        return collectionsStatus;
    }

    public void setCollectionsStatus(String collectionsStatus) {
        this.collectionsStatus = collectionsStatus;
    }

    public String getMultithreadingStatus() {
        return multithreadingStatus;
    }

    public void setMultithreadingStatus(String multithreadingStatus) {
        this.multithreadingStatus = multithreadingStatus;
    }

    public String getIoStatus() {
        return ioStatus;
    }

    public void setIoStatus(String ioStatus) {
        this.ioStatus = ioStatus;
    }

    public Java(Long id, String batchNo, String firstName, String lastName, String gender, String userName, String password, String course, Long phoneNumber, String email, String dateOfJoining, String javaBasicsStatus, String oopsStatus, String exceptionHandlingStatus, String collectionsStatus, String multithreadingStatus, String ioStatus) {
        this.id = id;
        this.batchNo = batchNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfJoining = dateOfJoining;
        this.javaBasicsStatus = javaBasicsStatus;
        this.oopsStatus = oopsStatus;
        this.exceptionHandlingStatus = exceptionHandlingStatus;
        this.collectionsStatus = collectionsStatus;
        this.multithreadingStatus = multithreadingStatus;
        this.ioStatus = ioStatus;
    }

    public Java() {
        super();
    }

    @Override
    public String toString() {
        return "Java{" +
                "id=" + id +
                ", batchNo='" + batchNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", course='" + course + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", javaBasicsStatus='" + javaBasicsStatus + '\'' +
                ", oopsStatus='" + oopsStatus + '\'' +
                ", exceptionHandlingStatus='" + exceptionHandlingStatus + '\'' +
                ", collectionsStatus='" + collectionsStatus + '\'' +
                ", multithreadingStatus='" + multithreadingStatus + '\'' +
                ", ioStatus='" + ioStatus + '\'' +
                '}';
    }
}
