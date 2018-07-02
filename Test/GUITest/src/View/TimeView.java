package View;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Map.Map1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeView extends JFrame{
    JPanel panel=new JPanel();
    JLabel label;
	JButton ExitButton;
	JButton Start;
	public static Font f=new Font("华文琥珀",0,60);
	public static JLabel ScoreLabel=new JLabel();
	static JLabel t=new JLabel();
	Map1 map = new Map1();
	public TimeView(){
		
	}
	private int width,height;
	private String backImageFile;
	public TimeView(String backImageFile) throws HeadlessException {
		super();
		this.backImageFile = backImageFile;	
		loadImage();	 
		loadButton();
		loadTimer();
		
		ScoreLabel.setForeground(Color.white);
		ScoreLabel.setFont(f);
		ScoreLabel.setSize(254, 65);
		ScoreLabel.setLocation(438, 138);
		ScoreLabel.setText(Map1.mark+"");
		label.add(t);
		label.add(ScoreLabel);
		label.add(map.jp1);
		map.jp1.setSize(600,600);
		map.jp1.setLocation(56, 285);
		map.jp1.setOpaque(false);
		map.jp1.setVisible(true);
		map.kind=1;
		// TODO Auto-generated method stub	
	}

	public void loadImage() {
		// TODO Auto-generated method stub
		ImageIcon im=new ImageIcon(backImageFile);
		setSize(im.getIconWidth(), im.getIconHeight());
		setLocationRelativeTo(null);
		label=new JLabel(im);
		label.setBounds(0, 0, im.getIconWidth(), im.getIconHeight());
		setUndecorated(true);
		JPanel imagePanel = (JPanel) this.getContentPane();  
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); 
	}
	
	
	public static void loadTimer(){ 
		Thread Mytimer;
		t.setSize(77, 53);
	    t.setLocation(158, 145);
	    Font f=new Font("华文琥珀",0,60);
	    t.setForeground(Color.white);
	    t.setFont(f);
	    
	    Mytimer=new Thread(){
	    	long time =60;
	    	public void run(){
	    		while(time>=0){
	    			t.setText(time+"");
	    			time--;
	    			try {
	    			      Thread.sleep(1000);
	    			} catch(Exception e) {
	    				e.printStackTrace();
	    			}
	    			if (time==0){
	    				EndView endframe = new EndView("./图片/计时模式结束界面.png");
	    				
	    				endframe.setSize(574, 319);
	    				endframe.setLocationRelativeTo(null);
	    				endframe.setVisible(true);
	    			}

	    	    }
	    	}
	    };
	    Mytimer.start();
	    
		
	}
	public void loadButton(){
		JButton ExitButton =new JButton();
		ImageIcon im=new ImageIcon("./图片/退出.png");
		ExitButton.setSize(im.getIconWidth(), im.getIconHeight());
		ExitButton.setIcon(im);
		ExitButton.setBorder(null);
		ExitButton.setLocation(630, 935);
		ExitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
			
		});		
		Container panel=this.getContentPane();
		((JPanel)panel).setOpaque(false);
		ExitButton.setVisible(true);
		((JComponent) panel).setOpaque(false);
		panel.setLayout(null);
		panel.add(ExitButton);
		
	}
	
}


