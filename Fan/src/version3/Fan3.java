package version3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Fan3 extends JPanel {
	int time = 0;
	boolean re = false;
	Timer timer = new Timer(30, new TimeListener());
	Color[] myColor = { Color.red, Color.blue, Color.yellow, Color.green,
			Color.orange };//随机选择的颜色
	private int speed = 0;
	private double radius = 1.0;
	private Color color = Color.red;
	int[] choice = new int[4];//4色的选择存储
	
	Fan3() {
		int choice1 = (int) (Math.random() * 100) % 8 + 10;//半径的选择
		/**
		 * 颜色的随机选择
		 */
		choice[0] = (int) (Math.random() * 10) % 4 + 1;
		choice[1] = (int) (Math.random() * 10) % 4 + 1;
		choice[2] = (int) (Math.random() * 10) % 4 + 1;
		choice[3] = (int) (Math.random() * 10) % 4 + 1;

		try {
			this.setRadius(choice1);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	Fan3(int speed, double radius, Color color) throws Exception {
		this.setSpeed(speed);
		this.setRadius(radius);
		this.setColor(color);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/**
		 * 对反转操作进行响应
		 */
		if (!re) {
			if (time < 0)
				time = -time;
			time++;
		} 
		else {
			if (time > 0)
				time = -time;
			time--;
		}
		time = time % 360;//防止数据溢出，造成风扇错误反转

		/**
		 * 计算风扇参数
		 */
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int) this.getRadius() * 30 + 100;
		int x = xCenter - (radius + 30) / 2;
		int y = yCenter - (radius + 30) / 2;
		int x1 = xCenter - radius / 2;
		int y1 = yCenter - radius / 2;
		
		/**
		 * 绘制风扇
		 */
		g.setColor(this.getColor());
		g.setColor(myColor[choice[0]]);
		g.fillArc(x1, y1, radius, radius, (0 + speed * time * 2) % 360, 30);
		g.setColor(myColor[choice[1]]);
		g.fillArc(x1, y1, radius, radius, (90 + speed * time * 2) % 360, 30);
		g.setColor(myColor[choice[2]]);
		g.fillArc(x1, y1, radius, radius, (180 + speed * time * 2) % 360, 30);
		g.setColor(myColor[choice[3]]);
		g.fillArc(x1, y1, radius, radius, (270 + speed * time * 2) % 360, 30);
		g.setColor(Color.WHITE);
		g.drawArc(x, y, radius + 30, radius + 30, 0, -360);
	}

	/**
	 * 监听时间变化，从而修改风扇参数
	 */
	class TimeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	/**
	 * 反转
	 */
	public void setRe() {
		re = !re;
	}

	/**
	 * 获取速度
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 修改风扇速度
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * 获取风扇半径
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * 修改风扇半径，如果风扇半径小于或等于0，抛出异常
	 * @param radius
	 * @throws RadiusExceedingLimitException
	 */
	public void setRadius(double radius) throws RadiusExceedingLimitException {
		if (radius > 0)
			this.radius = radius;
		else
			throw new RadiusExceedingLimitException();
	}

	/**
	 * 获取颜色
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 修改颜色
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 判断两个风扇的速度是否一致
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Fan3))
			return false;
		Fan3 p = (Fan3) o;
		return p.speed == this.getSpeed();
	}

	/**
	 * 返回风扇基本信息
	 */
	@Override
	public String toString() {
		return "Speed:" + speed + "\n" + "Radius:" + radius + "\n" + "Color:"
				+ color;
	}
}

@SuppressWarnings("serial")
class RadiusExceedingLimitException extends Exception {
	public String toString() {
		return "Radius should biger than 0";
	}
}