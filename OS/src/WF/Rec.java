package WF;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Rec {
	public static StackPane getRec(int longth,int state,int id){
		return Rec.getRec(longth, 200,state,id);
	}
	
	public static StackPane getRec(int longth,double width, int state,int id){
		StackPane stackPane = new StackPane();
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(width);
		rectangle.setHeight(longth * 20);
		if(state == 0){
			rectangle.setFill(Color.GREEN);
			rectangle.setStroke(Color.BLACK);
		} else {
			rectangle.setFill(Color.RED);
			rectangle.setStroke(Color.BLACK);
		}
		stackPane.getChildren().add(rectangle);
		stackPane.getChildren().add(new Text(longth + ""));
		stackPane.setId(id + "");
		return stackPane;
	}
}
