package za.ac.cput.gui.prescription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PrescriptionMenuGui implements ActionListener {
    private JFrame frame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAdd, btnUpdate, btnRead, btnGetAll, btnCancel, btnExit;
    private JLabel fil1, fil2, fil3, fil4, fil5;
    private Font headingFont;
    Color btnColor = Color.LIGHT_GRAY;

    public PrescriptionMenuGui() {
        frame = new JFrame("Add Prescriptions");
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

        headingFont = new Font("Arial", Font.BOLD, 20);

        lblHeading = new JLabel("Prescription", JLabel.CENTER);

        btnAdd = new JButton("Create Prescription");
        btnAdd.setBackground(btnColor);
        btnUpdate = new JButton("Update Prescription ");
        btnUpdate.setBackground(btnColor);
        btnRead = new JButton("Read Prescription");
        btnRead.setBackground(btnColor);
        btnGetAll = new JButton("Get All Prescriptions");
        btnGetAll.setBackground(btnColor);
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(btnColor);

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
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Create Prescription")) {
            AddprescriptionGui addprescriptionGui = new AddprescriptionGui();
            addprescriptionGui.setGUI();
        }

        if (ae.getActionCommand().equals("Cancel")) {
            frame.dispose();
        }
    }

}