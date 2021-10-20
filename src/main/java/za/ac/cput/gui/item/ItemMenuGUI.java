package za.ac.cput.gui.item;

//Na'eem Mahoney
//218190751
//Group13
//Capstone
//Front End
//ItemMenuGui

//Imports
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;


public class ItemMenuGUI implements ActionListener{
    //Initializing Components
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAddItem, btnDeleteItem, btnCheckItem, btnUpdateItem, btnGetAllItems, btnExit;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Color btnColor = Color.WHITE;

    //Setting Up GUI Components
    public ItemMenuGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        MenuFrame = new JFrame("Item: ");
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
        lblHeading = new JLabel("Item Menu",JLabel.CENTER);

        //Fillers:
        Filler1 = new JLabel("=====");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2 = new JLabel("=====");
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3 = new JLabel("================================");
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4 = new JLabel("================================");
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5 = new JLabel("================================");
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Buttons:
        btnAddItem = new JButton("Add New Item");
        btnAddItem.setBackground(btnColor);
        btnCheckItem = new JButton("Check Item");
        btnCheckItem.setBackground(btnColor);
        btnUpdateItem = new JButton("Update Item");
        btnUpdateItem.setBackground(btnColor);
        btnDeleteItem = new JButton("Delete Item");
        btnDeleteItem.setBackground(btnColor);
        btnGetAllItems = new JButton("Display All Items");
        btnGetAllItems.setBackground(btnColor);
        btnExit = new JButton("Exit");
        btnExit.setBackground(btnColor);
    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(7, 1));

        //Adding the components to the panels:
        //Panel North:
        panelNorth.add(Filler5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(Filler1);

        //Panel Center:
        panelCenter.add(Filler3);
        panelCenter.add(btnAddItem);
        panelCenter.add(btnCheckItem);
        panelCenter.add(btnUpdateItem);
        panelCenter.add(btnDeleteItem);
        panelCenter.add(btnGetAllItems);
        panelCenter.add(Filler4);

        //Panel East
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(btnExit);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Customer Frame:
        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnAddItem.addActionListener(this);
        btnCheckItem.addActionListener(this);
        btnUpdateItem.addActionListener(this);
        btnDeleteItem.addActionListener(this);
        btnGetAllItems.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(350, 350);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        //When Add New Item Button is clicked
        if(e.getActionCommand().equals("Add New Item")){
            //Call AddItemGui
            AddItemGUI addItemGUI = new AddItemGUI();
            addItemGUI.setGUI();
        }

        //When Check Item Button is clicked
        if(e.getActionCommand().equals("Check Item")){
            //Call CheckItemGui
            ReadItemGUI readItemGUI = new ReadItemGUI();
            readItemGUI.setGUI();
        }

        //When Update Item Button is clicked
        if(e.getActionCommand().equals("Update Item")){
            //Call UpdateItemGui
            UpdateItemGUI updateItemGUI = new UpdateItemGUI();
            updateItemGUI.setGUI();
        }

        //When Delete Item Button is clicked
        if(e.getActionCommand().equals("Delete Item")){
            //Call DeleteItemGui
            DeleteItemGUI deleteItemGUI = new DeleteItemGUI();
            deleteItemGUI.setGUI();
        }

        if(e.getActionCommand().equals("Display All Items")){
            GetAllItemsGui getAllItemsGui = new GetAllItemsGui();
            getAllItemsGui.setGUI();
        }

        if(e.getActionCommand().equals("Exit")){
            MenuFrame.dispose();
        }
    }

}
