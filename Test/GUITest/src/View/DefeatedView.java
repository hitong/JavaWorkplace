package View;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Map.Map1;

public class DefeatedView extends JFrame{
	public static JFrame dv = new JFrame();
	//static ImageIcon im=new ImageIcon("icons//过关界面.png");
	public static JLabel label = new JLabel();
	public static JButton PassButton, ExitButton;
	private int width,height;
	private String backImageFile;
	
	public DefeatedView(String backImageFile) throws HeadlessException {
		super();
		this.backImageFile = backImageFile;	
		loadImage();
		loadButton();		
	}
	public  void loadButton(){
		ExitButton=new JButton();
		PassButton=new JButton();
		ImageIcon im=new ImageIcon("图片//再来一次.png");
		PassButton.setSize(im.getIconWidth(),im.getIconHeight());
		PassButton.setIcon(im);
		PassButton.setLocation(255, 50);
		PassButton.setBorder(null);
		PassButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
				Map1.reNew();
				Map1.mark = 0;
				Map1.level=1;
				Map1.levelmark=1000;
				LevelView.LevelLabel.setText(Map1.level+"");
				LevelView.GoalScoreLabel.setText(Map1.levelmark+"");
				LevelView.ScoreLabel.setText(Map1.mark+"");
				TimeView.ScoreLabel.setText(Map1.mark+"");
				
			}
		});
		im=new ImageIcon(  "./图片/游戏结束退出游戏.png");
		ExitButton.setSize(im.getIconWidth(), im.getIconHeight());
		ExitButton.setIcon(im);
		ExitButton.setLocation(255, 175);
		ExitButton.setBorder(null);
		ExitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
			
		});
		label.setLayout(null);
		label.add(PassButton);
		label.add(ExitButton);
	}
	public void loadImage(){
		ImageIcon im=new ImageIcon( backImageFile);
		width=im.getIconWidth();
		height=im.getIconHeight();
		label=new JLabel(im);
		label.setSize(width, height);
		this.setSize(width, height);
		this.setUndecorated(true);
		this.add(label);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private static  void Closethis() {
		// TODO Auto-generated method stub
		dv.dispose();
	}
}
