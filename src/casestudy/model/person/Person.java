package casestudy.model.person;

import java.time.LocalDate;

public class Person {
    private String code;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String citizenship;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String code, String name, String dateOfBirth, String gender, String citizenship, String phoneNumber, String email) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.citizenship = citizenship;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s"
                ,code,name,dateOfBirth,gender,citizenship,phoneNumber,email);
    }
//    public String toStringWrite(){
//        return String.format("ID: %s,Họ và tên: %s,%s,%s,%s,%s,%s"
//                ,code,name,dateOfBirth,gender,citizenship,phoneNumber,email);
//    }
}
