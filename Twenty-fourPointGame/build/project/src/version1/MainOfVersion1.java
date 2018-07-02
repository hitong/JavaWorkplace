package version1;

import java.io.IOException;
import java.util.InputMismatchException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.InfixTurnSuffix;
import view.Version1Controller;

public class MainOfVersion1 extends Application {
	Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		this.primaryStage.setFullScreen(false);
		this.primaryStage.setResizable(false);
		this.showVersion1View();
	}

	public void showVersion1View() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainOfVersion1.class.getResource("../view/version1View.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			this.primaryStage.setScene(scene);
			this.primaryStage.setTitle("24点游戏");
			this.primaryStage.show();
			Version1Controller c = loader.getController();
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
			information.showAndWait(); // 显示弹窗，同时后续代码等挂起
		});
		information.show();
	}

	public void exit() {
		this.primaryStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}