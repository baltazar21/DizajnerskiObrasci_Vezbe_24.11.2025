package geometry;
import java.awt.Color;
import java.awt.Graphics;
public class Rectangle extends Shape {
	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;
	
	//------------------------- Konstruktori ------------------------
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, Color color, Color innerColor) {
		this(upperLeftPoint, height, width);
		setColor(color);
		setInnerColor(innerColor);
	}

	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color color) {
		this(upperLeftPoint, height, width, selected);
		setColor(color);
	}

	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint, height, width, selected, color);
		setInnerColor(innerColor);
	}
	//--------------------------------------------------------------
	
	
	
	public void moveBy(int x, int y) {
		this.upperLeftPoint.moveBy(x, y);
	}
	
	public void moveTo(int x, int y) {
		this.upperLeftPoint.moveTo(x, y);
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle shapeToCompare = (Rectangle)obj;
			return this.area() - shapeToCompare.area();
		}
		return 0;
	}
	
	
	
	
	public void Draw(Graphics g) {
		g.setColor(color);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if (isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.setColor(Color.black);
		}
		fill(g);

	}
	
	public void fill(Graphics g) {
		g.setColor(innerColor);
		g.fillRect(this.upperLeftPoint.getX() + 1, this.getUpperLeftPoint().getY() + 1, width - 1, height - 1);
	}
	
	
	public int area() {
		return height * width;
	}
	
	public int circumference() {
		return 2 * height + 2 * width;
	}
	
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width
					&& this.height == pomocna.height)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	
	public boolean contains(int x, int y) {
		return (x >= this.upperLeftPoint.getX() && x <= this.upperLeftPoint.getX() + width
				&& y >= this.upperLeftPoint.getY() && y <= this.upperLeftPoint.getY() + height);
	}

	
	
	public boolean contains(Point tackaKlika) {
		return (tackaKlika.getX() >= this.upperLeftPoint.getX()
				&& tackaKlika.getX() <= this.upperLeftPoint.getX() + width
				&& tackaKlika.getY() >= this.upperLeftPoint.getY()
				&& tackaKlika.getY() <= this.upperLeftPoint.getY() + height);
	}

	
	
	
	
	
	
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {
		return "Upper left point: " + upperLeftPoint + ", width = " + width + ", height = " + height;
	}


	
}