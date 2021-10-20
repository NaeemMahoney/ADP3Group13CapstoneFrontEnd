package za.ac.cput.gui.prescription;


import za.ac.cput.entity.medication.Prescription;
import za.ac.cput.factory.medication.PrescriptionFactory;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddprescriptionGui implements ActionListener {
    private JFrame appFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JLabel lblPrescriptionID, lblName, lblPatientNumber, lblBill, lblDosage;
    private JTextField txtPrescriptionID, txtName, txtPatientNumber, txtBill, txtDosage;
    private JLabel color1, color2, color3, color4, color5;
    private JButton btnSave, btnClear, btnExit;
    private JLabel fil1, fil2, fil3, fil4, fil5;
    private Font headingFont;

    public AddprescriptionGui(){
        appFrame = new JFrame("Add Prescriptions");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(Color.CYAN);
        panelEast.setBackground(Color.CYAN);
        panelSouth.setBackground(Color.WHITE);
        panelWest.setBackground(Color.WHITE);
        panelCenter.setBackground(Color.WHITE);

        headingFont = new Font("Calibri", Font.BOLD, 20);
        lblHeading = new JLabel("Add Prescription",  JLabel.CENTER);

        //prescription attributes
        lblPrescriptionID = new JLabel("Prescription ID");
        txtPrescriptionID = new JTextField("auto-generated");

        lblName = new JLabel("Name");
        txtName = new JTextField();
        lblPatientNumber = new JLabel("PatientNumber");
        txtPatientNumber = new JTextField();

        lblBill = new JLabel("Bill");
        txtBill = new JTextField();

        lblDosage = new JLabel("Dosage");
        txtDosage = new JTextField();


        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

    }

    public void setGUI(){
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(8, 1));

        panelNorth.add(lblHeading);
        lblHeading.setFont(headingFont);

        panelCenter.add(lblPrescriptionID);
        panelCenter.add(txtPrescriptionID);

        panelCenter.add(lblName);
        panelCenter.add(txtName);

        panelCenter.add(lblPatientNumber);
        panelCenter.add(txtPatientNumber);

        panelCenter.add(lblBill);
        panelCenter.add(txtBill);

        panelCenter.add(lblDosage);
        panelCenter.add(txtDosage);


        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        appFrame.add(panelNorth, BorderLayout.NORTH);
        appFrame.add(panelCenter, BorderLayout.CENTER);
        appFrame.add(panelEast, BorderLayout.EAST);
        appFrame.add(panelWest, BorderLayout.WEST);
        appFrame.add(panelSouth, BorderLayout.SOUTH);

        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        appFrame.pack();
        appFrame.setSize(450, 450);
        appFrame.setLocationRelativeTo(null);
        appFrame.setVisible(true);

    }


       public void actionPerformed(ActionEvent e) {
           if(e.getActionCommand().equals("Save")){

                 String name = txtName.getText();
                 String patientNumber = txtPatientNumber.getText();
                 String bill = txtBill.getText();
                 String dosage = txtDosage.getText();
                  String ID = txtPrescriptionID.getText();

                 Prescription prescription = PrescriptionFactory.buildPrescription("rati","pan23","12","17");

           }

           if(e.getActionCommand().equals("Clear")){
               txtPrescriptionID.setText("");
               txtName.setText("");
               txtPatientNumber.setText("");
             txtBill.setText("");
              txtDosage.setText("");

            }
           if(e.getActionCommand().equals("Exit")){
                   appFrame.dispose();
                 }


       }
}

