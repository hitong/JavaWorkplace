package view;

import application.Main;
import javafx.fxml.FXML;

public class ProgramDemo {
	private Main main;

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void handleTerminal() {
		System.out.println("deCoding");
		main.showDemo1();
	}
	
	@FXML
	public void handleFile() {
		main.showDemo1();
	}

	@FXML
	public void handleExit() {
		main.showMainMenu();
	}
}
