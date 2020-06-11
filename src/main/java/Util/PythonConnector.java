package Util;

import Model.GameModel;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

//Editor i observerpattern da det er her ny info om spillet kommer fra

public class PythonConnector extends Observable {


    private GameModel gameModel;
    String fromClient;
    String toClient;


    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        setChanged();
        notifyObservers(gameModel);
    }






    public PythonConnector() throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("wait for connection on port 8080");
        Socket client = server.accept();
        System.out.println("got connection on port 8080");
        boolean run = true;
        while (run) {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);



            fromClient = in.readLine();
            System.out.println(fromClient);


            Gson g = new Gson();
            GameModel GameFromClient =g.fromJson(fromClient, GameModel.class);
            if(!getGameModel().equals(GameFromClient)){
            setGameModel(GameFromClient);
            System.out.println(GameFromClient.toString());}

            // System.out.println("received: " + fromClient);
            // toClient = fromClient.toUpperCase();
            // out.println(toClient);

            if (fromClient.equals("exit")) {
                run = false;
            }
        }
    }
}