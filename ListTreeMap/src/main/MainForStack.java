package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import list.MyStack;
import listView.MyStackController;

public class MainForStack extends Application {
	private Stage primaryStage;
	private MyStack<String> stack;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		stack = new MyStack<>();
		this.showStackView();
	}

	public void showStackView() {
		try {
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(MainForStack.class.getResource("../listView/MyStackView.fxml"));
			AnchorPane page = (AnchorPane) fx.load();
			Scene s = new Scene(page);
			this.primaryStage.setScene(s);
			this.primaryStage.show();
			MyStackController c = fx.getController();
			c.setMain(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String get(int index) {
		return stack.get(index);
	}

	public void push(String s) {
		stack.push(s);
	}
	
	public String pop()	{
		return stack.pop();
	}

	public int getSize() {
		return stack.getSize();
	}

	public MyStack<String> getStack() {
		return stack;
	}

	public void showErr(String s) {
		Alert warning = new Alert(Alert.AlertType.WARNING, s);
		warning.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
