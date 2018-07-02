package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Map.Map1;

public class LevelView extends JFrame{

	static //闯关模式
	JLabel label;
	public static JLabel LevelLabel=new JLabel(),ScoreLabel=new JLabel(),GoalScoreLabel=new JLabel();
	JButton ExitButton;
	public static Font f=new Font("华文琥珀",0,60);
	private int width,height;
	private String backImageFile;
	Map1 map =new Map1();
	
	public LevelView(String backImageFile) throws HeadlessException {
		super();
		this.backImageFile = backImageFile;	
		loadImage();
		loadButton();
		LevelLabel.setForeground(Color.white);
		LevelLabel.setFont(f);
		ScoreLabel.setForeground(Color.white);
		ScoreLabel.setFont(f);
		GoalScoreLabel.setForeground(Color.white);
		GoalScoreLabel.setFont(f);
		LevelLabel.setSize(70, 65);
		LevelLabel.setLocation(294,34);
		ScoreLabel.setSize(150, 50);
		ScoreLabel.setLocation(536,123);
		GoalScoreLabel.setSize(150, 50);
		GoalScoreLabel.setLocation(540,44);
		LevelLabel.setText(Map1.level+"");
		ScoreLabel.setText(Map1.mark+"");
		GoalScoreLabel.setText(Map1.levelmark+"");
		
		label.add(map.jp1);
		label.add(GoalScoreLabel);
		label.add(ScoreLabel);
		label.add(LevelLabel);
		map.jp1.setSize(600,600);
		map.jp1.setLocation(56, 285);
		map.jp1.setOpaque(false);
		map.kind=0;
		
	}
	//按钮面板重置
	public static void reNew(){
		Map1 map =new Map1();
		label.add(map.jp1);
		map.jp1.setSize(600,600);
		map.jp1.setLocation(56, 285);
		map.jp1.setOpaque(false);
	}
	//添加按钮
	public void loadButton(){
		ExitButton =new JButton();
		ImageIcon im=new ImageIcon( "./图片/退出.png");
		ExitButton.setSize(im.getIconWidth(), im.getIconHeight());
		ExitButton.setIcon(im);
		ExitButton.setLocation(630, 935);
		ExitButton.setBorder(null);
		ExitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
			
		});
		
		label.setLayout(null);
		label.add(ExitButton);
	}
	//添加标签背景
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
	
	
}