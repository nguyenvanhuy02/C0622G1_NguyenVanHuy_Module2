package ss5_access_modifier_static_method_static_property.exercise.candidate;

import java.time.LocalDate;

public class Candidate {
    private int code ;
    private String name;
    private String dateOfBirth ;
    private int math;
    private int literature ;
    private int english;
    private int tottal;

    public Candidate(int code, String name, String dateOfBirth, int math, int literature, int english) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.math = math;
        this.literature = literature;
        this.english = english;
    }

    public Candidate() {
        this.code = 1;
        this.name = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getLiterature() {
        return literature;
    }

    public void setLiterature(int literature) {
        this.literature = literature;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getTottal() {
        return tottal= (this.math + this.literature + this.english);
    }

    public void setTottal(int tottal) {
        this.tottal = tottal;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", math=" + math +
                ", literature=" + literature +
                ", english=" + english +
                '}';
    }

}
