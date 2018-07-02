package View;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Map.ButtonListener;
import Map.Map1;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PassView extends JFrame{
	public static JFrame pv = new JFrame();
	//static ImageIcon im=new ImageIcon("icons//过关界面.png");
	public static JLabel label = new JLabel();
	public static JButton PassButton, ExitButton;
	private int width,height;
	private String backImageFile;
	
	public PassView(String backImageFile) throws HeadlessException {
		super();
		this.backImageFile = backImageFile;	
		loadImage();
		loadButton();
	
		
		
	}
	
	public  void loadButton(){
		ExitButton=new JButton();
		PassButton=new JButton();
		ImageIcon im=new ImageIcon("icons//继续游戏.png");
		PassButton.setSize(im.getIconWidth(),im.getIconHeight());
		PassButton.setIcon(im);
		PassButton.setLocation(283, 65);
		PassButton.setBorder(null);
		PassButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Map1.reNew();		
				LevelView.LevelLabel.setText(Map1.level+"");
				LevelView.GoalScoreLabel.setText(Map1.levelmark+"");
				
			}
		});
		im=new ImageIcon(  "./图片/游戏结束退出游戏.png");
		ExitButton.setSize(im.getIconWidth(), im.getIconHeight());
		ExitButton.setIcon(im);
		ExitButton.setLocation(285, 185);
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
		pv.dispose();
	}



}
