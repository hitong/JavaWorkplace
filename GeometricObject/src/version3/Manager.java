package version3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Manager extends JFrame{
	JButton pen = new JButton("SetPen");
	JButton revoke = new JButton("Revoke");
	JButton reStart = new JButton("ReStart");
	JButton delete = new JButton("Delete");
	JButton saveAndExit = new JButton("Save & Exit");
	int times = 0;	
	DrawPanel drawPanel = new DrawPanel(new Circle());
	
	/**
	 * �����������Լ���ʼ��ͼ���б�
	 * @param Continue
	 */
	Manager(boolean Continue){
		/**
		 * �ж��û��Ƿ�ѡ�������ƣ��Ǵ��ļ��ж�ȡͼ���б?���ǣ�ֱ�����¿�ʼ����
		 */
		if(Continue){
			ArrayList<GeometricObject> g = ReadGeometricObject.readGeometricObject();
			drawPanel.setGeometric(g);
		}
		Image icon = 
				new ImageIcon("F:\\JavaWorkplace\\GeometricObject\\src\\5.jpg").getImage();
		this.setIconImage(icon);
		setLayout(new BorderLayout());
		JPanel bt = new JPanel(new GridLayout(1,5));		
		bt.add(pen);
		bt.add(revoke);
		bt.add(delete);
		bt.add(reStart);
		bt.add(saveAndExit);	
		
		pen.addActionListener(new ButtonPen());		
		revoke.addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent e) {
				drawPanel.revoke();
			}		
		});
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please enter the image property you want to delete");
				try {
					setPen set = new setPen(getManager());
					if(set.isSave())
						drawPanel.delete(set.getPen());
				} catch (Exception ex){
					System.out.println(ex);
				}
			}		
		});
		reStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				drawPanel.reStart();
			}
		});
		saveAndExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {			
				SaveAllObject.work(drawPanel.getGeometric());
				dispose();
			}			
		});
	
		setLayout(new BorderLayout());
		add(bt, BorderLayout.NORTH);
		add(drawPanel, BorderLayout.CENTER);
		drawPanel.setBackground(Color.yellow); 
		this.setBackground(new Color(204, 204, 204));
		setSize(900,500);
		setLocationRelativeTo(null); 
		setVisible(true);	
	}
	
	/**
	 * ���û��򿪳��򣬵�һ�Σ������ʾ�����û����ʹ��
	 * ͨ���ȡpen��������Ϣ���ж��Ƿ�Ϸ������Ϸ��������Ӧ��ʾ��Ϣ
	 * @author Sun
	 *
	 */
	class ButtonPen implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(times++ == 0){
			JOptionPane.showMessageDialog(null, "1.you can choise input how many sides"
					+ "\n2.every TextFile can not be null"
					+ "\n3.sidenumber is range 001 - 999, colornumber is range 000 - 255(you can't make 000 is 0)"
					+ "\n4.hope you have a good experience");
			}
			
			setPen s;
			GeometricObject g;
			while(true){
				try {
					s = new setPen(getManager());
					if(s.isSave()){
						g = s.getPen();
						drawPanel.setPen(g);
						JOptionPane.showMessageDialog(null,"The area in which you entered graphics is " + g.getArea() + 
								"\nYou enter the perimeter of the figure is " + g.getPerimeter());
						break;
					}
					else
						break;
				}catch (IllegalArgumentException ex){
					JOptionPane.showMessageDialog(null, "The range of primary colors is 0-255");
				}catch(NotATriangleException ex){
					JOptionPane.showMessageDialog(null, "The three sides you enter cannot form a triangle");
				}catch(Exception ex){
					System.out.println(ex);
				}			
			}	
		}
	}
	
	/**
	 * ���ص�ǰframe
	 * @return
	 */
	public JFrame getManager(){
		return this;
	}
}
