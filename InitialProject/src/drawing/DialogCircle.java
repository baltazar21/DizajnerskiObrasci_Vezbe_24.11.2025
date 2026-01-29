package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogCircle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField radiusTxt;
	
	private PnlDrawing pnlDrawing;
	private JTextField xTxt;
	private JTextField yTxt;
	
	private JLabel xLbl;
	private JLabel yLbl;
	
	private JButton innerColorButton;
	private JButton outerColorButton;

	private boolean confirm;
	private int x;
	private int y;
	private int r;
	private Color outer = Color.black;
	private Color inner = Color.black;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PnlDrawing pnlDrawing = new PnlDrawing();
			Circle circle = new Circle();
			DialogCircle dialog = new DialogCircle(pnlDrawing,circle);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCircle(PnlDrawing pnldrawing, Circle circle) {
		
		String mode = pnldrawing.getCurrentMode();
		setModal(true);
		this.pnlDrawing = pnldrawing;
		setBounds(100, 100, 357, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Radius:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			radiusTxt = new JTextField();
			GridBagConstraints gbc_radiusTxt = new GridBagConstraints();
			gbc_radiusTxt.insets = new Insets(0, 0, 5, 0);
			gbc_radiusTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_radiusTxt.gridx = 1;
			gbc_radiusTxt.gridy = 0;
			contentPanel.add(radiusTxt, gbc_radiusTxt);
			radiusTxt.setColumns(10);
		}
		{
			xLbl = new JLabel("Center X:");
			GridBagConstraints gbc_xLbl = new GridBagConstraints();
			gbc_xLbl.anchor = GridBagConstraints.EAST;
			gbc_xLbl.insets = new Insets(0, 0, 5, 5);
			gbc_xLbl.gridx = 0;
			gbc_xLbl.gridy = 1;
			contentPanel.add(xLbl, gbc_xLbl);
		}
		{
			xTxt = new JTextField();
			xTxt.setColumns(10);
			GridBagConstraints gbc_xTxt = new GridBagConstraints();
			gbc_xTxt.insets = new Insets(0, 0, 5, 0);
			gbc_xTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_xTxt.gridx = 1;
			gbc_xTxt.gridy = 1;
			contentPanel.add(xTxt, gbc_xTxt);
		}
		{
			yLbl = new JLabel("Center Y:");
			GridBagConstraints gbc_yLbl = new GridBagConstraints();
			gbc_yLbl.anchor = GridBagConstraints.EAST;
			gbc_yLbl.insets = new Insets(0, 0, 5, 5);
			gbc_yLbl.gridx = 0;
			gbc_yLbl.gridy = 2;
			contentPanel.add(yLbl, gbc_yLbl);
		}
		{
			yTxt = new JTextField();
			yTxt.setColumns(10);
			GridBagConstraints gbc_yTxt = new GridBagConstraints();
			gbc_yTxt.insets = new Insets(0, 0, 5, 0);
			gbc_yTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_yTxt.gridx = 1;
			gbc_yTxt.gridy = 2;
			contentPanel.add(yTxt, gbc_yTxt);
		}
		{
			innerColorButton = new JButton("InnerColor");
			innerColorButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					inner = JColorChooser.showDialog(null, "Choose Inner Color", Color.BLACK);
					innerColorButton.setBackground(inner);
				}
			});
			GridBagConstraints gbc_innerColorButton = new GridBagConstraints();
			gbc_innerColorButton.insets = new Insets(0, 0, 5, 0);
			gbc_innerColorButton.gridx = 1;
			gbc_innerColorButton.gridy = 3;
			contentPanel.add(innerColorButton, gbc_innerColorButton);
		}
		{
			outerColorButton = new JButton("OuterColor");
			outerColorButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					outer = JColorChooser.showDialog(null, "Choose Outer Color", Color.BLACK);
					outerColorButton.setBackground(outer);
				}
			});
			GridBagConstraints gbc_outerColorButton = new GridBagConstraints();
			gbc_outerColorButton.gridx = 1;
			gbc_outerColorButton.gridy = 4;
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
						if(mode == "Draw") {
						if(radiusTxt.getText() != null && Integer.parseInt(radiusTxt.getText()) != 0) {
							try {int r = Integer.parseInt(radiusTxt.getText());
								pnlDrawing.setCircleRadius(r);
								setVisible(false);
							
					}catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Please enter valid integers", "Warning!",
								JOptionPane.WARNING_MESSAGE);
					}
						
				}else {JOptionPane.showMessageDialog(null, "Values must be greater than 0.", "Warning!",
						JOptionPane.WARNING_MESSAGE);;}
			}else {
				confirm = true; 
				setVisible(false);
				x = Integer.parseInt(xTxt.getText());
				y = Integer.parseInt(yTxt.getText());
				r = Integer.parseInt(radiusTxt.getText());
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
						
						
						if(mode == "Modify") {
							confirm=false;
							setVisible(false);
						}
						
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		if(mode == "Modify") {
			setTitle("Modify circle");
			xLbl.setVisible(true);
			yLbl.setVisible(true);
			xTxt.setVisible(true);
			yTxt.setVisible(true);
			innerColorButton.setVisible(true);
			outerColorButton.setVisible(true);
			
			
			x = circle.getCenter().getX();
			y = circle.getCenter().getY();
			r = circle.getRadius();			
			outer = circle.getColor();
			inner = circle.getInnerColor();
			radiusTxt.setText(Integer.toString(r));
			xTxt.setText(Integer.toString(x));
			yTxt.setText(Integer.toString(y));
			innerColorButton.setBackground(inner);
			outerColorButton.setBackground(outer);
			
		}else {
			setTitle("Set circle radius");
			
			xLbl.setVisible(false);
			yLbl.setVisible(false);
			xTxt.setVisible(false);
			yTxt.setVisible(false);
			innerColorButton.setVisible(false);
			outerColorButton.setVisible(false);
		}
		
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
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

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

}
