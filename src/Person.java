import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;

public class Person implements Serializable {
    private String name;  //instance variable
    private String surname;
    private LocalDate dateOfBirth;
    private int mobileNo;
    public Person(String name, String surname, LocalDate dateOfBirthday, int mobileNo) { //parametrize constructor
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirthday;
        this.mobileNo = mobileNo;
    }

    public String getName() { //instance method(and use setter & getter method)

        return name;       //local variable
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public LocalDate getDateOfBirthday() {

        return dateOfBirth;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {

        this.dateOfBirth = dateOfBirthday;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {

        this.mobileNo = mobileNo;
    }







}

