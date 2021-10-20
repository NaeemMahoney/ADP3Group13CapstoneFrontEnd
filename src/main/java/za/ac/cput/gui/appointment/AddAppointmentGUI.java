package za.ac.cput.gui.appointment;

import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAppointmentGUI implements ActionListener {
    private JFrame appFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JLabel lblDate, lblTime, lblReason, lblAppointmentID;
    private JTextField txtDate, txtTime, txtReason, txtAppointmentID;
    private JButton btnSave, btnClear, btnExit;
    private JLabel fil1, fil2, fil3, fil4, fil5;
    private Font headingFont;

    public AddAppointmentGUI(){
        appFrame = new JFrame("Add Appointments");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(Color.WHITE);
        panelEast.setBackground(Color.WHITE);
        panelSouth.setBackground(Color.WHITE);
        panelWest.setBackground(Color.WHITE);
        panelCenter.setBackground(Color.WHITE);

        headingFont = new Font("Calibri", Font.BOLD, 20);
        lblHeading = new JLabel("Add Appointments",  JLabel.CENTER);

        lblAppointmentID = new JLabel("Appointment ID: ");
        lblDate = new JLabel("Date: ");
        lblTime = new JLabel("Time: ");
        lblReason = new JLabel(" Reason: ");
        txtAppointmentID = new JTextField("auto-generated");
        txtDate = new JTextField();
        txtTime = new JTextField();
        txtReason = new JTextField();

        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

    }

    public void setGUI(){
        panelNorth.setLayout(new GridLayout(1, 1));
        panelEast.setLayout(new GridLayout(4, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(4, 1));
        panelCenter.setLayout(new GridLayout(8, 1));

        panelNorth.add(lblHeading);
        lblHeading.setFont(headingFont);

        panelCenter.add(lblAppointmentID);
        panelCenter.add(txtAppointmentID);
        panelCenter.add(lblDate);
        panelCenter.add(txtDate);
        panelCenter.add(lblTime);
        panelCenter.add(txtTime);
        panelCenter.add(lblReason);
        panelCenter.add(txtReason);

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

            String date = txtDate.getText();
            String time = txtTime.getText();
            String reason = txtReason.getText();
            String id = txtAppointmentID.getText();

        }

        if(e.getActionCommand().equals("Clear")){
            txtAppointmentID.setText("");
            txtDate.setText("");
            txtTime.setText("");
            txtReason.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            appFrame.dispose();
        }
    }

}
