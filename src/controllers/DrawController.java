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
import javafx.scene.image.Image;
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


public class DrawController {
    public FlowPane flowPaneDraw;

    public Button btnExit;

    PhongMaterial phongMaterial;

    @FXML
    public void initialize() {
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
        final Sphere sphere = new Sphere(100);
        phongMaterial = new PhongMaterial();
        phongMaterial.setBumpMap(new Image("/resources/assets/map.png"));
        phongMaterial.setDiffuseMap(new Image("/resources/assets/map.png"));
        sphere.setMaterial(phongMaterial);
        action(sphere);

    }

    public void action(Sphere sphere) {
        Random rand = new Random();
        sphere.setTranslateX(rand.nextInt(50) + 1);
        sphere.setTranslateY(rand.nextInt(50) + 1);
        sphere.setTranslateZ((rand.nextInt(50) + 1) * 10);
        sphere.setRotate(rand.nextInt(50) + 1);



        flowPaneDraw.getChildren().add(sphere);


        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame movePlane = new KeyFrame(Duration.millis(5000),
                new KeyValue(sphere.translateXProperty(), 0));
        timeline.getKeyFrames().add(movePlane);
        timeline.play();
    }

    public void drawBoxAction(ActionEvent actionEvent) {
        final Sphere sphere = new Sphere(100);
        phongMaterial = new PhongMaterial();
        phongMaterial.setBumpMap(new Image("/resources/assets/map.png"));
        //phongMaterial.setDiffuseMap(new Image("/resources/assets/map.png"));
        sphere.setMaterial(phongMaterial);
        action(sphere);
    }

    public void drawCylinderAction(ActionEvent actionEvent) {
        final Sphere sphere = new Sphere(100);
        phongMaterial = new PhongMaterial();
        //phongMaterial.setBumpMap(new Image("/resources/assets/map.png"));
        phongMaterial.setDiffuseMap(new Image("/resources/assets/map.png"));
        sphere.setMaterial(phongMaterial);
        action(sphere);
    }

    public void drawLightAction(ActionEvent actionEvent) {
    }
}
