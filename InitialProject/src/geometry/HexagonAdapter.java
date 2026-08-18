package geometry;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;

public class HexagonAdapter extends Shape {

	private Hexagon hexagon;

	public HexagonAdapter() {
		hexagon = new Hexagon(0, 0, 0);
	}

	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
	}

	public HexagonAdapter(int x, int y, int r) {
		hexagon = new Hexagon(x, y, r);
	}

	public HexagonAdapter(int x, int y, int r, Color color, Color innerColor) {
		this(x, y, r);
		setColor(color);
		setInnerColor(innerColor);
	}

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);
	}

	@Override
	public void moveBy(int x, int y) {
		hexagon.setX(hexagon.getX() + x);
		hexagon.setY(hexagon.getY() + y);
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof HexagonAdapter) {
			HexagonAdapter other = (HexagonAdapter) obj;
			return hexagon.getR() - other.hexagon.getR();
		}
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	public boolean contains(Point clickPoint) {
		return hexagon.doesContain(clickPoint.getX(), clickPoint.getY());
	}

	@Override
	public void Draw(Graphics g) {
		hexagon.paint(g);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			HexagonAdapter other = (HexagonAdapter) obj;
			return hexagon.getX() == other.hexagon.getX()
					&& hexagon.getY() == other.hexagon.getY()
					&& hexagon.getR() == other.hexagon.getR()
					&& hexagon.isSelected() == other.hexagon.isSelected();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Hexagon: x = " + hexagon.getX() + ", y = " + hexagon.getY() + ", r = " + hexagon.getR();
	}

	@Override
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
	}

	@Override
	public boolean isSelected() {
		return hexagon.isSelected();
	}

	@Override
	public void setColor(Color color) {
		super.setColor(color);
		hexagon.setBorderColor(color);
	}

	@Override
	public Color getColor() {
		return hexagon.getBorderColor();
	}

	@Override
	public void setInnerColor(Color innerColor) {
		super.setInnerColor(innerColor);
		hexagon.setAreaColor(innerColor);
	}

	@Override
	public Color getInnerColor() {
		return hexagon.getAreaColor();
	}

	public int getX() {
		return hexagon.getX();
	}

	public int getY() {
		return hexagon.getY();
	}

	public int getR() {
		return hexagon.getR();
	}

	public void setRadius(int r) {
		hexagon.setR(r);
	}

	@Override
	public Shape clone() {
		HexagonAdapter h = new HexagonAdapter(hexagon.getX(), hexagon.getY(), hexagon.getR(), getColor(), getInnerColor());
		h.setSelected(hexagon.isSelected());
		return h;
	}

}