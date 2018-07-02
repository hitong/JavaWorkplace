package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Path;
import model.Path.Location;
import view.MainViewController;
import view.ViewController;

public class Main extends Application {
	Stage primaryStage;
	private int[][] table = new int[17][21];//初始迷宫大小为 17 * 21
	private ArrayList<ArrayList<Location>> allPath;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setWidth(1200);
		this.primaryStage.setHeight(800);
		showMainView();
	}

	public void setTable(int[][] table) {
		this.table = table;
	}

	public int[][] getTable() {
		return table;
	}
	
	public int[][] reSet() {
		return Path.reSet(table);
	}
	
	public LinkedList<Path.Location> getPath(){
		findAllPath();
		return Path.getPath(table);
	}

	public void showView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/View.fxml"));
			BorderPane page = (BorderPane) loader.load();
			Scene scene = new Scene(page);
			this.primaryStage.setScene(scene);
			ViewController c = loader.getController();
			c.setMain(this);
			c.setTable(table);
			this.reSet();
			c.showTable(table);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showMainView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/MainView.fxml"));
			BorderPane page = (BorderPane) loader.load();
			Scene scene = new Scene(page);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();	
			MainViewController c = loader.getController();
			c.setMain(this);
			this.reSet();
			c.showTable(table);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void writeToFile(int[][] table) {
		try(DataOutputStream out = new DataOutputStream(
				new FileOutputStream("mazeData.dat"))){
			out.writeInt(table.length);
			out.writeInt(table[0].length);
			for(int i = 0; i < table.length; i++) {
				for(int j = 0; j < table[0].length; j++) {
					if(table[i][j] == Integer.MIN_VALUE) {
						out.writeInt(table[i][j]);
					}
					else {
						out.writeInt(0);
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int[][] readFromFile() {
		try(DataInputStream in = new DataInputStream(
				new FileInputStream("mazeData.dat"))){
			int col = in.readInt();
			int row = in.readInt();
			table = new int[col][row];
			for(int i = 0; i <col; i++) {
				for(int j = 0; j < row; j++) {
					table[i][j] = in.readInt();
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return table;
	}

	public void exit() {
		System.out.println("close");
		this.primaryStage.close();
	}
	
	private void findAllPath() {
		if(table[0].length <= 9 && table.length <= 9) {
			this.allPath = Path.findAllPath(table);
		}
	}
	
	public ArrayList<Location> changePath(){
		int tmp = (int)(Math.random() * Integer.MAX_VALUE) % allPath.size();		
		return allPath.get(tmp);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
