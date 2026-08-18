package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle {

    private int innerRadius;

    public Donut() { }

    public Donut(Point center, int radius, int innerRadius) {
        super(center, radius);
        this.innerRadius = innerRadius;
    }

    public Donut(Point center, int radius, int innerRadius, boolean selected) {
        this(center, radius, innerRadius);
        this.selected = selected;
    }

    public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
        this(center, radius, innerRadius, selected);
        setColor(color);
    }

    public Donut(Point center, int radius, int innerRadius, Color color, Color innerColor) {
        super(center, radius);
        this.innerRadius = innerRadius;
        setColor(color);
        setInnerColor(innerColor);
    }

    public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
        this(center, radius, innerRadius, color, innerColor);
        this.selected = selected;
    }

    public boolean contains(int x, int y) {
        double d = getCenter().distance(new Point(x, y));
        return d <= getRadius() && d >= innerRadius;
    }

    @Override
    public void Draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        fill(g2);

        g2.setColor(getColor());
        g2.drawOval(getCenter().getX() - getRadius(), getCenter().getY() - getRadius(), getRadius() * 2, getRadius() * 2);
        g2.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, innerRadius * 2, innerRadius * 2);

        if (isSelected()) {
            g2.setColor(Color.BLUE);
            g2.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
            g2.drawRect(getCenter().getX() - getRadius() - 2, getCenter().getY() - 2, 4, 4);
            g2.drawRect(getCenter().getX() + getRadius() - 2, getCenter().getY() - 2, 4, 4);
            g2.drawRect(getCenter().getX() - 2, getCenter().getY() - getRadius() - 2, 4, 4);
            g2.drawRect(getCenter().getX() - 2, getCenter().getY() + getRadius() - 2, 4, 4);
            g2.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
            g2.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
            g2.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
            g2.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
            g2.setColor(Color.BLACK);
        }
    }

    @Override
    public void fill(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Area outer = new Area(new Ellipse2D.Double(
                getCenter().getX() - getRadius(), getCenter().getY() - getRadius(),
                getRadius() * 2, getRadius() * 2));
        Area inner = new Area(new Ellipse2D.Double(
                getCenter().getX() - innerRadius, getCenter().getY() - innerRadius,
                innerRadius * 2, innerRadius * 2));
        outer.subtract(inner);

        g2.setColor(getInnerColor());
        g2.fill(outer);
        g2.setColor(getColor());
    }

    public double area() {
        return super.area() - innerRadius * innerRadius * Math.PI;
    }

    public double circumference() {
        return super.circumference() + 2 * innerRadius * Math.PI;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Donut d)
            return getCenter().equals(d.getCenter()) && getRadius() == d.getRadius() && innerRadius == d.innerRadius;
        return false;
    }

    public int compareTo(Object obj) {
        if (obj instanceof Donut d)
            return (int)(this.area() - d.area());
        return 0;
    }

    public int getInnerRadius() { return innerRadius; }
    public void setInnerRadius(int innerRadius) { this.innerRadius = innerRadius; }
    public String toString() { return super.toString() + ", innerRadius=" + innerRadius; }

    @Override
    public Shape clone() {
        return new Donut((Point) getCenter().clone(), getRadius(), innerRadius, selected, color, innerColor);
    }
}
