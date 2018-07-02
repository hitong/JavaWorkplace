package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import list.MyQueue;
import listView.MyQueueController;

public class MainForQueue extends Application {
	private Stage primaryStage;
	private MyQueue<String> queue;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		queue = new MyQueue<>();
		this.showQueueView();
	}

	public void showQueueView() {
		try {
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(MainForQueue.class.getResource("../listView/MyQueueView.fxml"));
			AnchorPane page = (AnchorPane) fx.load();
			Scene s = new Scene(page);
			this.primaryStage.setScene(s);
			this.primaryStage.show();
			MyQueueController c = fx.getController();
			c.setMain(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String get(int index) {
		return queue.get(index);
	}

	public void enqueue(String s) {
		queue.enqueue(s);
	}
	
	public String deQueue()	{
		return queue.deQueue();
	}

	public int getSize() {
		return queue.getSize();
	}

	public MyQueue<String> getQueue() {
		return queue;
	}

	public void showErr(String s) {
		Alert warning = new Alert(Alert.AlertType.WARNING, s);
		warning.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
