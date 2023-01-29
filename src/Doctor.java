import java.io.Serializable;
import java.time.LocalDate;


public class Doctor extends Person implements Serializable {
    private int licenceNo;   //instance variable
    private String specialisation;

    public Doctor(String name, String surname, LocalDate dateOfBirth, int mobileNo, int licenceNo, String specialisation) { //parametrize constructor
        super(name, surname, dateOfBirth, mobileNo);   //implement super class is Person class
        this.licenceNo = licenceNo;
        this.specialisation = specialisation;

    }

    public int getLicenceNo() {

        return licenceNo;
    }

    public void setLicenceNo(int licenceNo) {

        this.licenceNo = licenceNo;
    }

    public String getSpecialisation() {

        return specialisation;
    }

    public void setSpecialisation(String specialisation) {

        this.specialisation = specialisation;
    }








}

