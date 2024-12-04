package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

//To store variables of player class and etc.
public class Entity {
    public int worldX;
    public int worldY;
    public int speed;
    public String gender;

    public String direction;
    public BufferedImage up1, gUp1;
    public BufferedImage up2, gUp2;
    public BufferedImage down1, gDown1;
    public BufferedImage down2, gDown2;
    public BufferedImage left1, gLeft1;
    public BufferedImage left2, gLeft2;
    public BufferedImage right1, gRight1;
    public BufferedImage right2, gRight2;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;

    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    public boolean collisionOn = false;
}
