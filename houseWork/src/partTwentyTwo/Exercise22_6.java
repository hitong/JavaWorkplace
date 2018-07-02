package partTwentyTwo;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Exercise22_6 {
	JButton sort = new JButton("sort");
	JButton shuf = new JButton("Shuffle");
	JButton re = new JButton("Reverse");
	JTextField input = new JTextField(20);
	JTextArea show = new JTextArea();
	LinkedList<Double> list = new LinkedList<>();
	double insert = 0;
	Exercise22_6(){
		init();
	}
	
	public void init(){
		JFrame f = new JFrame();
		JPanel p = new JPanel(new BorderLayout());	
		bt b = new bt();
		sort.addActionListener(b);	
		shuf.addActionListener(b);
		re.addActionListener(b);
		input.addKeyListener(new text());
	
		show.setEditable(false);
		show.setLineWrap(true);
		
		show.setBackground(Color.white);
		JPanel tmp = new JPanel();
		tmp.add(new JLabel("Enter a number"));
		tmp.add(input);
		p.add(tmp,BorderLayout.NORTH);
		tmp = new JPanel();
		tmp.add(sort);
		tmp.add(shuf);
		tmp.add(re);
		p.add(tmp,BorderLayout.SOUTH);
		p.add(show,BorderLayout.CENTER);
		f.add(p);
		f.setTitle("Exercise22_6");
		f.setSize(500, 350);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	class text implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 10){//Enter键
				try{
					insert = Double.parseDouble(input.getText());
					if(list.contains(insert)){
						throw new Exception("数字" + insert + "已经存在");
					}
					list.add(insert);
					insert = 0;
					print(list);
					input.setText("");
				}
				catch(Exception ex){
					JDialog d = new JDialog();
					d.add(new JPanel().add(new JLabel(ex + " ")));
					d.setVisible(true);
					d.setBackground(Color.white);
					d.setTitle("警告");
					d.setLocation((int)Window.WIDTH / 2, (int)Window.HEIGHT / 2);
					d.setSize(400,200);
					input.setText("");
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}		
	}
	
	class bt implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(sort)){
				Collections.sort(list);
				print(list);
			}
			else if(e.getSource().equals(re)){
				Collections.reverse(list);
				print(list);
			}
			else{
				Collections.shuffle(list);
				print(list);
			}
		}	
	}
	
	private void print(LinkedList<Double> list){
		Iterator<Double> it = list.iterator();
		String s = "";
		while(it.hasNext()){
			s = s + it.next() + "    ";			
		}
		show.setText(s);
	}
	
	public static void main(String[] args){
		new Exercise22_6();
	}
}
