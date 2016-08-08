import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EllouganiFlAmazonAddPriceFilterFrame extends JFrame {

	private JPanel contentPane;
	private final JButton btnOk = new JButton("OK");
	private final JButton btnCancel = new JButton("Cancel");
	private final JRadioButton rdbtnLessThan = new JRadioButton("");
	private final JRadioButton rdbtnGreaterThan = new JRadioButton("");
	private final JRadioButton rdbtnRange = new JRadioButton("");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblLessThan = new JLabel("Less Than:");
	private final JLabel lblGreaterThan = new JLabel("Greater Than:");
	private final JLabel lblMin = new JLabel("Minimum:");
	private final JTextField lessThanTF = new JTextField();
	private final JTextField greaterThanTF = new JTextField();
	private final JTextField minTF = new JTextField();
	private final JLabel lblMaximum = new JLabel("Maximum:");
	private final JTextField maximumTF = new JTextField();
	private Filter thing = new Filter();

	/**
	 * Create the frame.
	 */
	public EllouganiFlAmazonAddPriceFilterFrame(Filter filter) {
		thing = filter;
		maximumTF.setToolTipText("Select and fill in fields for an in between price filter");
		maximumTF.setEditable(false);
		maximumTF.setBounds(320, 145, 86, 20);
		maximumTF.setColumns(10);
		minTF.setToolTipText("Select and fill in fields for an in between price filter");
		minTF.setEditable(false);
		minTF.setBounds(138, 145, 86, 20);
		minTF.setColumns(10);
		greaterThanTF.setToolTipText("Select and fill in fields for a greater than price filter");
		greaterThanTF.setEditable(false);
		greaterThanTF.setBounds(171, 98, 86, 20);
		greaterThanTF.setColumns(10);
		lessThanTF.setToolTipText("Select and fill in fields for a less than price filter");
		lessThanTF.setEditable(false);
		lessThanTF.setBounds(150, 59, 86, 20);
		lessThanTF.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Ellougani FlAmazon Add Price Filter");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnOk.setToolTipText("Click to complete price filter");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		btnOk.setBounds(81, 227, 89, 23);
		
		contentPane.add(btnOk);
		btnCancel.setToolTipText("Click to cancel price filter");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(255, 227, 89, 23);
		
		contentPane.add(btnCancel);
		buttonGroup.add(rdbtnLessThan);
		rdbtnLessThan.setToolTipText("Select and fill in fields for a less than price filter");
		rdbtnLessThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnLessThan_actionPerformed(arg0);
			}
		});
		rdbtnLessThan.setBounds(28, 56, 34, 23);
		
		contentPane.add(rdbtnLessThan);
		buttonGroup.add(rdbtnGreaterThan);
		rdbtnGreaterThan.setToolTipText("Select and fill in fields for a greater than price filter");
		rdbtnGreaterThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnGreaterThan_actionPerformed(arg0);
			}
		});
		rdbtnGreaterThan.setBounds(28, 98, 34, 23);
		
		contentPane.add(rdbtnGreaterThan);
		buttonGroup.add(rdbtnRange);
		rdbtnRange.setToolTipText("Select and fill in fields for an in between price filter");
		rdbtnRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnRange_actionPerformed(arg0);
			}
		});
		rdbtnRange.setBounds(28, 142, 34, 23);
		
		contentPane.add(rdbtnRange);
		lblLessThan.setToolTipText("Select and fill in fields for a less than price filter");
		lblLessThan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLessThan.setBounds(62, 59, 78, 14);
		
		contentPane.add(lblLessThan);
		lblGreaterThan.setToolTipText("Select and fill in fields for a greater than price filter");
		lblGreaterThan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGreaterThan.setBounds(62, 102, 99, 14);
		
		contentPane.add(lblGreaterThan);
		lblMin.setToolTipText("Select and fill in fields for an in between price filter");
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMin.setBounds(62, 146, 78, 14);
		
		contentPane.add(lblMin);
		
		contentPane.add(lessThanTF);
		
		contentPane.add(greaterThanTF);
		
		contentPane.add(minTF);
		lblMaximum.setToolTipText("Select and fill in fields for an in between price filter");
		lblMaximum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaximum.setBounds(237, 146, 77, 14);
		
		contentPane.add(lblMaximum);
		
		contentPane.add(maximumTF);
	}
	
	//Makes sure everything is cleared when another field to fill out is selected
	public void deSelect(){
		lessThanTF.setEditable(false);
		lessThanTF.setText("");
		greaterThanTF.setEditable(false);
		greaterThanTF.setText("");
		minTF.setEditable(false);
		minTF.setText("");
		maximumTF.setEditable(false);
		maximumTF.setText("");
	}
	
	//Calls the deselect function and allows use of the text field
	protected void do_rdbtnLessThan_actionPerformed(ActionEvent arg0) {
		deSelect();
		lessThanTF.setEditable(true);
	}
	
	//Calls the deselect function and allows use of the text field
	protected void do_rdbtnGreaterThan_actionPerformed(ActionEvent arg0) {
		deSelect();
		greaterThanTF.setEditable(true);
	}
	
	//Calls the deselect function and allows use of the text field
	protected void do_rdbtnRange_actionPerformed(ActionEvent arg0) {
		deSelect();
		minTF.setEditable(true);
		maximumTF.setEditable(true);
	}
	
	//Calls the deselect function and allows use of the text field
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	//Checks the values to make sure something is selected and that the input is a number
	public boolean checkValues(){
		if(rdbtnLessThan.isSelected() == false && rdbtnGreaterThan.isSelected() == false && rdbtnRange.isSelected() == false){
			JOptionPane.showMessageDialog(this, "Select one of the buttons and fill out the fields!", "Nothing Selected", 0);
			return false;
		}else if(rdbtnLessThan.isSelected() == true){
			try {
			     Double.parseDouble(lessThanTF.getText());
			     return true;
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Enter a number!", "Wrong format", 0);
				return false;
			}
		}else if(rdbtnGreaterThan.isSelected() == true){
			try {
				 Double.parseDouble(greaterThanTF.getText());
				 return true;
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Enter a number!", "Wrong format", 0);
				return false;
			}
		}else if(rdbtnRange.isSelected() == true){
			try {
				 Double.parseDouble(minTF.getText());
				 Double.parseDouble(maximumTF.getText());
				 return true;
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Enter a number!", "Wrong format", 0);
				return false;
			} 
		}else{
			return true;
		}
	}
	
	//Calls the check value function, and then if true it sets a filter number and price into the filter class
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		if(checkValues()){
			if(rdbtnLessThan.isSelected() == true){
				thing.setLessThanPrice(Double.parseDouble(lessThanTF.getText()));
				thing.setFilterNum(1);
				this.dispose();
			}else if(rdbtnGreaterThan.isSelected() == true){
				thing.setGreaterThanPrice(Double.parseDouble(greaterThanTF.getText()));
				thing.setFilterNum(2);
				this.dispose();
			}else if(rdbtnRange.isSelected() == true){
				if(Double.parseDouble(minTF.getText()) > Double.parseDouble(maximumTF.getText())){
					JOptionPane.showMessageDialog(this, "Make sure the min value is less than the max", "Incorrect Values", 0);
				}else{				
				thing.setMinPrice(Double.parseDouble(minTF.getText()));
				thing.setMaxPrice(Double.parseDouble(maximumTF.getText()));
				thing.setFilterNum(3);
				this.dispose();
				}
			}
		}
	}
}
