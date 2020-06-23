package View;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Cards {

    private static Map<String, Image> cards = new HashMap<>();
    public static Image getImage(String card) {
        Image image = cards.get(card);
        if (image == null) {
            StringBuilder sb = new StringBuilder();
            //Brug denne til at compile jar fil
            //sb.append("resources/");

            //Brug denne til at køre fra ide
            sb.append("src/main/resources/");
            sb.append(card);
            sb.append(".gif");

            try {
                image = new Image(new FileInputStream(String.valueOf(sb)));
                cards.put(card, image);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}

