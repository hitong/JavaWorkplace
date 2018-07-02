package version1;

public class Fan1 extends Object {
	final static int SLOW = 1;
	final static int MEDIUM = 2;
	final static int FAST = 3;

	private int speed = SLOW;
	private boolean on = false;
	private double radius = 1.0;
	private String color = "blue";

	Fan1() {
	}

	Fan1(int speed, boolean on, double radius, String color) throws Exception {
		this.setSpeed(speed);
		this.setOn(on);
		this.setRadius(radius);
		this.setColor(color);

	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) throws SpeedExceedingLimitException {
		if (speed > 0 && speed < 4)
			this.speed = speed;
		else
			throw new SpeedExceedingLimitException();
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) throws RadiusExceedingLimitException {
		if (radius > 0)
			this.radius = radius;
		else
			throw new RadiusExceedingLimitException();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		return this.speed == ((Fan1) obj).getSpeed();
	}

	@Override
	public String toString() {
		return "Speed:" + speed + "\n" + "On:" + on + "\n" + "Radius:" + radius
				+ "\n" + "Color:" + color;
	}

}

@SuppressWarnings("serial")
class SpeedExceedingLimitException extends Exception {
	public String toString() {
		return "Speed should be in 1 to 3";
	}
}

@SuppressWarnings("serial")
class RadiusExceedingLimitException extends Exception {
	public String toString() {
		return "Radius should biger than 0";
	}
}