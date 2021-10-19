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
    private JFrame ItemFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
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
        btnUpdate = new JButton("Update");
        btnGet = new JButton("Get Info");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grid Layout
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(8, 1));
        panelSouth.setLayout(new GridLayout(1, 4));
        panelWest.setLayout(new GridLayout(8, 1));
        panelCenter.setLayout(new GridLayout(11, 1));
        panelEast.setLayout(new GridLayout(8, 1));

        //Adding the components to the panels:
        //Panel North:
        panelNorth.add(Filler5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(Filler1);

        //Panel Center:
        panelCenter.add(lblItemID);
        panelCenter.add(txtItemID);
        panelCenter.add(lblItemName);
        panelCenter.add(txtItemName);
        panelCenter.add(lblItemType);
        panelCenter.add(txtItemType);
        panelCenter.add(lblItemPrice);
        panelCenter.add(txtItemPrice);
        panelCenter.add(lblItemStock);
        panelCenter.add(txtItemStock);
        panelCenter.add(Filler4);

        //Panel East
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(btnGet);
        panelSouth.add(btnUpdate);
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
        btnGet.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        ItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ItemFrame.pack();
        ItemFrame.setSize(450, 450);
        ItemFrame.setLocationRelativeTo(null);
        ItemFrame.setVisible(true);
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
            ItemFrame.dispose();
        }
    }
}
