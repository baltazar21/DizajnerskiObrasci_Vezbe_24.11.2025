package command;

import geometry.Shape;
import mvc.DrawingModel;

public class RemoveShapeCommand implements Command {

	private DrawingModel model;
	private Shape shape;
	private int index;

	public RemoveShapeCommand(DrawingModel model, Shape shape, int index) {
		this.model = model;
		this.shape = shape;
		this.index = index;
	}

	@Override
	public void execute() {
		model.removeShape(shape);
	}

	@Override
	public void unexecute() {
		model.addShape(index, shape);
	}

	@Override
	public String toString() {
		return "Remove: " + shape;
	}

}