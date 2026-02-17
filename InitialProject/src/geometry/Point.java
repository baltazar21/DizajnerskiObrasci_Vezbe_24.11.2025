package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	//definisemo peroperty klase point - PRIVATE
	private int x;
	private int y;

	
	//---------------- Konstruktori -----------------------------
	public Point() {

	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y, boolean selected) {
		//naseledjivanje konstruktora
		this(x,y);
		this.selected=selected;
	}

	public Point(int x2, int y2, Color outerColor) {
		// TODO Auto-generated constructor stub
		this(x2,y2);
		setColor(outerColor);
	}
	//------------------------------------------------------------
	
	
	
	
	//---------------- Move metode -----------------------------
	public void moveTo(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void moveBy(int x,int y) {
		this.x +=x;
		this.y +=y;
	}
	//------------------------------------------------------------
	
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point shapeToCompare = (Point) o;
			return (int) this.distance(new Point(0, 0)) - (int) shapeToCompare.distance(new Point(0, 0));
		}
		return 0;
	}
	
	
	//metoda instance
	public double distance(Point drugaTacka) {
		//x koordinata prve tacke tj one nad kojom se poziva metoda distance
				//-x koordinata druge tacke koja se prosledjuje metodi distance
				int a = this.x - drugaTacka.x;
				int b = this.y-drugaTacka.y;
				double distance = Math.sqrt(a*a+b*b);
				return distance;
				}

	public boolean equals(Object obj) {

		if(obj instanceof Point) {
			//downcast
			if(this.x == ((Point)obj).x && 
					this.y == ((Point)obj).y &&
					 	this.selected == ((Point)obj).selected)
				return true;

	        return false;
		}
		return false;
    }

	public int getX() {
		return x;}
	
		//return this.x;
		public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return "("+this.x+","+this.y+")";
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public void setX(int i) {
		// TODO Auto-generated method stub
		this.x = i;
		
	}

	public void setY(int i) {
		// TODO Auto-generated method stub
		this.y = i;
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		Point sadrziTacku = new Point(x, y);
		return this.distance(sadrziTacku) <= 2;
		
	}

	@Override
	public void Draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);

		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(x - 2, y - 2, 4, 4);
			g.setColor(Color.black);

		}
	}
	
	

	


}