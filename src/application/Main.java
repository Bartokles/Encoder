package application;

import encoder.CesarTextEncoder;
import encoder.NewEncoder;
import encoder.TextEncoder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout.fxml"));

			AnchorPane root = (AnchorPane) loader.load();
			//fx:controller="com.fxtest.MyController";


			EncoderController controller = loader.getController();

			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
