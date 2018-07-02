package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Code;
import util.Huffman;
import view.Demo1Controller;
import view.MainMenuController;
import view.PracticeController;

public class Main extends Application {
	Stage primaryStage;
	ObservableList<Code> codeData = FXCollections.observableArrayList();
	public Huffman hfm;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		this.primaryStage.setFullScreen(false);
		Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
		showMainMenu();
	}

	public ObservableList<Code> inputByTerminal(String data, boolean isSave) {
		codeData.clear();
		hfm.inputByTerminal(data, isSave);
		codeData.addAll(hfm.getListOfCode());
		return codeData;
	}

	public ObservableList<Code> inputByFile() {
		codeData.clear();
		hfm.inputByFile("demo");
		codeData.addAll(hfm.getListOfCode());
		return codeData;
	}

	public ObservableList<Code> getCodeData() {
		return this.codeData;
	}

	public String getCompressCode() {
		return hfm.getCompressedCode();
	}

	public String getData() {
		return hfm.getData();
	}

	public void showMainMenu() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/MainMenu.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			scene.setFill(null);
			this.primaryStage.setScene(scene);
			this.primaryStage.centerOnScreen();
			this.primaryStage.setResizable(false);
			this.primaryStage.show();
			MainMenuController c = loader.getController();
			c.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showDemo1() {
		try {
			hfm = new Huffman();
			codeData.clear();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Demo1.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			this.primaryStage.setScene(scene);
			this.primaryStage.setX(this.primaryStage.getWidth() / 4);
			this.primaryStage.setY(this.primaryStage.getHeight() / 8);
			this.primaryStage.setResizable(true);
			Demo1Controller c = loader.getController();
			c.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getStage() {
		return this.primaryStage;
	}

	public void showPractice() {
		try {
			hfm = new Huffman();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Decoding.fxml"));
			BorderPane page = (BorderPane) loader.load();
			Scene scene = new Scene(page);
			scene.setFill(null);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			this.primaryStage.centerOnScreen();
			this.primaryStage.setResizable(false);
			PracticeController c = loader.getController();
			c.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeHuffmanCode() {
		hfm.writeHuffmanCodeToFile("demo");
	}

	public void printTreeToFile() {
		hfm.printTreeToFile("demo");
	}

	public void showDiglog(String s) {
		Alert information = new Alert(Alert.AlertType.INFORMATION, "Information");
		information.setTitle("information"); 
		information.setHeaderText("Information"); 
		information.setContentText(s);
		Button infor = new Button("show Information");
		infor.setOnAction((ActionEvent) -> {
			information.showAndWait();
		});
		information.show();
	}

	public void exit() {
		primaryStage.close();
	}

	public String readDataFromFile(String path) {
		hfm.readDateFromFile(path);
		return hfm.getData();
	}

	public String readCompressDataFromFile(String path) {
		hfm.readCompressDateFromFile(path);
		return hfm.getCompressedCode();
	}

	public boolean saveCompressDataToFile(String path) {
		return hfm.writeCompressDataToFile(path.substring(0, path.length() - 4));
	}

	public boolean saveDataToFile(String path) {
		return hfm.writeToFile(path.substring(0, path.length() - 3) + "txt");
	}

	public static void main(String[] args) {
		launch(args);
	}
}