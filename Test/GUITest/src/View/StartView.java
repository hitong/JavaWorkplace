package View;
import java.lang.Package;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Map.Map1;


//开始界面
public class StartView extends JFrame{
	private String backImageFile;
	JLabel label;
	JButton buttonLevel,buttonTime,buttonExit;
	private int width ,height;
	protected Runnable TimeView;
	static JLabel t=new JLabel();
	
	public StartView(String backImageFile) throws HeadlessException {
		super();
		this.backImageFile = backImageFile;	   //开始界面
		loadImage();
		loadButtons();
		
	}
	public void loadButtons(){
		buttonLevel=new JButton();
		buttonTime=new JButton();
		buttonExit=new JButton();
		
		//闯关模式按钮
		ImageIcon im=new ImageIcon( "./图片/闯关模式2.png");
		buttonLevel.setSize(im.getIconWidth(), im.getIconHeight());
		buttonLevel.setIcon(im);
		buttonLevel.setLocation(230, 421);
		buttonLevel.setBorder(null);
		buttonLevel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LevelView Levelframe=new LevelView("./图片/闯关模式界面.png");
				Levelframe.setLayout(null);			
				Levelframe.setVisible(true);
				Closethis();
			}
		});
		
		//计时模式按钮
		im=new ImageIcon( "./图片/计时模式2.png");
		buttonTime.setIcon(im);
		buttonTime.setSize(im.getIconWidth(), im.getIconHeight());
		buttonTime.setLocation(230, 570);
		buttonTime.setBorder(null);
		buttonTime.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Closethis();
				TimeView Timeframe=new TimeView("./图片/计时模式界面.png");
				Timeframe.setLayout(null);
				Timeframe.setVisible(true);
			}
			
		});
		
		//退出游戏按钮
		im=new ImageIcon( "./图片/退出游戏2.png");
		buttonExit.setIcon(im);
		buttonExit.setSize(im.getIconWidth(), im.getIconHeight());
		buttonExit.setLocation(230, 725);
		buttonExit.setBorder(null);
		buttonExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0)	;			
			}
			
		});
		
		label.setLayout(null);
		
		label.add(buttonLevel);
		label.add(buttonTime);
		label.add(buttonExit);
	}
	
	public void loadImage(){
		ImageIcon im=new ImageIcon( backImageFile);
		width=im.getIconWidth();            //获取宽度
		height=im.getIconHeight();			//获取高度
		label=new JLabel(im);
		label.setSize(width, height);
		this.setSize(width, height);
		this.setUndecorated(true);
		this.add(label);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	private void Closethis() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}