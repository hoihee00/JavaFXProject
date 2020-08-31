package basic.container;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application { // Application을 상속받기 때문에 Override 해줌
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(); // 인스턴스 선언
		root.setPadding(new Insets(10,10,10,10)); // 패딩값 지정
		
		ImageView iv = new ImageView(); // root 컨테이너 안에 ImageView 컨테이너 담음
		iv.setFitWidth(200);
		iv.setPreserveRatio(true);
		iv.setImage(new Image("/basic/images/fruit1.jpg")); // bin 폴더 안
		
		HBox hbox = new HBox(); // root 컨테이너 안에 HBox 컨테이너 담음
		hbox.setAlignment(Pos.CENTER); // 가운데 정렬
		hbox.setSpacing(20);
		
		Button btnPrev = new Button(); // HBox 안에 "이전", "다음" 버튼 담음
		btnPrev.setText("이전");
		Button btnNext = new Button("다음");
		HBox.setHgrow(btnNext, Priority.ALWAYS); // HBox의 남은 영역을 "다음" 버튼으로 채움
		btnNext.setMaxWidth(Double.MAX_VALUE); // 버튼의 폭을 자동으로 확장
		hbox.getChildren().add(btnPrev);
		hbox.getChildren().add(btnNext);
		VBox.setMargin(hbox, new Insets(10));
		
		
		// 이벤트 핸들러를 해당 컨트롤에 등록 - 1
		btnNext.setOnAction(new EventHandler<ActionEvent>() { // 익명의 구현 객체인 이벤트핸들러 인터페이스(제너럴 타입은 action event)를 action event로 등록
			int loc = 1;
			@Override
			public void handle(ActionEvent ae) {
				if(loc == 9)
					loc = 1;
				iv.setImage(new Image("/basic/images/fruit" + loc++ + ".jpg"));
			}
		});
		
		
//		// 이벤트 핸들러를 해당 컨트롤에 등록 - 2 (람다식)
//		btnNext.setOnAction((ae) -> {
//				System.out.println("handle: " + ae.getSource());
//		});
		
		btnPrev.setOnAction(new EventHandler<ActionEvent>() {
			int loc = 8;
			@Override
			public void handle(ActionEvent ae) {
				if(loc == 0)
					loc = 8;
				iv.setImage(new Image("/basic/images/fruit" + loc-- + ".jpg"));
			}
		});

		
		root.getChildren().add(iv);
		root.getChildren().add(hbox);
		
		// 위에서 만든 컨데이너를 씬에 담기
		Scene scene = new Scene(root); // 스테이지(씬(컨테이너(컨트롤)))
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("VBox 예제");
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
