package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import drawing.PnlDrawing;
import geometry.Rectangle;

public class DialogTest extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTextField widthTxt;
	private JTextField heightTxt;
	
	  private PnlDrawing pnlDrawing;
	  private JTextField xTxt;
	  private JTextField yTxt;
	  
	  private JLabel xLbl;
	  private JLabel yLbl;
	  
	  private JButton outerColorButton;
	  private JButton innerColorButton;
	  
	  private boolean confirm;
		private int x;
		private int y;
		
		private Color outer = Color.black;
		private Color inner = Color.black;
		
		private int width;
		private int height;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			 PnlDrawing pnldrawing = new PnlDrawing(); 
			 Rectangle rect = new Rectangle();
	            DialogTest dialog = new DialogTest(pnldrawing,rect);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogTest(PnlDrawing pnldrawing, Rectangle rect) {
		String mode = pnldrawing.getCurrentMode();
		this.pnlDrawing = pnldrawing;
		setModal(true);
		setTitle("Set rectangle dimensions");
		setBounds(100, 100, 409, 284);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Width:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			widthTxt = new JTextField();
			GridBagConstraints gbc_widthTxt = new GridBagConstraints();
			gbc_widthTxt.gridwidth = 4;
			gbc_widthTxt.insets = new Insets(0, 0, 5, 5);
			gbc_widthTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_widthTxt.gridx = 1;
			gbc_widthTxt.gridy = 0;
			contentPanel.add(widthTxt, gbc_widthTxt);
			widthTxt.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Height:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			heightTxt = new JTextField();
			GridBagConstraints gbc_heightTxt = new GridBagConstraints();
			gbc_heightTxt.gridwidth = 4;
			gbc_heightTxt.insets = new Insets(0, 0, 5, 5);
			gbc_heightTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_heightTxt.gridx = 1;
			gbc_heightTxt.gridy = 1;
			contentPanel.add(heightTxt, gbc_heightTxt);
			heightTxt.setColumns(10);
		}
		{
			xLbl = new JLabel("X:");
			GridBagConstraints gbc_xLbl = new GridBagConstraints();
			gbc_xLbl.anchor = GridBagConstraints.EAST;
			gbc_xLbl.insets = new Insets(0, 0, 5, 5);
			gbc_xLbl.gridx = 0;
			gbc_xLbl.gridy = 2;
			contentPanel.add(xLbl, gbc_xLbl);
		}
		{
			xTxt = new JTextField();
			xTxt.setColumns(10);
			GridBagConstraints gbc_xTxt = new GridBagConstraints();
			gbc_xTxt.gridwidth = 4;
			gbc_xTxt.insets = new Insets(0, 0, 5, 5);
			gbc_xTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_xTxt.gridx = 1;
			gbc_xTxt.gridy = 2;
			contentPanel.add(xTxt, gbc_xTxt);
		}
		{
			yLbl = new JLabel("Y:");
			GridBagConstraints gbc_yLbl = new GridBagConstraints();
			gbc_yLbl.anchor = GridBagConstraints.EAST;
			gbc_yLbl.insets = new Insets(0, 0, 5, 5);
			gbc_yLbl.gridx = 0;
			gbc_yLbl.gridy = 3;
			contentPanel.add(yLbl, gbc_yLbl);
		}
		{
			yTxt = new JTextField();
			yTxt.setColumns(10);
			GridBagConstraints gbc_yTxt = new GridBagConstraints();
			gbc_yTxt.gridwidth = 4;
			gbc_yTxt.insets = new Insets(0, 0, 5, 5);
			gbc_yTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_yTxt.gridx = 1;
			gbc_yTxt.gridy = 3;
			contentPanel.add(yTxt, gbc_yTxt);
		}
		{
			innerColorButton = new JButton("InnerColor");
			innerColorButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					inner = JColorChooser.showDialog(null, "Choose Inner Color", inner);
					innerColorButton.setBackground(inner);
				}
			});
			GridBagConstraints gbc_innerColorButton = new GridBagConstraints();
			gbc_innerColorButton.insets = new Insets(0, 0, 5, 5);
			gbc_innerColorButton.gridx = 1;
			gbc_innerColorButton.gridy = 4;
			contentPanel.add(innerColorButton, gbc_innerColorButton);
		}
		{
			outerColorButton = new JButton("OuterColor");
			outerColorButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					outer = JColorChooser.showDialog(null, "Choose Outer Color", outer);
					outerColorButton.setBackground(outer);
				}
			});
			GridBagConstraints gbc_outerColorButton = new GridBagConstraints();
			gbc_outerColorButton.insets = new Insets(0, 0, 0, 5);
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
						if(mode=="Draw") {
						if(widthTxt.getText() != null && heightTxt.getText() != null) {
							try {int width = Integer.parseInt(widthTxt.getText());
								int height = Integer.parseInt(heightTxt.getText());
								System.out.println("Width: "+width+" Height: "+height);
								pnlDrawing.setRectangleDimensions(height, width);
								setVisible(false);
								
							
							}
							catch (NumberFormatException e1){
								setTitle("Values should be integers");
							}
						}
					}else {confirm = true;
						x = Integer.parseInt(xTxt.getText());
						y = Integer.parseInt(yTxt.getText());
						width = Integer.parseInt(widthTxt.getText());
						height = Integer.parseInt(heightTxt.getText());
						setVisible(false);
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
		
		if(mode == "Modify") {
			setTitle("Modify rectangle");
			xLbl.setVisible(true);
			yLbl.setVisible(true);
			xTxt.setVisible(true);
			yTxt.setVisible(true);
			innerColorButton.setVisible(true);
			outerColorButton.setVisible(true);
			widthTxt.setVisible(true);
			heightTxt.setVisible(true);
			
			//setting values
			x = rect.getUpperLeftPoint().getX();
			y = rect.getUpperLeftPoint().getX();	
			outer = rect.getColor();
			inner = rect.getInnerColor();
			width = rect.getWidth();
			height = rect.getHeight();
			
			//update UI
			widthTxt.setText(Integer.toString(width));
			heightTxt.setText(Integer.toString(height));
			xTxt.setText(Integer.toString(x));
			yTxt.setText(Integer.toString(y));
			innerColorButton.setBackground(inner);
			outerColorButton.setBackground(outer);
			
		}else {
			setTitle("Set rectangle dimensions");
			widthTxt.setVisible(true);
			heightTxt.setVisible(true);
			xLbl.setVisible(false);
			yLbl.setVisible(false);
			xTxt.setVisible(false);
			yTxt.setVisible(false);
			innerColorButton.setVisible(false);
			outerColorButton.setVisible(false);
		}
		
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getOuter() {
		return outer;
	}

	public void setOuter(Color outer) {
		this.outer = outer;
	}

	public Color getInner() {
		return inner;
	}

	public void setInner(Color inner) {
		this.inner = inner;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}


