package basic.container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TilePane root = new TilePane();
		root.setPadding(new Insets(10,10,10,10));
		
		ImageView iv1 = new ImageView();
		iv1.setFitHeight(100);
		iv1.setFitWidth(100);
		iv1.setImage(new Image("/basic/images/fruit1.jpg"));
		
		ImageView iv2 = new ImageView();
		iv2.setFitHeight(100);
		iv2.setFitWidth(100);
		iv2.setImage(new Image("/basic/images/fruit2.jpg"));
		
		ImageView iv3 = new ImageView();
		iv3.setFitHeight(100);
		iv3.setFitWidth(100);
		iv3.setImage(new Image("/basic/images/fruit3.jpg"));
		
		ImageView iv4 = new ImageView();
		iv4.setFitHeight(100);
		iv4.setFitWidth(100);
		iv4.setImage(new Image("/basic/images/fruit4.jpg"));
		
		ImageView iv5 = new ImageView();
		iv5.setFitHeight(100);
		iv5.setFitWidth(100);
		iv5.setImage(new Image("/basic/images/fruit5.jpg"));
		
		root.getChildren().add(iv1);
		root.getChildren().add(iv2);
		root.getChildren().add(iv3);
		root.getChildren().add(iv4);
		root.getChildren().add(iv5);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("TilePane 예제");

		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
