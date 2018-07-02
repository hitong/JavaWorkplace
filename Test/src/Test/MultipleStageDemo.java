package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class MultipleStageDemo extends Application{
	public void start(Stage primaryStage){
		Scene scene = new Scene(new Button("ok"), 200, 250);
		primaryStage.setTitle("ss");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Stage stage = new Stage();
		stage.setTitle("Second");
		
		stage.setScene(new Scene(new Button("123"), 500 , 500));
		stage.show();		
	}
	
	public static void main(String[] args){
		Application.launch();
	}
}
