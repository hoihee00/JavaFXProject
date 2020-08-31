package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox(); //컨테이너 클래스
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		
		TextField tField = new TextField(); //text입력 컨트롤
		tField.setPrefWidth(200);
		
		Button btn = new Button(); //버튼 컨트롤
		btn.setText("확인");
		btn.setOnAction(new EventHandler<ActionEvent>() {;
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
		});
		
		//컨테이너에 컨트롤 달기
		hbox.getChildren().add(tField); //컨테이너에 text 컨트롤 붙임
		hbox.getChildren().add(btn); //컨테이너에 버튼 컨트롤 붙임

		Scene scene = new Scene(hbox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("AppMain");
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
