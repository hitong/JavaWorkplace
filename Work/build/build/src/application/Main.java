package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.AlterController;
import view.ViewControl;
import work.IORecord;
import work.Init;
import work.Model;

public class Main extends Application {
	ObservableList<Model> codeData = FXCollections.observableArrayList();
	ArrayList<Model> saveDataFromFile = new ArrayList<Model>();
	String searchType = "全局搜索";
	Stage primaryStage;
	Stage stage;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			startView(primaryStage);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startView(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/StartView.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Scene scene = new Scene(page);
		primaryStage.setScene(scene);
		primaryStage.show();
		ViewControl c = (ViewControl) loader.getController();
		this.codeData = IORecord.getRecoding(codeData);
		saveDataFromFile.addAll(codeData);
		c.setMain(this);
	}

	public ObservableList<Model> getData() {
		return this.codeData;
	}

	public void showSearch(String searchContext) {
		if (searchContext == null || searchContext.trim().equals("")) {
			codeData.clear();
			codeData.addAll(saveDataFromFile);
		} else {
			ArrayList<Model> tmp = null;
			switch (searchType) {
			case "全局搜索":
				tmp = work.Search.search(saveDataFromFile, searchContext, new int[] { 0, 1, 2, 3, 4, 5 });
				break;
			case "发件人":
				tmp = work.Search.search(saveDataFromFile, searchContext, new int[] { 5 });
				break;
			case "发布日期":
				tmp = work.Search.search(saveDataFromFile, searchContext, new int[] { 3 });
				break;
			case "出台部门":
				tmp = work.Search.search(saveDataFromFile, searchContext, new int[] { 4 });
				break;
			case "所属文件":
				tmp = work.Search.search(saveDataFromFile, searchContext, new int[] { 2 });
				break;
			case "所属条文":
				tmp = work.Search.search(saveDataFromFile, searchContext, new int[] { 1 });
				break;
			case "主要内容":
				tmp = work.Search.search(saveDataFromFile, searchContext, new int[] { 0 });
				break;
			default:break;
			}
			codeData.clear();
			codeData.addAll(tmp);
		}
	}
	
	public void setSearchType(String change){
		this.searchType = change;
	}

	public void showAlter(Init init) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/Alter.fxml"));
		GridPane page;
		try {
			page = (GridPane) loader.load();
			AlterController al = loader.getController();
			al.setMain(this,init);
			Scene scene = new Scene(page);
			stage = new Stage();
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeAlter() {
		stage.close();
	}

	public void addMessage(Model model) {
		if (model.isUsed())
			saveDataFromFile.add(model);
		showSearch("");
		IORecord.writeFile(saveDataFromFile);
		stage.close();
	}

	public void changeMessage(Model model, Model model2) {
		saveDataFromFile.set(saveDataFromFile.indexOf(model), model2);
		codeData.clear();
		codeData.addAll(saveDataFromFile);
		IORecord.writeFile(saveDataFromFile);
	}

	public void delMessage(Model model) {
		saveDataFromFile.remove(model);
		IORecord.writeFile(saveDataFromFile);
		codeData.clear();
		codeData.addAll(saveDataFromFile);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
