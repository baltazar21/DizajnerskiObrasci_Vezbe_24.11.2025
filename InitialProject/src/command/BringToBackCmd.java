package command;

import geometry.Shape;
import mvc.DrawingModel;

public class BringToBackCmd implements Command {

	private DrawingModel model;
	private Shape shape;
	private int originalIndex;

	public BringToBackCmd(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		originalIndex = model.getShapes().indexOf(shape);
		model.getShapes().remove(shape);
		model.getShapes().add(0, shape);
	}

	@Override
	public void unexecute() {
		model.getShapes().remove(shape);
		model.getShapes().add(originalIndex, shape);
	}

	@Override
	public String toString() {
		return "Bring To Back: " + shape;
	}

}