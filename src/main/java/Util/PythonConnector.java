package Util;

import Model.Card;
import Model.GameModel;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.Observable;
import java.util.Scanner;

//Editor i observerpattern da det er her ny info om spillet kommer fra

public class PythonConnector extends Observable {


    private GameModel gameModel;
    Socket client;
    String fromClient;
    String toClient;
    ServerSocket server;


    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        setChanged();
        notifyObservers(gameModel);
    }


    public PythonConnector() throws IOException {

        server = new ServerSocket(8080);
        System.out.println("wait for connection on port 8080");
        client = server.accept();
        System.out.println("got connection on port 8080");
    }


     public Card getSingleCard() throws  IOException {
         BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
         PrintWriter out = new PrintWriter(client.getOutputStream(), true);
         toClient = "singleCard";
         out.println(toClient);
         fromClient = "";
         while(!in.ready())
         {
             // Vent til klar
         }

         while (in.ready()){
             fromClient += in.readLine();
         }

        // System.out.println(fromClient);
         Gson g = new Gson();
         Card card =g.fromJson(fromClient, Card.class);
         System.out.println(fromClient);
            return card; // card
     }

     public Card[] getStartDeck() throws IOException{
         System.out.println("Tryk når python er klar");
         Scanner scanner = new Scanner(System.in);
         scanner.nextLine();
         BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
         PrintWriter out = new PrintWriter(client.getOutputStream(), true);
         toClient = "startDeck";
         out.println(toClient);
         fromClient = "";
         while(!in.ready())
         {
             // Vent til klar
         }

         while (in.ready()){
             fromClient += in.readLine();
         }

         System.out.println(fromClient);
         Gson g = new Gson();
         Card[] startPile =g.fromJson(fromClient, Card[].class);
         return startPile; // card


     }
}