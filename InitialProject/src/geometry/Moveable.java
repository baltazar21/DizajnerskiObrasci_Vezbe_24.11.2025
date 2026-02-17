package geometry;

import java.awt.Graphics;

public interface Moveable {

	public abstract void moveTo(int x, int y);

	void moveBy(int x, int y);

	void fill(Graphics g);

}
