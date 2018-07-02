package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.NineTailModel;
import view.NineTailController;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	Stage primaryStage;
	NineTailModel nineTailModel;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		nineTailModel = new NineTailModel();
		this.primaryStage = primaryStage;
		this.primaryStage.setResizable(false);
		Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
		showNineTail();
	}

	List<Character[]> solutions;

	public boolean start(int t) {
		if (t > util.NineTailModel.NUMBER_OF_NODES) {
			return false;
		}
		List<Integer> path = this.nineTailModel.getShortestPath(t);
		List<Character[]> list = new ArrayList<>(path.size());
		for (int i = 0; i < path.size(); i++) {
			list.add(NineTailModel.getNode2(path.get(i).intValue()));
		}
		this.solutions = list;
		return true;
	}

	public List<Character[]> getSolutions() {
		return solutions;
	}

	public void showNineTail() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/NineTail.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			NineTailController c = loader.getController();
			c.setMain(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
