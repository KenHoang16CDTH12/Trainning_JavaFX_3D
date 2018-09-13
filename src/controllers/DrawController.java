package controllers;

import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.sun.javafx.scene.control.skin.Utils.getResource;


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
        String[] arrColor = {"#b71c1c", "#7f0000", "#5ddef4", "#9162e4", "#9162e6"};
        Random rd = new Random();
        int i = rd.nextInt(arrColor.length - 1);
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
        StlMeshImporter stlImporter = new StlMeshImporter();
        try {
            stlImporter.read(this.getClass().getResource("/resources/assets/dragon.stl"));


            TriangleMesh triangMesh = stlImporter.getImport();
            stlImporter.close();
            MeshView mesh = new MeshView(triangMesh);
            phongMaterial = new PhongMaterial();
            phongMaterial.setDiffuseColor(Color.RED);
            phongMaterial.setSpecularColor(Color.DARKRED);
            mesh.setMaterial(phongMaterial);
            action(mesh);

        } catch (ImportException e) {
            e.printStackTrace();
            return;
        }
    }

    private void action(MeshView mesh) {
        Random rand = new Random();
        mesh.setTranslateX(rand.nextInt(50) + 1);
        mesh.setTranslateZ((rand.nextInt(50) + 1) * 10);
        mesh.setTranslateY(0);
        mesh.setRotate(180);

        mesh.setScaleX(3);
        mesh.setScaleY(3);
        mesh.setScaleZ(3);


        flowPaneDraw.getChildren().add(mesh);


        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame movePlane = new KeyFrame(Duration.millis(5000),
                new KeyValue(mesh.translateYProperty(), -2000));
        timeline.getKeyFrames().add(movePlane);
        timeline.play();
    }

}
