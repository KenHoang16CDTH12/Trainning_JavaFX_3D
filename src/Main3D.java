import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class Main3D extends Application {
    /*private static final String MESH_FILENAME =
            "/home/kenhoang/IdeaProjects/1TrainningJavaFX/src/resources/assets/dragon.stl";

    private static final double MODEL_SCALE_FACTOR = 400;
    private static final double MODEL_X_OFFSET = 0; // standard
    private static final double MODEL_Y_OFFSET = 0; // standard

    private static final int VIEWPORT_SIZE = 800;

    private static final Color lightColor = Color.rgb(244, 255, 250);
    private static final Color jewelColor = Color.rgb(0, 190, 222);

    private Group root;
    private PointLight pointLight;

    static MeshView[] loadMeshViews() {
        File file = new File(MESH_FILENAME);
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(file);
        Mesh mesh = importer.getImport();

        return new MeshView[] { new MeshView(mesh) };
    }

    private Group buildScene() {
        MeshView[] meshViews = loadMeshViews();
        for (int i = 0; i < meshViews.length; i++) {
            meshViews[i].setTranslateX(VIEWPORT_SIZE / 2 + MODEL_X_OFFSET);
            meshViews[i].setTranslateY(VIEWPORT_SIZE / 2 + MODEL_Y_OFFSET);
            meshViews[i].setTranslateZ(VIEWPORT_SIZE / 2);
            meshViews[i].setScaleX(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleY(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleZ(MODEL_SCALE_FACTOR);

            PhongMaterial sample = new PhongMaterial(jewelColor);
            sample.setSpecularColor(lightColor);
            sample.setSpecularPower(16);
            meshViews[i].setMaterial(sample);

            meshViews[i].getTransforms().setAll(new Rotate(38, Rotate.Z_AXIS), new Rotate(20, Rotate.X_AXIS));
        }

        pointLight = new PointLight(lightColor);
        pointLight.setTranslateX(VIEWPORT_SIZE*3/4);
        pointLight.setTranslateY(VIEWPORT_SIZE/2);
        pointLight.setTranslateZ(VIEWPORT_SIZE/2);
        PointLight pointLight2 = new PointLight(lightColor);
        pointLight2.setTranslateX(VIEWPORT_SIZE*1/4);
        pointLight2.setTranslateY(VIEWPORT_SIZE*3/4);
        pointLight2.setTranslateZ(VIEWPORT_SIZE*3/4);
        PointLight pointLight3 = new PointLight(lightColor);
        pointLight3.setTranslateX(VIEWPORT_SIZE*5/8);
        pointLight3.setTranslateY(VIEWPORT_SIZE/2);
        pointLight3.setTranslateZ(0);

        //Color ambientColor = Color.rgb(80, 80, 80, 0);
        //AmbientLight ambient = new AmbientLight(ambientColor);

        root = new Group(meshViews);
        root.getChildren().add(pointLight);
        root.getChildren().add(pointLight2);
        root.getChildren().add(pointLight3);
        //root.getChildren().add(ambient);

        return root;
    }

    private PerspectiveCamera addCamera(Scene scene) {
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        System.out.println("Near Clip: " + perspectiveCamera.getNearClip());
        System.out.println("Far Clip:  " + perspectiveCamera.getFarClip());
        System.out.println("FOV:       " + perspectiveCamera.getFieldOfView());

        scene.setCamera(perspectiveCamera);
        return perspectiveCamera;
    }*/

    @Override
    public void start(Stage primaryStage) {
        StlMeshImporter stlImporter = new StlMeshImporter();

        try {
            stlImporter.read(this.getClass().getResource("/resources/assets/dragon.stl"));


            TriangleMesh triangMesh = stlImporter.getImport();
            stlImporter.close();
            MeshView mesh = new MeshView(triangMesh);

            Random rand = new Random();
            mesh.setTranslateX(rand.nextInt(50) + 1);
            mesh.setTranslateY(rand.nextInt(50) + 1);
            mesh.setTranslateZ((rand.nextInt(50) + 1) * 10);
            mesh.setRotate(rand.nextInt(50) + 1);

            Group root = new Group(mesh);
            Scene scene = new Scene(root, 1024, 800, true);
            Camera camera = new PerspectiveCamera();
            scene.setCamera(camera);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (ImportException e) {
            e.printStackTrace();
            return;
        }
        /*
        Scene scene = new Scene(group, VIEWPORT_SIZE, VIEWPORT_SIZE, true);
        scene.setFill(Color.rgb(10, 10, 40));
        addCamera(scene);
        primaryStage.setTitle("Ken Hoang");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    public static void main(String[] args) {
        System.setProperty("prism.dirtyopts", "false");
        launch(args);
    }
}
