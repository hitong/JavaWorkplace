package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tree.BinaryTree;
import treeView.TreeController;

public class MainForTree extends Application{
	Stage primaryStage;
	BinaryTree<String> tree;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		showArrView();
	}
	
	public void showArrView() {
		try {
			tree = new BinaryTree<>();
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(MainForTree.class.getResource("../treeView/TreeView.fxml"));
			AnchorPane page = (AnchorPane)fx.load();
			Scene s = new Scene(page);
			this.primaryStage.setScene(s);
			this.primaryStage.show();
			TreeController c = fx.getController();
			c.setMain(this);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public BinaryTree<String> getTree(){
		return tree;
	}
	
	public int getTreeWidth() {
		return tree.getWidth();
	}
	
	public void insert(String s) {
		tree.insert(s);
	}

	public void delete(String s) {
		tree.delete(s);
	}
	
	public boolean search(String s) {
		return tree.search(s);
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
