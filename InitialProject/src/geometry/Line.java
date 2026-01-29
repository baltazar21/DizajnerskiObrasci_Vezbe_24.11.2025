package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	private Color OuterColor;
	private boolean selected;
	
	
	//-------------------- Konstruktori -----------------------------
	public Line() {
		// TODO Auto-generated constructor stub
	}
	
	public Line(Point point, Point point2) {
		this.startPoint = point;
		this.endPoint = point2;
	}
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}

	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		setColor(color);
		System.out.println("Konstruktor Line: Boja"+ color);
	}

	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		setColor(color);
	}
	//---------------------------------------------------------------
	
	
	
	
	//------------------------------- Move metode -------------------
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		// ostaje neimplementirano
	}

	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		this.startPoint.moveBy(x, y);
		this.endPoint.moveBy(x, y);
	}
	//---------------------------------------------------------------
	
	
	
	
	public int compareTo(Object obj) {
		if (obj instanceof Line) {
			Line shapeToCompare = (Line) obj;
			return (int) (this.length() - shapeToCompare.length());
		}
		return 0;
	}
	
	public boolean contains(int x,int y) {
		Point sadrziTacku = new Point(x,y);
		return this.startPoint.distance(sadrziTacku)+this.endPoint.distance(sadrziTacku)-length()<=2;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line) obj;
			if(this.startPoint == pomocna.startPoint && this.endPoint == pomocna.endPoint && this.selected==pomocna.selected)
				return true;
			else
				return false;
		}
		return false;
	}
	

	public double length() {
		//reusable
		return this.startPoint.distance(endPoint);
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return startPoint.toString()+"-->"+endPoint;
	}

	public void Draw(Graphics g) {
		g.setColor(color);
		g.drawLine(startPoint.getX(), startPoint.getY(),
				endPoint.getX(), endPoint.getY());

		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX()-2, startPoint.getY()-2, 4, 4);
			g.drawRect(endPoint.getX()-2, endPoint.getY()-2, 4, 4);
			g.setColor(Color.black);}
	}
	

}