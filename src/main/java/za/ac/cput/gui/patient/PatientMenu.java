package za.ac.cput.gui.patient;

import za.ac.cput.gui.main.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientMenu implements ActionListener {
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAddPatient, btnDeletePatient, btnCheckPatient, btnUpdatePatient, btnGetAllPatients, btnExit;
    private Font headingFont;
    Color btnColor = Color.WHITE;

    public PatientMenu(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        MenuFrame = new JFrame("Patient: ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(Color.LIGHT_GRAY);
        panelEast.setBackground(Color.LIGHT_GRAY);
        panelSouth.setBackground(Color.LIGHT_GRAY);
        panelWest.setBackground(Color.LIGHT_GRAY);
        panelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Patient Menu",JLabel.CENTER);

        //Buttons:
        btnAddPatient = new JButton("Add New Patient");
        btnAddPatient.setBackground(btnColor);
        btnCheckPatient = new JButton("Check A Patient");
        btnCheckPatient.setBackground(btnColor);
        btnUpdatePatient = new JButton("Update Patients Details");
        btnUpdatePatient.setBackground(btnColor);
        btnDeletePatient = new JButton("Delete Patient");
        btnDeletePatient.setBackground(btnColor);
        btnGetAllPatients = new JButton("Display All Patients");
        btnGetAllPatients.setBackground(btnColor);
        btnExit = new JButton("Exit");
        btnExit.setBackground(btnColor);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(7, 1));

        panelNorth.add(lblHeading);

        panelCenter.add(btnAddPatient);
        panelCenter.add(btnCheckPatient);
        panelCenter.add(btnUpdatePatient);
        panelCenter.add(btnDeletePatient);
        panelCenter.add(btnGetAllPatients);

        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        btnAddPatient.addActionListener(this);
        btnCheckPatient.addActionListener(this);
        btnUpdatePatient.addActionListener(this);
        btnDeletePatient.addActionListener(this);
        btnGetAllPatients.addActionListener(this);
        btnExit.addActionListener(this);

        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(350, 350);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add New Patient")){
            AddPatient addPatient = new AddPatient();
            addPatient.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Check A Patient")){
            CheckPatient checkPatient = new CheckPatient();
            checkPatient.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Update Patients Details")){
            UpdatePatient updatePatient = new UpdatePatient();
            updatePatient.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Delete Patient")){
            DeletePatient deletePatient = new DeletePatient();
            deletePatient.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Display All Patients")){
            DispalyPatients dispalyPatients = new DispalyPatients();
            dispalyPatients.setGUI();
            MenuFrame.dispose();
        }
        if(e.getActionCommand().equals("Exit")){
            MenuFrame.dispose();
            MainGUI mainGUI = new MainGUI();
            mainGUI.setGUI();
        }
    }
}
