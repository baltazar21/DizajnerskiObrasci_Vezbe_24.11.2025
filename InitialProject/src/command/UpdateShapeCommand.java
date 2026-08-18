package command;

import geometry.Shape;
import mvc.DrawingModel;

public class UpdateShapeCommand implements Command {

	private DrawingModel model;
	private Shape current;
	private Shape before;
	private Shape after;

	public UpdateShapeCommand(DrawingModel model, Shape shape, Shape before, Shape after) {
		this.model = model;
		this.current = shape;
		this.before = before;
		this.after = after;
	}

	@Override
	public void execute() {
		int index = model.getShapes().indexOf(current);
		Shape newShape = after.clone();
		model.replaceShape(current, newShape);
		current = newShape;
	}

	@Override
	public void unexecute() {
		int index = model.getShapes().indexOf(current);
		Shape oldShape = before.clone();
		model.replaceShape(current, oldShape);
		current = oldShape;
	}

	public Shape getCurrent() {
		return current;
	}

	@Override
	public String toString() {
		return "Update: " + after;
	}

}