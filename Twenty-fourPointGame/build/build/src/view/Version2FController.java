package view;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import version2.MainOfVersion2;

public class Version2FController {
	@FXML
	TextField text1;

	@FXML
	TextField text2;

	@FXML
	TextField text3;

	@FXML
	TextField text4;

	@FXML
	Pane solutions;

	MainOfVersion2 main;

	public void setMain(MainOfVersion2 main) {
		this.main = main;
	}

	@FXML
	public void findSolutions() {
		int[] input = new int[4];
		try {
			input[0] = Integer.parseInt(this.text1.getText());
			input[1] = Integer.parseInt(this.text2.getText());
			input[2] = Integer.parseInt(this.text3.getText());
			input[3] = Integer.parseInt(this.text4.getText());
		}
		catch(Exception ex) {
			main.showDiglog("Please Check The Input");
			return;
		}
		for(int i = 0 ; i < 4; i++) {
			if(input[i] <= 0 || input[i] > 13) {
				main.showDiglog("Please Check The Input");
				return;
			}
		}
		
		List<String> answer = main.getSolution(input);
		this.solutions.getChildren().clear();
		if(answer.size() == 0) {
			this.solutions.getChildren().add(new Label("No Solution"));
			return;
		}
		for(String s: answer) {
			TextField l = new TextField(s);
			l.setBorder(null);
			l.setFont(new Font("",20));
			l.setDisable(false);
			this.solutions.getChildren().add(l);
		}
		this.solutions.getChildren().add(new Label("total:" +answer.size()));
	}

	@FXML
	public void back() {
		main.showVersion2View();
	}

	@FXML
	public void typed() {
		if (text1.getText().length() > 0 && text1.getText().length() < 3) {
			try {
				Integer.parseInt(text1.getText());
			} catch (Exception ex) {
				main.showDiglog("InputErr");
				text1.setText("");
			}
		} else if (text1.getText().length() == 0)
			return;
		else {
			main.showDiglog("Please input 1 - 13");
			text1.setText("");

		}

		if (text2.getText().length() > 0 && text2.getText().length() < 3) {
			try {
				Integer.parseInt(text2.getText());
			} catch (Exception ex) {
				main.showDiglog("InputErr");
				text2.setText("");
			}
		} else if (text2.getText().length() == 0)
			return;
		else {
			main.showDiglog("Please input 1 - 13");
			text2.setText("");
		}

		if (text3.getText().length() > 0 && text3.getText().length() < 3) {
			try {
				Integer.parseInt(text3.getText());
			} catch (Exception ex) {
				main.showDiglog("InputErr");
				text3.setText("");
			}
		} else if (text3.getText().length() == 0)
			return;
		else {
			main.showDiglog("Please input 1 - 13");
			text3.setText("");
		}

		if (text4.getText().length() == 1 || text4.getText().length() == 2) {
			try {
				Integer.parseInt(text4.getText());
			} catch (Exception ex) {
				main.showDiglog("InputErr");
				text4.setText("");
			}
		} else if (text4.getText().length() == 0)
			return;
		else {
			main.showDiglog("Please input 1 - 13");
			text4.setText("");
		}
	}
}
