package za.ac.cput.gui.patient;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispalyPatients implements ActionListener {
    private JFrame PatientsDisplayFrame;
    private JPanel panelNorth, panelSouth,panelCenter;
    private JLabel lblHeading;
    private TextArea taDisplay;
    private JButton btnDisplay, btnExit, btnClear;
    private Font headingFont;

    public DispalyPatients() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        PatientsDisplayFrame = new JFrame("All Patients: ");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        lblHeading = new JLabel("Patients Are As Follows:",JLabel.CENTER);

        taDisplay = new TextArea("PatientNumber\tName\tSurname\tContact Number\tAddressNumber\n");

        btnDisplay = new JButton("Display");
        btnExit = new JButton("Exit");
        btnClear = new JButton("Clear");
    }
    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(1,1));
        panelSouth.setLayout(new GridLayout(1, 3));

        panelNorth.add(lblHeading);

        panelCenter.add(taDisplay);

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
        PatientsDisplayFrame.setSize(400, 400);
        PatientsDisplayFrame.setLocationRelativeTo(null);
        PatientsDisplayFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display")){
            PatientHttp patientHttp = new PatientHttp();
            taDisplay.append(patientHttp.getAll());
        }

        if(e.getActionCommand().equals("Clear")){
           taDisplay.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            PatientsDisplayFrame.dispose();
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.setGUI();
        }
    }
}
