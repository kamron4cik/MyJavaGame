package main;

import entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel implements ActionListener {

    public JButton boyButton;
    public JButton girlButton;
    public String gender;

    public StartScreen(){
        //setting image to icon
        ImageIcon bIcon = new ImageIcon("/player/boy_default.png");
        ImageIcon gIcon = new ImageIcon("/player/girl_down.png");

        //create new buttons
        boyButton = new JButton();
        girlButton = new JButton();

        //set buttons positions and boundaries
        boyButton.setBounds(50,100,144,144);
        girlButton.setBounds(200,100,144,144);

        //set icons to button
        boyButton.setIcon(bIcon);
        girlButton.setIcon(gIcon);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boyButton){
            gender = "boy";
        }
        if(e.getSource() == girlButton){
            gender = "girl";
        }
    }

    //getting images

}
