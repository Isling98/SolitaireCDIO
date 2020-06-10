package View;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Cards {

    private static Map<String, Image> cards = new HashMap<>();

    private static Image getImage(String card) {
        Image image = cards.get(card);
        if (image == null) {
//            StringBuilder sb = new StringBuilder();
//            sb.append("C:\\fancy/");
//            sb.append(card);
//            sb.append(".gif");
//
            try {
                image = new Image(new FileInputStream("C:\\SolitaireCDIO\\src\\main\\resources\\2c.gif"));

                // image = new Image(Cards.class.getClassLoader()
                   //    .getResourceAsStream("resources" + card + ".gif"));
                cards.put(card, image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
           }
        }

            return image;
    }

        public static Image getFaceDownCard(){
            return getImage("2c");
        }

}

