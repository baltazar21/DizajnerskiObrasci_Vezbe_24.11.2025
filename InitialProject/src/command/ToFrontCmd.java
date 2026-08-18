package command;

import java.util.Collections;

import geometry.Shape;
import mvc.DrawingModel;

public class ToFrontCmd implements Command {

	private DrawingModel model;
	private Shape shape;

	public ToFrontCmd(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		int index = model.getShapes().indexOf(shape);
		if (index < model.getShapes().size() - 1) {
			Collections.swap(model.getShapes(), index, index + 1);
		}
	}

	@Override
	public void unexecute() {
		int index = model.getShapes().indexOf(shape);
		if (index > 0) {
			Collections.swap(model.getShapes(), index, index - 1);
		}
	}

	@Override
	public String toString() {
		return "To Front: " + shape;
	}

}