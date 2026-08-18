package mvc;

import java.util.ArrayList;

import geometry.Shape;

public class DrawingModel {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape s) {
		shapes.add(s);
	}

	public void addShape(int index, Shape s) {
		shapes.add(index, s);
	}

	public void replaceShape(Shape oldShape, Shape newShape) {
		int index = shapes.indexOf(oldShape);
		shapes.set(index, newShape);
	}
	
	public void removeShape(Shape s) {
		shapes.remove(s);
	}
	
	public Shape get (int index) {
		return shapes.get(index);
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public void setShapesList(ArrayList<Shape> shapes) {
		
		this.shapes=shapes;
	}
}
