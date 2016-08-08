import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EllouganiFlAmazonAddItemFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblItemIdNumber = new JLabel("Item ID Number:");
	private final JLabel lblItemName = new JLabel("Item Name:");
	private final JLabel lblCategory = new JLabel("Category:");
	private final JLabel lblQuantity = new JLabel("Quantity:");
	private final JLabel lblPrice = new JLabel("Price:");
	private final JLabel lblShippingPrice = new JLabel("Shipping Price:");
	private final JButton btnOk = new JButton("OK");
	private final JButton btnCancel = new JButton("Cancel");
	private final JTextField itemIdNumberTF = new JTextField();
	private final JTextField itemNameTF = new JTextField();
	private final JComboBox categoryComboBox = new JComboBox();
	private final JTextField quantityTF = new JTextField();
	private final JTextField priceTF = new JTextField();
	private final JTextField shippingPriceTF = new JTextField();

	/**
	 * Create the frame.
	 */
	public EllouganiFlAmazonAddItemFrame() {
		shippingPriceTF.setToolTipText("Enter a price for the shipping of the item");
		shippingPriceTF.setBounds(161, 212, 86, 20);
		shippingPriceTF.setColumns(10);
		priceTF.setToolTipText("Enter a price for the item");
		priceTF.setBounds(161, 173, 86, 20);
		priceTF.setColumns(10);
		quantityTF.setToolTipText("Enter a number for the quantity of the item");
		quantityTF.setBounds(161, 132, 86, 20);
		quantityTF.setColumns(10);
		itemNameTF.setToolTipText("Fill in with text that hasn't been used as a name");
		itemNameTF.setBounds(161, 49, 86, 20);
		itemNameTF.setColumns(10);
		itemIdNumberTF.setToolTipText("Fill in with number that hasn't been used as an ID");
		itemIdNumberTF.setBounds(161, 10, 86, 20);
		itemIdNumberTF.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Ellougani FlAmazon Add Item");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblItemIdNumber.setToolTipText("Fill in with number that hasn't been used as an ID");
		lblItemIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemIdNumber.setBounds(10, 11, 143, 14);
		
		contentPane.add(lblItemIdNumber);
		lblItemName.setToolTipText("Fill in with text that hasn't been used as a name");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemName.setBounds(10, 50, 111, 14);
		
		contentPane.add(lblItemName);
		lblCategory.setToolTipText("Select one of the categories");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategory.setBounds(10, 90, 111, 20);
		
		contentPane.add(lblCategory);
		lblQuantity.setToolTipText("Enter a number for the quantity of the item");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(10, 130, 86, 20);
		
		contentPane.add(lblQuantity);
		lblPrice.setToolTipText("Enter a price for the item");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(10, 174, 57, 14);
		
		contentPane.add(lblPrice);
		lblShippingPrice.setToolTipText("Enter a price for the shipping of the item");
		lblShippingPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblShippingPrice.setBounds(10, 210, 132, 20);
		
		contentPane.add(lblShippingPrice);
		btnOk.setToolTipText("Click to finish adding an item");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		btnOk.setBounds(77, 241, 89, 23);
		
		contentPane.add(btnOk);
		btnCancel.setToolTipText("Click to cancel adding an item");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(233, 241, 89, 23);
		
		contentPane.add(btnCancel);
		
		contentPane.add(itemIdNumberTF);
		
		contentPane.add(itemNameTF);
		categoryComboBox.setToolTipText("Select one of the categories");
		categoryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Category", "Electronics", "Computers", "Clothing", "Music", "Books", "Movies", "HomeGarden", "Sports", "Automotive", "Other"}));
		categoryComboBox.setBounds(146, 92, 122, 20);
		
		contentPane.add(categoryComboBox);
		
		contentPane.add(quantityTF);
		
		contentPane.add(priceTF);
		
		contentPane.add(shippingPriceTF);
		
		//Step 1: Adding Driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Inserts a record into the database
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		Statement stmt = null;
		if(checkValues()){
			try {
				//2 Establish the connection
				Connection conn = DriverManager.getConnection("jdbc:ucanaccess://./FlAmazon.accdb");
				
				//3 Create the statement, a different type of statement to allow insert/update
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String theQuery = "INSERT INTO SHOPPINGCART(ItemId, ItemName, Category, Quantity, Price, Shipping) VALUES (";
				theQuery += itemIdNumberTF.getText().trim() + ", ";
				theQuery += "'" + itemNameTF.getText().trim() + "', ";
				theQuery += "'" + categoryComboBox.getSelectedItem().toString().trim() + "', ";
				theQuery += quantityTF.getText().trim() + ", ";
				theQuery += priceTF.getText().trim() + ", ";
				theQuery += shippingPriceTF.getText().trim() + ")";
				System.out.println(theQuery);
				
				
				//4 Execute the statement and check the result
				if(stmt.executeUpdate(theQuery) != 0){
					JOptionPane.showMessageDialog(this, "Sucessfully added an item!", "Success", 1);
					this.dispose();
				}
				conn.close();
				
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			}
		}
	}
	
	//Checks all the values in the database to make sure that there are no duplicates and empty values
	public boolean checkValues(){
		int x = 0;
		lblItemIdNumber.setForeground(Color.black);
		lblItemName.setForeground(Color.black);
		lblCategory.setForeground(Color.black);
		lblQuantity.setForeground(Color.black);
		lblPrice.setForeground(Color.black);
		lblShippingPrice.setForeground(Color.black);
		
		
		if(itemIdNumberTF.getText().isEmpty()){
			lblItemIdNumber.setForeground(Color.RED);
			x = 1;
		}
		if(itemNameTF.getText().isEmpty()){
			lblItemName.setForeground(Color.RED);
			x = 1;
		}
		if(categoryComboBox.getSelectedItem().toString() == "Select Category"){
			lblCategory.setForeground(Color.RED);
			x = 1;
		}
		if(quantityTF.getText().isEmpty()){
			lblQuantity.setForeground(Color.RED);
			x = 1;
		}
		if(priceTF.getText().isEmpty()){
			lblPrice.setForeground(Color.RED);
			x = 1;
		}
		if(shippingPriceTF.getText().isEmpty()){
			lblShippingPrice.setForeground(Color.RED);
			x = 1;
		}
		
		
		
		if(x == 1){
			JOptionPane.showMessageDialog(this, "Fill out the Add Item Fields!", "Missing Values", 0);
			return false;
		}else if(checkNumValues()){
			Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			//Step 2: Establish the connection
			try {
				Connection conn = DriverManager.getConnection("jdbc:ucanaccess://./FlAmazon.accdb");
				
				//Step 3: Create the statement
				stmt = conn.createStatement();
				
				String theQuery = "SELECT ItemID FROM ShoppingCart WHERE ItemID = ";
				theQuery += itemIdNumberTF.getText().trim();
				String theQuery2 = "SELECT ItemName FROM ShoppingCart WHERE ItemName = ";
				theQuery2 += "'" + itemNameTF.getText().trim() + "'";
				
				//Step 4: Execute the statement
				rs = stmt.executeQuery(theQuery);
				if(rs.next()){
					x = 2;
					lblItemIdNumber.setForeground(Color.red);
				}
				
				rs2 = stmt.executeQuery(theQuery2);
				if(rs2.next()){
					x = 2;
					lblItemName.setForeground(Color.red);
				}				
				//DO NOT FORGET THESE STEPS!!!
				rs.close();
				rs2.close();
				conn.close();
			} catch (SQLException ex){
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} //catch
			if(x == 0){
				return true;
			}else{
				JOptionPane.showMessageDialog(this, "Change fields in red", "Same Value", 0);
				return false;
			}
		}else{
			return false;
		}
	}
	
	//Check if it is a number rather than text
	public boolean checkNumValues(){
		try {
		     Double.parseDouble(itemIdNumberTF.getText());
		     Double.parseDouble(quantityTF.getText());
		     Double.parseDouble(priceTF.getText());
		     Double.parseDouble(shippingPriceTF.getText());
		     return true;
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Make sure all the red fields are numbers instead of text!", "Wrong format", 0);
			lblItemIdNumber.setForeground(Color.RED);
			lblQuantity.setForeground(Color.RED);
			lblPrice.setForeground(Color.RED);
			lblShippingPrice.setForeground(Color.RED);
			return false;
		}
	}
	
	//Close the add item frame and not add an item
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
