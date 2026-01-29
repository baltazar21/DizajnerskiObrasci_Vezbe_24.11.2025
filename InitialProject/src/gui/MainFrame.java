package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList<String> boje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Vezbanje");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{284, 121, 121, 0};
		gbl_panel_3.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Crvena");
		buttonGroup.add(tglbtnNewToggleButton);
		GridBagConstraints gbc_tglbtnNewToggleButton = new GridBagConstraints();
		gbc_tglbtnNewToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton.gridx = 0;
		gbc_tglbtnNewToggleButton.gridy = 0;
		panel_3.add(tglbtnNewToggleButton, gbc_tglbtnNewToggleButton);
		
		
		
		
		
		JToggleButton tglbtnPlava = new JToggleButton("Zelena");
		buttonGroup.add(tglbtnPlava);
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 1;
		panel_3.add(tglbtnPlava, gbc_tglbtnPlava);
		
		JToggleButton tglbtnPlava_2 = new JToggleButton("Plava");
		buttonGroup.add(tglbtnPlava_2);
		GridBagConstraints gbc_tglbtnPlava_2 = new GridBagConstraints();
		gbc_tglbtnPlava_2.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava_2.gridx = 0;
		gbc_tglbtnPlava_2.gridy = 2;
		panel_3.add(tglbtnPlava_2, gbc_tglbtnPlava_2);
		
		JButton btnNewButton = new JButton("Dodaj boju");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgTest dlg = new DlgTest();
				dlg.setVisible(true);
				
				String red = dlg.getrTxtField().toString();
				String green = dlg.getgTxtField().toString();
				String blue = dlg.getbTxtField().toString();
				String stringColor = red+" " +green+" "+blue;
				
				
			
			}
		});
		
		JButton izmeniBojuBTN = new JButton("Izmeni boju");
		izmeniBojuBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexOfSelectedElement = boje.getSelectedIndex();
				//String selectedElement = dlg.getElement(indexOfSelectedElement); <--- ne valjaa
			}
		});
		GridBagConstraints gbc_izmeniBojuBTN = new GridBagConstraints();
		gbc_izmeniBojuBTN.insets = new Insets(0, 0, 5, 5);
		gbc_izmeniBojuBTN.gridx = 0;
		gbc_izmeniBojuBTN.gridy = 4;
		panel_3.add(izmeniBojuBTN, gbc_izmeniBojuBTN);
		
		JList JList = new JList();
		GridBagConstraints gbc_JList = new GridBagConstraints();
		gbc_JList.gridheight = 8;
		gbc_JList.insets = new Insets(0, 0, 5, 5);
		gbc_JList.fill = GridBagConstraints.BOTH;
		gbc_JList.gridx = 1;
		gbc_JList.gridy = 4;
		panel_3.add(JList, gbc_JList);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 12;
		panel_3.add(btnNewButton, gbc_btnNewButton);
			
		}
	public void addElement(String s) {
		
	}
	}


