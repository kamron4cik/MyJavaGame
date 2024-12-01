package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class MedalObject extends SuperObject{
    public MedalObject(){
        name = "Medal";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/medal.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
