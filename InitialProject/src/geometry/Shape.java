package geometry;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Shape implements Moveable, Comparable {
	protected boolean selected;
	protected Color color;
	protected Color innerColor;

	public Shape() {

	}

	public Shape(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	// metode bez implementacije
	public abstract boolean equals(Object obj);

	public abstract String toString();

	public abstract boolean contains(int x, int y);

	public abstract void Draw(Graphics g);

	public void fill(Graphics g) {
		// TODO Auto-generated method stub

	}

}