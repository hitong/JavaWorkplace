package version3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class FanControl{
	Fan3 fan = new Fan3();
	JButton[] bt = { new JButton("Start"), new JButton("Stop"),
			new JButton("Reverse") };//上栏的三个控制按钮
	JScrollBar scrollBar = new JScrollBar(0);
	Date nowTime;
	JFrame f = new JFrame();//主面板
	Image image = 
			new ImageIcon("F:\\JavaWorkplace\\Fan\\src\\2.gif").getImage();//导入gif图，作为背景参数
	JPanel p = new JPanel();//主容器
	
	FanControl() {	
		
		bt[0].addActionListener(new Bt0());
		bt[1].addActionListener(new Bt1());
		bt[2].addActionListener(new Bt2());
		
		scrollBar.setMaximum(100);//设置滑动条最大值 
		/**
		 * 监听滑动条
		 */
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				fan.setSpeed(e.getValue());
			}
		});
		p = new MyPanel(image);
		p.setBackground(Color.black);
		p.setOpaque(true);
		p.setLayout(new BorderLayout());
		JPanel panel2 = new JPanel(new GridLayout(1, 3));
		for (int i = 0; i < 3; i++) {
			panel2.add(bt[i]);
		};
		
		/**
		 * 配置主面板
		 */
		fan.setOpaque(false);
		panel2.setOpaque(false);
		p.add(fan, BorderLayout.CENTER);
		p.add(panel2, BorderLayout.NORTH);
		p.add(scrollBar, BorderLayout.SOUTH);
		
		f.add(p);
		f.setTitle("Fan");
		f.setSize(1200, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	/**
	 * 监听开始按钮
	 * @author Sun
	 *
	 */
	class Bt0 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fan.timer.start();
			if (fan.getSpeed() == 0) {
				scrollBar.setValue(10);
				fan.setSpeed(10);
			}
			fan.repaint();
		}
	}

	/**
	 * 监听暂停按钮
	 * @author Sun
	 *
	 */
	class Bt1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fan.timer.stop();
			image.flush();
		}
	}

	/**
	 * 监听反向按钮
	 * @author Sun
	 *
	 */
	class Bt2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fan.setRe();
		}
	}
}

