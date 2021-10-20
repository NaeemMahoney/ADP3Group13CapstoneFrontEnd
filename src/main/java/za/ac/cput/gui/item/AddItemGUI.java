package za.ac.cput.gui.item;

//Na'eem Mahoney
//218190751
//ADP3
//Group 13
//Capstone - Front-End
//AddItemGui
//Imports

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import za.ac.cput.util.GenericHelper;

public class AddItemGUI implements ActionListener{
    //Initializing Components
    private JFrame AddItemFrame;
    private JPanel AddItemPanelNorth, AddItemPanelSouth, AddItemPanelEast, AddItemPanelWest, AddItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblItemName, lblItemType, lblItemPrice, lblItemStock, lbItemID;
    private JTextField txtItemName, txtItemType,txtItemPrice, txtItemStock, txtItemID;
    private JButton btnSave, btnExit, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;

    //Setting Up GUI Components
    public AddItemGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        AddItemFrame = new JFrame("Item: ");
        AddItemPanelNorth = new JPanel();
        AddItemPanelSouth = new JPanel();
        AddItemPanelEast = new JPanel();
        AddItemPanelWest = new JPanel();
        AddItemPanelCenter = new JPanel();
        AddItemPanelNorth.setBackground(Color.LIGHT_GRAY);
        AddItemPanelEast.setBackground(Color.LIGHT_GRAY);
        AddItemPanelSouth.setBackground(Color.LIGHT_GRAY);
        AddItemPanelWest.setBackground(Color.LIGHT_GRAY);
        AddItemPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("1. Add New Item",JLabel.CENTER);

        //Labels
        lblItemName = new JLabel("Name:");
        lblItemPrice = new JLabel("Price:");
        lblItemType = new JLabel("Type:");
        lblItemStock = new JLabel("Stock:");

        //TextFields
        txtItemName = new JTextField();
        txtItemPrice = new JTextField();
        txtItemType = new JTextField();
        txtItemStock = new JTextField();

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
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        AddItemPanelNorth.setLayout(new GridLayout(2, 1));
        AddItemPanelEast.setLayout(new GridLayout(8, 1));
        AddItemPanelSouth.setLayout(new GridLayout(1, 3));
        AddItemPanelWest.setLayout(new GridLayout(8, 1));
        AddItemPanelCenter.setLayout(new GridLayout(9, 1));
        AddItemPanelEast.setLayout(new GridLayout(8, 1));

        //Adding the components to the panels:
        //Panel North:
        AddItemPanelNorth.add(Filler5);
        AddItemPanelNorth.add(lblHeading);

        //Panel West:
        AddItemPanelWest.add(Filler1);

        //Panel Center:
        AddItemPanelCenter.add(lblItemName);
        AddItemPanelCenter.add(txtItemName);
        AddItemPanelCenter.add(lblItemType);
        AddItemPanelCenter.add(txtItemType);
        AddItemPanelCenter.add(lblItemPrice);
        AddItemPanelCenter.add(txtItemPrice);
        AddItemPanelCenter.add(lblItemStock);
        AddItemPanelCenter.add(txtItemStock);
        AddItemPanelCenter.add(Filler4);

        //Panel East
        AddItemPanelEast.add(Filler2);

        //Panel South:
        AddItemPanelSouth.add(btnSave);
        AddItemPanelSouth.add(btnClear);
        AddItemPanelSouth.add(btnExit);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        AddItemFrame.add(AddItemPanelNorth, BorderLayout.NORTH);
        AddItemFrame.add(AddItemPanelSouth, BorderLayout.SOUTH);
        AddItemFrame.add(AddItemPanelEast, BorderLayout.EAST);
        AddItemFrame.add(AddItemPanelCenter, BorderLayout.CENTER);
        AddItemFrame.add(AddItemPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        AddItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddItemFrame.pack();
        AddItemFrame.setSize(400, 400);
        AddItemFrame.setLocationRelativeTo(null);
        AddItemFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //When Save Button is clicked
        if(e.getActionCommand().equals("Save")){

            //Store textfield text in string
            String itemName = txtItemName.getText();
            String itemType = txtItemType.getText();
            String itemPrice = txtItemPrice.getText();
            String itemStock = txtItemStock.getText();

            //booleans for checking valid input
            boolean nameCheck, priceCheck, stockCheck, typecheck;

            if(itemType==null || !itemType.matches("[a-zA-Z]+")){
                typecheck = false;
                txtItemType.setText("Invalid Type Input");
            }
            else{
                typecheck = true;
            }

            if(!itemName.matches("[a-zA-Z0-9]+")){
                nameCheck = false;
                txtItemName.setText("Invalid Name Input");
            }
            else{
                nameCheck = true;
            }

            if(GenericHelper.validNumber(itemPrice)){
                priceCheck = true;
            }
            else{
                priceCheck = false;
                txtItemPrice.setText("Invalid Price Input");
            }

            if(GenericHelper.validNumber(itemStock)){
                stockCheck = true;
            }
            else{
                stockCheck = false;
                txtItemStock.setText("Invalid Stock Input");
            }

            //If all are valid then call save httpmethod
            if(nameCheck && typecheck && priceCheck && stockCheck){
                double ditemPrice = Double.parseDouble(itemPrice);
                double ditemStock = Double.parseDouble(itemStock);
                httpmethods httpmethods = new httpmethods();
                httpmethods.saveItem(itemName, itemType, ditemPrice, ditemStock);
            }

        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtItemName.setText("");
            txtItemType.setText("");
            txtItemPrice.setText("");
            txtItemStock.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Exit")){
            AddItemFrame.dispose();
        }
    }

}
