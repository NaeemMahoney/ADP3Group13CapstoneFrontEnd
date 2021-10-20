package za.ac.cput.gui.item;

//Na'eem Mahoney
//218190751
//ADP3
//Group 13
//Capstone - Front-End
//GetAllItemsGui

//Imports
import java.awt.*;
import java.awt.event.*;
import java.util.Set;
import javax.swing.*;

import za.ac.cput.entity.medication.Item;
import za.ac.cput.util.GenericHelper;

public class GetAllItemsGui implements ActionListener{
    //Initializing Components
    private JFrame GetAllFrame;
    private JPanel GetAllPanelNorth, GetAllPanelEast, GetAllPanelWest, GetAllPanelSouth, GetAllPanelCenter;
    private JTextArea ItemTextArea;
    private JLabel lblHeading;
    private JButton btnGetall, btnClear, btnExit;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont, textAreaFont;
    private JScrollPane scrollPane;

    public GetAllItemsGui(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        GetAllFrame = new JFrame("Item:");

        //Panels
        GetAllPanelSouth = new JPanel();
        GetAllPanelNorth = new JPanel();
        GetAllPanelNorth.setBackground(Color.LIGHT_GRAY);
        GetAllPanelCenter = new JPanel();
        GetAllPanelCenter.setBackground(Color.LIGHT_GRAY);

        //TextArea
        ItemTextArea = new JTextArea(50, 40);
        ItemTextArea.setBackground(Color.white);
        ItemTextArea.setLineWrap(true);
        ItemTextArea.setWrapStyleWord(true);


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

        //Heading
        lblHeading = new JLabel("4. Display all Items",JLabel.CENTER);

        //Buttons
        btnGetall = new JButton("Display All Items");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

    }

    //Setting GUI Layout
    public void setGUI() {
        GetAllPanelNorth.setLayout(new GridLayout(3, 1));

        //Adding the components to the panels:
        //Panel North:
        GetAllPanelNorth.add(Filler5);
        GetAllPanelNorth.add(lblHeading);
        GetAllPanelNorth.add(btnGetall);

        //Panel Center
        GetAllPanelCenter.add(ItemTextArea);

        //Panel South
        GetAllPanelSouth.add(btnClear);
        GetAllPanelSouth.add(btnExit);

        //Adding panels to Customer Frame:
        GetAllFrame.add(GetAllPanelSouth, BorderLayout.SOUTH);
        GetAllFrame.add(GetAllPanelNorth, BorderLayout.NORTH);
        GetAllFrame.add(GetAllPanelCenter, BorderLayout.CENTER);

        //Telling compiler to listen for actions from the buttons:
        btnGetall.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        GetAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GetAllFrame.pack();
        GetAllFrame.setSize(400, 400);
        GetAllFrame.setLocationRelativeTo(null);
        GetAllFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        //When Display all button is clicked
        if(e.getActionCommand().equals("Display All Items")){

            httpmethods httpmethods = new httpmethods();

            //Create set to store method output
            Set<Item> items = httpmethods.getItems();

            //Display set in text area
            ItemTextArea.setText(String.valueOf(items));
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            ItemTextArea.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Exit")){
            GetAllFrame.dispose();
        }
    }
}
