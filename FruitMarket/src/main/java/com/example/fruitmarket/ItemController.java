package com.example.fruitmarket;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class ItemController {

    @FXML
    private ImageView image;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    private Fruit fruit;

    private MyListener myListener;

    @FXML
    private void click(MouseEvent mouseEvent)
    {
        myListener.onClickListener(fruit);
    }

    public void setData(Fruit fruit,MyListener myListener){
        this.fruit = fruit;
        this.myListener = myListener;
        nameLabel.setText(fruit.getName());
        priceLabel.setText(Main.Currency + fruit.getPrice());
        Image image = new Image(getClass().getResourceAsStream(fruit.getImageSrc()));
        this.image.setImage(image);
    }
}
