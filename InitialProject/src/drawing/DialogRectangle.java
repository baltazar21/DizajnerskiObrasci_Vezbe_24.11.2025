package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogRectangle extends JDialog {

	private static final long serialVersionUID = 1L;

	
	
	
	private final JPanel contentPanel = new JPanel();
	private PnlDrawing pnlDrawing;
	/*private JTextField widthTxt;
	private JTextField heightTxt;
	private JTextField xTxt;
	private JTextField yTxt;
	
	private JLabel widthLbl;
	private JLabel heightLbl;
	private JLabel xLbl;
	private JLabel yLbl;*/
	private JButton outerColorButton;
	private JButton innerColorButton;
	
	private Point RectUpperLeftCorner;
	private int Width;
	private int Height;
	private int X;
	private int Y;
	private Color outer;
	private Color inner;
	private boolean confirm;
	
	private JTextField widthTxt;
	private JTextField heightTxt;
	private JTextField xTxt;
	private JTextField yTxt;
	
	private JLabel xLabel;
	private JLabel yLabel;
	private JLabel widthLabel;
	private JLabel heightLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.print("Called DialogRectFix Main");
		try {
			Rectangle rect = new Rectangle();
			PnlDrawing pnlDrawing = new PnlDrawing();
			DialogRectangle dialog = new DialogRectangle(pnlDrawing,rect);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogRectangle(PnlDrawing pnlDrawing, Rectangle selectedShape) {
		//setBounds(100, 100, 450, 300);
		setModal(true);
		
		this.pnlDrawing = pnlDrawing;
		if(pnlDrawing.getCurrentMode().isBlank() || pnlDrawing.getCurrentMode().isEmpty()) {
			pnlDrawing.setCurrentMode("Draw");
		}
		
		String mode = pnlDrawing.getCurrentMode();
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			widthLabel = new JLabel("Width:");
			GridBagConstraints gbc_widthLabel = new GridBagConstraints();
			gbc_widthLabel.anchor = GridBagConstraints.EAST;
			gbc_widthLabel.insets = new Insets(0, 0, 5, 5);
			gbc_widthLabel.gridx = 0;
			gbc_widthLabel.gridy = 0;
			contentPanel.add(widthLabel, gbc_widthLabel);
		}
		{
			widthTxt = new JTextField();
			GridBagConstraints gbc_widthTxt = new GridBagConstraints();
			gbc_widthTxt.insets = new Insets(0, 0, 5, 0);
			gbc_widthTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_widthTxt.gridx = 1;
			gbc_widthTxt.gridy = 0;
			contentPanel.add(widthTxt, gbc_widthTxt);
			widthTxt.setColumns(10);
		}
		{
			heightLabel = new JLabel("Height:");
			GridBagConstraints gbc_heightLabel = new GridBagConstraints();
			gbc_heightLabel.anchor = GridBagConstraints.EAST;
			gbc_heightLabel.insets = new Insets(0, 0, 5, 5);
			gbc_heightLabel.gridx = 0;
			gbc_heightLabel.gridy = 1;
			contentPanel.add(heightLabel, gbc_heightLabel);
		}
		{
			heightTxt = new JTextField();
			GridBagConstraints gbc_heightTxt = new GridBagConstraints();
			gbc_heightTxt.insets = new Insets(0, 0, 5, 0);
			gbc_heightTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_heightTxt.gridx = 1;
			gbc_heightTxt.gridy = 1;
			contentPanel.add(heightTxt, gbc_heightTxt);
			heightTxt.setColumns(10);
		}
		{
			xLabel = new JLabel("X: ");
			GridBagConstraints gbc_xLabel = new GridBagConstraints();
			gbc_xLabel.anchor = GridBagConstraints.EAST;
			gbc_xLabel.insets = new Insets(0, 0, 5, 5);
			gbc_xLabel.gridx = 0;
			gbc_xLabel.gridy = 2;
			contentPanel.add(xLabel, gbc_xLabel);
		}
		{
			xTxt = new JTextField();
			GridBagConstraints gbc_xTxt = new GridBagConstraints();
			gbc_xTxt.insets = new Insets(0, 0, 5, 0);
			gbc_xTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_xTxt.gridx = 1;
			gbc_xTxt.gridy = 2;
			contentPanel.add(xTxt, gbc_xTxt);
			xTxt.setColumns(10);
		}
		{
			yLabel = new JLabel("Y:");
			GridBagConstraints gbc_yLbl = new GridBagConstraints();
			gbc_yLbl.anchor = GridBagConstraints.EAST;
			gbc_yLbl.insets = new Insets(0, 0, 5, 5);
			gbc_yLbl.gridx = 0;
			gbc_yLbl.gridy = 3;
			contentPanel.add(yLabel, gbc_yLbl);
		}
		{
			yTxt = new JTextField();
			GridBagConstraints gbc_yTxt = new GridBagConstraints();
			gbc_yTxt.insets = new Insets(0, 0, 5, 0);
			gbc_yTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_yTxt.gridx = 1;
			gbc_yTxt.gridy = 3;
			contentPanel.add(yTxt, gbc_yTxt);
			yTxt.setColumns(10);
		}
		{
			innerColorButton = new JButton("Inner Color");
			innerColorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inner = JColorChooser.showDialog(null, "Choose Inner Color", Color.BLACK);
					innerColorButton.setBackground(inner);
				}
			});
			GridBagConstraints gbc_innerColorButton = new GridBagConstraints();
			gbc_innerColorButton.insets = new Insets(0, 0, 5, 0);
			gbc_innerColorButton.gridx = 1;
			gbc_innerColorButton.gridy = 4;
			contentPanel.add(innerColorButton, gbc_innerColorButton);
		}
		{
			outerColorButton = new JButton("Outer Color");
			outerColorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outer = JColorChooser.showDialog(null, "Choose Outer Color", Color.BLACK);
					outerColorButton.setBackground(outer);
				}
			});
			GridBagConstraints gbc_outerColorButton = new GridBagConstraints();
			gbc_outerColorButton.gridx = 1;
			gbc_outerColorButton.gridy = 5;
			contentPanel.add(outerColorButton, gbc_outerColorButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if ("Draw".equals(mode)) {
							try {
							Width = Integer.parseInt(widthTxt.getText());
							Height = Integer.parseInt(heightTxt.getText());
							pnlDrawing.setRectangleDimensions(Width, Height);
							confirm = true;
							setVisible(false);
							System.out.println("Finished Draw RectangleDialog with Dimensions   Width:" + Width+" Height:" + Height);
							} catch(NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Please enter valid integers", "Warning",JOptionPane.WARNING_MESSAGE);}
							
						}else {
							try {
							Width = Integer.parseInt(widthTxt.getText());
							Height = Integer.parseInt(heightTxt.getText());
							X = Integer.parseInt(xTxt.getText());
							Y = Integer.parseInt(yTxt.getText());
							
							setVisible(false);
							System.out.println("Finished Modify Rectangle");
							confirm = true;
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Please enter valid integers", "Warning",JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						System.out.println("Cancelled RectangleDialog with Mode: " + pnlDrawing.getCurrentMode());
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		if ("Draw".equals(mode)) {
			xLabel.setVisible(false);
			xTxt.setVisible(false);
			
			yLabel.setVisible(false);
			yTxt.setVisible(false);
			
			widthLabel.setVisible(true);
			widthTxt.setVisible(true);
			
			heightLabel.setVisible(true);
			heightTxt.setVisible(true);
			
			innerColorButton.setVisible(false);
			outerColorButton.setVisible(false);
			this.setTitle("Rectangle - Draw Mode");
		} else {
		    widthTxt.setText(String.valueOf(selectedShape.getWidth()));
		    heightTxt.setText(String.valueOf(selectedShape.getHeight()));
		    xTxt.setText(String.valueOf(selectedShape.getUpperLeftPoint().getX()));
		    yTxt.setText(String.valueOf(selectedShape.getUpperLeftPoint().getY()));
			outerColorButton.setBackground(selectedShape.getColor());
			innerColorButton.setBackground(selectedShape.getInnerColor());
			
			
			xLabel.setVisible(true);
			xTxt.setVisible(true);
			
			yLabel.setVisible(true);
			yTxt.setVisible(true);
			
			widthLabel.setVisible(true);
			widthTxt.setVisible(true);
			
			heightLabel.setVisible(true);
			heightTxt.setVisible(true);
			
			innerColorButton.setVisible(true);
			outerColorButton.setVisible(true);
			this.setTitle("Rectangle - Modify Mode");
		}
		pack();
		setLocationRelativeTo(null);
	}

	public int getRectX() {
		return this.X;
	}
	
	public void setX(int x) {
		this.X = x;
	}
	
	public int getRectY() {
		return this.Y;
	}
	
	public void setY(int y) {
		this.Y = y;
	}
	
	public int getRectWidth() {
		return this.Width;
	}
	
	public int getRectHeight() {
		return this.Height;
	}
	
	public Color getRectInner() {
		return this.inner;
	}
	
	public Color getRectOuter() {
		return this.outer;
	}

	public boolean isConfirm() {
		// TODO Auto-generated method stub
		return confirm;
	}
	
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}


}
