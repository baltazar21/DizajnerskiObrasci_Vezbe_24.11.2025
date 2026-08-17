package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Iscrtavanje oblika");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}

	public Drawing() {

	}

	public void paint(Graphics g) {
		Point pt1 = new Point();
		pt1.setX(100);
		pt1.setY(100);
		pt1.setColor(Color.red);
		pt1.Draw(g);
		
		Rectangle rect = new Rectangle();
		Point rectangleStart = new Point(200,200);
		rect.setUpperLeftPoint(rectangleStart);
		rect.setHeight(50);
		rect.setWidth(100);
		rect.setColor(Color.red);
		rect.setInnerColor(Color.red);
		rect.Draw(g);
		
		Circle circle = new Circle();
		Point circleCenter = new Point(500,500);
		circle.setCenter(rectangleStart);
		circle.setRadius(30);
		circle.setColor(Color.red);
		circle.Draw(g);
		
		Donut don = new Donut();
		Point donutCenter = new Point(700,700);
		don.setCenter(circleCenter);
		don.setInnerRadius(100);
		don.setRadius(200);
		don.setColor(Color.blue);
		don.setInnerColor(Color.blue);
		don.Draw(g);
	}
	
	


}