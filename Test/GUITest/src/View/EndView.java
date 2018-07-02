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

import Map.ButtonListener;
import Map.Map1;

public class EndView extends JFrame{
	JLabel label;
	JButton ExitButton,AgainButton;
	private int width,height;
	private String backImageFile;
	public static Font f=new Font("华文琥珀",0,60);
	public static JLabel ScoreLabel=new JLabel();
	public EndView(String backImageFile) throws HeadlessException {
		super();
		this.backImageFile = backImageFile;	
		loadImage();
		loadButton();
		ScoreLabel.setForeground(Color.white);
		ScoreLabel.setFont(f);
		ScoreLabel.setSize(180, 70);
		ScoreLabel.setLocation(45, 126);
		ScoreLabel.setText(Map1.mark+"");
		label.add(ScoreLabel);
	}
	public void loadImage(){
		ImageIcon im=new ImageIcon(backImageFile);
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
	public void loadButton(){
		ExitButton=new JButton();
		AgainButton=new JButton();
		ImageIcon im=new ImageIcon( "./图片/再来一次.png");
		AgainButton.setSize(im.getIconWidth(),im.getIconHeight());
		AgainButton.setIcon(im);
		AgainButton.setLocation(290, 75);
		AgainButton.setBorder(null);
		AgainButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("in");
				Map1.mark = 0;
				Map1.level=0;
				Map1.levelmark=1000;
				LevelView.LevelLabel.setText(Map1.level+"");
				LevelView.GoalScoreLabel.setText(Map1.levelmark+"");
				LevelView.ScoreLabel.setText(Map1.mark+"");
				TimeView.ScoreLabel.setText(Map1.mark+"");
				//ButtonListener.level = 0;
				dispose();
				Map1.reNew();
				TimeView.loadTimer();
			}
			
		});
		im=new ImageIcon( "./图片/游戏结束退出游戏.png");
		ExitButton.setSize(im.getIconWidth(), im.getIconHeight());
		ExitButton.setIcon(im);
		ExitButton.setLocation(290, 195);
		ExitButton.setBorder(null);
		ExitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
			
		});
		label.setLayout(null);
		label.add(AgainButton);
		label.add(ExitButton);
	}
}
