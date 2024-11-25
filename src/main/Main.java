import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args) {
        //Default settings. Non-resizable window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D adventure");

        //to be displayed at the center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}