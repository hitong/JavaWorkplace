package view;

import application.Main;
import javafx.fxml.FXML;

public class MainMenuController {
	private Main main;

	public void setMain(Main d) {
		this.main = d;
	}
	
	@FXML
	public void demo() {
		main.showDemo1();
	}
	
	@FXML
	public void practice() {
		main.showPractice();
	}
	
	@FXML
	public void exit() {
		main.exit();
	}
}
