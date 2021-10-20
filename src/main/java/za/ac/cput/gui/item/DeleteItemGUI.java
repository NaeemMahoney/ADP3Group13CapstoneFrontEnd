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
    private JFrame DeleteItemFrame;
    private JPanel DeleteItemPanelNorth, DeleteItemPanelSouth, DeleteItemPanelEast, DeleteItemPanelWest, DeleteItemPanelCenter;
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
        DeleteItemFrame = new JFrame("Item: ");
        DeleteItemPanelNorth = new JPanel();
        DeleteItemPanelSouth = new JPanel();
        DeleteItemPanelEast = new JPanel();
        DeleteItemPanelWest = new JPanel();
        DeleteItemPanelCenter = new JPanel();
        DeleteItemPanelNorth.setBackground(Color.LIGHT_GRAY);
        DeleteItemPanelEast.setBackground(Color.LIGHT_GRAY);
        DeleteItemPanelSouth.setBackground(Color.LIGHT_GRAY);
        DeleteItemPanelWest.setBackground(Color.LIGHT_GRAY);
        DeleteItemPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("4. Delete an Item", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter Item ID:");

        //TextFields
        txtItemID = new JTextField();

        //Fillers:
        Filler1 = new JLabel("===========");
        Filler2 = new JLabel("===========");
        Filler3 = new JLabel("================================");
        Filler4 = new JLabel("================================");
        Filler5 = new JLabel("================================");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Buttons:
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        DeleteItemPanelNorth.setLayout(new GridLayout(2, 1));
        DeleteItemPanelEast.setLayout(new GridLayout(3, 1));
        DeleteItemPanelSouth.setLayout(new GridLayout(1, 3));
        DeleteItemPanelWest.setLayout(new GridLayout(3, 1));
        DeleteItemPanelCenter.setLayout(new GridLayout(3, 1));
        DeleteItemPanelEast.setLayout(new GridLayout(3, 1));

        //Adding the components to the panels:
        //Panel North:
        DeleteItemPanelNorth.add(Filler5);
        DeleteItemPanelNorth.add(lblHeading);

        //Panel West:
        DeleteItemPanelWest.add(Filler1);

        //Panel Center:
        DeleteItemPanelCenter.add(lblID);
        DeleteItemPanelCenter.add(txtItemID);
        DeleteItemPanelCenter.add(Filler4);

        //Panel East
        DeleteItemPanelEast.add(Filler2);

        //Panel South:
        DeleteItemPanelSouth.add(btnDelete);
        DeleteItemPanelSouth.add(btnClear);
        DeleteItemPanelSouth.add(btnExit);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        DeleteItemFrame.add(DeleteItemPanelNorth, BorderLayout.NORTH);
        DeleteItemFrame.add(DeleteItemPanelSouth, BorderLayout.SOUTH);
        DeleteItemFrame.add(DeleteItemPanelEast, BorderLayout.EAST);
        DeleteItemFrame.add(DeleteItemPanelCenter, BorderLayout.CENTER);
        DeleteItemFrame.add(DeleteItemPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        DeleteItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteItemFrame.pack();
        DeleteItemFrame.setSize(400, 200);
        DeleteItemFrame.setLocationRelativeTo(null);
        DeleteItemFrame.setVisible(true);

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
            DeleteItemFrame.dispose();
        }
    }

    }


