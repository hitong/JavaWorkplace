package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import list.MyArrayList;
import list.MyList;
import listView.ArrayListController;

public class MainForArr extends Application{
	Stage primaryStage;
	MyArrayList<String> list;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		showArrView();
	}
	
	public void showArrView() {
		try {
			list = new MyArrayList<>();
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(MainForArr.class.getResource("../listView/ArrayListView.fxml"));
			AnchorPane page = (AnchorPane)fx.load();
			Scene s = new Scene(page);
			this.primaryStage.setScene(s);
			this.primaryStage.show();
			ArrayListController c = fx.getController();
			c.setMain(this);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void trimToSize() {
		list.trimToSize();
	}
	
	public MyList<String> getList(){
		return this.list;
	}
	
	public int getRealSize() {
		return list.getRealSize();
	}
	
	public void insert(String s, int index) {
		list.add(index, s);
	}
	
	public void delete(int index) {
		list.remove(index);
	}
	
	public void delete(String s) {
		list.remove(s);
	}
	
	public int search(String s) {
		return list.indexOf(s);
	}
	
	public void showInfor(String s) {
		Alert information = new Alert(Alert.AlertType.INFORMATION, s);
		information.setTitle("information");         //设置标题，不设置默认标题为本地语言的information
		information.setHeaderText("Information");    //设置头标题，默认标题为本地语言的information

		Button infor = new Button("show Information");
		infor.setOnAction((ActionEvent)->{
		     information.showAndWait();   //显示弹窗，同时后续代码等挂起
		}) ;
		information.show();
	}
	
	public void showErr(String s) {
		Alert warning = new Alert(Alert.AlertType.WARNING, s);
		warning.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
