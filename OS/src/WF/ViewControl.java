package WF;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import 动态分配.Depart;
import 动态分配.Utils;

public class ViewControl {
	@FXML
	private TextField longth;
	
	@FXML
	private TextArea resultArea;
	
	@FXML
	private VBox vbox;
	
	@FXML
	private void add(){
		try{
			int tmp = Integer.parseInt(longth.getText());
			if(tmp <= 0){
				resultArea.setText("请输入大于0的整形数字");
			}
			else if(Utils.applyWF(main.list, tmp)){
				resultArea.setText("成功添加");
				changeView();
			} else {
				resultArea.setText("暂无空间可放入此进程，添加失败");
			}
		} catch(Exception e){
			resultArea.setText("请正确整形数据");
		}
	}
	
	public void remove(int id){
		
	}
	
	Launch main;
	public void setMain(Launch main){
		this.main = main;
		main.list.add(new Depart(50, 0));
		changeView();
	}
	
	private void changeView(){
		vbox.getChildren().clear();
		for(int i = 0; i < main.list.size();i++){
			StackPane stackPane = Rec.getRec(main.list.get(i).getLongth(), main.list.get(i).getStatus(), i);
			stackPane.setOnMouseClicked(evet -> {
				relise(stackPane);
			});
			vbox.getChildren().add(stackPane);
		}
	}
	
	private void relise(StackPane stackPane){
		Utils.relise(main.list, Integer.parseInt(stackPane.getId()));
		changeView();
	}
}
