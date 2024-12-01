package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class UI {
    GamePanel gp;
    Font arial40;
    Font arial60;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    public int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat df = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp = gp;
        arial40 = new Font("Arial", Font.ITALIC, 40);
        arial60 = new Font("Arial", Font.BOLD, 60);

        // set key image
        try{
            keyImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/keys.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        if(gameFinished){
            g2.setFont(arial40);
            g2.setColor(Color.RED);

            String winText;
            int textLength;
            int x;
            int y;

            //text1 display
            winText = "You found a treasure!";
            textLength = (int) g2.getFontMetrics().getStringBounds(winText,g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize * 3);

            g2.drawString(winText, x, y);

            //time display
            winText = "You playing time : " + df.format(playTime);
            textLength = (int) g2.getFontMetrics().getStringBounds(winText,g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize * 4);

            g2.drawString(winText, x, y);

            //text2 display
            g2.setFont(arial60);
            g2.setColor(Color.YELLOW);

            winText = "CONGRATULATIONS!!!";
            textLength = (int)g2.getFontMetrics().getStringBounds(winText,g2).getWidth();

            x = gp.screenWidth / 2 - textLength/2;
            y = gp.screenHeight / 2 + (gp.tileSize * 2);

            g2.drawString(winText, x, y);

            //stop the game
            gp.gameThread = null;

        }else{
            g2.setFont(arial40);
            g2.setColor(Color.ORANGE);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString(": " + gp.player.hasKey, 74, 65);

            //Playing time
            playTime += (double) 1 /60;
            g2.drawString("Time: " + df.format(playTime), gp.tileSize * 12, 65);

            //notifications
            if(messageOn){
                g2.setFont(g2.getFont().deriveFont(24f));
                g2.setColor(Color.WHITE);
                g2.setFont(g2.getFont().deriveFont(Font.BOLD));
                g2.drawString(message, gp.tileSize * 7, gp.tileSize * 10);

                if(messageCounter++ > 90){
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
