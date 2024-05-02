package surnoi.FusionIQ.FusionIQ.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Python {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String batchNo;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String gender;
    private String course;
    private Long phoneNumber;
    private String email;
    private String dateOfJoining;
    private String pythonBasicsStatus;
    private String listsStatus;
    private String setsStatus;
    private String tuplesStatus;
    private String dictionariesStatus;
    private String functionsStatus;
    private String lambdaStatus;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPythonBasicsStatus() {
        return pythonBasicsStatus;
    }

    public void setPythonBasicsStatus(String pythonBasicsStatus) {
        this.pythonBasicsStatus = pythonBasicsStatus;
    }

    public String getListsStatus() {
        return listsStatus;
    }

    public void setListsStatus(String listsStatus) {
        this.listsStatus = listsStatus;
    }

    public String getSetsStatus() {
        return setsStatus;
    }

    public void setSetsStatus(String setsStatus) {
        this.setsStatus = setsStatus;
    }

    public String getTuplesStatus() {
        return tuplesStatus;
    }

    public void setTuplesStatus(String tuplesStatus) {
        this.tuplesStatus = tuplesStatus;
    }

    public String getDictionariesStatus() {
        return dictionariesStatus;
    }

    public void setDictionariesStatus(String dictionariesStatus) {
        this.dictionariesStatus = dictionariesStatus;
    }

    public String getFunctionsStatus() {
        return functionsStatus;
    }

    public void setFunctionsStatus(String functionsStatus) {
        this.functionsStatus = functionsStatus;
    }

    public String getLambdaStatus() {
        return lambdaStatus;
    }

    public void setLambdaStatus(String lambdaStatus) {
        this.lambdaStatus = lambdaStatus;
    }

    public Python(Long id, String batchNo, String firstName, String lastName, String userName, String password, String gender, String course, Long phoneNumber, String email, String dateOfJoining, String pythonBasicsStatus, String listsStatus, String setsStatus, String tuplesStatus, String dictionariesStatus, String functionsStatus, String lambdaStatus) {
        this.id = id;
        this.batchNo = batchNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfJoining = dateOfJoining;
        this.pythonBasicsStatus = pythonBasicsStatus;
        this.listsStatus = listsStatus;
        this.setsStatus = setsStatus;
        this.tuplesStatus = tuplesStatus;
        this.dictionariesStatus = dictionariesStatus;
        this.functionsStatus = functionsStatus;
        this.lambdaStatus = lambdaStatus;
    }

    public Python() {
        super();
    }

    @Override
    public String toString() {
        return "Python{" +
                "id=" + id +
                ", batchNo='" + batchNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", course='" + course + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", pythonBasicsStatus='" + pythonBasicsStatus + '\'' +
                ", listsStatus='" + listsStatus + '\'' +
                ", setsStatus='" + setsStatus + '\'' +
                ", tuplesStatus='" + tuplesStatus + '\'' +
                ", dictionariesStatus='" + dictionariesStatus + '\'' +
                ", functionsStatus='" + functionsStatus + '\'' +
                ", lambdaStatus='" + lambdaStatus + '\'' +
                '}';
    }
}
