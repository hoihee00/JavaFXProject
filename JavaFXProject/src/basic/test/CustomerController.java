package basic.test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import basic.example.Student;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerController implements Initializable {

	@FXML
	TableView<Customer> tableView;

	@FXML
	Button btnAdd, btnClose;

	ObservableList<Customer> list;

	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Customer, ?> tc = tableView.getColumns().get(0); // 첫번째 칼럼
		tc.setCellValueFactory(new PropertyValueFactory<>("id"));

		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));

		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("phone"));

		tc = tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("email"));

		list = FXCollections.observableArrayList();
		tableView.setItems(list);

		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				handleBtnAddAction();
			}

			public void handleBtnAddAction() {
				Stage stage = new Stage(StageStyle.UTILITY);
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(btnAdd.getScene().getWindow());

				try {
					Parent parent = FXMLLoader.load(getClass().getResource("CustomerAdd.fxml"));
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
							TextField txtPhone = (TextField) parent.lookup("#txtPhone");
							TextField txtEmail = (TextField) parent.lookup("#txtEmail");
							Customer customer= new Customer(Integer.parseInt(txtId.getText()), txtName.getText(), txtPhone.getText(), txtEmail.getText());
							list.add(customer);
							// 추가화면 닫기
							stage.close();
						}

					});

					// 추가화면에 있는 취소 버튼
					Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
					btnFormCancel.setOnAction(e -> {
						TextField txtId = (TextField) parent.lookup("#txtId");
						TextField txtName = (TextField) parent.lookup("#txtName");
						TextField txtPhone = (TextField) parent.lookup("#txtPhone");
						TextField txtEmail = (TextField) parent.lookup("#txtEmail");

						txtId.clear();
						txtName.clear();
						txtPhone.clear();
						txtEmail.clear();

					});

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

	}

}
