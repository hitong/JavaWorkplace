package version3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarBody{
	int number = 14;
	private JLabel[] dayLabel = new JLabel[31];
	private JPanel calendarPanel = null;
	private String[] week = {
			"Sunday","Monday", "Tuesday" , "Wednesday","Thursday", "Friday","Saturday","Sunday"
	};	
	int month = 0;
	int year = 0;
	int day = 0;
	boolean flag = true;
	
	CalendarBody(int year, int month, int day, JPanel panel, boolean flag){
		this.year = year;
		this.month = month;
		this.day = day;
		this.flag = flag;
		calendarPanel = panel;
		calendarPanel.setOpaque(false);	
		calendarPanel.setLayout(new GridLayout(8,6));			
		init();
	}	
	
	/**
	 * 初始化日期，向其中添加组件
	 */
	private void init(){	
		for(int i = 0; i < 31; i++){
			dayLabel[i] = new JLabel("" + (i + 1) , 4);		
			dayLabel[i].setFont(new java.awt.Font("" + i, 1, 16));
			dayLabel[i].setOpaque(false);
			dayLabel[i].setBackground(new Color(0,111,111));
			dayLabel[i].setBorder(BorderFactory.createTitledBorder(""));
		}
			
		if(flag){
			dayLabel[day - 2].
			setBorder(BorderFactory.createLineBorder(Color.red));	
		}
		printMonth(year, month);
	}
	
	/**
	 * 传入年和月，添加对应组件到相应容器中
	 * @param year
	 * @param month
	 */
	private void printMonth(int year, int month){
		printMonthTitle(year , month);	
		
		for(int i = 0; i < 7; i++){
			calendarPanel.add(new JLabel(week[i],  JLabel.CENTER));
		}	
		
		GregorianCalendar g = new GregorianCalendar(year, month - 1, 1);
		
		printMonthBody(g.get(Calendar.DAY_OF_WEEK) - 1, 
				g.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 出入开始的星期，以及当月的天数，添加当月组件进面板中
	 * @param startDay
	 * @param numOfDaysInMonth
	 */
	private void printMonthBody(int startDay, int numOfDaysInMonth){	
		startDay = startDay % 7;
		for(int k = 0; k < startDay; k++){
			calendarPanel.add(new JLabel("   "));
			number++;
		}
		
		for(int k = 0; k < numOfDaysInMonth; k++){
			calendarPanel.add(dayLabel[k]);
			dayLabel[k].setBorder(dayLabel[k].getBorder());			
			startDay++;
			number++;
		}	
		
		while(number++ <= 49){
			calendarPanel.add(new JLabel("   "));
		}
	}
	
	/**
	 * 添加标题
	 * @param year
	 * @param month
	 */
	private void printMonthTitle(int year, int month) {
		JButton temp = new JButton(month + "/" + year);
		temp.setFocusable(false);
		temp.addActionListener(new ButtonChange());
		temp.setContentAreaFilled(false);
		for(int i = 0; i < 6; i++){
			calendarPanel.add(new JLabel());	
			if(i == 2){			
					calendarPanel.add(temp);	
			}
		}
	}
	
	/**
	 * 呼出对话框，判断信息是否改变，进而更新面板
	 * @author Sun
	 *
	 */
	class ButtonChange implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ChangeYearAndMonth change = new ChangeYearAndMonth(year ,month);
			if(change.isChange()){
				month = change.getMonth();
				year = change.getYear();
				calendarPanel.removeAll();
				calendarPanel = new CalendarBody(year, month, day, calendarPanel, false).getBody();
				calendarPanel.updateUI();
			}
		}
	}
	
	/**
	 * 返回装有日期标题等面板信息的panel
	 * @return
	 */
	public JPanel getBody(){
		return calendarPanel;
	}
}
