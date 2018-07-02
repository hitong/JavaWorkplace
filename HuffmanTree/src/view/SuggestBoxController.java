package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SuggestBoxController {
	private Stage stage;
	
	@FXML
	private Label title;
	
	@FXML
	private TextArea data;
	
	@FXML
	private TextArea code;

	public void init(Main main) {
		this.data.setText(main.getData());
		this.code.setText(main.getCompressCode());
		this.code.setEditable(false);
		this.data.setEditable(false);
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	public void onClick() {
		stage.close();
	}
}
