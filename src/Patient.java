public class Patient {
    private int patientId; //instance varible

    public int getPatientId() { //instance constructor
        return patientId;
    }

    public void setPatientId(int patientId) { //creat getter and setter method
        this.patientId = patientId;
    }

    public Patient(int patientId) {

        this.patientId = patientId;
    }
}
