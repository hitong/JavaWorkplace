package version3;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Calendar3 extends JFrame{	
	Image image = 
			new ImageIcon("F:\\JavaWorkplace\\Calendar\\src\\123.jpg").getImage();
	Image icon = 
			new ImageIcon("F:\\JavaWorkplace\\Calendar\\src\\p.png").getImage();
	JPanel calendarPanel = null;
	
	/**
	 * 设置面板参数
	 */
	public Calendar3(){
		calendarPanel = new MyPanel(image);
		this.setIconImage(icon);
		this.setTitle("Calendar");
		init(Calendar.getInstance());
		setVisible(true);	
		this.setBounds(500, 500, 700, 500);	
		setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/**
	 * 获取系统时间初始化日期，将面板组件导入frame
	 * @param date
	 */
	public void init(Calendar date){
		String Month = String.valueOf(date.get(Calendar.MONTH));
        String Year = String.valueOf(date.get(Calendar.YEAR));	
        String Day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
            
		setLayout(new BorderLayout());
		int year = Integer.parseInt(Year);
		int month = Integer.parseInt(Month) + 1;
		int day = Integer.parseInt(Day) + 1;
		
		add(calendarPanel = 
			new CalendarBody(year, month, day, calendarPanel, true).getBody(),BorderLayout.CENTER);
	}
	
	/**
	 * 启动日历程序
	 * @param args
	 */
	public static void main(String[] args){
		new Calendar3();
	}	
}

 