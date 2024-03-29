package me.lutto.blockcollisions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HorizontalDirection;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML
    private Line wall;

    @FXML
    private Text numberOfCollisionsText;

    @FXML
    private Rectangle biggerBlock;
    private double biggerBlockX;

    @FXML
    private Rectangle smallerBlock;

    @FXML
    private Text biggerBlockText;
    private double biggerBlockTextX;

    private HorizontalDirection biggerBlockDirection = HorizontalDirection.LEFT;
    private ArrayList<Node> nodes = new ArrayList<>();
    private Integer numberOfCollisions = 0;

    public void gameStart(ActionEvent event) {
        nodes.add(wall);
        nodes.add(smallerBlock);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (checkCollision(biggerBlock) && biggerBlockDirection.equals(HorizontalDirection.LEFT)) {
                    biggerBlockDirection = HorizontalDirection.RIGHT;
                }

                if (biggerBlockDirection.equals(HorizontalDirection.LEFT)) {
                    biggerBlockText.setX(biggerBlockTextX -= 1);
                    biggerBlock.setX(biggerBlockX -= 1);
                } else {
                    biggerBlockText.setX(biggerBlockTextX += 1);
                    biggerBlock.setX(biggerBlockX += 1);
                }
            }
        }, 0, 10);
    }

    private Boolean checkCollision(Shape block) {
        for (Node node : nodes) {
            if (block.getBoundsInParent().intersects(node.getBoundsInParent())) {
                numberOfCollisions += 1;
                numberOfCollisionsText.setText("# Collisions: " + numberOfCollisions);
                return true;
            }
        }
        return false;
    }

}