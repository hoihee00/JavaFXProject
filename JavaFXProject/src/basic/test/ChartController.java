//package basic.test;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.PieChart;
//import javafx.scene.chart.XYChart;
//import javafx.scene.chart.PieChart.Data;
//
//public class ChartController implements Initializable{
//
//	@FXML
//	LineChart lineChart;
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		ObservableList<javafx.scene.chart.XYChart.Data> list = FXCollections.observableArrayList(
//				new LineChart.Data("1월", 10), new LineChart.Data("2월", 30),
//				new LineChart.Data("3월", 25), new LineChart.Data("4월", 35));		
//
//		lineChart.setData(list);
//	
//		
//		
//		XYChart.Series<String, Integer> s = new XYChart.Series<>();
//		s.setData(getSeries1());
//		s.setName("Monthly");
//		
//		lineChart.getData().add(s);
//		
//		
//		
//	}
//
//	public ObservableList<XYChart.Data<String, Integer>> getSeries1() {
//		ObservableList<XYChart.Data<String, Integer>> list =
//				FXCollections.observableArrayList();
//		list.add(new XYChart.Data<String, Integer>("5월", 5));
//		list.add(new XYChart.Data<String, Integer>("6월", 12));
//		list.add(new XYChart.Data<String, Integer>("7월", 15));
//		list.add(new XYChart.Data<String, Integer>("8월", 25));
//		return list;
//		
//	}
//	
//	
//} //end of class
