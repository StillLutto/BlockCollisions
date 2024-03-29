package me.lutto.blockcollisions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML
    private Rectangle biggerBlock;
    private double biggerBlockX;

    @FXML
    private Text biggerBlockText;
    private double biggerBlockTextX;

    public void gameStart(ActionEvent event) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                biggerBlockText.setX(biggerBlockTextX -= 1);
                biggerBlock.setX(biggerBlockX -= 1);
            }
        }, 0, 10);
    }

}