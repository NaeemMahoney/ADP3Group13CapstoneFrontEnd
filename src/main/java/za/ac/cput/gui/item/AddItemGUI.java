package za.ac.cput.gui.item;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.medication.Item;
import za.ac.cput.factory.medication.ItemFactory;
import za.ac.cput.util.GenericHelper;

public class AddItemGUI implements ActionListener{
    private JFrame ItemFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JLabel lblItemName, lblItemType, lblItemPrice, lblItemStock, lbItemID;
    private JTextField txtItemName, txtItemType,txtItemPrice, txtItemStock, txtItemID;
    private JButton btnSave, btnExit, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;

    public AddItemGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

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
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(8, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(8, 1));
        panelCenter.setLayout(new GridLayout(9, 1));
        panelEast.setLayout(new GridLayout(8, 1));

        //Adding the components to the panels:
        //Panel North:
        panelNorth.add(Filler5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(Filler1);

        //Panel Center:
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
        panelSouth.add(btnSave);
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
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        ItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ItemFrame.pack();
        ItemFrame.setSize(400, 400);
        ItemFrame.setLocationRelativeTo(null);
        ItemFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Save")){

            String itemName = txtItemName.getText();
            String itemType = txtItemType.getText();
            String itemPrice = txtItemPrice.getText();
            String itemStock = txtItemStock.getText();

            boolean priceCheck, stockCheck, typecheck;

            if(itemType==null || !itemType.matches("[a-zA-Z]+")){
                typecheck = false;
                txtItemType.setText("Invalid Type Input");
            }
            else{
                typecheck = true;
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

            if(typecheck && priceCheck && stockCheck){
                double ditemPrice = Double.parseDouble(itemPrice);
                double ditemStock = Double.parseDouble(itemStock);
                httpmethods httpmethods = new httpmethods();
                httpmethods.saveItem(itemName, itemType, ditemPrice, ditemStock);
            }

        }

        if(e.getActionCommand().equals("Clear")){
            txtItemName.setText("");
            txtItemType.setText("");
            txtItemPrice.setText("");
            txtItemStock.setText("");
        }

        if(e.getActionCommand().equals("Exit")){
            ItemFrame.dispose();
        }
    }

}
