package za.ac.cput.gui.patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePatient implements ActionListener {
    private JFrame PatientsDeleteFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading, lblPatientNumber;
    private TextField txtPatientNumber;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont;


    public DeletePatient() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        PatientsDeleteFrame = new JFrame("Deleting Patient: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        lblHeading = new JLabel("Deleting",JLabel.CENTER);
        lblPatientNumber = new JLabel("Patient Number:");

        txtPatientNumber = new TextField("");

        btnDisplay = new JButton("Delete");
        btnExit = new JButton("Exit");
        btnClear = new JButton("Clear");
    }
    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(1,2));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblHeading);

        panelCenter.add(lblPatientNumber);
        panelCenter.add(txtPatientNumber);

        panelSouth.add(btnDisplay);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        PatientsDeleteFrame.add(panelNorth, BorderLayout.NORTH);
        PatientsDeleteFrame.add(panelSouth, BorderLayout.SOUTH);
        PatientsDeleteFrame.add(panelCenter, BorderLayout.CENTER);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        PatientsDeleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PatientsDeleteFrame.pack();
        PatientsDeleteFrame.setSize(350, 300);
        PatientsDeleteFrame.setLocationRelativeTo(null);
        PatientsDeleteFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
            PatientHttp patientHttp = new PatientHttp();
            String patientNumber = txtPatientNumber.getText();
            patientHttp.delete(patientNumber);
        }

        if(e.getActionCommand().equals("Clear")){
            txtPatientNumber.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            PatientsDeleteFrame.dispose();
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.setGUI();
        }
    }
}
