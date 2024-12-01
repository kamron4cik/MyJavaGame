package main;

import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        //Default settings. Non-resizable window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D adventure");

        //Game panel
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //to fit preferred size
        window.pack();

        //to be displayed at the center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //calling the game loop
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}