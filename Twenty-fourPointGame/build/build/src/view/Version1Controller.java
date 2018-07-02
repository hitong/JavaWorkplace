package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import version1.MainOfVersion1;

public class Version1Controller {
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

	MainOfVersion1 main;
	int[] pick = new int[4];
	List<Integer> all = new ArrayList<>(52);

	public void setMain(MainOfVersion1 main) {
		this.main = main;
	}

	@FXML
	private void initialize() {
		for (int i = 0; i < 52; i++) {
			all.add(i + 1);
		}
		Collections.shuffle(all);
		refresh();
	}

	@FXML
	public void refresh() {
		Image[] image = new Image[4];
		ImageView[] imageView = new ImageView[4];
		Collections.shuffle(all);
//		int[] tmp = {4,4,4,4};
		for (int i = 0; i < 4; i++) {
			pick[i] = all.get(i);
//			pick[i] = tmp[i];
			image[i] = new Image("image/" + pick[i] + ".png", true);
			imageView[i] = new ImageView(image[i]);
			imageView[i].setFitWidth(144);
			imageView[i].setFitHeight(192);
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
//			e.printStackTrace();
			main.showDiglog("This numbers in the expression don't match the numbers in the set");
		}
	}
}
