package WF;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.applet.Main;
import 动态分配.Depart;

public class Launch extends Application{
	Stage stage = null;
	ArrayList<Depart> list = new ArrayList<>();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.stage = primaryStage;
		showView();
	}
	
	
	public void showView(){
		FXMLLoader loder = new FXMLLoader();
		loder.setLocation(Main.class.getResource("/WF/View.fxml"));
		try {
			AnchorPane page =(AnchorPane)loder.load();
			Scene scene = new Scene(page);
			this.stage.setScene(scene);
			ViewControl c = (ViewControl)loder.getController();
			c.setMain(this);
			stage.setMaximized(true);
			stage.setTitle("最差分配");
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}
}
