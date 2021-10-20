package za.ac.cput.gui.patient;

import za.ac.cput.entity.person.Patient;
import za.ac.cput.factory.person.PatientFactory;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatient implements ActionListener {
    private JFrame AddPatientFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private JLabel lblPatientName, lblPatientLastName,lblContactNumber, lblAddressNumber, lblPatientNumber;
    private JTextField txtPatientName, txtPatientLastName,txtContactNumber, txtAddressNumber, txtPatientNumber;
    private JButton btnSave, btnExit, btnClear;
    private Font headingFont;

    public AddPatient(){

        headingFont = new Font("Arial", Font.BOLD, 18);

        AddPatientFrame = new JFrame("Patient: ");
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

        AddPatientFrame.add(panelNorth, BorderLayout.NORTH);
        AddPatientFrame.add(panelSouth, BorderLayout.SOUTH);
        AddPatientFrame.add(panelCenter, BorderLayout.CENTER);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        AddPatientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddPatientFrame.pack();
        AddPatientFrame.setSize(350, 350);
        AddPatientFrame.setLocationRelativeTo(null);
        AddPatientFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Save")){

            String name = txtPatientName.getText();
            String lastname = txtPatientLastName.getText();
            String cell = txtContactNumber.getText();
            String addressNumber = txtAddressNumber.getText();



            PatientHttp patientHttp = new PatientHttp();

            patientHttp.save(name,lastname,cell,addressNumber);


        }

        if(e.getActionCommand().equals("Clear")){

            txtPatientName.setText("");
            txtPatientLastName.setText("");
            txtContactNumber.setText("");
            txtAddressNumber.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            AddPatientFrame.dispose();
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.setGUI();
        }
    }
}
