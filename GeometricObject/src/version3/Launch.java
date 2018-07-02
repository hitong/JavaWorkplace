package version3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * �����ṩ�����ڣ������ṩmain��������������
 * @author Sun
 *
 */
public class Launch {
	JFrame f = new JFrame();
	Image image = 
			new ImageIcon("F:\\JavaWorkplace\\GeometricObject\\src\\2.jpg").getImage();
	Image icon = 
			new ImageIcon("F:\\JavaWorkplace\\GeometricObject\\src\\4.jpg").getImage();
	Launch(){
		f = new JFrame();
		f.setIconImage(icon);
		JLabel label1 = new JLabel("Welcome to use the software", JLabel.CENTER);
		JLabel label2 = new JLabel("auther's qq: 1906194855", JLabel.RIGHT);
		label1.setFont(new Font("Serif",Font.PLAIN,27));	
		JPanel p = new MyPanel(this.image);	
		p.setLayout(new GridLayout(5,1));
		JButton newStart = new JButton(" new Start");
		JButton Continue = new JButton(" Continue");
		JButton exit = new JButton(" Exit");
		
		newStart.setFocusable(false);
		Continue.setFocusable(false);
		exit.setFocusable(false);
		
		newStart.setOpaque(false);
		newStart.setBorder(BorderFactory.createTitledBorder(""));
		Continue.setOpaque(false);

		Continue.setBorder(BorderFactory.createTitledBorder(""));
		exit.setOpaque(false);

		exit.setBorder(BorderFactory.createTitledBorder(""));
	
		newStart.setFont(new Font("Serif",Font.PLAIN,20));
		Continue.setFont(new Font("Serif",Font.PLAIN,20));
		exit.setFont(new Font("Serif",Font.PLAIN,20));
		
		label1.setForeground(new Color(0,235,0));
		label2.setForeground(new Color(0,235,0));	
	
		newStart.setBackground(Color.white);	
		Continue.setBackground(Color.WHITE);	
		exit.setBackground(Color.WHITE);	
		
		p.add(label1);	
		p.add(newStart);
		p.add(Continue);
		p.add(exit);
		p.add(label2);
		p.setBackground(Color.cyan);
		
		newStart.addActionListener(new btStart());
		Continue.addActionListener(new btContinue());
		exit.addActionListener(new btExit());
			
		f.add(p);
		f.setBounds(400,500,600, 400);	
		f.setLocationRelativeTo(null); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);	
	}
	
	/**
	 * �رյ�ǰ���ڣ�����ָ���Ի�����ʾ�û����ʹ�������
	 * Ȼ������һ��������falseֵ������һ�γ����ô��ĵ��ж�ȡ��ʷ��Ϣ
	 * @author Sun
	 *
	 */
	class btStart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.dispose();
			JOptionPane.showMessageDialog(null, "Turn on the software every time.You have to set the brush before you can do the drawing");
			new Manager(false);		
		}		
	}
	
	/**
	 * �رյ�ǰ���ڣ�������һ������trueֵ������һ�����ĵ��ж�ȡ��ʷ��Ϣ
	 * @author Sun
	 *
	 */
	class btContinue implements ActionListener{
		public void actionPerformed(ActionEvent e){
			f.dispose();
			new Manager(true);	
		}
	}
	
	/**
	 * �رյ�ǰ���ڣ������˳�����
	 * @author Sun
	 *
	 */
	class btExit implements ActionListener{
		public void actionPerformed(ActionEvent e){
			f.dispose();
		}
	}
	
	/**
	 * ��������
	 * @param args
	 */
	public static void main(String[] args){
		new Launch();
	}
}
