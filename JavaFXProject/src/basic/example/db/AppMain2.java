package basic.example.db;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// UI: Root2.fxml(기본), AddFrom2.fxml(추가), BarChart2.fxml(차트)
// Control: RootController2.java
public class AppMain2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Root2.fxml"));
		BorderPane root = loader.load();
		
		basic.example.RootController controller = loader.getController();
//		RootController controller = loader.getController();
		controller.setprimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
