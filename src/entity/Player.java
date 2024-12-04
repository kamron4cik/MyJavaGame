package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        gender = "boy";

        //Camera
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        //coordinates and collision on part of character
        solidArea = new Rectangle(12, 24, 24, 24);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 20;
        worldY = gp.tileSize * 17;
        speed = 4;
        direction = "up";
    }
    //Image of player
    public void getPlayerImage(){
        try{

            if(Objects.equals(gender, "boy")){
                up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_1.png")));
                up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_2.png")));
                down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_1.png")));
                down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_2.png")));
                left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_1.png")));
                left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_2.png")));
                right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_1.png")));
                right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_2.png")));
            }
            else if(Objects.equals(gender, "girl")){
                gUp1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_up.png")));
                gUp2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_up.png")));
                gDown1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_down.png")));
                gDown2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_down.png")));
                gLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_left_1.png")));
                gLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_left_2.png")));
                gRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_right_1.png")));
                gRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_right_2.png")));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //update method for updating information
    public void update(){
        //Check and change player position if any button is pressed
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.rightPressed) {
                direction = "right";
            } else if (keyH.leftPressed) {
                direction = "left";
            }
            if(keyH.changeCharacter){
                System.out.println("Gender changed");
                if(Objects.equals(gender, "boy")){
                    gender = "girl";
                }else{
                    gender = "boy";
                }
            }

            //Tile Collision checking
            collisionOn = false;
            gp.collisionChecker.checkTile(this);

            //Object Collision checking
            int objIndex = gp.collisionChecker.checkObject(this, true);
            pickObject(objIndex);

            //Unless collision is true, player can move
            if(!collisionOn){
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                }
            }

            //To make it step
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickObject(int index){
        if(index != 999){
            //So that object disappears, use gp.obj[index] = null;

            //check the object type
            String objectName = gp.obj[index].name;

            // action with object
            switch (objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("Key has been picked up");
                    break;
                case "Door":
                    if(hasKey > 0){
                        gp.playSE(2);
                        hasKey--;
                        gp.obj[index] = null;
                        gp.ui.showMessage("Door opened");
                    }
                    else{
                        gp.playSE(4);
                        gp.ui.showMessage("You need a key");
                    }
                    System.out.println("Keys: " + hasKey);
                    break;
                case "Medal":
                    gp.stopMusic();
                    gp.playMusic(5);
                    speed++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("DESPACITO TIME!!!");
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(6);
                    break;
            }
        }
    }

    //draw updated information
    public void draw(Graphics2D g2){
//        //set color for drawing
//        g2.setColor(Color.white);
//
//        //draw
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch (direction){
            case "up":
                if(Objects.equals(gender, "boy")){
                    System.out.println("Drawing boy");
                    if(spriteNum == 1)
                        image = up1;
                    if(spriteNum == 2)
                        image = up2;
                }else if(Objects.equals(gender, "girl")){
                    System.out.println("Drawing girl");
                    if(spriteNum == 1)
                        image = gUp1;
                    if(spriteNum == 2)
                        image = gUp2;
                }

                break;
            case "down":
                if(Objects.equals(gender, "boy")){
                    System.out.println("Drawing boy");
                    if(spriteNum == 1)
                        image = down1;
                    if(spriteNum == 2)
                        image = down2;
                }else if(Objects.equals(gender, "girl")){
                    System.out.println("Drawing girl");
                    if(spriteNum == 1)
                        image = gDown1;
                    if(spriteNum == 2)
                        image = gDown2;
                }
                break;
            case "left":
                if(Objects.equals(gender, "boy")){
                    System.out.println("Drawing boy");
                    if(spriteNum == 1)
                        image = left1;
                    if(spriteNum == 2)
                        image = left2;
                }else if(Objects.equals(gender, "girl")){
                    System.out.println("Drawing girl");
                    if(spriteNum == 1)
                        image = gLeft1;
                    if(spriteNum == 2)
                        image = gLeft2;
                }
                break;
            case "right":
                if(Objects.equals(gender, "boy")){
                    System.out.println("Drawing boy");
                    if(spriteNum == 1)
                        image = right1;
                    if(spriteNum == 2)
                        image = right2;
                }else if(Objects.equals(gender, "girl")){
                    System.out.println("Drawing girl");
                    if(spriteNum == 1)
                        image = gRight1;
                    if(spriteNum == 2)
                        image = gRight2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
/*
 if(Objects.equals(gender, "boy")){
            switch (direction){
                case "up":
                    if(spriteNum == 1)
                        image = up1;
                    if(spriteNum == 2)
                        image = up2;
                    break;
                case "down":
                    if(spriteNum == 1)
                        image = down1;
                    if(spriteNum == 2)
                        image = down2;
                    break;
                case "left":
                    if(spriteNum == 1)
                        image = left1;
                    if(spriteNum == 2)
                        image = left2;
                    break;
                case "right":
                    if(spriteNum == 1)
                        image = right1;
                    if(spriteNum == 2)
                        image = right2;
                    break;
            }
        }else{
            switch (direction){
                case "up":
                    if(spriteNum == 1)
                        image = gUp1;
                    if(spriteNum == 2)
                        image = gUp2;
                    break;
                case "down":
                    if(spriteNum == 1)
                        image = gDown1;
                    if(spriteNum == 2)
                        image = gDown2;
                    break;
                case "left":
                    if(spriteNum == 1)
                        image = gLeft1;
                    if(spriteNum == 2)
                        image = gLeft2;
                    break;
                case "right":
                    if(spriteNum == 1)
                        image = gRight1;
                    if(spriteNum == 2)
                        image = gRight2;
                    break;
            }
        }
*/