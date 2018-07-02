package version2;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FanUI extends JFrame{
	public FanUI(){
		setTitle("DrawArcs");
		add(new Fan2());
	}
	
	public static void main(String[] args){
		FanUI frame = new FanUI();
		frame.setSize(550, 550);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
