import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX application that displays a text Label and an Image
 * (in an ImageView) arranged vertically using a VBox layout.
 */
public class DisplayTextAndImage extends Application {

    // Path of the image file. Change this to an image that exists on your system.
    // Examples:
    //   "file:imagePath.jpg"                 (file in the project's working folder)
    //   "file:C:/Users/you/Pictures/pic.jpg" (absolute path on Windows)
    //   "file:/home/you/Pictures/pic.jpg"    (absolute path on Linux/Mac)
    private static final String IMAGE_PATH = "file:imagePath.jpg";

    @Override
    public void start(Stage primaryStage) {

        // Step 3: Set the title of the stage
        primaryStage.setTitle("Text and Image Display");

        // Step 4: Create a Label with the text
        Label label = new Label("Hello, JavaFX!");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Step 5: Load the image and put it in an ImageView
        Image image = new Image(IMAGE_PATH);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        // Warn on the console if the image could not be loaded
        if (image.isError()) {
            System.err.println("Could not load image from: " + IMAGE_PATH);
            System.err.println("Check that the file exists at that path.");
        }

        // Step 6: Create a VBox layout with 10 px spacing and add the nodes
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, imageView);

        // Step 7: Create a Scene of size 600 x 400 with the VBox as root
        Scene scene = new Scene(vbox, 600, 400);

        // Step 8: Set the scene on the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Step 9: main method launches the application
    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * ---------------------------------------------------------------
 * SETUP
 * ---------------------------------------------------------------
 * 1. Install JDK 11 or later and download the JavaFX SDK
 *    (https://openjfx.io). Note the path to its "lib" folder.
 * 2. Put an image named imagePath.jpg in the same folder as this
 *    file, or change IMAGE_PATH above to your image's location.
 *
 * ---------------------------------------------------------------
 * COMPILE & RUN (command line)
 * ---------------------------------------------------------------
 * Replace PATH_TO_FX with your JavaFX SDK lib folder.
 *
 * javac --module-path PATH_TO_FX --add-modules javafx.controls DisplayTextAndImage.java
 * java  --module-path PATH_TO_FX --add-modules javafx.controls DisplayTextAndImage
 *
 * (In an IDE such as IntelliJ or Eclipse, add the same two options
 *  as VM arguments:  --module-path PATH_TO_FX --add-modules javafx.controls)
 *
 * ---------------------------------------------------------------
 * EXPECTED OUTPUT
 * ---------------------------------------------------------------
 * A 600 x 400 window titled "Text and Image Display" showing the
 * label "Hello, JavaFX!" with the image underneath it.
 */
