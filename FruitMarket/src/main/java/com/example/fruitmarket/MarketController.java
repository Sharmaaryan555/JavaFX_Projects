package com.example.fruitmarket;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private VBox chosenFruitCard;

    @FXML
    private ImageView fruitImage;

    @FXML
    private Label fruitNameLabel;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    private Image image;

    private List<Fruit> fruits = new ArrayList<>();

    private MyListener myListener;

    private List<Fruit> getData() {
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit;

        fruit = new Fruit();
        fruit.setName("Kiwi");
        fruit.setPrice(2.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/kiwi.png");  // Ensure this path is correct
        fruit.setColor("6a7324");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Coconut");
        fruit.setPrice(3.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/coconut.png");
        fruit.setColor("A7745B");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Peach");
        fruit.setPrice(1.50);
        fruit.setImageSrc("/com/example/fruitmarket/img/peach.png");
        fruit.setColor("F16C31");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Grapes");
        fruit.setPrice(0.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/grapes.png");
        fruit.setColor("291D36");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Watermelon");
        fruit.setPrice(4.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/watermelon.png");
        fruit.setColor("22371D");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Orange");
        fruit.setPrice(2.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/orange.png");
        fruit.setColor("FB5D03");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("StrawBerry");
        fruit.setPrice(0.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/strawberry.png");
        fruit.setColor("80080C");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Mango");
        fruit.setPrice(0.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/mango.png");
        fruit.setColor("FFB605");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Cherry");
        fruit.setPrice(0.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/cherry.png");
        fruit.setColor("5F060E");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Banana");
        fruit.setPrice(1.99);
        fruit.setImageSrc("/com/example/fruitmarket/img/banana.png");
        fruit.setColor("E7C00F");
        fruits.add(fruit);


        return fruits;
    }

    private void setChosenFruit(Fruit fruit) {
        fruitNameLabel.setText(fruit.getName());
        fruitPriceLabel.setText(Main.Currency + fruit.getPrice());
        Image image = new Image(getClass().getResourceAsStream(fruit.getImageSrc()));
        fruitImage.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "  -fx-background-radius: 30;"
        );

    }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        fruits.addAll(getData());
        if (fruits.size() > 0) {
            setChosenFruit(fruits.getFirst());
            myListener = this::setChosenFruit;
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/fruitmarket/item.fxml")); // Ensure this path is correct

                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);


                GridPane.setMargin(anchorPane, new Insets(10));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
