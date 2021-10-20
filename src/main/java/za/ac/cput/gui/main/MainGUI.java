package za.ac.cput.gui.main;

//Group13
//Capstone - Front-End
//MainGUI

import za.ac.cput.gui.address.AddressMenuGUI;
import za.ac.cput.gui.item.AddItemGUI;
import za.ac.cput.gui.item.ItemMenuGUI;
import za.ac.cput.gui.patient.PatientMenu;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MainGUI implements ActionListener {
    private JFrame mainframe;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnPatient, btnDoctor, btnReceptionist, btnItem, btnAppointment, btnPrescription, btnAddress;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5, Filler6, Filler7, Filler8, Filler9, Filler10;
    Color panAllColor = Color.LIGHT_GRAY;
    Color btnColor = Color.WHITE;
    private Font headingFont;

    public MainGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        mainframe = new JFrame("Clinic System");
        panelWest = new JPanel();
        panelNorth = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(panAllColor);
        panelEast.setBackground(panAllColor);
        panelSouth.setBackground(panAllColor);
        panelWest.setBackground(panAllColor);
        panelCenter.setBackground(panAllColor);

        //Fillers
        Filler1 = new JLabel("======");
        Filler2 = new JLabel("======");
        Filler3 = new JLabel("======");
        Filler4 = new JLabel("======");
        Filler1.setForeground(panAllColor);
        Filler2.setForeground(panAllColor);
        Filler3.setForeground(panAllColor);
        Filler4.setForeground(panAllColor);

        //Buttons
        btnPatient = new JButton("1. Patients");
        btnPatient.setBackground(btnColor);
        btnDoctor = new JButton("2. Doctors");
        btnDoctor.setBackground(btnColor);
        btnReceptionist = new JButton("3. Receptionists");
        btnReceptionist.setBackground(btnColor);
        btnAppointment = new JButton("4. Appointments");
        btnAppointment.setBackground(btnColor);
        btnItem = new JButton("5. Medication");
        btnItem.setBackground(btnColor);
        btnPrescription = new JButton("6. Prescriptions");
        btnPrescription.setBackground(btnColor);
        btnAddress = new JButton("7. Address");
        btnAddress.setBackground(btnColor);
    }

    //Creating the GUI
    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelSouth.setLayout(new GridLayout(1, 1));
        panelWest.setLayout(new GridLayout(7, 1));
        panelCenter.setLayout(new GridLayout(7, 1));
        panelEast.setLayout(new GridLayout(7, 1));

        //Panel North
        panelNorth.add(Filler4);

        //Panel West:
        panelWest.add(Filler1);

        //Panel East:
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(Filler3);

        //Panel Center
        panelCenter.add(btnPatient);
        panelCenter.add(btnDoctor);
        panelCenter.add(btnReceptionist);
        panelCenter.add(btnAppointment);
        panelCenter.add(btnItem);
        panelCenter.add(btnPrescription);
        panelCenter.add(btnAddress);

        //Adding panels to mainframe:
        mainframe.add(panelNorth, BorderLayout.NORTH);
        mainframe.add(panelSouth, BorderLayout.SOUTH);
        mainframe.add(panelEast, BorderLayout.EAST);
        mainframe.add(panelCenter, BorderLayout.CENTER);
        mainframe.add(panelWest, BorderLayout.WEST);

        //Adding actions to buttons
        btnDoctor.addActionListener(this);
        btnPatient.addActionListener(this);
        btnReceptionist.addActionListener(this);
        btnAppointment.addActionListener(this);
        btnItem.addActionListener(this);
        btnPrescription.addActionListener(this);
        btnAddress.addActionListener(this);

        // Set UI:
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(400,400);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e)
    {
       if(e.getActionCommand().equals("1. Patients"))
        {
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.setGUI();
            mainframe.dispose();
        }
       if(e.getActionCommand().equals("5. Medication"))
        {
           ItemMenuGUI itemMenuGUI = new ItemMenuGUI();
           itemMenuGUI.setGUI();
        }
        if(e.getActionCommand().equals("7. Address"))
        {
            AddressMenuGUI addressMenuGUI = new AddressMenuGUI();
            addressMenuGUI.setGUI();
        }
    

    }

}
