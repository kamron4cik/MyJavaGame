package main;

import object.ChestObject;
import object.DoorObject;
import object.KeyObject;
import object.MedalObject;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new KeyObject();
        gp.obj[0].worldX = 21 * gp.tileSize;
        gp.obj[0].worldY = 13 * gp.tileSize;

        gp.obj[1] = new KeyObject();
        gp.obj[1].worldX = 28 * gp.tileSize;
        gp.obj[1].worldY = 19 * gp.tileSize;

        gp.obj[2] = new KeyObject();
        gp.obj[2].worldX = 17 * gp.tileSize;
        gp.obj[2].worldY = 12 * gp.tileSize;

        gp.obj[3] = new DoorObject();
        gp.obj[3].worldX = 28 * gp.tileSize;
        gp.obj[3].worldY = 17 * gp.tileSize;

        gp.obj[4] = new DoorObject();
        gp.obj[4].worldX = 14 * gp.tileSize;
        gp.obj[4].worldY = 12 * gp.tileSize;

        gp.obj[5] = new DoorObject();
        gp.obj[5].worldX = 19 * gp.tileSize;
        gp.obj[5].worldY = 9 * gp.tileSize;

        gp.obj[6] = new ChestObject();
        gp.obj[6].worldX = 19 * gp.tileSize;
        gp.obj[6].worldY = 8 * gp.tileSize;

        gp.obj[7] = new MedalObject();
        gp.obj[7].worldX = 19 * gp.tileSize;
        gp.obj[7].worldY = 16 * gp.tileSize;
    }
}
