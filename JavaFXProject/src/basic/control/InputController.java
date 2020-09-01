package basic.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputController implements Initializable {
	
	@FXML
	TextField txtTitle;
	@FXML
	PasswordField txtPassword;
	@FXML
	ComboBox<String> comboPublic;
	@FXML
	DatePicker dataExit;
	@FXML
	TextArea txtContent;
	@FXML
	Button btnReg, btnCancel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		txtTitle.setText("안녕하세요");
//		comboPublic.setValue("public");
		
//		btnReg.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent ae) {
//				handleBtnRegAction();
//			}
//		});
		btnReg.setOnAction((ae) -> handleBtnRegAction()); // 람다식
		
	}

	public void handleBtnRegAction() {
		if (txtTitle.getText() == null || txtTitle.getText().equals("")) {
			showPopup(" 타이틀을 입력하세요  ");
		} else if (txtPassword.getText() == null || txtPassword.getText().equals("")) {
			showPopup(" 비밀번호를 입력하세요  ");
		} else if (comboPublic.getValue() == null || comboPublic.getValue().equals("")) {
			showPopup(" 공개여부를 지정하세요  ");
		} else if (dataExit.getValue() == null) {
			showCustomDialog("날짜를 입력하세요");
		}
	}
	
	public void showCustomDialog(String msg) {
		
		// 날짜 안내 입력 Stage 등록
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnReg.getScene().getWindow());
		
		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);
		
		ImageView iv = new ImageView();
		iv.setImage(new Image("/basic/images/dialog-info.png"));
		iv.setFitWidth(50);
		iv.setFitHeight(50);
		iv.setLayoutX(15);
		iv.setLayoutY(15);
		iv.setPreserveRatio(true);
		
		Button btnok = new Button("확인");
		btnok.setLayoutX(336);
		btnok.setLayoutY(104);
		btnok.setOnAction((e) -> stage.close());
		
		Label label = new Label(msg);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefSize(290, 15);
		
		ap.getChildren().addAll(iv, btnok, label);
		
		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void showPopup(String msg) { // 반복되는 작업 메소드로 등록
		
		// Popup 타이틀 등록
		HBox  hbox = new HBox();
		hbox.setStyle("-fx-background-color: black; -fx-background-radius: 13;");
		hbox.setAlignment(Pos.CENTER);
		
		ImageView iv = new ImageView();
		iv.setImage(new Image("/basic/images/dialog-info.png"));
		
		Label label = new Label();
		label.setText(msg);
		label.setStyle("-fx-text-fill: yellow; ");
		
		hbox.getChildren().addAll(iv, label);
		
		Popup pop = new Popup();
		pop.getContent().add(hbox);
		pop.setAutoHide(true);
		pop.show(btnReg.getScene().getWindow()); // 윈도우를 가지고 오는 방법이 없어서 윈도우 내의 아무 컨트롤의 씬과 윈도우를 가지고 오는 방식으로 윈도우 가지고 옴
		
	}
}
