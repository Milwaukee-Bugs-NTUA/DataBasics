package gr.ntua.ece.databases.data.model;

import java.util.*;

enum Sex {
    male,
    female,
    other
}

enum MaritalStatus {
    single,
    married,
    divorced,
    in_relationship
}

public class User {
    private Long cardNumber;
    private String email;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Sex sex;
    private String addressStreet;
    private int  addressNumber;
    private String addressPostalCode;
    private String addressCity;
    private String phoneNumber;
    private MaritalStatus maritalStatus;
    private int  numberOfChildren;
    private int  points;

    public User() {
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setSex(String sex) {
        this.sex = Sex.valueOf(sex);
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public int  getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int  addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = MaritalStatus.valueOf(maritalStatus);
    }

    public int  getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int  numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int  getPoints() {
        return points;
    }

    public void setPoints(int  points) {
        this.points = points;
    }

}
