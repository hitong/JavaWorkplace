package view;

import java.util.ArrayList;
import java.util.List;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class NineTailController {
	@FXML
	Pane start;

	@FXML
	Pane solution;

	@FXML
	TextField text;

	Main main;

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	private void randomLayout() {
		this.start.getChildren().clear();
		int tmp = (int) (Math.random() * Integer.MAX_VALUE % util.NineTailModel.NUMBER_OF_NODES);
		main.start(tmp);
		showFirst(tmp);
	}
	
	/**
	 * 传入布局对应的数字编码
	 * @param tmp
	 */
	private void showFirst(int tmp) {
		this.text.setText(tmp + "");
		this.solution.getChildren().clear();
		List<Character[]> list = main.getSolutions();
		HBox hb = new HBox();
		Character[] ch = list.get(0);
		HBox t = new HBox();
		VBox v = new VBox();
		for (int j = 0; j < ch.length; j++) {
			if (j % util.NineTailModel.COL == 0 && !t.getChildren().isEmpty()) {
				v.getChildren().add(t);
				t = new HBox();
			} else {
			}
			Button l = new Button(ch[j] + "");
			l.setId(j + "");
			l.setOnAction(event -> {
				System.out.println(l.idProperty().getValue());
				if(l.getText().compareTo("H") == 0) {
					l.setText("T");
					ch[Integer.parseInt(l.idProperty().getValue())] = 'T';
				} else {
					l.setText("H");
					ch[Integer.parseInt(l.idProperty().getValue())] = 'H';
				}
				int index = util.NineTailModel.getIndex(ch);
				main.start(index);
				showFirst(index);
			});
			l.setMaxWidth(80);
			l.setMinWidth(80);
			l.setFont(new Font("", 30));
			t.getChildren().add(l);
		}
		v.getChildren().add(t);
		hb.getChildren().add(v);
		this.start.getChildren().add(hb);
	}

	/**
	 * 获取输入框的值从而更改布局
	 */
	@FXML
	private void manualLayout() {
		this.start.getChildren().clear();
		this.solution.getChildren().clear();
		int tmp;
		try {
			tmp =Integer.parseInt(text.getText());
			if (!main.start(tmp)) {
				return;
			}
		} catch (Exception ex) {
			return;
		}
		this.solution.getChildren().clear();
		showFirst(tmp);
	}

	@FXML
	private void startSolve() {
		List<Character[]> list = main.getSolutions();
		this.solution.getChildren().clear();
		if (list.size() <= 1) {
			Label l = new Label("No Solution");
			l.setMinWidth(60);
			l.setFont(new Font("", 50));
			this.solution.getChildren().add(l);
			return;
		} else if (text.getText().length() == 0) {
			return;
		}
		ArrayList<HBox> vb = new ArrayList<>();
		Character[] exp;
		for (int i = 0; i < list.size(); i++) {
			Character[] ch = list.get(i);
			if (i > 0) {
				exp = list.get(i - 1);
			} else {
				exp = list.get(0);
			}
			vb.add(new HBox());
			HBox t = new HBox();
			VBox v = new VBox();
			for (int j = 0; j < ch.length; j++) {
				if (j % util.NineTailModel.COL == 0 && !t.getChildren().isEmpty()) {
					v.getChildren().add(t);
					t = new HBox();
				} else {
				}
				Label l = new Label(ch[j] + "");
				l.setMinWidth(60);
				l.setFont(new Font("", 50));
				if (exp[j] != ch[j]) {
					l.setTextFill(Color.RED);
				}
				t.getChildren().add(l);
			}
			v.getChildren().add(t);
			vb.get(i).getChildren().add(v);
		}

		for (HBox h : vb) {
			this.solution.getChildren().add(h);
			Pane t = new Pane();
			t.setMinWidth(30);
			t.getChildren().add(new Line(5, 300, 5, 5));
			this.solution.getChildren().add(t);
		}
		this.solution.getChildren().remove(this.solution.getChildren().size() - 1);
	}

	@FXML
	private void startOver() {
		this.start.getChildren().clear();
		main.start(0);
		this.text.setText(0 + "");
		this.solution.getChildren().clear();
		showFirst(0);
	}
}
