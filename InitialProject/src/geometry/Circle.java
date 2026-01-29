package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
public class Circle extends Shape {
	private Point center;
	private int radius;
	// Ne treba vise - protected boolean selected;
	
	//------------------------ Konstruktori ------------------------
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	public Circle(Point center, int radius, Color color, Color innerColor) {
		this(center, radius);
		setColor(color);
		setInnerColor(innerColor);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		setColor(color);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		setInnerColor(innerColor);
	}
	//--------------------------------------------------------------
	
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}
	
	public void moveBy(int x, int y) {
		center.moveBy(x, y);
	}
	
	
	
	
	public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			Circle shapeToCompare = (Circle)obj;
			return (int)(this.area() - shapeToCompare.area());
		}
		return 0;
	}
	
	
	
	
	public void Draw(Graphics g) {
		g.setColor(color);
		g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.black);
		}
		fill(g);
	}
	
	
	
	//------------------Povrsina i obim-----------------------------
	public double area() {
		return radius * radius * Math.PI;
	}
	public double circumference() {
		return 2 * radius * Math.PI;
	}
	//--------------------------------------------------------------
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX() - radius + 1, this.center.getY() - radius + 1, radius * 2 - 2, radius * 2 - 2);
	}
	
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if (this.center.equals(pomocna.center) && this.radius == pomocna.radius)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public boolean contains(int x, int y) {
		Point sadrziTacku = new Point(x, y);
		return (this.center.distance(sadrziTacku) <= this.radius);
	}

	public boolean contains(Point tackaKlika) {
		return (this.center.distance(tackaKlika) <= this.radius);
	}

	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return "Center: " + center + ", radius = " + radius;
	}
}