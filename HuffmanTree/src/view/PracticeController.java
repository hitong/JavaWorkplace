package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class PracticeController {
	private Main main;
	private String path;
	private boolean isC;
	@FXML
	MenuItem save;

	@FXML
	TextArea text;

	@FXML
	private void save() {
		if (isC) {
			if (main.saveDataToFile(path)) {
				main.showDiglog("保存成功");
			} else {
				main.showDiglog("保存失败");
			}
		} else {
			if (main.saveCompressDataToFile(path)) {
				main.showDiglog("保存成功");
			} else {
				main.showDiglog("保存失败");
			}
		}
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	private void showCompressData() {
		text.setText(main.getCompressCode());
	}

	@FXML
	private void showData() {
		text.setText(main.getData());
	}

	@FXML
	public void compresingCode() {
		try {
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			path = fileChooser.showOpenDialog(main.getStage()).toString();
			String data = main.readDataFromFile(path);
			text.setText(data);
			isC = false;
			save.setDisable(false);
		} catch (Exception ex) {
		}
	}

	@FXML
	public void deCodingCode() {
		try {
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
			fileChooser.getExtensionFilters().add(extFilter);
			path = fileChooser.showOpenDialog(main.getStage()).toString();
			String data = main.readCompressDataFromFile(path);
			text.setText(data);
			isC = true;
			System.out.println(path);
			save.setDisable(false);
		} catch (Exception ex) {
		}
	}

	@FXML
	public void back() {
		main.showMainMenu();
		System.out.println("back");
	}
}
