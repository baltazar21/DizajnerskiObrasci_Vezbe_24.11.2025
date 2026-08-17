package mvc;

import javax.swing.JFrame;

public class Application {
	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		
		frame.getView().setModel(model);
		DrawingController contoller = new DrawingController(model, frame);
		frame.setController(contoller);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		System.out.println("[MVC]<Application.java>: Application is running...");
	}
}
