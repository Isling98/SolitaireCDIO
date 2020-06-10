package Simulation;

import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GameController {




    public static void main(String[] args) throws IOException {
      SimGame Simulator = new SimGame();


      // Algorithm.AnalyseMove(Game);
      ObjectMapper mapper = new ObjectMapper();
      StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Simulator.cardPiles.length; i++) {
           String jsonString = mapper.writeValueAsString(Simulator.cardPiles[i].printPile());
            sb.append(jsonString);
        }
        System.out.println(sb);




     //   System.out.println(sb);

      mapper.writeValue(new File("c:\\test\\Game.json"), sb.toString());


    }



    



}
