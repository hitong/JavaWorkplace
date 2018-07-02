package version2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Count24;
import util.InfixTurnSuffix;
import view.Version2Controller;
import view.Version2FController;

public class MainOfVersion2 extends Application {
	Stage primaryStage;
	Count24 count24;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		count24 = new Count24();
		this.primaryStage = primaryStage;
		this.primaryStage.setFullScreen(false);
		this.primaryStage.setResizable(false);
		this.showVersion2View();
	}

	public void showVersion2View() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainOfVersion2.class.getResource("/view/version2View.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			this.primaryStage.setScene(scene);
			this.primaryStage.setTitle("24点游戏");
			this.primaryStage.show();
			Version2Controller c = loader.getController();
			c.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showVersion2View2() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainOfVersion2.class.getResource("/view/Version2View2.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			this.primaryStage.setScene(scene);
			this.primaryStage.setTitle("24点游戏");
			this.primaryStage.show();
			Version2FController c = loader.getController();
			c.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isTwetyFour(String s, int[] pick) throws InputMismatchException {
		return InfixTurnSuffix.compute(s, pick);
	}

	public void showDiglog(String s) {
		Alert information = new Alert(Alert.AlertType.INFORMATION, "Welocme to JavaFX");
		information.setTitle("information"); // 设置标题，不设置默认标题为本地语言的information
		information.setHeaderText("Information"); // 设置头标题，默认标题为本地语言的information
		information.setContentText(s);
		Button infor = new Button("show Information");
		infor.setOnAction((ActionEvent) -> {
			information.showAndWait(); 
		});
		information.show();
	}

	public List<String> getSolution(int[] pick){
		try {
			return this.count24.getSolutions(pick);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void exit() {
		this.primaryStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}