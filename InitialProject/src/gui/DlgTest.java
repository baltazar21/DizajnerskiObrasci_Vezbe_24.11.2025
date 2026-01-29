package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTest extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField rTxtField;
	private JTextField gTxtField;
	private JTextField bTxtField;
	private boolean isOkay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTest dialog = new DlgTest();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTest() {
		setTitle("Dodavanje boja");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblR = new JLabel("R");
			GridBagConstraints gbc_lblR = new GridBagConstraints();
			gbc_lblR.insets = new Insets(0, 0, 5, 5);
			gbc_lblR.anchor = GridBagConstraints.EAST;
			gbc_lblR.gridx = 0;
			gbc_lblR.gridy = 0;
			contentPanel.add(lblR, gbc_lblR);
		}
		{
			rTxtField = new JTextField();
			GridBagConstraints gbc_rTxtField = new GridBagConstraints();
			gbc_rTxtField.fill = GridBagConstraints.HORIZONTAL;
			gbc_rTxtField.insets = new Insets(0, 0, 5, 0);
			gbc_rTxtField.gridx = 1;
			gbc_rTxtField.gridy = 0;
			contentPanel.add(rTxtField, gbc_rTxtField);
			rTxtField.setColumns(10);
		}
		{
			JLabel lblG = new JLabel("G");
			GridBagConstraints gbc_lblG = new GridBagConstraints();
			gbc_lblG.anchor = GridBagConstraints.EAST;
			gbc_lblG.insets = new Insets(0, 0, 5, 5);
			gbc_lblG.gridx = 0;
			gbc_lblG.gridy = 1;
			contentPanel.add(lblG, gbc_lblG);
		}
		{
			gTxtField = new JTextField();
			gTxtField.setColumns(10);
			GridBagConstraints gbc_gTxtField = new GridBagConstraints();
			gbc_gTxtField.insets = new Insets(0, 0, 5, 0);
			gbc_gTxtField.fill = GridBagConstraints.HORIZONTAL;
			gbc_gTxtField.gridx = 1;
			gbc_gTxtField.gridy = 1;
			contentPanel.add(gTxtField, gbc_gTxtField);
		}
		{
			JLabel lblB = new JLabel("B");
			GridBagConstraints gbc_lblB = new GridBagConstraints();
			gbc_lblB.insets = new Insets(0, 0, 0, 5);
			gbc_lblB.anchor = GridBagConstraints.EAST;
			gbc_lblB.gridx = 0;
			gbc_lblB.gridy = 2;
			contentPanel.add(lblB, gbc_lblB);
		}
		{
			bTxtField = new JTextField();
			bTxtField.setColumns(10);
			GridBagConstraints gbc_bTxtField = new GridBagConstraints();
			gbc_bTxtField.fill = GridBagConstraints.HORIZONTAL;
			gbc_bTxtField.gridx = 1;
			gbc_bTxtField.gridy = 2;
			contentPanel.add(bTxtField, gbc_bTxtField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int r = Integer.parseInt(rTxtField.getText());
						int g = Integer.parseInt(gTxtField.getText());
						int b = Integer.parseInt(bTxtField.getText());
						String color = r+" "+g+""+b;
						if(r>=0 && r<256 && g>=0 && g<256 && b>=0 && b<256) {
							MainFrame main = new MainFrame();
							main.addElement(color);
							
							
						}else {
							//JOptionPane.showMessageDialog(null, "Vrednosti su van opsega."); <--- Popravi ovo?????
							
						}
						
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
	}

	public JTextField getrTxtField() {
		return rTxtField;
	}

	public void setrTxtField(JTextField rTxtField) {
		this.rTxtField = rTxtField;
	}

	public JTextField getgTxtField() {
		return gTxtField;
	}

	public void setgTxtField(JTextField gTxtField) {
		this.gTxtField = gTxtField;
	}

	public JTextField getbTxtField() {
		return bTxtField;
	}

	public void setbTxtField(JTextField bTxtField) {
		this.bTxtField = bTxtField;
	}

	public boolean isOkay() {
		return isOkay;
	}

	public void setOkay(boolean isOkay) {
		this.isOkay = isOkay;
	}

}
