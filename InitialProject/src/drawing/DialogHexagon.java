package drawing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import geometry.HexagonAdapter;
import mvc.DrawingFrame;

public class DialogHexagon extends JDialog {

    private static final long serialVersionUID = 1L;

    private final JPanel contentPanel = new JPanel();

    private JTextField radiusTxt;
    private JTextField xTxt;
    private JTextField yTxt;

    private JLabel xLbl;
    private JLabel yLbl;

    private JButton innerColorButton;
    private JButton outerColorButton;

    private JCheckBox useGlobalInnerChk;
    private JCheckBox useGlobalOuterChk;

    private boolean confirm;

    private int X;
    private int Y;
    private int r;

    private Color outerColor = Color.BLACK;
    private Color innerColor = Color.BLACK;

    private DrawingFrame frame;
    private HexagonAdapter selectedShape;

    public DialogHexagon(DrawingFrame frame, HexagonAdapter selectedShape) {

        this.frame = frame;
        this.selectedShape = selectedShape;

        setModal(true);
        setBounds(100, 100, 300, 230);
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new GridBagLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        GridBagConstraints gbc;

        // Radius
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Radius:"), gbc);

        radiusTxt = new JTextField(10);
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(radiusTxt, gbc);

        // X
        xLbl = new JLabel("Center X:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(xLbl, gbc);

        xTxt = new JTextField(10);
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(xTxt, gbc);

        // Y
        yLbl = new JLabel("Center Y:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(yLbl, gbc);

        yTxt = new JTextField(10);
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(yTxt, gbc);

        // Inner color
        useGlobalInnerChk = new JCheckBox("Use Global?");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.insets = new Insets(5,5,5,5);
        contentPanel.add(useGlobalInnerChk, gbc);

        innerColorButton = new JButton("Inner Color");
        innerColorButton.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Choose Inner Color", innerColor);
            if (c != null) {
                innerColor = c;
                innerColorButton.setBackground(c);
            }
        });

        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.insets = new Insets(5,5,5,5);
        contentPanel.add(innerColorButton, gbc);

        // Outer color
        useGlobalOuterChk = new JCheckBox("Use Global?");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.insets = new Insets(5,5,5,5);
        contentPanel.add(useGlobalOuterChk, gbc);

        outerColorButton = new JButton("Outer Color");
        outerColorButton.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Choose Outer Color", outerColor);
            if (c != null) {
                outerColor = c;
                outerColorButton.setBackground(c);
            }
        });

        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.insets = new Insets(5,5,5,5);
        contentPanel.add(outerColorButton, gbc);

        // Buttons panel
        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
				        r = Integer.parseInt(radiusTxt.getText());
				        
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
				            System.out.println("Finished Draw DialogHexagon Radius: " + r);
				        else
				            System.out.println("Finished Modify Hexagon");
				    } catch (NumberFormatException ex) {
				        JOptionPane.showMessageDialog(null, "Please enter valid integers", "Warning", JOptionPane.WARNING_MESSAGE);
				    }
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            confirm = false;
            setVisible(false);
        });
        buttonPane.add(cancelButton);

        if(selectedShape == null) {
        	xTxt.setVisible(false);
        	yTxt.setVisible(false);
        	xLbl.setVisible(false);
        	yLbl.setVisible(false);
        	
        	this.setTitle("Hexagon - Draw Mode");
        }else {
          	xTxt.setVisible(true); 
        	yTxt.setVisible(true);
        	xLbl.setVisible(true);
        	yLbl.setVisible(true);
        	
        	xTxt.setText(String.valueOf(selectedShape.getX()));
        	yTxt.setText(String.valueOf(selectedShape.getY()));
        	radiusTxt.setText(String.valueOf(selectedShape.getR()));
        	outerColorButton.setBackground(selectedShape.getColor());
    		    innerColorButton.setBackground(selectedShape.getInnerColor());
        	outerColor = selectedShape.getColor();
        	innerColor = selectedShape.getInnerColor();
    		    
    		    
        	this.setTitle("Hexagon - Modify Mode");
        }
    }

    // Getters
    public int getR() { return r; }
    public int getX() { return X; }
    public int getY() { return Y; }
    public Color getOuterColor() { return outerColor; }
    public Color getInnerColor() { return innerColor; }
    public boolean isConfirm() { return confirm; }
}