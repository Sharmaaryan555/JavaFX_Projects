package com.example.fruitmarket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public  static  final String Currency = "$";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("market.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fruit Market");
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}