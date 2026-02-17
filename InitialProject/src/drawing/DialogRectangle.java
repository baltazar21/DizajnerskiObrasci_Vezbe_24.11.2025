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
import mvc.DrawingFrame;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class DialogRectangle extends JDialog {

	private static final long serialVersionUID = 1L;

	
	
	
	private final JPanel contentPanel = new JPanel();
	private DrawingFrame pnlDrawing;
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
	private Color outerColor;
	private Color innerColor;
	private boolean confirm;
	
	private JTextField widthTxt;
	private JTextField heightTxt;
	private JTextField xTxt;
	private JTextField yTxt;
	
	private JLabel xLabel;
	private JLabel yLabel;
	private JLabel widthLabel;
	private JLabel heightLabel;
	private JCheckBox useGlobalInnerChk;
	private JCheckBox useGlobalOuterChk;

	/**
	 * Create the dialog.
	 * @param currentMode 
	 */
	public DialogRectangle(DrawingFrame frame, Rectangle selectedShape) {
		//setBounds(100, 100, 450, 300);
		setModal(true);

		
		
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
					innerColor = JColorChooser.showDialog(null, "Choose Inner Color", Color.BLACK);
					innerColorButton.setBackground(innerColor);
				}
			});
			{
				useGlobalInnerChk = new JCheckBox("Use Global?");
				GridBagConstraints gbc_useGlobalInnerChk = new GridBagConstraints();
				gbc_useGlobalInnerChk.insets = new Insets(0, 0, 5, 5);
				gbc_useGlobalInnerChk.gridx = 0;
				gbc_useGlobalInnerChk.gridy = 4;
				contentPanel.add(useGlobalInnerChk, gbc_useGlobalInnerChk);
			}
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
					outerColor = JColorChooser.showDialog(null, "Choose Outer Color", Color.BLACK);
					outerColorButton.setBackground(outerColor);
				}
			});
			{
				useGlobalOuterChk = new JCheckBox("Use Global?");
				GridBagConstraints gbc_useGlobalOuterChk = new GridBagConstraints();
				gbc_useGlobalOuterChk.insets = new Insets(0, 0, 0, 5);
				gbc_useGlobalOuterChk.gridx = 0;
				gbc_useGlobalOuterChk.gridy = 5;
				contentPanel.add(useGlobalOuterChk, gbc_useGlobalOuterChk);
			}
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
						  try {
						        Width = Integer.parseInt(widthTxt.getText());
						        Height = Integer.parseInt(heightTxt.getText());
						        if (selectedShape != null) 
						        {
						        	X = Integer.parseInt(xTxt.getText()); 
						        	Y = Integer.parseInt(yTxt.getText()); 
						        }
						        
						        if (useGlobalInnerChk.isSelected())
						        	innerColor = frame.getGlobalInnerColor();
						        if (useGlobalOuterChk.isSelected()) 
						        	outerColor = frame.getGlobalOuterColor();
						        
						        confirm = true;
						        setVisible(false);
						        
						        if (selectedShape == null)
						            System.out.println("Finished Draw RectangleDialog Width: " + Width + " Height: " + Height);
						        else
						            System.out.println("Finished Modify Rectangle");
						    } catch (NumberFormatException ex) {
						        JOptionPane.showMessageDialog(null, "Please enter valid integers", "Warning", JOptionPane.WARNING_MESSAGE);
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
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		if (selectedShape == null) {
			xTxt.setVisible(false);
        	yTxt.setVisible(false);
			xLabel.setVisible(false);
			yLabel.setVisible(false);
			this.setTitle("Rectangle - Draw Mode");
		} else {
		    widthTxt.setText(String.valueOf(selectedShape.getWidth()));
		    heightTxt.setText(String.valueOf(selectedShape.getHeight()));
		    xTxt.setText(String.valueOf(selectedShape.getUpperLeftPoint().getX()));
		    yTxt.setText(String.valueOf(selectedShape.getUpperLeftPoint().getY()));
		    outerColorButton.setBackground(selectedShape.getColor());
		    innerColorButton.setBackground(selectedShape.getInnerColor());
		    outerColor = selectedShape.getColor();
        	innerColor = selectedShape.getInnerColor();
		    
		    xLabel.setVisible(true);
		    yLabel.setVisible(true);
		 	xTxt.setVisible(true);
        	yTxt.setVisible(true);
		    this.setTitle("Rectangle - Modify Mode");
		}

		pack();
		setLocationRelativeTo(null);
	}

	//Getterss
	public int getRectX() {return this.X;}
	public int getRectY() {return this.Y;}
	public int getRectWidth() {return this.Width;}
	public int getRectHeight() {return this.Height;}
	public Color getRectInnerColor() {return this.innerColor;}
	public Color getRectOuterColor() {return this.outerColor;}
	public boolean isConfirm() {return confirm;}
	
}      
