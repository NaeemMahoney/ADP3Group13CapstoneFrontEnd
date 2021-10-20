package za.ac.cput.gui.appointment;
/* AppointmentMenuGUI.java
   Appointment menu gui class
   Author: Nolusindiso Makosa (219023557)
   Due Date: 20 October 2021
*/

import za.ac.cput.gui.item.AddItemGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentMenuGUI implements ActionListener {
    private JFrame frame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAdd, btnUpdate, btnRead, btnGetAll, btnCancel, btnExit;
    private JLabel fil1, fil2, fil3, fil4, fil5;
    private Font headingFont;
    Color btnColor = Color.WHITE;

    public AppointmentMenuGUI() {
        frame = new JFrame("Add Appointments");
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

        lblHeading = new JLabel("APPOINTMENTS", JLabel.CENTER);

        btnAdd = new JButton("Create Appointment");
        btnAdd.setBackground(btnColor);
        btnUpdate = new JButton("Update Appointment");
        btnUpdate.setBackground(btnColor);
        btnRead = new JButton("Read Appointment");
        btnRead.setBackground(btnColor);
        btnGetAll = new JButton("Get All Appointments");
        btnGetAll.setBackground(btnColor);
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(btnColor);
//        btnExit = new JButton("Exit");
//        btnExit.setBackground(btnColor);

        fil1 = new JLabel("=====");
        fil1.setForeground(Color.WHITE);
        fil2 = new JLabel("=====");
        fil2.setForeground(Color.WHITE);
        fil3 = new JLabel("===================================");
        fil3.setForeground(Color.WHITE);
        fil4 = new JLabel("===================================");
        fil4.setForeground(Color.WHITE);
        fil5 = new JLabel("===================================");
        fil5.setForeground(Color.WHITE);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(7, 1));

//        panelEast.setPreferredSize(new Dimension(200, 50));
//        panelWest.setPreferredSize(new Dimension(200, 50));

        panelNorth.add(fil5);
        panelNorth.add(lblHeading);
        lblHeading.setFont(headingFont);

        panelWest.add(fil1);
        panelEast.add(fil2);

        panelCenter.add(fil3);
        panelCenter.add(btnAdd);
        panelCenter.add(btnRead);
        panelCenter.add(btnUpdate);
        panelCenter.add(btnGetAll);
        panelCenter.add(fil4);

        panelSouth.add(btnCancel);
        //panelSouth.add(btnExit);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelEast, BorderLayout.EAST);
        frame.add(panelWest, BorderLayout.WEST);
        frame.add(panelSouth, BorderLayout.SOUTH);

        //action listeners for buttons
        btnAdd.addActionListener(this);
        btnRead.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnGetAll.addActionListener(this);
        btnCancel.addActionListener(this);
        //btnExit.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Create Appointment")) {
            AddAppointmentGUI addAppointmentGUI = new AddAppointmentGUI();
            addAppointmentGUI.setGUI();
        }

        if (ae.getActionCommand().equals("Cancel")) {
            frame.dispose();
        }
    }

}
