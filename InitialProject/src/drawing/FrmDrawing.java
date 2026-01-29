package drawing;

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

import geometry.Circle;
import geometry.Donut;
import geometry.Rectangle;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PnlDrawing drawingPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	private Color currentInnerColor = Color.black;
	private Color currentOuterColor = Color.black;

	//UIElements
	public JButton OuterColorButton;
	public JButton InnerColorButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setTitle("Radojicic Lazar IT/71-2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		
		//============= OUTER COLOR BUTTON ==============
		OuterColorButton = new JButton("Outer Color");
		OuterColorButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(null, "Choose Outer Color", currentOuterColor);
				if (newColor != null) {
					currentOuterColor = newColor;
					OuterColorButton.setBackground(newColor);
					drawingPanel.setOuterColor(newColor);
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
				Color newColor = JColorChooser.showDialog(null, "Choose Inner Color", currentInnerColor);
				if (newColor != null) {
					currentInnerColor = newColor;
					InnerColorButton.setBackground(newColor);
					drawingPanel.setInnerColor(newColor);
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
		ModesPanel.add(DrawToggleButton);
		DrawToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawingPanel.setCurrentMode("Draw");
			}
		});
		buttonGroup.add(DrawToggleButton);
		DrawToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//====================================================
		
		
		
		//============ MODIFY BUTTON =========================
		JToggleButton ModifyToggleButton = new JToggleButton("Modify");
		ModesPanel.add(ModifyToggleButton);
		ModifyToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawingPanel.setCurrentMode("Modify");
				drawingPanel.modifyShape();
			}
		});
		buttonGroup.add(ModifyToggleButton);
		ModifyToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//============================================


		
		//================= SELECT BUTTON  ==========
		JToggleButton SelectToggleButton = new JToggleButton("Select");
		ModesPanel.add(SelectToggleButton);
		SelectToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawingPanel.setCurrentMode("Select");
			}
		});
		buttonGroup.add(SelectToggleButton);
		SelectToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//=============================================
		
		
		
		//==================== DELETE BUTTON =================
		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawingPanel.deleteShape();
			}
		});
		ModesPanel.add(deleteButton);
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
		PointToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawingPanel.setSelectedShape("Point");
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
				drawingPanel.setSelectedShape("Line");
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
				drawingPanel.setSelectedShape("Rectangle");
				InnerColorButton.setVisible(true);
				DialogRectangle dlg = new DialogRectangle(drawingPanel,(Rectangle)drawingPanel.getSelectedShape());
				System.out.println("Called RectangleDialog with Mode: " + drawingPanel.getCurrentMode());
				dlg.show();
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
				drawingPanel.setSelectedShape("Circle");
				InnerColorButton.setVisible(true);
				DialogCircle dlg = new DialogCircle(drawingPanel,(Circle)drawingPanel.getSelectedShape());
				dlg.show();
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
				drawingPanel.setSelectedShape("Donut");
				InnerColorButton.setVisible(true);
				DialogDonut dlg = new DialogDonut(drawingPanel,(Donut)drawingPanel.getSelectedShape());
				dlg.show();
			}
		});
		buttonGroup_1.add(DonutButton);
		DonutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ObjectsPanel.add(DonutButton);
		
		drawingPanel = new PnlDrawing(); 
		drawingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		drawingPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(drawingPanel, BorderLayout.CENTER); 
		//==============================================
		
	}

}
