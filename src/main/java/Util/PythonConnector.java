package Util;

import Model.Card;
import Model.GameModel;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Editor i observerpattern da det er her ny info om spillet kommer fra

public class PythonConnector  {


    private GameModel gameModel;
    Socket client;
    String fromClient;
    String toClient;
    ServerSocket server;
    ArrayList<Card> simCards;
    boolean pyCon;


    public PythonConnector(boolean pyCon) throws IOException {
        this.pyCon = pyCon;
        if (pyCon){
            server = new ServerSocket(8080);
            System.out.println("wait for connection on port 8080");
            client = server.accept();
            System.out.println("got connection on port 8080");
        }

        else {
            simCards = new ArrayList<>();
            for (int i = 0; i < 4 ; i++) {
                for (int j = 0; j < 13; j++) {
                    Card temp = new Card(j,i);
                    simCards.add(temp);
                }
            }
            Collections.shuffle(simCards);
        }
    }


     public Card getSingleCard() throws  IOException {
        if (pyCon) {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            toClient = "singleCard";
            out.println(toClient);
            fromClient = "";
            while (!in.ready()) {
                // Vent til klar
            }

            while (in.ready()) {
                fromClient += in.readLine();
            }

            // System.out.println(fromClient);
            Gson g = new Gson();
            Card card = g.fromJson(fromClient, Card.class);
            System.out.println(fromClient);
            return card; // card
        }
        else return simCards.remove(0);
     }

     public Card[] getStartDeck() throws IOException{
         Card[] startPile = new Card[7];
         if (pyCon) {
            System.out.println("Tryk når python er klar");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            toClient = "startDeck";
            out.println(toClient);
            fromClient = "";
            while (!in.ready()) {
                // Vent til klar
            }

            while (in.ready()) {
                fromClient += in.readLine();
            }

            System.out.println(fromClient);
            Gson g = new Gson();
            startPile = g.fromJson(fromClient, Card[].class);

        }
        else {
            startPile = new Card[7];
            for (int i = 0; i < 7; i++) {
                startPile[i] = simCards.remove(0);
            }
        }
         return startPile; // card
     }
}