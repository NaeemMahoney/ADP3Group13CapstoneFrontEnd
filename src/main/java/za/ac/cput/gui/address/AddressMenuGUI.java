package za.ac.cput.gui.address;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressMenuGUI implements ActionListener
{
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAddAddress, btnDeleteAddress, btnReadAddress, btnUpdateAddress, btnExit;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Color btnColor = Color.WHITE;

    public AddressMenuGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        MenuFrame = new JFrame("Address: ");
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
        lblHeading = new JLabel("Address Menu",JLabel.CENTER);

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
        btnAddAddress = new JButton("Create Address");
        btnAddAddress.setBackground(btnColor);
        btnReadAddress = new JButton("Read Address");
        btnReadAddress.setBackground(btnColor);
        btnUpdateAddress = new JButton("Update Address");
        btnUpdateAddress.setBackground(btnColor);
        btnDeleteAddress = new JButton("Delete Address");
        btnDeleteAddress.setBackground(btnColor);
        btnExit = new JButton("Exit");
        btnExit.setBackground(btnColor);
    }
    public void setGUI() {
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
        panelCenter.add(btnAddAddress);
        panelCenter.add(btnReadAddress);
        panelCenter.add(btnUpdateAddress);
        panelCenter.add(btnDeleteAddress);
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
        btnAddAddress.addActionListener(this);
        btnReadAddress.addActionListener(this);
        btnUpdateAddress.addActionListener(this);
        btnDeleteAddress.addActionListener(this);
        btnExit.addActionListener(this);

        //Set GUI:
        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(350, 350);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent f)
    {
        if(f.getActionCommand().equals("Create Address"))
        {
            CreateAddress createAddressGUI = new CreateAddress();
            createAddressGUI.setGUI();
        }

        if(f.getActionCommand().equals("Read Address"))
        {
            ViewAddress viewAddress = new ViewAddress();
            viewAddress.setGUI();
        }
        if(f.getActionCommand().equals("Update Address"))
        {
            UpdateAddress updateAddress = new UpdateAddress();
            updateAddress.setGUI();
        }
        if(f.getActionCommand().equals("Delete Address"))
        {
            DeleteAddress deleteAddress = new DeleteAddress();
            deleteAddress.setGUI();
        }

        if(f.getActionCommand().equals("Exit"))
        {
            MenuFrame.dispose();
        }
    }
}
