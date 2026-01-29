package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private PnlDrawing pnldrawing;
	
	//First Point
	private int x1;
	private int y1;
	
	//Second Point
	private int x2;
	private int y2;
	
	private boolean confirm;

	private Color color;
	private JTextField x1Txt;
	private JTextField y1Txt;
	private JTextField x2Txt;
	private JTextField y2Txt;
	private JButton colorButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PnlDrawing pnlDrawing = new PnlDrawing();
			Line line = new Line();
			DialogLine dialog = new DialogLine(pnlDrawing,line);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLine(PnlDrawing pnldrawing,Line line) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		String mode = pnldrawing.getCurrentMode();
		this.pnldrawing = pnldrawing;
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
			JLabel x1Label = new JLabel("X1:");
			GridBagConstraints gbc_x1Label = new GridBagConstraints();
			gbc_x1Label.anchor = GridBagConstraints.EAST;
			gbc_x1Label.insets = new Insets(0, 0, 5, 5);
			gbc_x1Label.gridx = 0;
			gbc_x1Label.gridy = 0;
			contentPanel.add(x1Label, gbc_x1Label);
		}
		{
			x1Txt = new JTextField();
			GridBagConstraints gbc_x1Txt = new GridBagConstraints();
			gbc_x1Txt.insets = new Insets(0, 0, 5, 0);
			gbc_x1Txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_x1Txt.gridx = 1;
			gbc_x1Txt.gridy = 0;
			contentPanel.add(x1Txt, gbc_x1Txt);
			x1Txt.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Y1:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			y1Txt = new JTextField();
			y1Txt.setColumns(10);
			GridBagConstraints gbc_y1Txt = new GridBagConstraints();
			gbc_y1Txt.insets = new Insets(0, 0, 5, 0);
			gbc_y1Txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_y1Txt.gridx = 1;
			gbc_y1Txt.gridy = 1;
			contentPanel.add(y1Txt, gbc_y1Txt);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("X2:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 3;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			x2Txt = new JTextField();
			x2Txt.setColumns(10);
			GridBagConstraints gbc_x2Txt = new GridBagConstraints();
			gbc_x2Txt.insets = new Insets(0, 0, 5, 0);
			gbc_x2Txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_x2Txt.gridx = 1;
			gbc_x2Txt.gridy = 3;
			contentPanel.add(x2Txt, gbc_x2Txt);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Y2:");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 4;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			y2Txt = new JTextField();
			y2Txt.setColumns(10);
			GridBagConstraints gbc_y2Txt = new GridBagConstraints();
			gbc_y2Txt.insets = new Insets(0, 0, 5, 0);
			gbc_y2Txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_y2Txt.gridx = 1;
			gbc_y2Txt.gridy = 4;
			contentPanel.add(y2Txt, gbc_y2Txt);
		}
		{
			colorButton = new JButton("Color");
			colorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
					colorButton.setBackground(color);
				}
			});
			GridBagConstraints gbc_colorButton = new GridBagConstraints();
			gbc_colorButton.gridx = 1;
			gbc_colorButton.gridy = 5;
			contentPanel.add(colorButton, gbc_colorButton);
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
						x1 = Integer.parseInt(x1Txt.getText());
						y1 = Integer.parseInt(y1Txt.getText());
						
						x2 = Integer.parseInt(x2Txt.getText());
						y2 = Integer.parseInt(y2Txt.getText());
						setVisible(false);
						confirm = true;
						}catch(NumberFormatException e1) {JOptionPane.showMessageDialog(null, "Please enter valid integers", "Warning",
								JOptionPane.WARNING_MESSAGE);}
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
		color = line.getColor();
		x1Txt.setText(Integer.toString(line.getStartPoint().getX()));
		y1Txt.setText(Integer.toString(line.getStartPoint().getY()));
		
		x2Txt.setText(Integer.toString(line.getEndPoint().getX()));
		y2Txt.setText(Integer.toString(line.getEndPoint().getY()));
		colorButton.setBackground(color);
		
		
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
