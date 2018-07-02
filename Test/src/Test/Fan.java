package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Fan extends JFrame implements ActionListener {
	static int time = 1;
	static int ti;
	Timer time_1 = new Timer(100, this);
	x1 x = new x1();
	static TransPane jp;
	JButton add = new JButton("加速");
	JButton stop = new JButton("暂停/开始");
	JButton low = new JButton("减速");
	JButton dingshi = new JButton("定时1分钟");
	JTextField TextIn = new JTextField("100");
	JPanel p = new JPanel();

	public Fan() {
		super("旋转");
		add(jp);
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		p.add(add);
		p.add(stop);
		p.add(low);
		p.add(dingshi);
		add(p, BorderLayout.SOUTH);
		add.addActionListener(new ButtonHandler());
		low.addActionListener(new ButtonHandler());
		stop.addActionListener(new ButtonHandler());
		dingshi.addActionListener(new ButtonHandler());
		time_1 = new Timer(1, x);
		time_1.start();
	}

	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == add) {
				if (time >= 0)
					time++;
				else if (time < 0)
					time--;
			} else if (e.getSource() == low) {
				if (time > 0)
					time--;
				else if (time < 0)
					time++;
			} else if (e.getSource() == stop) {
				if (time != 0) {
					ti = time;
					time = 0;
				} else
					time = ti;
			} else if (e.getSource() == dingshi) {
				if (time != 1) {
					ti = time;
					time = 1;
				} else
					time++;
			}
		}
	}

	public static void main(String[] args) {
		jp = new TransPane();
		Fan tran = new Fan();
		tran.setSize(250, 300);
		tran.setVisible(true);
		tran.pack();
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	class x1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jp.i += time;
			jp.repaint();
		}
	}
}

class TransPane extends JPanel {
	int i = 0;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int) (Math.min(getWidth(), getHeight() * 0.4));
		int x = xCenter - radius;
		int y = yCenter - radius;
		g2d.fillArc(x, y, 2 * radius, 2 * radius, i, 30);
		g2d.setColor(Color.red);
		g2d.fillArc(x, y, 2 * radius, 2 * radius, i + 60, 30);
		g2d.setColor(Color.yellow);
		g2d.fillArc(x, y, 2 * radius, 2 * radius, i + 120, 30);
		g2d.setColor(Color.green);
		g2d.fillArc(x, y, 2 * radius, 2 * radius, i + 180, 30);
		g2d.setColor(Color.gray);
		g2d.fillArc(x, y, 2 * radius, 2 * radius, i + 240, 30);
		g2d.setColor(Color.blue);
		g2d.fillArc(x, y, 2 * radius, 2 * radius, i + 300, 30);
		g2d.setColor(Color.black);
	}
}