package geometry;


import java.awt.Color;
import java.awt.Graphics;
public class Donut extends Circle {

	//ostale property nasledjuje iz Circle
	private int innerRadius;

	
	//------------------------------------- Konstruktori ----------------------------------------------------
	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		this.selected = selected;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
		this(center, radius, innerRadius, selected);
		setColor(color);
	}

	public Donut(Point center, int radius, int innerRadius, Color color, Color innerColor) {
		this(center, radius, innerRadius);
		setColor(color);
		setInnerColor(innerColor);
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
		this(center, radius, innerRadius, selected, color);
		setInnerColor(innerColor);
	}
	//----------------------------------------------------------------------------------------------------------
	
	
	public boolean contains(int x, int y) {
		double distanceFromCenter = getCenter().distance(new Point(x, y));
		return distanceFromCenter <= getRadius() && distanceFromCenter >= innerRadius;
	}

	
	
	
	public void Draw(Graphics g) {
		g.setColor(color);
		super.Draw(g);
		g.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, 2 * innerRadius,
				2 * innerRadius);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}
		fill(g);
		}
	
	
	public void fill(Graphics g) {
		g.setColor(color);
		super.fill(g);
		g.setColor(color.WHITE);
		g.fillOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, this.innerRadius * 2,
				this.innerRadius * 2);
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public double circumference() {
		return super.circumference() + 2 * innerRadius * Math.PI;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			if (getCenter().equals(pomocna.getCenter()) && getRadius() == pomocna.getRadius()
					&& innerRadius == pomocna.getInnerRadius())
				return true;
			else
				return false;
		} else
			return false;
	}
	
	
	public int compareTo(Object obj) {
		if (obj instanceof Donut) {
			Donut shapeToCompare = (Donut) obj;
			return (int) (this.area() - shapeToCompare.area());
		}
		return 0;
	}

	
	//ostale get i set nasledjuje iz Circle
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public String toString() {
		// ako samo pozovemo toString dobicemo rekurziju
		return super.toString() + ", innerRadius = " + innerRadius;
	}




}