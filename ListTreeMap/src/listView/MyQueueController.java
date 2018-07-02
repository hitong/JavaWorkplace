package listView;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.MainForQueue;

public class MyQueueController {
	@FXML
	TextField value;

	@FXML
	Pane pane;

	private MainForQueue main;

	public void setMain(MainForQueue main) {
		this.main = main;
		showQueue();
	}

	private void showQueue() {
		HBox hb = new HBox();
		if (main.getSize() != 0) {
			for (int i = 0; i < main.getSize(); i++) {
				Label l = new Label(main.get(i));
				l.setMaxSize(100, 30);
				l.setMinSize(100, 30);
				l.setStyle("-fx-border-style: solid;");
				l.setAlignment(Pos.CENTER);
				hb.getChildren().add(l);
			}

			hb.setLayoutX(40);
			hb.setLayoutY(150);
			Text head = new Text("head");
			head.setFont(new Font(15));
			head.setLayoutX(40 - 20);
			head.setLayoutY(85);
			Line headLine = new Line(40 + 100 / 2, 150, 40, 89);
			Line thl1 = new Line(40 + 100 / 2, 145, 40 + 100 / 2 - 20, 145);
			thl1.setRotate(24);
			Line thl2 = new Line(40 + 100 / 2 + 10, 140, 40 + 100 / 2 - 10, 140);
			thl2.setRotate(95);

			Text tail = new Text("tail");
			tail.setFont(new Font(15));
			tail.setLayoutX(100 * (main.getSize()) + 45);
			tail.setLayoutY(85);
			Line tailLine = new Line(100 * (main.getSize() - 1) + 90 , 150, 100 * (main.getSize()) + 50, 89);
			Line ttl1 = new Line(100 * (main.getSize()) + 10, 145, 100 * (main.getSize()) - 10, 145);
			ttl1.setRotate(156);
			Line ttl2 = new Line(100 * (main.getSize()) - 20, 140, 100 * (main.getSize()), 140);
			ttl2.setRotate(95);
//			pane.getChildren().addAll(head, headLine, thl1, thl2, tail, tailLine, ttl1, ttl2);
			this.pane.getChildren().clear();
			this.pane.getChildren().addAll(hb, headLine, thl1, thl2, head, tail, ttl1, ttl2, tailLine);
		} else {
			Label l = new Label("No Data");
			l.setFont(new Font(30));
			this.pane.getChildren().clear();
			pane.getChildren().add(l);
		}
	}

	@FXML
	public void enqueue() {
		main.enqueue(value.getText());
		showQueue();
	}

	@FXML
	public void dequeue() {
		try {
			main.deQueue();
		} catch (Exception ex) {
			main.showErr("No Data");
		}
		showQueue();
	}
}
