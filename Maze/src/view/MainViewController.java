package view;

import java.util.List;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Path;
import util.MyButton;

public class MainViewController {
	private boolean isStart = false;
	@FXML
	Pane pane;

	@FXML
	Main main;

	public void showTable(int[][] table) {
		this.pane.getChildren().clear();
		VBox vb = new VBox();
		int row = 0;
		int col = 0;
		for (int[] x : table) {
			HBox hb = new HBox();
			row++;
			col = 0;
			for (int y : x) {
				col++;
				MyButton b = new MyButton(row, col);
				b.setMinWidth(45);
				b.setMinHeight(45);
				if (y == Integer.MIN_VALUE) {
					b.setStyle("-fx-background-color: #191970");
				} else {
					b.setStyle("-fx-background-color: #8B8682");
				}

				if (row == table.length && col == table[0].length) {
					b.setStyle("-fx-background-color: #FFEC8B");
				} else if (row == 1 && col == 1) {
					b.setStyle("-fx-background-color: #d6ed6e");
				} else {

				}
				hb.getChildren().add(b);
			}
			vb.getChildren().add(hb);
		}
		this.pane.getChildren().add(vb);
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void start() {
		if (isStart) {
			return;
		} else {
			isStart = true;
		}
		showPathForStart(main.getPath());
	}

	private void showPathForStart(List<Path.Location> path) {
		this.pane.getChildren().clear();
		int[][] table = main.getTable();
		VBox vb = new VBox();
		int a = 0;
		int c = 0;
		for (int[] x : table) {
			HBox hb = new HBox();
			c = 0;
			for (int y : x) {
				Button b = new Button();
				b.setMinWidth(45);
				b.setMinHeight(45);
				if (y == Integer.MIN_VALUE) {
					b.setStyle("-fx-background-color: #191970");
				} else if (y == -1) {
					for (int i = 0; i < path.size(); i++) {
						if (path.get(i).inTheLocation(a, c)) {
							b.setGraphic(checkImg(path.get(i).getDirection()));
							break;
						} else {
						}
					}
				} else if (y == Integer.MIN_VALUE / 2) {
					b.setStyle("-fx-background-color: #FA8072");
				} else {
					if (a == table.length - 1 && c == table[0].length - 1) {
						b.setStyle("-fx-background-color: #FFEC8B");
					} else {

						b.setStyle("-fx-background-color: #8B8682");
					}
				}
				c++;
				hb.getChildren().add(b);
			}
			a++;
			vb.getChildren().add(hb);
		}
		this.pane.getChildren().add(vb);
	}

	private ImageView checkImg(int direction) {
		Image imageDecline;
		switch (direction) {
		case 0:
			imageDecline = new Image(getClass().getResourceAsStream("../image/images.jpg"));
			break;
		case Path.TOP:
			imageDecline = new Image(getClass().getResourceAsStream("../image/top.png"));
			break;
		case Path.RIGHT:
			imageDecline = new Image(getClass().getResourceAsStream("../image/right.png"));
			break;
		case Path.BOTTOM:
			imageDecline = new Image(getClass().getResourceAsStream("../image/buttom.png"));
			break;
		case Path.LEFT:
			imageDecline = new Image(getClass().getResourceAsStream("../image/left.png"));
			break;
		default:
			imageDecline = new Image(getClass().getResourceAsStream("../image/left.png"));
		}
		ImageView img = new ImageView(imageDecline);
		img.setFitWidth(25);
		img.setFitHeight(25);
		return img;
	}

	@SuppressWarnings("unused")
	private void showChangePath(List<Path.Location> path) {
		this.pane.getChildren().clear();
		int[][] table = main.getTable();
		VBox vb = new VBox();
		int a = 0;
		int c = 0;
		for (int[] x : table) {
			HBox hb = new HBox();
			c = 0;
			for (int y : x) {
				Button b = new Button();
				b.setMinWidth(45);
				b.setMinHeight(45);
				if (y == Integer.MIN_VALUE) {
					b.setStyle("-fx-background-color: #191970");
				} else {
					boolean flag = false;
					for (int i = 0; i < path.size(); i++) {
						if (path.get(i).inTheLocation(a, c)) {
							b.setGraphic(checkImg(path.get(i).getDirection()));
							flag = true;
							break;
						} else {
						}
					}
					if (!flag) {
						b.setStyle("-fx-background-color: #8B8682");
					}
				}
				c++;
				hb.getChildren().add(b);
			}
			a++;
			vb.getChildren().add(hb);
		}
		this.pane.getChildren().add(vb);
	}

	@FXML
	public void changePath() {
		try {
			List<Path.Location> d = main.changePath();
			showChangePath(d);
		} catch (NullPointerException ex) {
		}
	}

	@FXML
	public void reStart() {
		isStart = false;
		this.showTable(main.reSet());
	}

	@FXML
	public void model() {
		main.showView();
	}

	@FXML
	public void exit() {
		main.exit();
	}
}
