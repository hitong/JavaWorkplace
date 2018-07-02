package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import list.MyLinkedList;
import list.MyList;
import listView.LinkedListController;

public class MainForLinked extends Application{
	private Stage primaryStage;
	private MyLinkedList<String> list;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		list = new MyLinkedList<>();
		this.showLinkedView();
	}
	
	public void showLinkedView() {
		try {
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(MainForLinked.class.getResource("../listView/LinkedListView.fxml"));
			AnchorPane page = (AnchorPane)fx.load();
			Scene s = new Scene(page);
			this.primaryStage.setScene(s);
			this.primaryStage.show();
			LinkedListController c = fx.getController();
			c.setMain(this);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
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
	
	public int getSize() {
		return list.size();
	}
	
	public int search(String s) {
		return list.indexOf(s);
	}
	
	public MyList<String> getList(){
		return list;
	}
	
	public void showInfor(String s) {
		Alert information = new Alert(Alert.AlertType.INFORMATION, s);
		information.setTitle("information");   
		information.setHeaderText("Information"); 

		Button infor = new Button("show Information");
		infor.setOnAction((ActionEvent)->{
		     information.showAndWait();
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
