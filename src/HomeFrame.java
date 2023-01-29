import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeFrame extends JFrame {
    public HomeFrame(ArrayList<Doctor> doctors) {
        setTitle("Home Panel");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel homePanel = new JPanel(new GridLayout(4, 1, 10, 50) );

        JButton docButton = new JButton("View Doctors");
        JButton formButton = new JButton("New Consultation");

        docButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstFrame docTableFrame = new FirstFrame(doctors);
                docTableFrame.setVisible(true);
            }
        });

        formButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondFrame formFrame = new SecondFrame(doctors);
                formFrame.setVisible(true);
            }
        });

        homePanel.add(docButton);
        homePanel.add(formButton);
        this.add(homePanel);


    }


    public HomeFrame() {

    }
}

