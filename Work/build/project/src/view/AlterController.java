package view;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import work.Init;
import work.Model;

public class AlterController implements Initializable {
	@FXML
	private TextField sender;

	@FXML
	DatePicker date;

	@FXML
	private TextArea mainConcent;

	@FXML
	private TextArea comeFromText;

	@FXML
	private TextField comeFromFile;

	@FXML
	private TextField depart;

	@FXML
	private Button save;
	
	@FXML
	private Button cancel;
	
	Model change;

	@FXML
	private void save() {
		Model tmp = new Model();
		if (comeFromFile.getText() != null && !comeFromFile.getText().equals("")) {
			tmp.serComeFromFile(comeFromFile.getText());
			tmp.setUsed(true);
		}
		if (date.getValue() != null && !date.getValue().toString().equals("")) {
			tmp.setData(this.date.getValue().toString());
			tmp.setUsed(true);
		}
		if (depart.getText() != null && !depart.getText().equals("")) {
			tmp.setDepart(depart.getText());
			tmp.setUsed(true);
		}
		if (mainConcent.getText() != null && !mainConcent.getText().equals("")) {
			tmp.setMainConcent(mainConcent.getText());
			tmp.setUsed(true);
		}
		if (comeFromText.getText() != null && !comeFromText.getText().equals("")) {
			tmp.setComeFromText(comeFromText.getText());
			tmp.setUsed(true);
		}
		if (sender.getText() != null && !sender.getText().equals("")) {
			tmp.setSender(sender.getText());
			tmp.setUsed(true);
		}
		if (change == null) {
			main.addMessage(tmp);
		} else {
			main.changeMessage(change, tmp);
		}
		main.closeAlter();
	}

	public void showChange(Model model) {
		change = model;
		comeFromFile.setText(model.getComeFromFile().getValue());
		sender.setText(model.getSender().getValue());
		comeFromText.setText(model.getComeFromText().getValue());
		depart.setText(model.getDepart().getValue());
		try {
			date.setValue(LocalDate.parse(model.getData().getValue()));
		} catch (Exception e) {
		}
		mainConcent.setText(model.getMainConcent().getValue());
	}
	
	public void moveToView(){
		comeFromFile.setDisable(true);
		sender.setDisable(true);
		comeFromText.setDisable(true);
		depart.setDisable(true);
		date.setDisable(true);
		mainConcent.setDisable(true);
	}

	@FXML
	public void cancel() {
		main.closeAlter();
	}

	Main main;

	public void setMain(Main main, Init init) {
		this.main = main;
		if (init == null) {
			
		} else if (init.getType().equals("查看")) {
			this.showChange(init.getModel());
			moveToView();
			save.setText("返回");
			cancel.setVisible(false);
		} else if (init.getType().equals("修改")) {
			this.showChange(init.getModel());
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date data = new Date();
		date.setValue(LocalDate.parse(dFormat.format(data)));
	}
}
