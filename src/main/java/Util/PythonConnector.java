package Util;

import Model.GameModel;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


//Editor i observerpattern da det er her ny info om spillet kommer fra

public class PythonConnector {

    private List<Observer> observers = new ArrayList<>();
    private GameModel gameModel;
    String fromClient;
    String toClient;

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
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
            StringBuilder sb = new StringBuilder();


            Stream<String> data = in.lines();
            fromClient = data.toString();
            System.out.println(fromClient);


            Gson g = new Gson();
            GameModel GameFromClient =g.fromJson(fromClient, GameModel.class);
            setGameModel(GameFromClient);
            System.out.println(GameFromClient.toString());

            // System.out.println("received: " + fromClient);
            // toClient = fromClient.toUpperCase();
            // out.println(toClient);

            if (fromClient.equals("exit")) {
                run = false;
            }
        }
    }
}