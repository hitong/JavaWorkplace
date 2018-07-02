package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import version2.MainOfVersion2;

public class Version2Controller {
	@FXML
	Pane img1;
	
	@FXML
	Pane img2;
	
	@FXML
	Pane img3;
	
	@FXML
	Pane img4;
	
	@FXML
	TextField text;
	
	@FXML 
	Pane answer;
	
	MainOfVersion2 main;
	int[] pick = new int[4];
	List<Integer> all = new ArrayList<>(52);
	
	public void setMain(MainOfVersion2 main) {
		this.main = main;
	}
	
	@FXML
	private void initialize() {
		for (int i = 0; i < 52; i++) {
			all.add(i + 1);
		}
		img1.setPrefWidth(115);
		img1.setPrefHeight(115);
		img2.setPrefWidth(115);
		img2.setPrefHeight(115);
		img3.setPrefWidth(115);
		img3.setPrefHeight(115);
		img4.setPrefWidth(115);
		img4.setPrefHeight(115);
		Collections.shuffle(all);
		refresh();
	}

	@FXML
	public void refresh() {
		this.answer.getChildren().clear();
		this.text.setText("");
		Image[] image = new Image[4];
		ImageView[] imageView = new ImageView[4];
		Collections.shuffle(all);
//		int[] tmp = {3,4,7,5};
		for (int i = 0; i < 4; i++) {
			pick[i] = all.get(i);
//			pick[i] = tmp[i];
			image[i] = new Image("image/" + pick[i] + ".png", true);
			imageView[i] = new ImageView(image[i]);
		}
		this.img1.getChildren().add(imageView[0]);
		this.img2.getChildren().add(imageView[1]);
		this.img3.getChildren().add(imageView[2]);
		this.img4.getChildren().add(imageView[3]);
	}

	@FXML
	public void verify() {
		try {
			if (main.isTwetyFour(this.text.getText(), pick)) {
				main.showDiglog("Correct");
			} else {
				main.showDiglog("Incorrect result");
			}
		} catch (InputMismatchException | EmptyStackException e) {
			main.showDiglog("This numbers in the expression don't match the numbers in the set");
		}
	}
	
	@FXML
	public void showSolutions() {
		List<String> answer = main.getSolution(pick);
		this.answer.getChildren().clear();
		if(answer.size() == 0) {
			this.answer.getChildren().add(new Label("No Solution"));
			return;
		}
		for(String s: answer) {
			TextField l = new TextField(s);
			l.setBorder(null);
			l.setFont(new Font("",20));
			l.setDisable(false);
			this.answer.getChildren().add(l);
		}
		this.answer.getChildren().add(new Label("total:" +answer.size()));
	}
	
	@FXML
	public void modeSwitch() {
		main.showVersion2View2();
	}
	
	@FXML
	public void exit() {
		main.exit();
	}
}
