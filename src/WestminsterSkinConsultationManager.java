import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class    WestminsterSkinConsultationManager implements SkinConsultationManager{
    static ArrayList<Doctor> doctors = new ArrayList<>();

    @Override
    public  void addNewDoctor() {
        boolean flag = sizeAdd();
        if(flag){
            doctors.add(getInput());
        }
    }
    public Doctor getInput(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Doctors' Name : ");
        String name = scn.nextLine();
        System.out.println("Enter Doctors' Surname : ");
        String surname = scn.nextLine();
        int medicalNo = fixErrorMedicalNo();//fixErrorMedicalNo() is creat the method function
        System.out.println("Enter Doctors' specialisation : ");
        String specialisation = scn.nextLine();
        LocalDate date = fixErrorDate();//fixErrorDate() is creat the other method
        int mobileNo = fixErrorMobileNumber();
        Doctor dr = new Doctor(name,surname,date,medicalNo,mobileNo,specialisation);
        return dr;
    }
    public int fixErrorMedicalNo(){
        while(true){
            try{
                System.out.println("Enter Doctors' Medical licence Number : ");
                Scanner scn1 = new Scanner(System.in);
                int medical = scn1.nextInt();
                return medical;
            }catch (Exception e){
                System.out.println("Enter the valid Medical licence Number : ");
            }
        }
    }

    public LocalDate fixErrorDate(){
        while(true){
            try{
                System.out.println("Enter date of birth(YYYY-MM-DD) : ");
                Scanner scn1 = new Scanner(System.in);
                String dateOfBirth = scn1.nextLine();
                LocalDate date = LocalDate.parse(dateOfBirth);
                return date;
            }catch (Exception e){
                System.out.println("Enter the valid input(YYYY-MM-DD) :");
            }
        }
    }
    public int fixErrorMobileNumber(){
        while(true){
            try{
                System.out.println("Enter Doctors' Mobile Number : ");
                Scanner scn1 = new Scanner(System.in);
                int mobile = scn1.nextInt();
                return mobile;
            }catch (Exception e){
                System.out.println("Enter the valid Mobile Number : ");
            }
        }
    }
    public boolean sizeAdd(){
        if (doctors.size()==10){
            System.out.println("Please!Can't add");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public  void deleteDoctor() {
        boolean flag = sizeDelete();
        if(flag){
            getMedicalNo();
            System.out.println("Available doctors : " + doctors.size());
        }
    }
    public boolean sizeDelete(){
        if(doctors.size() == 0){
            System.out.println("Can't delete");
            return false;
        }else{
            return true;
        }
    }
    public void getMedicalNo(){
        int medicalNumber = fixErrorMedicalNo();
        for(Doctor doc: doctors){
            if(doc.getLicenceNo() == medicalNumber){
                doctors.remove(doc);
                System.out.println(doc.getName());
                System.out.println(doc.getSurname());
                System.out.println(doc.getLicenceNo());
                System.out.println(doc.getMobileNo());
                System.out.println(doc.getSpecialisation());
                System.out.println("delete successful");
                return;
            }
        }

    }

    @Override
    public void listDoctor() {
        Collections.sort(doctors, new NameSort());

        for(Doctor doc: doctors){
            System.out.println("Doctor " + (doctors.indexOf(doc) +1));
            System.out.println();
            System.out.println("Name : " +doc.getName());
            System.out.println("Surname :" +doc.getSurname());
            System.out.println("Medical Licence Number : " + doc.getMobileNo());
            System.out.println("Mobile Number : " + doc.getLicenceNo());
            System.out.println("Specialisation : " + doc.getSpecialisation());
            System.out.println();
        }
    }
    public class NameSort implements Comparator<Doctor> {
        public int compare(Doctor doc1, Doctor doc2){

            return doc1.getSurname().compareTo(doc2.getSurname());
        }
    }

    @Override
    public void saveFile() {
        try{
            File f1 = new File("w1904447.txt");
            f1.createNewFile();

            FileOutputStream fileOS = new FileOutputStream(f1);
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
            objectOS.writeObject(doctors);
            objectOS.close();
            fileOS.close();
        }catch(IOException e){

        }
    }
    public void readData(){
        try{
            FileInputStream fileIS = new FileInputStream("w1904447.txt");
            ObjectInputStream objectIS = new ObjectInputStream(fileIS);
            doctors = (ArrayList<Doctor>) objectIS.readObject();

        }catch (ClassNotFoundException | IOException e){

        }

    }

    public static void main(String[] args) {
        SkinConsultationManager skin = new WestminsterSkinConsultationManager();
        Scanner scn = new Scanner(System.in);
        skin.readData();

        while (true) {
//            skin.readData();
            System.out.println("""
                    A. Add Doctor
                    B. Delete Doctor
                    C. Sort Doctors Alphabetically
                    D. Save File
                    E. Open GUI
                    F. Quit
                    
                    Enter Option :""");
            String option = scn.nextLine();
            switch (option) {
                case "A":
                    skin.addNewDoctor();
                    break;

                case "B":
                    skin.deleteDoctor();
                    break;

                case "C":
                    skin.listDoctor();
                    break;

                case "D":
                    skin.saveFile();
                    break;

                case "E":
                    openGUI();
                    break;

                case "F":
                    System.out.println("Good Bye !" + "");
                    return;

                default:
                    System.out.println("Please, Use the Capital");
                    System.out.println();
            }
        }

    }

    public static void openGUI() { //GUI method

        HomeFrame homeFrame = new HomeFrame(doctors);
        homeFrame.setVisible(true);

    }

}


