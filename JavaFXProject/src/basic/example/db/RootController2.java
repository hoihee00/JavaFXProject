package basic.example.db;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController2 implements Initializable {

	@FXML
	TableView<Student2> tableView;

	@FXML
	Button btnAdd, btnList, btnBarChart; // 조회 버튼 추가

	ObservableList<Student2> list;

	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TableColumn<Student2, ?> tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("id"));

		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));

		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("korean"));

		tc = tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("math"));

		tc = tableView.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("english"));

		tableView.setItems(getStudentList());

		// 성적 저장
		list = FXCollections.observableArrayList();
		tableView.setItems(list);

		// 추가 버튼
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				handleBtnAddAction();
			}
		});

		// 조회버튼
		btnList.setOnAction(ae -> handleBtnListAction());

		// 차트버튼
		btnBarChart.setOnAction(ae -> handleBtnChartAction());

		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println(event);
				if (event.getClickCount() == 2) { // 2: 더블클릭
					String selectedName = tableView.getSelectionModel().getSelectedItem().getName();
					handleDoubleClickAction(selectedName);
				}
			}

		});

	} // end of initialize

	private Object handleBtnChartAction() {
		// TODO Auto-generated method stub
		return null;
	}

	// handleBtnListAction
	private Object handleBtnListAction() {
		// TODO Auto-generated method stub
		return null;
	}

	// handleDoubleClickAction
	public void handleDoubleClickAction(String name) {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);

		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(210, 230);
		Label lId, lKorean, lMath, lEnglish;
		TextField tId, tName, tKorean, tMath, tEnglish;
		
		lId = new Label("Id");
		lId.setLayoutX(35);
		lId.setLayoutY(73);

		lKorean = new Label("국어");
		lKorean.setLayoutX(35);
		lKorean.setLayoutY(103);

		lMath = new Label("수학");
		lMath.setLayoutX(35);
		lMath.setLayoutY(133);

		lEnglish = new Label("영어");
		lEnglish.setLayoutX(35);
		lEnglish.setLayoutY(163);

		tId = new TextField();
		tId.setPrefWidth(110);
		tId.setLayoutX(72);
		tId.setLayoutY(30);

		tName = new TextField();
		tName.setPrefWidth(110);
		tName.setLayoutX(72);
		tName.setLayoutY(30);
		tName.setText(name);
		tName.setEditable(false);

		tKorean = new TextField();
		tKorean.setPrefWidth(110);
		tKorean.setLayoutX(72);
		tKorean.setLayoutY(69);

		tMath = new TextField();
		tMath.setPrefWidth(110);
		tMath.setLayoutX(72);
		tMath.setLayoutY(95);

		tEnglish = new TextField();
		tEnglish.setPrefWidth(110);
		tEnglish.setLayoutX(72);
		tEnglish.setLayoutY(128);

		Button btnUpdate = new Button("수정");
		btnUpdate.setLayoutX(85);
		btnUpdate.setLayoutY(184);

		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals(name)) {
						Student2 student = new Student2(Integer.parseInt(tId.getText()), name,
								Integer.parseInt(tKorean.getText()),
								Integer.parseInt(tMath.getText()),
								Integer.parseInt(tEnglish.getText()));
						list.set(i, student);
					}
					stage.close();
				}
			}

		});

		// 이름 기준으로 국어, 수학 , 영어 점수 화면에 입력
		for (Student2 stu : list) {
			if (stu.getName().equals(name)) {
				tKorean.setText(String.valueOf(stu.getKorean()));
				tMath.setText(String.valueOf(stu.getMath()));
				tEnglish.setText(String.valueOf(stu.getEnglish()));
			}
		}

		ap.getChildren().addAll(btnUpdate, tId, tName, tKorean, tMath, tEnglish, lId, lKorean, lMath, lEnglish);

		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.show();

	}

	private ObservableList<Student2> getStudentList() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr", passwd = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		String sql = "select * from school";
	
		list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student2 st = new Student2();
				String name = rs.getString("name");
				st.setName(name);
				st.setId(rs.getInt("id"));
				st.setKorean(rs.getInt("korean"));
				st.setMath(rs.getInt("math"));
				st.setEnglish(rs.getInt("english"));
				
//				Student2 st = new Student2(rs.getInt("id"),
//						rs.getString("name"), rs.getInt("korean"),
//						rs.getInt("math"), rs.getInt("english"));
//				list.add(st);
		}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 추가화면
	public void handleBtnAddAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd.getScene().getWindow());

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm2.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();

			// 추가화면의 컨트롤 사용하기
			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					TextField txtId = (TextField) parent.lookup("#txtId");
					TextField txtName = (TextField) parent.lookup("#txtName");
					TextField txtKorean = (TextField) parent.lookup("#txtKorean");
					TextField txtMath = (TextField) parent.lookup("#txtMath");
					TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
					Student2 student = new Student2(Integer.parseInt(txtId.getText()), txtName.getText(), Integer.parseInt(txtKorean.getText()),
							Integer.parseInt(txtMath.getText()), Integer.parseInt(txtEnglish.getText()));

					list.add(student);
					// 추가화면 닫기
					stage.close();
				}
			});
			// 추가화면에 있는 취소 버튼
			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e -> {
				TextField txtName = (TextField) parent.lookup("#txtName");
				TextField txtKorean = (TextField) parent.lookup("#txtKorean");
				TextField txtMath = (TextField) parent.lookup("#txtMath");
				TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");

				txtName.clear();
				txtKorean.clear();
				txtMath.clear();
				txtEnglish.clear();

			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
} // end of class
