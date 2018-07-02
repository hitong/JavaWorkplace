package version3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ChangeYearAndMonth extends JDialog{
	int year;
	int month;
	boolean change = false;
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JLabel labelYear = new JLabel("" + year);
	JLabel labelMonth = new JLabel("" + month);
	JButton right1 = new JButton(">");
	JButton right2 = new JButton(">");
	JButton left1 = new JButton("<");
	JButton left2 = new JButton("<");
	JButton ok = new JButton("Ok");
	JButton cancel  = new JButton("Cancel");
	Image image = 
			new ImageIcon("F:\\JavaWorkplace\\GeometricObject\\src\\2.jpg").getImage();
	
	ChangeYearAndMonth(int year, int month){	
		labelYear = new JLabel("" + year);
		labelMonth = new JLabel("" + month);
		this.year = year;
		this.month = month;
		init();
		super.setLocationRelativeTo(null); 
		super.setLayout(new BorderLayout());
		super.add(panel, BorderLayout.NORTH);
		super.add(panel1, BorderLayout.SOUTH);
		super.pack();
		super.setResizable(false);
		super.setModal(true);
		super.setVisible(true);
	}
	
	/**
	 * 初始化组件并添加对应的监听器
	 */
	private void init(){		
		left1.addActionListener(new Left1());
		left2.addActionListener(new Left2());
		right1.addActionListener(new Right1());
		right2.addActionListener(new Right2());
		ok.addActionListener(new Ok());		
		cancel.addActionListener(new Cancel());
		
		labelYear.setPreferredSize(new Dimension(40,40));;
		labelMonth.setPreferredSize(new Dimension(15,10));
		panel.add(left1);
		panel.add(labelYear);
		panel.add(right1);
		panel.add(left2);
		panel.add(labelMonth);
		panel.add(right2);
		
		panel1.add(ok);
		panel1.add(cancel);
		
		panel.setOpaque(false);
		panel1.setOpaque(true);
	}
	
	/**
	 * 返回修改后的年份
	 * @return
	 */
	public int getYear(){
		return year;
	}
	
	/**
	 * 返回修改后月份
	 * @return
	 */
	public int getMonth(){
		return month;
	}
	
	/**
	 * 判断信息是否修改
	 * @return
	 */
	public boolean isChange(){
		return change;
	}
	
	/**
	 * 用于监听年份的减少按键
	 * @author Sun
	 *
	 */
	class Left1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(year > 1){
				labelYear.setText("" + --year);
				panel.updateUI();
			}
		}		
	}
	
	/**
	 * 用于监听月份的减少按键
	 * @author Sun
	 *
	 */
	class Left2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(month > 1){
			    labelMonth.setText("" + --month);
			    panel.updateUI();
			}
			else{
				month = 12;
				labelMonth.setText("" + month);
				labelYear.setText("" + --year);
			}
			panel.updateUI();
		}		
	}
	
	/**
	 * 用于监听年份的添加按键
	 * @author Sun
	 *
	 */
	class Right1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub	
			if(year < 9999){
				labelYear.setText("" + ++year);
				panel.updateUI();
			}
		}		
	}
	
	/**
	 * 用于监听月份的添加按键
	 * @author Sun
	 *
	 */
	class Right2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub		
			if(month < 12){
				labelMonth.setText("" + ++month);
				panel.updateUI();
			}
			else{
				month = 1;
				labelMonth.setText("" + month);
				labelYear.setText("" + ++year);
			}
			panel.updateUI();
		}		
	}
	
	/**
	 * 监听确认键
	 * @author Sun
	 *
	 */
	class Ok implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			change = true;
			dispose();
		}	
	}
	
	/**
	 * 监听返回键
	 * @author Sun
	 *
	 */
	class Cancel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}	
	}
}
