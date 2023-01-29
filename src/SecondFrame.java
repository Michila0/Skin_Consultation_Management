import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class SecondFrame extends JFrame{
    public SecondFrame(ArrayList<Doctor> doctors){

        JPanel p= new JPanel(new GridLayout(7, 2, 10, 5));

        setTitle("PATIENT DETAILS");
        setSize(400, 400);

        add(p);

        JLabel l1= new JLabel("Name: "); //creat the pation detail
        JTextField t1= new JTextField();
        JLabel l2= new JLabel("Surname: ");
        JTextField t2= new JTextField();
        JLabel l3= new JLabel("Date of Birth: ");
        JTextField t3= new JTextField();
        JLabel l4= new JLabel("Mobile No: ");
        JTextField t4= new JTextField();
        JLabel l5= new JLabel("Patient Id: ");
        JTextField t5= new JTextField();
        JLabel l6= new JLabel("Time: ");
        JTextField t6= new JTextField();

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(l4);
        p.add(t4);
        p.add(l5);
        p.add(t5);
        p.add(l6);
        p.add(t6);

        JButton backB= new JButton("Back");
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame backTableFrame = new HomeFrame(doctors);
                backTableFrame.setVisible(true);
            }
        });
        JButton submitB= new JButton("Submit");
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThirdFrame submitTableFrame = new ThirdFrame(doctors);
                submitTableFrame.setVisible(true);
            }
        });
        p.add(backB);
        p.add(submitB);
        this.add(p);
        this.add(p);

        submitB.addActionListener(e -> {
            String name = t1.getText();
            String surname = t2.getText();
//            String dob = t3.getText();
            String mob = t4.getText();
            LocalDate patientBirthDate;
            int mobileno ;
            Date appointmentdate;
//==================================================Input validation=============================================================

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(p, "Name Cannot Empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (surname.isEmpty()) {
                JOptionPane.showMessageDialog(p, "Surname Cannot Empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                mobileno = Integer.parseInt(mob);
            } catch (Exception x) {
                JOptionPane.showMessageDialog(p, "Mobile should be integer", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd;HH:mm");

        });

    }

}



