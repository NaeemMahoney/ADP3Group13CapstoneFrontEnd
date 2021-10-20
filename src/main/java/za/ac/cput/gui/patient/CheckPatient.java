package za.ac.cput.gui.patient;

import za.ac.cput.entity.person.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPatient implements ActionListener {
    private JFrame PatientsDisplayFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblPatientNumber;
    private TextArea taCheck;
    private TextField txtPatientNumber;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont;

    public CheckPatient() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        PatientsDisplayFrame = new JFrame("Patient: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        lblHeading = new JLabel("Requested Patient",JLabel.CENTER);
        lblPatientNumber = new JLabel("Patient Number:");

        taCheck = new TextArea("PatientNumber\tName\tSurname\n");

        txtPatientNumber = new TextField("");

        btnDisplay = new JButton("Display");
        btnExit = new JButton("Exit");
        btnClear = new JButton("Clear");
    }
    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(3,1));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblHeading);

        panelCenter.add(lblPatientNumber);
        panelCenter.add(txtPatientNumber);
        panelCenter.add(taCheck);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        PatientsDisplayFrame.add(panelNorth, BorderLayout.NORTH);
        PatientsDisplayFrame.add(panelSouth, BorderLayout.SOUTH);
        PatientsDisplayFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        PatientsDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PatientsDisplayFrame.pack();
        PatientsDisplayFrame.setSize(350, 350);
        PatientsDisplayFrame.setLocationRelativeTo(null);
        PatientsDisplayFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display")){
            PatientHttp patientHttp = new PatientHttp();
            String patientNumber = txtPatientNumber.getText();
            taCheck.append(patientHttp.check(patientNumber));
        }

        if(e.getActionCommand().equals("Clear")){
            taCheck.setText("");
            txtPatientNumber.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            PatientsDisplayFrame.dispose();
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.setGUI();
        }
    }
}
