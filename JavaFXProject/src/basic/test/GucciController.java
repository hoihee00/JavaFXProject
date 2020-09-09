package basic.test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GucciController implements Initializable {

	@FXML
	Button btnProduct, btnCustomer, btnChart, btnClose, btnChartClose;

	ObservableList<Customer> list;

	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// product 버튼
//		btnProduct.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				HandleBtnProductAction();
//			}
//		});
//
		// customer 버튼
		btnCustomer.setOnAction(e -> HandleBtnCustomerAction());

		// 매출 분석 chart 버튼
		btnChart.setOnAction(e -> HandleBtnChartAction());
		
		btnClose.setOnAction(e -> HandleBtnCloseAction());

//		btnChartClose.setOnAction(e -> HandleBtnChartCloseAction());
		
	}
	
	

	// 고객관리 화면 (customer)
	public void HandleBtnCustomerAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnCustomer.getScene().getWindow());
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("Customer.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // end of HandleBtnCustomerAction
	

	// 매출 분석 chart 화면
	public void HandleBtnChartAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);

		try {
			Parent chart = FXMLLoader.load(getClass().getResource("SalesChart.fxml"));
			Scene scene = new Scene(chart);

			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		stage.close(); // chart 화면 닫기
	} // end of HandleBtnChartAction

	
	
	// 닫기 버튼 동작
	public void HandleBtnCloseAction() {
		Platform.exit();
	}


} // end of class
