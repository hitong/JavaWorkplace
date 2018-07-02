package partFourteen;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculator2 extends Frame implements ActionListener,WindowListener{
	private JTextField displayField;
	private String lastCommand;//reserve order
	private double result;
	private boolean start;//if start with data
	private Dialog dialog;
	private Label label_dialog;
	private JButton button_sqrt,button_plusminus,button_CE,button_cancel,button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0,
	button_plus,button_multiply,button_divide,button_point,button_equal,button_log,button_tan,button_cos,button_sin,button_exp;
	
	public Calculator2(){//create method set layout and listen
		super("Calculator");
		this.setLocation(240, 200);
		this.setSize(350, 300);
		this.setResizable(false);
		this.setLayout(new GridLayout(7,1));
		this.addmyMenu();//���ó�Ա������Ӳ˵�
		displayField = new JTextField(30);
		this.add(displayField);
		displayField.setEditable(true);
		
		start=true;
		result=0;
		lastCommand="=";
		
		JPanel panel0 = new JPanel();
		panel0.setLayout(new GridLayout(1,4,4,4));
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,5,4,4));
		this.add(panel1);
		button_sqrt=new JButton("sqrt");
		button_plusminus = new JButton("+/-");
		button_exp = new JButton("exp");
		button_CE = new JButton("�˸�");
		button_cancel = new JButton("C");
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,5,4,4));
		this.add(panel2);
		button_7 = new JButton("7");
		button_8 = new JButton("8");
		button_9 = new JButton("9");
		button_log = new JButton("log");
		button_divide = new JButton("/");
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,5,4,4));
		this.add(panel3);
		button_4 = new JButton("4");
		button_5 = new JButton("5");
		button_6 = new JButton("6");
		button_tan = new JButton("tan");
		button_multiply = new JButton("*");
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,5,4,4));
		this.add(panel4);
		button_1 = new JButton("1");
		button_2 = new JButton("2");
		button_3 = new JButton("3");
		button_cos = new JButton("cos");
		button_divide = new JButton("-");
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1,5,4,4));
		this.add(panel5);
		button_0 = new JButton("0");
		button_point = new JButton(".");
		button_equal = new JButton("=");
		button_sin = new JButton("sin");
		button_plus = new JButton("+");
		
		
		panel1.add(button_sqrt);
		panel1.add(button_plusminus);
		panel1.add(button_exp);
		panel1.add(button_CE);
		panel1.add(button_cancel);
		panel2.add(button_7);
		panel2.add(button_8);
		panel2.add(button_9);
		panel2.add(button_log);
		panel2.add(button_divide);
		panel3.add(button_4);
		panel3.add(button_5);
		panel3.add(button_6);
		panel3.add(button_tan);
		panel3.add(button_multiply);
		panel4.add(button_1);
		panel4.add(button_2);
		panel4.add(button_3);
		panel4.add(button_cos);
	//	panel4.add(button_minus);
		panel5.add(button_0);
		panel5.add(button_point);
		panel5.add(button_equal);
		panel5.add(button_sin);
		panel5.add(button_plus);
		
		button_sqrt.addActionListener(this);
		button_plusminus.addActionListener(this);
		button_exp.addActionListener(this);
		button_CE.addActionListener(this);
		button_cancel.addActionListener(this);
		button_7.addActionListener(this);
		button_8.addActionListener(this);
		button_9.addActionListener(this);
		button_log.addActionListener(this);
		button_divide.addActionListener(this);
		button_4.addActionListener(this);
		button_5.addActionListener(this);
		button_6.addActionListener(this);
		button_tan.addActionListener(this);
		button_multiply.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_cos.addActionListener(this);
	//	button_minus.addActionListener(this);
		button_0.addActionListener(this);
		button_point.addActionListener(this);
		button_equal.addActionListener(this);
		button_sin.addActionListener(this);
		button_plus.addActionListener(this);

		
		this.addWindowListener(new WinClose());
		this.setVisible(true);
		
	}
	
	//��Ӳ˵�
	public void addmyMenu(){
		JMenuBar menubar = new JMenuBar();
		this.add(menubar);
		JMenu m1 = new JMenu("ѡ��");
		JMenu m2 = new JMenu("����ת��");
		JMenuItem m1_exit = new JMenuItem("�˳�");
		m1_exit.addActionListener(this);
		JMenuItem m2_ejz = new JMenuItem("������");
		m2_ejz.addActionListener(this);
		JMenuItem m2_bjz = new JMenuItem("�˽���");
		m2_bjz.addActionListener(this);
		JMenu m3 = new JMenu("����");
		JMenuItem m3_Help = new JMenuItem("�÷�");
		m3_Help.addActionListener(this);
		
		dialog = new Dialog(this,"��ʾ",true);
		dialog.setSize(240, 80);
		label_dialog = new Label("",Label.CENTER);//��ǩ���ַ���Ϊ�գ����ж���
		dialog.add(label_dialog);
		dialog.addWindowListener(this);//Ϊ�Ի���ע�������
		
		m1.add(m1_exit);
		menubar.add(m1);
		m2.add(m2_ejz);
		m2.add(m2_bjz);
		menubar.add(m2);
		m3.add(m3_Help);
		menubar.add(m3);
	}
		
		//��ť�����¼�������
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(button_1)||e.getSource().equals(button_2)||e.getSource().equals(button_3)||
					e.getSource().equals(button_4)||e.getSource().equals(button_5)||e.getSource().equals(button_6)||
					e.getSource().equals(button_7)||e.getSource().equals(button_8)||e.getSource().equals(button_9)||
					e.getSource().equals(button_0)||e.getSource().equals(button_point)||e.getSource().equals(button_plusminus)||
					e.getSource().equals(button_cancel)||e.getSource().equals(button_CE)){
				String input = e.getActionCommand();
				if(start){
					displayField.setText("");
					start=false;
					if(input.equals("+/-"))
						displayField.setText(displayField.getText()+"-");
				}
				if(!input.equals("+/-")){
					String str = displayField.getText();
					if(input.equals("�˸�")){
						if(str.length()>0)
							displayField.setText(str.substring(0,str.length()-1));
					}
					else if(input.equals("C")){
						displayField.setText("0");
						start = true;
						
					}
					else
						displayField.setText(displayField.getText() + input);
					
				}
			}
			else if(e.getActionCommand() == "������"){
				int n = Integer.parseInt(displayField.getText());
				displayField.setText(Integer.toBinaryString(n));
				
			}
			else if(e.getActionCommand() == "�˽���"){
				int n = Integer.parseInt(displayField.getText());
				displayField.setText(Integer.toOctalString(n));
				
			}
			else if(e.getActionCommand() == "�˳�"){
				label_dialog.setText("sqrt,exp�ȼ��������������������\n");
				dialog.setLocation(400,250);
				dialog.setVisible(true);
			}
			else{
				String command = e.getActionCommand();
				if(start){
					lastCommand = command;
				}
				else{
					calculate(Double.parseDouble(displayField.getText()));
					lastCommand = command;
					start = true;
					
				}
			}
			
		}
		
		
		public void calculate(double x){
			double d = 0;
			if(lastCommand.equals("+"))
				result += x;
			else if(lastCommand.equals("-"))
				result -= x;
			else if(lastCommand.equals("*"))
				result *= x;
			else if(lastCommand.equals("/"))
				result /= x;
			else if(lastCommand.equals("="))
				result = x;
			else if(lastCommand.equals("sqrt")){
				d = Math.sqrt(x);
				result = d;
			}
			else if(lastCommand.equals("exp")){
				d = Math.exp(x);
				result = d;
			}
			else if(lastCommand.equals("log")){
				d = Math.log(x);
				result = d;
			}
			else if(lastCommand.equals("sin")){
				d = Math.sin(x);
				result = d;
			}
			else if(lastCommand.endsWith("cos")){
				d = Math.cos(x);
				result = d;
			}
			else if(lastCommand.equals("tan")){
				d = Math.tan(x);
				result = d;
			}
			displayField.setText("" + result);
		}
		
		public void windowClosing(WindowEvent e){
			if(e.getSource() == dialog)
				dialog.setVisible(false);
			else
				System .exit(0);
		}
		public void windowOpened(WindowEvent e1) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		
		@SuppressWarnings("unused")
		public static void main(String[] arge){
			Calculator2 calculator = new Calculator2();
		}
	}
	
	class WinClose implements WindowListener{
		public void windowClosing(WindowEvent e){
			System .exit(0);
		}
		public void windowOpened(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		
		
	}


	
	
	
	

