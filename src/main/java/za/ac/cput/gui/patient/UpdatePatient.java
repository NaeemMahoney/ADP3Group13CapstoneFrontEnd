package za.ac.cput.gui.patient;

import za.ac.cput.entity.person.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePatient implements ActionListener {
    private JFrame UpdatePatientFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblPatientName, lblPatientLastName,lblContactNumber, lblAddressNumber, lblPatientNumber;
    private JTextField txtPatientName, txtPatientLastName,txtContactNumber, txtAddressNumber, txtPatientNumber;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont;

    public UpdatePatient(){

        headingFont = new Font("Arial", Font.BOLD, 18);

        UpdatePatientFrame = new JFrame("Patient: ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(Color.LIGHT_GRAY);
        panelSouth.setBackground(Color.LIGHT_GRAY);
        panelCenter.setBackground(Color.LIGHT_GRAY);

        lblHeading = new JLabel("New Patient Registry",JLabel.CENTER);


        lblPatientName = new JLabel("Name:");
        lblPatientLastName = new JLabel("Last Name:");
        lblContactNumber = new JLabel("Cell Number:");
        lblAddressNumber = new JLabel("Address number:");

        txtPatientName = new JTextField();
        txtPatientLastName = new JTextField();
        txtContactNumber = new JTextField();
        txtAddressNumber = new JTextField();


        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelCenter.setLayout(new GridLayout(5, 2));

        panelNorth.add(lblHeading);

        panelCenter.add(lblPatientName);
        panelCenter.add(txtPatientName);
        panelCenter.add(lblPatientLastName);
        panelCenter.add(txtPatientLastName);
        panelCenter.add(lblContactNumber);
        panelCenter.add(txtContactNumber);
        panelCenter.add(lblAddressNumber);
        panelCenter.add(txtAddressNumber);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        lblHeading.setFont(headingFont);

        UpdatePatientFrame.add(panelNorth, BorderLayout.NORTH);
        UpdatePatientFrame.add(panelSouth, BorderLayout.SOUTH);
        UpdatePatientFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        UpdatePatientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdatePatientFrame.pack();
        UpdatePatientFrame.setSize(350, 350);
        UpdatePatientFrame.setLocationRelativeTo(null);
        UpdatePatientFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Save")){

            String name = txtPatientName.getText();
            String lastname = txtPatientLastName.getText();
            String cell = txtContactNumber.getText();
            String addressNumber = txtAddressNumber.getText();

            Patient patient = new Patient.Builder().build();

            PatientHttp patientHttp = new PatientHttp();

            patientHttp.Update(patient,name,lastname,cell,addressNumber);


        }

        if(e.getActionCommand().equals("Clear")){

            txtPatientName.setText("");
            txtPatientLastName.setText("");
            txtContactNumber.setText("");
            txtAddressNumber.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            UpdatePatientFrame.dispose();
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.setGUI();
        }
    }
}
