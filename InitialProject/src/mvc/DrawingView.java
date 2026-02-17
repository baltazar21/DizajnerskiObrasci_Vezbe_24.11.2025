package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Shape;

public class DrawingView extends JPanel{
	private static final long serialVersionUID = 1L;
	private DrawingFrame frame;
	private DrawingModel model;


	public DrawingView(DrawingFrame drawingFrame) {
		this.frame = drawingFrame;
		setBackground(new Color(255, 255, 255));
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				drawingFrame.getController().shapeHandler(e);
			}
		});
	}	
	public void setModel(DrawingModel model) {
		this.model = model;
	}
	
	
	
	public void paint(Graphics g) {
		Iterator<Shape> it = model.getShapes().iterator();
		while(it.hasNext()) {
			it.next().Draw(g);
		}
	}
}
