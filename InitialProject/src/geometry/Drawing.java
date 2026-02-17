package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

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
		Point rectStart = new Point(200,200);
		rect.setUpperLeftPoint(rectStart);
		rect.setHeight(50);
		rect.setWidth(100);
		rect.setColor(Color.red);
		rect.setInnerColor(Color.red);
		rect.Draw(g);
		
		Circle crcl = new Circle();
		Point crclCenter = new Point(500,500);
		crcl.setCenter(rectStart);
		crcl.setRadius(30);
		crcl.setColor(Color.red);
		crcl.Draw(g);
		
		Donut don = new Donut();
		Point donCenter = new Point(700,700);
		don.setCenter(crclCenter);
		don.setInnerRadius(100);
		don.setRadius(200);
		don.setColor(Color.blue);
		don.setInnerColor(Color.blue);
		don.Draw(g);
	}
	
	


}