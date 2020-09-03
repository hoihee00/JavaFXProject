package basic.control.chart;
//UI: Chart.fxml (p.925)
//Control: ChartController.java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChartExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hb = FXMLLoader.load(this.getClass().getResource("Chart.fxml"));
		Scene scene = new Scene(hb);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
