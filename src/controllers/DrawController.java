package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import static java.lang.Math.random;

public class DrawController {
    public FlowPane flowPaneDraw;

    public Button btnExit;

    PhongMaterial redMaterial;
    PhongMaterial blueMaterial;
    PhongMaterial greyMaterial;

    @FXML
    public void initialize() {
        redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.RED);
        redMaterial.setSpecularColor(Color.ORANGE);

        blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.LIGHTBLUE);

        greyMaterial = new PhongMaterial();
        greyMaterial.setDiffuseColor(Color.DARKGREY);
        greyMaterial.setSpecularColor(Color.GREY);
    }

    public void exitAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void backgroundAction(ActionEvent actionEvent) {
        String[] arrColor = {"#b71c1c","#7f0000","#5ddef4","#9162e4","#9162e6"};
        Random rd = new Random();
        int i = rd.nextInt(arrColor.length-1);
        flowPaneDraw.setStyle("-fx-background-color: " + arrColor[i]);
        flowPaneDraw.getChildren().clear();
    }

    public void drawSphereAction(ActionEvent actionEvent) {
        final Sphere blue = new Sphere(50);
        blue.setMaterial(blueMaterial);
        action(blue);

    }

    public void action(Sphere sphere) {
        Random rand = new Random();
        sphere.setTranslateX(rand.nextInt(100) + 1);
        sphere.setTranslateY(rand.nextInt(100) + 1);
        sphere.setTranslateZ((rand.nextInt(100) + 1) * 10);
        sphere.setRotate(rand.nextInt(100) + 1);



        flowPaneDraw.getChildren().add(sphere);


        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame movePlane = new KeyFrame(Duration.millis(5000),
                new KeyValue(sphere.translateXProperty(), 0));
        timeline.getKeyFrames().add(movePlane);
        timeline.play();


        flowPaneDraw.getChildren().add(sphere);

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        movePlane = new KeyFrame(Duration.millis(5000),
                new KeyValue(sphere.translateXProperty(), 900));
        timeline.getKeyFrames().add(movePlane);
        timeline.play();


    }

    public void drawBoxAction(ActionEvent actionEvent) {
        final Box red = new Box(400, 400, 400);
        red.setMaterial(redMaterial);
        flowPaneDraw.getChildren().add(red);
    }

    public void drawCylinderAction(ActionEvent actionEvent) {
        final Cylinder grey = new Cylinder(5, 100);
        grey.setMaterial(greyMaterial);
        flowPaneDraw.getChildren().add(grey);

    }

    public void drawLightAction(ActionEvent actionEvent) {
    }
}
