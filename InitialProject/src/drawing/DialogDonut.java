package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField innerTxt;
	private JTextField outerTxt;

	private PnlDrawing pnlDrawing;
	private JTextField xTxt;
	private JTextField yTxt;
	
	private JLabel xLabel;
	private JLabel yLabel;
	
	
	private JButton innerColorButton;
	private JButton outerColorButton;
	
	private JButton innerColorButton1;
	private JButton outerColorButton1;

	private boolean confirm;
	private int x;
	private int y;
	private int r;
	private int r2;
	private Color outer = Color.black;
	private Color inner = Color.black;
	private JTextField xText;
	private JTextField yText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("called DialogDonut Main()");
		try {
			PnlDrawing pnldrawing = new PnlDrawing();
			Donut donut = new Donut();
			DialogDonut dialog = new DialogDonut(pnldrawing,donut);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogDonut(PnlDrawing pnldrawing,geometry.Donut donut) {
		System.out.println("called DialogDonut constr");
		setBounds(100, 100, 390, 271);
		String mode = pnldrawing.getCurrentMode();
		setModal(true);
		this.pnlDrawing = pnldrawing;
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
			JLabel innerLabel = new JLabel("Inner Radius:");
			GridBagConstraints gbc_innerLabel = new GridBagConstraints();
			gbc_innerLabel.anchor = GridBagConstraints.EAST;
			gbc_innerLabel.insets = new Insets(0, 0, 5, 5);
			gbc_innerLabel.gridx = 0;
			gbc_innerLabel.gridy = 0;
			contentPanel.add(innerLabel, gbc_innerLabel);
		}
		{
			innerTxt = new JTextField();
			GridBagConstraints gbc_innerTxt = new GridBagConstraints();
			gbc_innerTxt.insets = new Insets(0, 0, 5, 0);
			gbc_innerTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_innerTxt.gridx = 1;
			gbc_innerTxt.gridy = 0;
			contentPanel.add(innerTxt, gbc_innerTxt);
			innerTxt.setColumns(10);
		}
		{
			JLabel outerLabel = new JLabel("Outer Radius:");
			GridBagConstraints gbc_outerLabel = new GridBagConstraints();
			gbc_outerLabel.anchor = GridBagConstraints.EAST;
			gbc_outerLabel.insets = new Insets(0, 0, 5, 5);
			gbc_outerLabel.gridx = 0;
			gbc_outerLabel.gridy = 1;
			contentPanel.add(outerLabel, gbc_outerLabel);
		}
		{
			outerTxt = new JTextField();
			GridBagConstraints gbc_outerTxt = new GridBagConstraints();
			gbc_outerTxt.insets = new Insets(0, 0, 5, 0);
			gbc_outerTxt.fill = GridBagConstraints.HORIZONTAL;
			gbc_outerTxt.gridx = 1;
			gbc_outerTxt.gridy = 1;
			contentPanel.add(outerTxt, gbc_outerTxt);
			outerTxt.setColumns(10);
		}
		{
			xLabel = new JLabel("X:");
			GridBagConstraints gbc_xLabel = new GridBagConstraints();
			gbc_xLabel.anchor = GridBagConstraints.EAST;
			gbc_xLabel.insets = new Insets(0, 0, 5, 5);
			gbc_xLabel.gridx = 0;
			gbc_xLabel.gridy = 2;
			contentPanel.add(xLabel, gbc_xLabel);
		}
		{
			xText = new JTextField();
			xText.setColumns(10);
			GridBagConstraints gbc_xText = new GridBagConstraints();
			gbc_xText.insets = new Insets(0, 0, 5, 0);
			gbc_xText.fill = GridBagConstraints.HORIZONTAL;
			gbc_xText.gridx = 1;
			gbc_xText.gridy = 2;
			contentPanel.add(xText, gbc_xText);
		}
		{
			yLabel = new JLabel("Y:");
			GridBagConstraints gbc_yLabel = new GridBagConstraints();
			gbc_yLabel.anchor = GridBagConstraints.EAST;
			gbc_yLabel.insets = new Insets(0, 0, 5, 5);
			gbc_yLabel.gridx = 0;
			gbc_yLabel.gridy = 3;
			contentPanel.add(yLabel, gbc_yLabel);
		}
		{
			yText = new JTextField();
			yText.setColumns(10);
			GridBagConstraints gbc_yText = new GridBagConstraints();
			gbc_yText.insets = new Insets(0, 0, 5, 0);
			gbc_yText.fill = GridBagConstraints.HORIZONTAL;
			gbc_yText.gridx = 1;
			gbc_yText.gridy = 3;
			contentPanel.add(yText, gbc_yText);
		}
		{
			innerColorButton1 = new JButton("Inner Color");
			innerColorButton1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					inner = JColorChooser.showDialog(null, "Choose Inner Color", Color.BLACK);
					innerColorButton1.setBackground(inner);
				}
			});
			GridBagConstraints gbc_innerColorButton1 = new GridBagConstraints();
			gbc_innerColorButton1.insets = new Insets(0, 0, 5, 0);
			gbc_innerColorButton1.gridx = 1;
			gbc_innerColorButton1.gridy = 4;
			contentPanel.add(innerColorButton1, gbc_innerColorButton1);
		}
		{
			outerColorButton1 = new JButton("Outer Color");
			outerColorButton1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					outer = JColorChooser.showDialog(null, "Choose Outer Color", Color.BLACK);
					outerColorButton1.setBackground(outer);
				}
			});
			GridBagConstraints gbc_outerColorButton1 = new GridBagConstraints();
			gbc_outerColorButton1.gridx = 1;
			gbc_outerColorButton1.gridy = 5;
			contentPanel.add(outerColorButton1, gbc_outerColorButton1);
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
						if(innerTxt.getText() != null && outerTxt.getText() != null) {
							try {
								r = Integer.parseInt(innerTxt.getText());
								r2 = Integer.parseInt(outerTxt.getText());
								pnldrawing.setDonutRadiuses(r,r2);
								confirm = true;
								setVisible(false);
							}catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Please enter valid integers", "Warning!",
										JOptionPane.WARNING_MESSAGE);
							}
						}else { JOptionPane.showMessageDialog(null, "Please  input all values.", "Warning!",
								JOptionPane.WARNING_MESSAGE);}
					}else {
					try {
					r = Integer.parseInt(innerTxt.getText());
					r2 = Integer.parseInt(outerTxt.getText());
					x = Integer.parseInt(xText.getText());
					y = Integer.parseInt(yText.getText());
					confirm = true;
					setVisible(false);
					
					}catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Please enter valid integers.", "Warning!",
								JOptionPane.WARNING_MESSAGE);
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
						confirm = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(mode == "Modify") {
			setTitle("Modify Donut");
			xText.setVisible(true);
			yText.setVisible(true);
			innerColorButton1.setVisible(true);
			outerColorButton1.setVisible(true);
			yLabel.setVisible(true);
			xLabel.setVisible(true);
			
			
			x = donut.getCenter().getX();
			y = donut.getCenter().getY();
			r = donut.getInnerRadius();	
			r2 = donut.getRadius();
			outer = donut.getColor();
			inner = donut.getInnerColor();
			innerTxt.setText(Integer.toString(r));
			outerTxt.setText(Integer.toString(r2));
			xText.setText(Integer.toString(x));
			yText.setText(Integer.toString(y));
			innerColorButton1.setBackground(inner);
			outerColorButton1.setBackground(outer);
			
		}else {
			setTitle("Set Donut Radiuses");
			
			innerTxt.setVisible(true);
			outerTxt.setVisible(true);
			
			yLabel.setVisible(false);
			xLabel.setVisible(false);
			xText.setVisible(false);
			yText.setVisible(false);
			innerColorButton1.setVisible(false);
			outerColorButton1.setVisible(false);
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

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getR2() {
		return r2;
	}

	public void setR2(int r2) {
		this.r2 = r2;
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
	

}
