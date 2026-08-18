package mvc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class DrawingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	

	//UIElements
	public JButton OuterColorButton;
	public JButton InnerColorButton;
	private JButton undoButton;
	private JButton redoButton;
	
	
	private DrawingController controller;
	protected DrawingView view = new DrawingView(this);



	private Color globalOuterColor = Color.black;
	private Color globalInnerColor = Color.black;

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setTitle("Radojicic Lazar IT/71-2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		view.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		view.setBackground(new Color(255, 255, 255));
		contentPane.add(view, BorderLayout.CENTER); 
		
		
		
		//============= OUTER COLOR BUTTON ==============
		OuterColorButton = new JButton("Outer Color");
		OuterColorButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(null, "Choose Outer Color", globalOuterColor);
				if (newColor != null) {
					globalOuterColor = newColor;
					OuterColorButton.setBackground(newColor);
					System.out.println("OuterColor Selected = " + newColor.toString());
				}
			}
		});
		OuterColorButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(OuterColorButton);
		//============================================================
		
		
		
		//==================== INNER COLOR BUTTON ====================
		InnerColorButton = new JButton("Inner Color");
		InnerColorButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(null, "Choose Inner Color", globalInnerColor);
				if (newColor != null) {
					globalInnerColor = newColor;
					InnerColorButton.setBackground(newColor);
				}
			}
		});
		InnerColorButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(InnerColorButton);
		//==============================================================
		
		
		
		JPanel TopPanel = new JPanel();
		contentPane.add(TopPanel, BorderLayout.NORTH);
		
		JPanel ModesPanel = new JPanel();
		ModesPanel.setBackground(new Color(128, 128, 128));
		TopPanel.add(ModesPanel);

		

		
		JLabel ModesLabel = new JLabel("Modes:");
		ModesLabel.setForeground(new Color(255, 255, 255));
		ModesLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ModesPanel.add(ModesLabel);
		
		
		
		//================ DRAW BUTTON ========================
		JToggleButton DrawToggleButton = new JToggleButton("Draw");
		DrawToggleButton.setSelected(true);
		ModesPanel.add(DrawToggleButton);
		DrawToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setCurrentMode("draw");
			}
		});
		buttonGroup.add(DrawToggleButton);
		DrawToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//====================================================
		
		
		
		//================= SELECT BUTTON  ==========
		JToggleButton SelectToggleButton = new JToggleButton("Select");
		ModesPanel.add(SelectToggleButton);
		SelectToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setCurrentMode("select");
			}
		});
		buttonGroup.add(SelectToggleButton);
		SelectToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//=============================================
		
		
		
		//============ MODIFY BUTTON =========================
		JToggleButton ModifyToggleButton = new JToggleButton("Modify");
		ModesPanel.add(ModifyToggleButton);
		ModifyToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String previousMode = controller.getCurrentMode();
				controller.setCurrentMode("modify");
				controller.modifyShape();
				controller.setCurrentMode(previousMode);
				ModifyToggleButton.setSelected(false);
				if ("select".equals(previousMode)) {
					SelectToggleButton.setSelected(true);
				} else {
					DrawToggleButton.setSelected(true);
				}
			}
		});
		buttonGroup.add(ModifyToggleButton);
		ModifyToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//============================================


		
		//==================== DELETE BUTTON =================
		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setCurrentMode("delete");
				controller.deleteShape();
			}
		});
		ModesPanel.add(deleteButton);
		//====================================================
		
		
		//==================== UNDO BUTTON =================
		undoButton = new JButton("Undo");
		undoButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		undoButton.setEnabled(false);
		undoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.undo();
			}
		});
		ModesPanel.add(undoButton);
		//====================================================
		
		//==================== REDO BUTTON =================
		redoButton = new JButton("Redo");
		redoButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		redoButton.setEnabled(false);
		redoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.redo();
			}
		});
		ModesPanel.add(redoButton);
		//====================================================
		
		
		JPanel ObjectsPanel = new JPanel();
		ObjectsPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		ObjectsPanel.setBackground(new Color(192, 192, 192));
		TopPanel.add(ObjectsPanel);
		
		
		
		JLabel ShapesLabel = new JLabel("Shapes:");
		ShapesLabel.setForeground(new Color(0, 0, 0));
		ShapesLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ObjectsPanel.add(ShapesLabel);
		
		
		
		//=================== POINT BUTTON =====================
		JToggleButton PointToggleButton = new JToggleButton("Point");
		PointToggleButton.setSelected(true);
		PointToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setSelectedShapeType("Point");
				InnerColorButton.setVisible(false);
				
			}
		});
		
		buttonGroup_1.add(PointToggleButton);
		PointToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ObjectsPanel.add(PointToggleButton);
		//===================================================
		


		//=============== LINE BUTTON =======================
		JToggleButton LineToggleButton = new JToggleButton("Line");
		LineToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setSelectedShapeType("Line");
				InnerColorButton.setVisible(false);
			}
		});
		buttonGroup_1.add(LineToggleButton);
		LineToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ObjectsPanel.add(LineToggleButton);
		//===================================================
		
		
		
		//================== RECTANGLE BUTTON =============
		JToggleButton RectangleToggleButton = new JToggleButton("Rectangle");
		RectangleToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setSelectedShapeType("Rectangle");
				InnerColorButton.setVisible(true);
			}
		});
		buttonGroup_1.add(RectangleToggleButton);
		RectangleToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ObjectsPanel.add(RectangleToggleButton);
		//==================================================
		
		
		
		//================== CIRCLE BUTTON ================
		JToggleButton CircleToggleButton = new JToggleButton("Circle");
		CircleToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setSelectedShapeType("Circle");
				InnerColorButton.setVisible(true);
			}
		});
		buttonGroup_1.add(CircleToggleButton);
		CircleToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ObjectsPanel.add(CircleToggleButton);
		//==================================================
		
		
		
		//================== DONUT BUTTON ================
		JToggleButton DonutButton = new JToggleButton("Donut");
		DonutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setSelectedShapeType("Donut");
				InnerColorButton.setVisible(true);
			}
		});
		buttonGroup_1.add(DonutButton);
		DonutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ObjectsPanel.add(DonutButton);
	
		//==============================================
		
		
		
		//================== HEXAGON BUTTON ================
		JToggleButton HexagonButton = new JToggleButton("Hexagon");
		HexagonButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setSelectedShapeType("Hexagon");
				InnerColorButton.setVisible(true);
			}
		});
		buttonGroup_1.add(HexagonButton);
		HexagonButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ObjectsPanel.add(HexagonButton);
		//==================================================
		
	}
	
	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public DrawingController getController() {
		// TODO Auto-generated method stub
		return controller;
	}

	public void setView(DrawingView view) {
		
		this.view = view;
				
	}
	
	public DrawingView getView() {
		// TODO Auto-generated method stub
		return view;
	}


	public Color getGlobalOuterColor() {
		return globalOuterColor;
	}

	public void setGlobalOuterColor(Color globalOuterColor) {
		this.globalOuterColor = globalOuterColor;
	}

	public Color getGlobalInnerColor() {
		return globalInnerColor;
	}

	public void setGlobalInnerColor(Color globalInnerColor) {
		this.globalInnerColor = globalInnerColor;
	}

	public void setUndoEnabled(boolean enabled) {
		undoButton.setEnabled(enabled);
	}

	public void setRedoEnabled(boolean enabled) {
		redoButton.setEnabled(enabled);
	}

}
