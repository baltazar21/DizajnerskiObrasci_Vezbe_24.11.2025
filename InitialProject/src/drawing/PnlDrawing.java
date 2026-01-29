package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	private String SelectedMode = "Draw";
	private String SelectedShape = "Point";
	private Shape selectedShape = null;
	
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint = null;
	
	//Dimensions
	private int rectangleWidth = 0;
	private int rectangleHeight = 0;
	private int circleRadius = 0;
	private int donutOuterRadius = 0;
	private int donutInnerRadius = 0;
	
	//Colors
	private Color innerColor = Color.black;
	private Color outerColor = Color.black;

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("\n"+"mousePressed on :"+" X:" +e.getX() + " Y:" + e.getY() + " Mode:" + SelectedMode + "\n SelectedShape:" + SelectedShape);
				if (SelectedMode == null) {
					JOptionPane.showMessageDialog(null, "Please select mode.", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if (SelectedMode.equals("Draw")) {
                    addShape(e.getX(), e.getY());
                    repaint();
                    
                    return;}
                else if (SelectedMode.equals("Select")) {
                	selectShape(e.getX(), e.getY());
    		    }else {
    				addShape(e.getX(), e.getY());
    		    }
				repaint();
				
			}
		});
		setBackground(Color.WHITE);
		
	}

	
	//=================================== Modify Shape ===============================================================
	public void modifyShape() {
	    System.out.print("Called MODIFYSHAPE() with shapeType: " + selectedShape);
	    if (selectedShape != null) {
	        
	        // --------------------------------- Modify Point --------------------------------------------------
	        if (selectedShape instanceof Point) {
	            DialogPoint dlg = new DialogPoint((Point) selectedShape);
	            System.out.println("DialogShow (selectedShape != null) && Instanceof Point == true");
	            dlg.show();

	            if (dlg.isConfirm()) {
	                try {
	                    Point point = (Point) selectedShape;
	                    int X = dlg.getX();
	                    int Y = dlg.getY();

	                    point.setX(X);
	                    point.setY(Y);
	                    point.setColor(dlg.getColor());
	                    selectedShape.setSelected(false);
	                    selectedShape = null;
	                    repaint();
	                    System.out.println("Modified: newX" + point.getX() + " newY:" + point.getY() + " newColor:" + point.getColor());
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(this, "Coordinates must be integers", "Error!", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                System.out.println("Cancelled by user or dlg.Confirm() == false");
	            }
	            System.out.println(dlg.isConfirm());
	      //-------------------------------------------------------------------------------------------------------      
	            
	            
	            
	        // ------------------------------------ Modify Circle ------------------------------------------------
	        } else if (selectedShape instanceof Circle && !(selectedShape instanceof Donut)) {
	            DialogCircle dlg = new DialogCircle(this, (Circle) selectedShape);
	            System.out.println("\nCall CircleDialog Modify!");
	            dlg.show();

	            if (dlg.isConfirm()) {
	                try {
	                    Circle circle = (Circle) selectedShape;
	                    int x = dlg.getX();
	                    int y = dlg.getY();
	                    int r = dlg.getR();
	                    Color inner = dlg.getInner();
	                    Color outer = dlg.getOuter();

	                    circle.setCenter(new Point(x, y));
	                    circle.setColor(outer);
	                    circle.setInnerColor(inner);
	                    circle.setRadius(r);
	                    selectedShape.setSelected(false);
	                    selectedShape = null;
	                    repaint();
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(this, "All values must be integers", "Error!", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	            //-------------------------------------------------------------------------------------------------------
	        
	            
	            
	            // -------------------------------- Modify Donut --------------------------------------------------------
	        } else if (selectedShape instanceof Donut) {
	            DialogDonut dlg = new DialogDonut(this, (Donut) selectedShape);
	            System.out.println("Call DonutDialog Modify!");
	            dlg.show();

	            if (dlg.isConfirm()) {
	                try {
	                    int x = dlg.getX();
	                    int y = dlg.getY();
	                    int r = dlg.getR();
	                    int r2 = dlg.getR2();
	                    Color inner = dlg.getInner();
	                    Color outer = dlg.getOuter();

	                    Donut donut = (Donut) selectedShape;
	                    donut.setCenter(new Point(x, y));
	                    donut.setRadius(r2);
	                    donut.setInnerRadius(r);
	                    donut.setColor(outer);
	                    donut.setInnerColor(inner);
	                    selectedShape.setSelected(false);
	                    selectedShape = null;
	                    repaint();
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(this, "All values must be integers", "Error!", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	            //----------------------------------------------------------------------------------------------
	            
	            
	            
	        //---------------------------------- Modify Rectangle -----------------------------------
	        } else if (selectedShape instanceof Rectangle) {
	            DialogRectangle dlg = new DialogRectangle(this, (Rectangle) selectedShape);
	            System.out.println("Call RectangleDialog Modify!");
	            dlg.show();

	            if (dlg.isConfirm()) {
	                try {
	                    int x = dlg.getRectX();
	                    int y = dlg.getRectY();
	                    int width = dlg.getRectWidth();
	                    int height = dlg.getRectHeight();
	                    Color inner = dlg.getRectInner();
	                    Color outer = dlg.getRectOuter();

	                    Rectangle rect = (Rectangle) selectedShape;
	                    rect.setUpperLeftPoint(new Point(x, y));
	                    rect.setWidth(width);
	                    rect.setHeight(height);
	                    rect.setColor(outer);
	                    rect.setInnerColor(inner);
	                    selectedShape.setSelected(false);
	                    selectedShape = null;
	                    repaint();
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(this, "All values must be integers", "Error!", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	            //-------------------------------------------------------------------------------------------------------
	            
	            
	            
	        // ------------------------------ Modify Line ----------------------------------------------
	        } else if (selectedShape instanceof Line) {
	            DialogLine dlg = new DialogLine(this, (Line) selectedShape);
	            System.out.println("Call LineDialog Modify!");
	            dlg.show();

	            if (dlg.isConfirm()) {
	                int x1 = dlg.getX1();
	                int y1 = dlg.getY1();
	                int x2 = dlg.getX2();
	                int y2 = dlg.getY2();
	                Color color = dlg.getColor();

	                Line line = (Line) selectedShape;
	                line.setStartPoint(new Point(x1, y1));
	                line.setEndPoint(new Point(x2, y2));
	                line.setColor(color);
	                selectedShape.setSelected(false);
	                selectedShape = null;
	                repaint();
	            }
	        }
	      //---------------------------------------------------------------------------------------------------------------
	    }else {
	    	//None selected shapes...
	    	JOptionPane.showMessageDialog(this, "Please select the shape first.", "Warning!", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	//==================================================================================================================
	
	
	
	//------------------------------------- Delete Shape ----------------------------------------------------
	public void deleteShape() {
		if (selectedShape != null) {
			int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected shape?",
					"Delete", JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.YES_OPTION) {
				shapes.remove(selectedShape);
				selectedShape = null;
				repaint();
			}
		} else {
			JOptionPane.showMessageDialog(this, "No shape selected.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	//-------------------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------- Select Shape ----------------------------------------------------
	private void selectShape(int x, int y) {
		Shape shapeToSelect = null;
		System.out.println("Called selectShape()");
		for (int i = shapes.size() - 1; i >= 0; i--) {
			Shape shape = shapes.get(i);
			if (shape.contains(x, y)) {
				shapeToSelect = shape;
				System.out.println("Found shapeToSelect");
				break;
			}
		}
		if (shapeToSelect != null) {
			if (selectedShape == shapeToSelect) {
				shapeToSelect.setSelected(false);
				selectedShape = null;
			} else {
				if (selectedShape != null) {
					selectedShape.setSelected(false);
				}
				shapeToSelect.setSelected(true);
				System.out.println("shapeToSelect.setSelected(true)");
				selectedShape = shapeToSelect;
			}
		} else {
			if (selectedShape != null) {
				selectedShape.setSelected(false);
				selectedShape = null;
			}
		}
	}
	// -----------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------- Add Shape ---------------------------------------------------------
	private void addShape(int x, int y) {
        switch (SelectedShape) {
        	//--------------------------- add Point --------------------------------------------
            case "Point":
                shapes.add(new Point(x, y, outerColor));
                break;
                
              //--------------------------- add Line --------------------------------------------
            case "Line":if(startPoint == null) {
            	startPoint = new Point(x,y);
            	System.out.println("First point of line set." + startPoint.getX() + " " + startPoint.getY());
            	}else {
            	shapes.add(new Line(startPoint , new Point(x,y), outerColor));
            		System.out.println("Second point of line set." + "\nStartPoint X:"+startPoint.getX() +" Y:"+startPoint.getY() +"\nSecondPoint X:" + x + " Y:" + y + "\nColor: " + outerColor);
            		startPoint = null;
            	}
            	break;
            	
            	//--------------------------- add Rectangle --------------------------------------------
            case "Rectangle":if (rectangleWidth > 0 && rectangleHeight > 0) {
				shapes.add(new Rectangle(new Point(x, y), rectangleWidth, rectangleHeight, outerColor, innerColor));
			} else {
				JOptionPane.showMessageDialog(this, "Rectangle dimensions must be greater than 0.", "Warning!",JOptionPane.WARNING_MESSAGE);
			} break;
			
			//--------------------------- add Circle --------------------------------------------
            case "Circle":if (circleRadius > 0) {
				shapes.add(new Circle(new Point(x, y), circleRadius, outerColor, innerColor));
				
			} else {
				JOptionPane.showMessageDialog(this, "Circle radius must be greater than 0.", "Warning!",JOptionPane.WARNING_MESSAGE);
			}break;
			
			//--------------------------- add Donut --------------------------------------------
            case "Donut": if (donutInnerRadius > 0 && donutOuterRadius > donutInnerRadius) {
				shapes.add(new Donut(new Point(x, y), donutOuterRadius, donutInnerRadius, outerColor, innerColor));
			} else {
				JOptionPane.showMessageDialog(this,"Donut values must be greater than 0 and outer radius must be greater than inner radius.","Warning!", JOptionPane.WARNING_MESSAGE);
			}
            	break;
            
            default:
                break;
        }
    }
	//--------------------------------------------------------------------------------------------------------------

	
	
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).Draw(g);
		}
        }

	
	
	//---------------------------- Getters & Setters -----------------------------
	public void setCurrentMode(String mode) {
		this.SelectedMode = mode;
		startPoint = null;
	}
	
	public String getCurrentMode() {
		return this.SelectedMode;
	}
	
	public void setSelectedShape(String shape) {
		this.SelectedShape = shape;
	}
	
	public Shape getSelectedShape() {
		return this.selectedShape;
	}
	

	public void setRectangleDimensions(int width, int height) {
		this.rectangleWidth = width;
		this.rectangleHeight = height;
	}

	public void setCircleRadius(int radius) {
		this.circleRadius = radius;
	}

	public void setDonutRadiuses(int innerRadius, int outerRadius) {
		this.donutOuterRadius = outerRadius;
		this.donutInnerRadius = innerRadius;
	}

	public void setOuterColor(Color outerColor) {
		this.outerColor = outerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

}