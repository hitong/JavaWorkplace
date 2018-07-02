package mapView;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import main.MainForMap;
import map.Vertex;
import map.WeightedEdge;

public class MapController {
	@FXML
	Pane pane;

	@FXML
	TextField start;

	@FXML
	TextField end;

	@FXML
	TextField weight;

	@FXML
	TextField vertexName;

	@FXML
	TextField x;

	@FXML
	TextField y;

	@FXML
	TextField pre;

	@FXML
	TextField last;

	private MainForMap main;

	public void setMain(MainForMap main) {
		this.main = main;
	}

	private void clean() {
		// this.end.setText(null);
		// this.start.setText(null);
		// this.x.setText(null);
		// this.y.setText(null);
		// this.pre.setText(null);
		// this.last.setText(null);
		// this.vertexName.setText(null);
		// this.weight.setText(null);
	}

	private void show() {
		List<Vertex> vertexs = main.getMap().getVertexs();
		List<WeightedEdge> edges = main.getMap().getEdge();
		pane.getChildren().clear();
		for (int i = 0; i < vertexs.size(); i++) {
			Shape shape = new Circle(10);
			Label label = new Label(vertexs.get(i).toString());
			int x = vertexs.get(i).getX() + 10;
			int y = vertexs.get(i).getY() + 20;
			label.setLayoutX(x - 10);
			label.setLayoutY(y - 20);
			shape.setLayoutX(x);
			shape.setLayoutY(y + 10);
			Label index = new Label(i + "");
			index.setLayoutX(x - 5);
			index.setLayoutY(y);
			shape.setStroke(Color.BLACK);
			shape.setFill(null);
			shape.setStyle("-fx-border-style: solid;");
			pane.getChildren().addAll(index, shape, label);
		}
		for (int j = 0; j < edges.size(); j++) {
			map.Location location = edges.get(j).getLocation();
			int x1 = location.getX1() + 10;
			int y1 = location.getY1() + 20;
			int x2 = location.getX2() + 10;
			int y2 = location.getY2() + 20;
			Line line = new Line(x1, y1 + 10, x2, y2 + 10);
			line.setSmooth(true);
			Label weight = new Label(edges.get(j).weight + "");
			weight.setLayoutX((x1 + x2) / 2);
			weight.setLayoutY((y1 + y2) / 2);
			pane.getChildren().addAll(weight, line);
		}
	}

	@FXML
	public void addVertex() {
		String name = this.vertexName.getText();
		int x = Integer.parseInt(this.x.getText());
		int y = Integer.parseInt(this.y.getText());
		main.addVertex(name, x, y);
		show();
		clean();
	}

	@FXML
	public void addEdge() {
		int pre = Integer.parseInt(this.pre.getText());
		int last = Integer.parseInt(this.last.getText());
		if (pre == last) {
			return;
		}
		int weight = Integer.parseInt(this.weight.getText());
		main.addEdge(pre, last, weight);
		main.addEdge(last, pre, weight);
		show();
		clean();
	}

	@FXML
	public void showDFSTree() {
		try {
			show();
			for (int i = 0; i < main.getMap().getVertexs().size(); i++) {
				int tmp = main.getMap().getDFS(Integer.parseInt(start.getText())).getParent(i);
				if (tmp != -1) {
					WeightedEdge edge = main.getMap().getEdge(i, tmp);
					int x1 = edge.getLocation().getX1() + 10;
					int x2 = edge.getLocation().getX2() + 10;
					int y1 = edge.getLocation().getY1() + 20;
					int y2 = edge.getLocation().getY2() + 20;
					Line line = new Line(x1, y1, x2, y2);
					line.setStroke(Color.RED);
					line.setSmooth(true);
					this.pane.getChildren().add(line);
				}
			}
			clean();
		} catch (Exception ex) {

		}
	}

	@FXML
	public void showBFSTree() {
		try {
			show();
			for (int i = 0; i < main.getMap().getVertexs().size(); i++) {
				int tmp = main.getMap().getBFS(Integer.parseInt(start.getText())).getParent(i);
				if (tmp != -1) {
					WeightedEdge edge = main.getMap().getEdge(i, tmp);
					int x1 = edge.getLocation().getX1() + 10;
					int x2 = edge.getLocation().getX2() + 10;
					int y1 = edge.getLocation().getY1() + 20;
					int y2 = edge.getLocation().getY2() + 20;
					Line line = new Line(x1, y1, x2, y2);
					line.setStroke(Color.RED);
					line.setSmooth(true);
					this.pane.getChildren().add(line);
				}
			}
			clean();
		} catch (Exception ex) {

		}
	}

	@FXML
	public void showSP() {
		try {
			show();
			for (int i = 0; i < main.getMap().getVertexs().size(); i++) {
				int tmp = main.getMap().getMST(Integer.parseInt(start.getText())).getParent(i);
				if (tmp != -1) {
					WeightedEdge edge = main.getMap().getEdge(i, tmp);
					int x1 = edge.getLocation().getX1() + 10;
					int x2 = edge.getLocation().getX2() + 10;
					int y1 = edge.getLocation().getY1() + 20;
					int y2 = edge.getLocation().getY2() + 20;
					Line line = new Line(x1, y1, x2, y2);
					line.setStroke(Color.RED);
					line.setSmooth(true);
					this.pane.getChildren().add(line);
				}
			}
			clean();
		} catch (Exception ex) {
		}
	}
}
