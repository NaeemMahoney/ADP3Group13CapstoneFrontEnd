package za.ac.cput.gui.item;

//Na'eem Mahoney
//218190751
//ADP3
//Group 13
//Capstone - Front-End
//DeleteItemGui

//Imports
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.medication.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteItemGUI implements ActionListener {
    //Initializing Components
    Item item;
    private JFrame ItemFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading, lblID;
    private JTextField txtItemID;
    private JButton btnDelete, btnExit, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;

    //Setting Up GUI Components
    public DeleteItemGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        ItemFrame = new JFrame("Item: ");
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
        lblHeading = new JLabel("4. Delete an Item", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter Item ID:");

        //TextFields
        txtItemID = new JTextField();

        //Fillers:
        Filler1 = new JLabel("===========");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2 = new JLabel("===========");
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3 = new JLabel("================================");
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4 = new JLabel("================================");
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5 = new JLabel("================================");
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Buttons:
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(3, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(3, 1));
        panelCenter.setLayout(new GridLayout(3, 1));
        panelEast.setLayout(new GridLayout(3, 1));

        //Adding the components to the panels:
        //Panel North:
        panelNorth.add(Filler5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(Filler1);

        //Panel Center:
        panelCenter.add(lblID);
        panelCenter.add(txtItemID);
        panelCenter.add(Filler4);

        //Panel East
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(btnDelete);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        ItemFrame.add(panelNorth, BorderLayout.NORTH);
        ItemFrame.add(panelSouth, BorderLayout.SOUTH);
        ItemFrame.add(panelEast, BorderLayout.EAST);
        ItemFrame.add(panelCenter, BorderLayout.CENTER);
        ItemFrame.add(panelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        ItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ItemFrame.pack();
        ItemFrame.setSize(400, 200);
        ItemFrame.setLocationRelativeTo(null);
        ItemFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){

            //Store textfield text in string
            String id = txtItemID.getText();
            httpmethods httpmethods = new httpmethods();

            //Use String as parameter in http method
            httpmethods.deleteItem(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Item Deleted");
            txtItemID.setText("");
        }

        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtItemID.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Exit")){
            ItemFrame.dispose();
        }
    }

    }


