package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import map.MyMap;
import map.Vertex;
import map.WeightedEdge;
import mapView.MapController;

public class MainForMap extends Application {
	private Stage primaryStage;
	private MyMap map;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		map = new MyMap();
		this.primaryStage.setTitle("Map");
		this.showMap();
	}

	public void showMap() {
		try {
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(MainForMap.class.getResource("../mapView/MapView.fxml"));
			BorderPane bp = fx.load();
			Scene sc = new Scene(bp);
			this.primaryStage.setScene(sc);
			this.primaryStage.show();
			MapController c = fx.getController();
			c.setMain(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public MyMap getMap(){
		return map;
	}

	public void addVertex(String name, int x, int y) {
		map.addVertex(new Vertex(name, x, y));
	}
	
	public void addEdge(int u, int v, int weight) {
		map.addEdge(new WeightedEdge(u,v,weight));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
