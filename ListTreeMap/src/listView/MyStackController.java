package listView;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.MainForStack;

public class MyStackController {
	@FXML
	TextField value;

	@FXML
	Pane pane;

	private MainForStack main;

	public void setMain(MainForStack main) {
		this.main = main;
	}

	private void showStack() {
		VBox vb = new VBox();
		if (main.getSize() != 0) {
			for (int i = main.getSize() - 1; i >= 0; i--) {
				Label l = new Label(main.get(i));
				l.setMaxSize(100, 30);
				l.setMinSize(100, 30);
				l.setStyle("-fx-border-style: solid;");
				l.setAlignment(Pos.CENTER);
				vb.getChildren().add(l);
			}

			vb.setLayoutX(250);
			vb.setLayoutY(30);
			Text t = new Text("Top");
			t.setLayoutX(200);
			t.setLayoutY(50);
			Line line = new Line(225, 45, 250, 45);
			Line ltop = new Line(240, 40, 250, 40);
			Line lbt = new Line(240, 50, 250, 50);
			ltop.setRotate(30);
			lbt.setRotate(-30);
			this.pane.getChildren().clear();
			this.pane.getChildren().addAll(vb, t, line, ltop, lbt);
		} else {
			Text t = new Text("No Data");
			t.setFont(new Font(25));
			this.pane.getChildren().clear();
			this.pane.getChildren().add(t);
		}
	}

	@FXML
	public void push() {
		main.push(value.getText());
		showStack();
	}

	@FXML
	public void pop() {
		System.out.println("pop");
		try {
			main.pop();
		} catch (Exception ex) {
			main.showErr("No Data");
		}
		showStack();
	}
}
