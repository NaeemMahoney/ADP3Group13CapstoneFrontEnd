package za.ac.cput.gui.item;

//Na'eem Mahoney
//218190751
//ADP3
//Group 13
//Capstone - Front-End
//UpdateItemGui

//Imports
import za.ac.cput.entity.medication.Item;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateItemGUI implements ActionListener {
    //Initializing Components
    private JFrame UpdateItemFrame;
    private JPanel UpdateItemPanelNorth, UpdateItemPanelSouth, UpdateItemPanelEast, UpdateItemPanelWest, UpdateItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblItemName, lblItemType, lblItemPrice, lblItemStock, lblItemID;
    private JTextField txtItemName, txtItemType,txtItemPrice, txtItemStock, txtItemID;
    private JButton btnUpdate, btnExit, btnClear, btnGet;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Item item;

    public UpdateItemGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        UpdateItemFrame = new JFrame("Item: ");
        UpdateItemPanelNorth = new JPanel();
        UpdateItemPanelSouth = new JPanel();
        UpdateItemPanelEast = new JPanel();
        UpdateItemPanelWest = new JPanel();
        UpdateItemPanelCenter = new JPanel();
        UpdateItemPanelNorth.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelEast.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelSouth.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelWest.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("3. Update Item",JLabel.CENTER);

        //Labels
        lblItemID = new JLabel("ID");
        lblItemName = new JLabel("Name:");
        lblItemPrice = new JLabel("Price:");
        lblItemType = new JLabel("Type:");
        lblItemStock = new JLabel("Stock:");

        //TextFields
        txtItemID = new JTextField();
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
        btnUpdate = new JButton("Update");
        btnGet = new JButton("Get Info");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grid Layout
        UpdateItemPanelNorth.setLayout(new GridLayout(2, 1));
        UpdateItemPanelEast.setLayout(new GridLayout(8, 1));
        UpdateItemPanelSouth.setLayout(new GridLayout(1, 4));
        UpdateItemPanelWest.setLayout(new GridLayout(8, 1));
        UpdateItemPanelCenter.setLayout(new GridLayout(11, 1));
        UpdateItemPanelEast.setLayout(new GridLayout(8, 1));

        //Adding the components to the panels:
        //Panel North:
        UpdateItemPanelNorth.add(Filler5);
        UpdateItemPanelNorth.add(lblHeading);

        //Panel West:
        UpdateItemPanelWest.add(Filler1);

        //Panel Center:
        UpdateItemPanelCenter.add(lblItemID);
        UpdateItemPanelCenter.add(txtItemID);
        UpdateItemPanelCenter.add(lblItemName);
        UpdateItemPanelCenter.add(txtItemName);
        UpdateItemPanelCenter.add(lblItemType);
        UpdateItemPanelCenter.add(txtItemType);
        UpdateItemPanelCenter.add(lblItemPrice);
        UpdateItemPanelCenter.add(txtItemPrice);
        UpdateItemPanelCenter.add(lblItemStock);
        UpdateItemPanelCenter.add(txtItemStock);
        UpdateItemPanelCenter.add(Filler4);

        //Panel East
        UpdateItemPanelEast.add(Filler2);

        //Panel South:
        UpdateItemPanelSouth.add(btnGet);
        UpdateItemPanelSouth.add(btnUpdate);
        UpdateItemPanelSouth.add(btnClear);
        UpdateItemPanelSouth.add(btnExit);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        UpdateItemFrame.add(UpdateItemPanelNorth, BorderLayout.NORTH);
        UpdateItemFrame.add(UpdateItemPanelSouth, BorderLayout.SOUTH);
        UpdateItemFrame.add(UpdateItemPanelEast, BorderLayout.EAST);
        UpdateItemFrame.add(UpdateItemPanelCenter, BorderLayout.CENTER);
        UpdateItemFrame.add(UpdateItemPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnGet.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        UpdateItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateItemFrame.pack();
        UpdateItemFrame.setSize(450, 450);
        UpdateItemFrame.setLocationRelativeTo(null);
        UpdateItemFrame.setVisible(true);
    }

    //When Update Button is clicked
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Update")){
            httpmethods httpmethods = new httpmethods();

            //Store textfield text in string
            String itemID = txtItemID.getText();
            String itemName = txtItemName.getText();
            String itemType = txtItemType.getText();
            String itemPrice = txtItemPrice.getText();
            String itemStock = txtItemStock.getText();

            //Read method
            Item it = httpmethods.findItem(itemID);

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

            //If all are valid then call update httpmethod
            if(nameCheck && typecheck && priceCheck && stockCheck){
                double ditemPrice = Double.parseDouble(itemPrice);
                double ditemStock = Double.parseDouble(itemStock);
                item = new Item.Builder().copy(it).itemName(itemName).itemType(itemType).itemPrice(ditemPrice).itemStock(ditemStock).builder();
                httpmethods.updateItem(item);
                txtItemName.setText("");
                txtItemType.setText("");
                txtItemPrice.setText("");
                txtItemStock.setText("");
                JOptionPane.showMessageDialog(null, "Item Updated");
            }


        }

        //When Get Info Button is clicked
        if(e.getActionCommand().equals("Get Info")){
            boolean idCheck;

            //Use read method of readitemgui
            String id = txtItemID.getText();
            httpmethods httpmethods = new httpmethods();
            Item it = httpmethods.findItem(id);
            txtItemName.setText(it.getItemName());
            txtItemType.setText(it.getItemType());

            //Doubles are stored in string without decimals
            String price = String.valueOf(it.getItemPrice()).split("\\.")[0];;
            String stock = String.valueOf(it.getItemStock()).split("\\.")[0];
            txtItemPrice.setText(price);
            txtItemStock.setText(stock);
        }

        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtItemID.setText("");
            txtItemName.setText("");
            txtItemType.setText("");
            txtItemPrice.setText("");
            txtItemStock.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Exit")){
            UpdateItemFrame.dispose();
        }
    }
}
