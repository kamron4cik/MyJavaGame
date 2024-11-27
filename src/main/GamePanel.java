package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //screen settings
    final int originalTileSiza = 16; //default 16x16 tile size
    final int scale = 3;  //for objects to be bigger

    public final int tileSize = originalTileSiza * scale; // 48x48 tile size
    public final int maxScreenCol = 16; //16 tiles horizontally
    public final int maxScreenRow = 12; //12 tiles vertically
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int maxWorldWidth = tileSize * maxWorldCol;
    public final int maxWorldHeight = tileSize * maxWorldRow;

    //FPS of the game
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public Player player = new Player(this,keyH);

    //players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    //constructor
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        //to make all components drawing in off-screen painting buffer
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        //to be focused in key input
        this.setFocusable(true);
    }

    //instantiate a thread
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //System.out.println("The game loop is running");
        //Set fps via sleep method
        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            //FPS regulations
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            //Use FPS
            if(delta >= 1){
                //UPDATE: update the information such as character position
                update();
                //DRAW: draw the screen with updated information
                repaint();
                delta--;
                drawCount++;
            }

            //Show FPS
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    //update method for updating information
    public void update(){
        //Check and change player position
        player.update();
    }
    //repaint method for drawing updated information
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //convert graphics class to graphics2D class
        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);

        //Dispose of this graphics content and release any system resources that it is using
        g2.dispose();
    }
}
