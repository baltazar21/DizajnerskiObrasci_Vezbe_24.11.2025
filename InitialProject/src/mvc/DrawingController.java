package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JOptionPane;

import command.AddShapeCommand;
import command.BringToBackCmd;
import command.BringToFrontCmd;
import command.Command;
import command.RemoveShapeCommand;
import command.ToBackCmd;
import command.ToFrontCmd;
import command.UpdateShapeCommand;
import drawing.DialogCircle;
import drawing.DialogDonut;
import drawing.DialogHexagon;
import drawing.DialogLine;
import drawing.DialogPoint;
import drawing.DialogRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingController {
	private DrawingModel model;
	private DrawingFrame frame;

	
	private String selectedShapeType = "point";
	private String currentMode = "draw";
	private Shape selectedShapeObject;
	private Stack<Command> undoStack = new Stack<Command>();
	private Stack<Command> redoStack = new Stack<Command>();


	Point point1;
	
	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	public void shapeHandler(MouseEvent e) {

		if("select".equals(currentMode))
		{
			selectShape(e.getX(),e.getY());
			return;
		}		
		
		if("draw".equals(currentMode)) {
			Shape newShape = null;
			switch (selectedShapeType.toLowerCase()) {

	        
	        case "point":
	        case "rectangle":
	        case "circle":
	        case "donut":
	        case "hexagon":
	            newShape = createSingleClickShape(e);
	            break;

	        case "line":
	            newShape = createLineShape(e);
	            break;
			}
			
			  if (newShape != null) {
			        AddShapeCommand cmd = new AddShapeCommand(model, newShape);
			        cmd.execute();
			        undoStack.push(cmd);
			        redoStack.clear();
			        updateButtons();
			        frame.addToLog(cmd.toString());
			        frame.repaint();
			}
		}

	}
	

	
	
	
	private Shape createSingleClickShape(MouseEvent e) {
		Shape newShape = null;
		switch(selectedShapeType.toLowerCase()) {
			case "point":     
				newShape = drawPoint(e); 
				break;
				
			
				
			case "rectangle":
				DialogRectangle dlgr = new DialogRectangle(frame,null); 
				dlgr.setModal(true); 
				dlgr.setVisible(true); 
				
				if(dlgr.isConfirm()) 
					newShape = drawRectangle(e,dlgr.getRectWidth(),dlgr.getRectHeight(),dlgr.getRectOuterColor(),dlgr.getRectInnerColor()); 	
				break;
				
				
				
			case "circle":    
				DialogCircle dlgc = new DialogCircle(frame,null);    
				dlgc.setModal(true); 
				dlgc.setVisible(true); 
				
				if(dlgc.isConfirm())
					newShape = drawCircle(e,dlgc.getR(),dlgc.getOuterColor(),dlgc.getInnerColor());                         
				break;
				
				
				
			case "donut":     
				DialogDonut dlgd = new DialogDonut(frame,null);
				dlgd.setModal(true); 
				dlgd.setVisible(true);
				
				if(dlgd.isConfirm())
					newShape = drawDonut(e,dlgd.getR(),dlgd.getR2(),dlgd.getOuterColor(),dlgd.getInnerColor());            
				break;
				
				
				
			case "hexagon":   
				DialogHexagon dlgx = new DialogHexagon(frame,null);
				dlgx.setModal(true); 
				dlgx.setVisible(true);
				
				if(dlgx.isConfirm())
					newShape = drawHexagon(e,dlgx.getR(),dlgx.getOuterColor(),dlgx.getInnerColor()); 
				break;
		}
		return newShape;
	}
	
    private Shape createLineShape(MouseEvent e) {
        if (point1 == null) {
            point1 = new Point(e.getX(), e.getY());
            return null; 
        }

        Point endPoint = new Point(e.getX(), e.getY());
        DialogLine dlgl = new DialogLine(frame, null, point1, endPoint);
        dlgl.setModal(true);
        dlgl.setVisible(true);
        
        if(dlgl.isConfirm()) {
            Line line = new Line(point1, endPoint, dlgl.getOuterColor());
            point1 = null; 
            return line;
        }
        
        point1 = null;
        return null;
    }
	
    
    
    //=========================== Draw ================================================
	public Shape drawPoint(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		p.setColor(frame.getGlobalOuterColor());
		return p;
	}
	
	public Shape drawRectangle(MouseEvent e,int width, int height, Color outer, Color inner) {
		Rectangle r = new Rectangle(new Point(e.getX(),e.getY()),width,height,outer,inner);
		return r;
	}
	
	public Shape drawCircle(MouseEvent e, int r,Color outer,Color inner) {
		Circle c = new Circle(new Point(e.getX(),e.getY()),r,outer,inner);
		return c;
	}
	
	public Shape drawDonut(MouseEvent e,int r,int r2,Color outer,Color inner) {
		Donut d = new Donut(new Point(e.getX(),e.getY()),r2,r,outer,inner);
		return d;
		
	}
	
	public Shape drawHexagon(MouseEvent e, int r, Color outer, Color inner) {
		HexagonAdapter hex = new HexagonAdapter(e.getX(), e.getY(), r, outer, inner);
		return hex;
	}
	//==============================================================================
	
	
	
	
	//======================== Select =======================================
	private void selectShape(int x, int y) {
		Shape shapeToSelect = null;
		System.out.println("Called selectShape()");
		for (int i = model.getShapes().size() - 1; i >= 0; i--) {
			Shape shape = model.getShapes().get(i);
			if (shape.contains(x, y)) {
				shapeToSelect = shape;
				System.out.println("Found shapeToSelect");
				break;
			}
		}
		if (shapeToSelect != null) {
			if (selectedShapeObject == shapeToSelect) {
				shapeToSelect.setSelected(false);
				selectedShapeObject = null;
				frame.addToLog("Deselect: " + shapeToSelect);
			} else {
				if (selectedShapeObject != null) {
					selectedShapeObject.setSelected(false);
					frame.addToLog("Deselect: " + selectedShapeObject);
				}
				shapeToSelect.setSelected(true);
				System.out.println("shapeToSelect.setSelected(true)");
				selectedShapeObject = shapeToSelect;
				frame.addToLog("Select: " + shapeToSelect);
			}
		} else {
			if (selectedShapeObject != null) {
				selectedShapeObject.setSelected(false);
				frame.addToLog("Deselect: " + selectedShapeObject);
				selectedShapeObject = null;
			}
		}
		frame.repaint();
	}
	//==============================================================================
	
	
	
	
	//============================== Modify =======================================
	public void modifyShape() {
	    System.out.print("Called MODIFYSHAPE() with shapeType: " + selectedShapeObject);
	    if (selectedShapeObject != null) {
	        
	        // --------------------------------- Modify Point --------------------------------------------------
	        if (selectedShapeObject instanceof Point) {
	        	Shape before = selectedShapeObject.clone();
	            DialogPoint dlg = new DialogPoint((Point) selectedShapeObject);
	            System.out.println("DialogShow (selectedShape != null) && Instanceof Point == true");
	            dlg.setVisible(true);

	            if (dlg.isConfirm()) {
	                    Point point = (Point) selectedShapeObject;
	                    int X = dlg.getX();
	                    int Y = dlg.getY();

	                    point.setX(X);
	                    point.setY(Y);
	                    point.setColor(dlg.getColor());
	                    Shape after = selectedShapeObject.clone();
	                    updateShape(before, after);
	                    System.out.println("Modified: newX" + point.getX() + " newY:" + point.getY() + " newColor:" + point.getColor());
	            }
	      //-------------------------------------------------------------------------------------------------------      
	            
	            
	            
	        // ------------------------------------ Modify Circle ------------------------------------------------
	        } else if (selectedShapeObject instanceof Circle && !(selectedShapeObject instanceof Donut)) {
	        	Shape before = selectedShapeObject.clone();
	            DialogCircle dlg = new DialogCircle(frame, (Circle) selectedShapeObject);
	            System.out.println("\nCall CircleDialog Modify!");
	            dlg.setVisible(true);

	            if (dlg.isConfirm()) {
	                    Circle circle = (Circle) selectedShapeObject;
	                    int x = dlg.getX();
	                    int y = dlg.getY();
	                    int r = dlg.getR();
	                    Color inner = dlg.getInnerColor();
	                    Color outer = dlg.getOuterColor();

	                    circle.setCenter(new Point(x, y));
	                    circle.setColor(outer);
	                    circle.setInnerColor(inner);
	                    circle.setRadius(r);
	                    Shape after = selectedShapeObject.clone();
	                    updateShape(before, after);
	            }
	            //-------------------------------------------------------------------------------------------------------
	        
	            
	            
	            // -------------------------------- Modify Donut --------------------------------------------------------
	        } else if (selectedShapeObject instanceof Donut) {
	        	Shape before = selectedShapeObject.clone();
	            DialogDonut dlg = new DialogDonut(frame, (Donut) selectedShapeObject);
	            System.out.println("Call DonutDialog Modify!");
	            dlg.setVisible(true);

	            if (dlg.isConfirm()) {
	                    int x = dlg.getX();
	                    int y = dlg.getY();
	                    int r = dlg.getR();
	                    int r2 = dlg.getR2();
	                    Color inner = dlg.getInnerColor();
	                    Color outer = dlg.getOuterColor();

	                    Donut donut = (Donut) selectedShapeObject;
	                    donut.setCenter(new Point(x, y));
	                    donut.setRadius(r2);
	                    donut.setInnerRadius(r);
	                    donut.setColor(outer);
	                    donut.setInnerColor(inner);
	                    Shape after = selectedShapeObject.clone();
	                    updateShape(before, after);
	            }
	            //----------------------------------------------------------------------------------------------
	            
	            
	            
	        //---------------------------------- Modify Rectangle -----------------------------------
	        } else if (selectedShapeObject instanceof Rectangle) {
	        	Shape before = selectedShapeObject.clone();
	            DialogRectangle dlg = new DialogRectangle(frame, (Rectangle) selectedShapeObject);
	            System.out.println("Call RectangleDialog Modify!");
	            dlg.setVisible(true);

	            if (dlg.isConfirm()) {
	                    int x = dlg.getRectX();
	                    int y = dlg.getRectY();
	                    int width = dlg.getRectWidth();
	                    int height = dlg.getRectHeight();
	                    Color inner = dlg.getRectInnerColor();
	                    Color outer = dlg.getRectOuterColor();

	                    Rectangle rect = (Rectangle) selectedShapeObject;
	                    rect.setUpperLeftPoint(new Point(x, y));
	                    rect.setWidth(width);
	                    rect.setHeight(height);
	                    rect.setColor(outer);
	                    rect.setInnerColor(inner);
	                    Shape after = selectedShapeObject.clone();
	                    updateShape(before, after);
	            }
	            //-------------------------------------------------------------------------------------------------------
	            
	            
	            
	        // ------------------------------ Modify Line ----------------------------------------------
	        } else if (selectedShapeObject instanceof Line) {
	        	Shape before = selectedShapeObject.clone();
	            DialogLine dlg = new DialogLine(frame, (Line) selectedShapeObject);
	            System.out.println("Call LineDialog Modify!");
	            dlg.setVisible(true);

	            if (dlg.isConfirm()) {
	                int x1 = dlg.getX1();
	                int y1 = dlg.getY1();
	                int x2 = dlg.getX2();
	                int y2 = dlg.getY2();
	                Color color = dlg.getOuterColor();

	                Line line = (Line) selectedShapeObject;
	                line.setStartPoint(new Point(x1, y1));
	                line.setEndPoint(new Point(x2, y2));
	                line.setColor(color);
	                Shape after = selectedShapeObject.clone();
	                updateShape(before, after);
	            }
	            
	            
	        // ------------------------------ Modify Hexagon ----------------------------------------------
	        } else if (selectedShapeObject instanceof HexagonAdapter) {
	        	Shape before = selectedShapeObject.clone();
	            DialogHexagon dlg = new DialogHexagon(frame, (HexagonAdapter) selectedShapeObject);
	            System.out.println("Call HexagonDialog Modify!");
	            dlg.setVisible(true);

	            if (dlg.isConfirm()) {
	                int x = dlg.getX();
	                int y = dlg.getY();
	                int r = dlg.getR();
	                Color inner = dlg.getInnerColor();
	                Color outer = dlg.getOuterColor();

	                HexagonAdapter hex = (HexagonAdapter) selectedShapeObject;
	                hex.moveTo(x, y);
	                hex.setRadius(r);
	                hex.setColor(outer);
	                hex.setInnerColor(inner);
	                Shape after = selectedShapeObject.clone();
	                updateShape(before, after);
	            }
	        }
	      //---------------------------------------------------------------------------------------------------------------
	        frame.repaint();
	    }else {
	    	//null selected shape...
			JOptionPane.showMessageDialog(null, "No shape selected.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
	    }
	}

	private void updateShape(Shape before, Shape after) {
		UpdateShapeCommand cmd = new UpdateShapeCommand(model, selectedShapeObject, before, after);
		cmd.execute();
		undoStack.push(cmd);
		redoStack.clear();
		selectedShapeObject = cmd.getCurrent();
		selectedShapeObject.setSelected(true);
		updateButtons();
		frame.addToLog(cmd.toString());
	}

	//==================================================================================================================
	
	
	public void deleteShape() {
		if (selectedShapeObject != null) {
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected shape?",
					"Delete", JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.YES_OPTION) {
				int index = model.getShapes().indexOf(selectedShapeObject);
				RemoveShapeCommand cmd = new RemoveShapeCommand(model, selectedShapeObject, index);
				cmd.execute();
				undoStack.push(cmd);
				redoStack.clear();
				selectedShapeObject = null;
				updateButtons();
				frame.addToLog(cmd.toString());
				frame.repaint();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No shape selected.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void undo() {
		if (!undoStack.isEmpty()) {
			Command cmd = undoStack.pop();
			cmd.unexecute();
			redoStack.push(cmd);
			updateButtons();
			frame.addToLog("Undo: " + cmd);
			frame.repaint();
		}
	}

	public void redo() {
		if (!redoStack.isEmpty()) {
			Command cmd = redoStack.pop();
			cmd.execute();
			undoStack.push(cmd);
			updateButtons();
			frame.addToLog("Redo: " + cmd);
			frame.repaint();
		}
	}

	public void updateButtons() {
		frame.setUndoEnabled(!undoStack.isEmpty());
		frame.setRedoEnabled(!redoStack.isEmpty());
	}

	//============================== Z Order =======================================
	public void toFront() {
		if (selectedShapeObject == null) {
			JOptionPane.showMessageDialog(null, "No shape selected.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int index = model.getShapes().indexOf(selectedShapeObject);
		if (index < model.getShapes().size() - 1) {
			executeZOrderCommand(new ToFrontCmd(model, selectedShapeObject));
		} else {
			JOptionPane.showMessageDialog(null, "The selected shape is already at the front.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void toBack() {
		if (selectedShapeObject == null) {
			JOptionPane.showMessageDialog(null, "No shape selected.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int index = model.getShapes().indexOf(selectedShapeObject);
		if (index > 0) {
			executeZOrderCommand(new ToBackCmd(model, selectedShapeObject));
		} else {
			JOptionPane.showMessageDialog(null, "The selected shape is already at the back.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void bringToFront() {
		if (selectedShapeObject == null) {
			JOptionPane.showMessageDialog(null, "No shape selected.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int index = model.getShapes().indexOf(selectedShapeObject);
		if (index < model.getShapes().size() - 1) {
			executeZOrderCommand(new BringToFrontCmd(model, selectedShapeObject));
		} else {
			JOptionPane.showMessageDialog(null, "The selected shape is already at the front.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void bringToBack() {
		if (selectedShapeObject == null) {
			JOptionPane.showMessageDialog(null, "No shape selected.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int index = model.getShapes().indexOf(selectedShapeObject);
		if (index > 0) {
			executeZOrderCommand(new BringToBackCmd(model, selectedShapeObject));
		} else {
			JOptionPane.showMessageDialog(null, "The selected shape is already at the back.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void executeZOrderCommand(Command cmd) {
		cmd.execute();
		undoStack.push(cmd);
		redoStack.clear();
		updateButtons();
		frame.addToLog(cmd.toString());
		frame.repaint();
	}
	//=========================================================================================
	
	
	public String getSelectedShapeType() {
		return selectedShapeType;
	}

	public void setSelectedShapeType(String selectedShape) {
		this.selectedShapeType = selectedShape;
		point1 = null;
	}
	
	public String getCurrentMode() {
		return currentMode;
	}

	public void setCurrentMode(String currentMode) {
		this.currentMode = currentMode;
	}


}
