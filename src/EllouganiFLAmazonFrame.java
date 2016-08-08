import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class EllouganiFLAmazonFrame extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	
	//All items under the File Menu
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	
	//All items under the tool menu
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenuItem mntmAddItem = new JMenuItem("Add Item...");
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenuItem mntmByItemName = new JMenuItem("By Item Name");
	private final JMenuItem mntmByPrice = new JMenuItem("By Price");
	private final JMenu mnSetFilter = new JMenu("Set Filter");
	private final JMenuItem mntmByPrice_1 = new JMenuItem("By Price...");
	private final JMenuItem mntmByCategory_1 = new JMenuItem("By Category...");
	private final JCheckBoxMenuItem chckbxmntmByItemName = new JCheckBoxMenuItem("By Item Name");
	private final JCheckBoxMenuItem chckbxmntmByPrice = new JCheckBoxMenuItem("By Price");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JMenuItem mntmDefault = new JMenuItem("Default");
	private final JSeparator separator = new JSeparator();
	private final JMenu mnByItemName = new JMenu("By Item Name");
	private final JMenu mnByPrice = new JMenu("By Price");
	private final JMenu mnByCategory = new JMenu("By Category");
	private final JRadioButtonMenuItem rdbtnmntmAZ = new JRadioButtonMenuItem("A - Z");
	private final JRadioButtonMenuItem rdbtnmntmZA = new JRadioButtonMenuItem("Z - A");
	private final JRadioButtonMenuItem rdbtnmntmLowHigh = new JRadioButtonMenuItem("Low - High");
	private final JRadioButtonMenuItem rdbtnmntmHighLow = new JRadioButtonMenuItem("High - Low");
	private final JRadioButtonMenuItem rdbtnmntmAZ1 = new JRadioButtonMenuItem("A - Z");
	private final JRadioButtonMenuItem rdbtnmntmZA1 = new JRadioButtonMenuItem("Z - A");
	
	//All items under the help menu
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmHelp = new JMenuItem("Help");
	private final JTable shoppingCartTable = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnLoad = new JButton("Default");
	private final JMenuItem mntmDefualtPrice = new JMenuItem("Default Price");
	private final JSeparator separator_1 = new JSeparator();
	private final JMenuItem mntmDefaultCategory = new JMenuItem("Default Category");
	private final JMenuItem mntmAllDefault = new JMenuItem("All Default");
	private final JSeparator separator_2 = new JSeparator();
	private final JLabel lblSorting = new JLabel("Sorting:");
	private final JLabel lblSortingSet = new JLabel("OFF");
	private final JLabel lblFilterPrice = new JLabel("Filter Price:");
	private final JLabel lblFilterPriceSet = new JLabel("OFF");
	private final JLabel lblFilterCategory = new JLabel("Filter Category:");
	private final JLabel lblCategorySet = new JLabel("OFF");
	
	//Filter class used for data sharing
	private Filter filter = new Filter();
	
	//Number that indicates the type of sorting
	int sortNum = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EllouganiFLAmazonFrame frame = new EllouganiFLAmazonFrame();
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
	public EllouganiFLAmazonFrame() {
		jbInit();
	}
	private void jbInit() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				do_this_windowGainedFocus(arg0);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});

		setTitle("Ellougani FLAmazon");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1021, 521);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmExit_actionPerformed(e);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnTools);
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmAddItem_actionPerformed(arg0);
			}
		});
		
		mnTools.add(mntmAddItem);
		
		mnTools.add(mnSetSort);
		
		mnSetSort.add(separator);
		mntmDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmDefault_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mnByItemName);
		rdbtnmntmAZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnmntmAZ_actionPerformed(arg0);
			}
		});
		
		mnByItemName.add(rdbtnmntmAZ);
		rdbtnmntmZA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnmntmZA_actionPerformed(arg0);
			}
		});
		
		mnByItemName.add(rdbtnmntmZA);
		
		mnSetSort.add(mnByPrice);
		rdbtnmntmLowHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnmntmLowHigh_actionPerformed(arg0);
			}
		});
		
		mnByPrice.add(rdbtnmntmLowHigh);
		rdbtnmntmHighLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnmntmHighLow_actionPerformed(arg0);
			}
		});
		
		mnByPrice.add(rdbtnmntmHighLow);
		
		mnSetSort.add(mnByCategory);
		rdbtnmntmAZ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnmntmAZ_1_actionPerformed(arg0);
			}
		});
		
		mnByCategory.add(rdbtnmntmAZ1);
		rdbtnmntmZA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnmntmZA_1_actionPerformed(arg0);
			}
		});
	
		
		mnByCategory.add(rdbtnmntmZA1);
		
		mnSetSort.add(mntmDefault);
		
		mnTools.add(mnSetFilter);
		mntmByPrice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByPrice_1_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmByPrice_1);
		mntmByCategory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_1_actionPerformed(e);
			}
		});
		mntmDefualtPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmDefualtPrice_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(mntmDefualtPrice);
		
		mnSetFilter.add(separator_1);
		
		mnSetFilter.add(mntmByCategory_1);
		mntmDefaultCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmDefaultCategory_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(mntmDefaultCategory);
		
		mnSetFilter.add(separator_2);
		mntmAllDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAllDefault_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(mntmAllDefault);
		
		menuBar.add(mnHelp);
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmHelp_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(10, 11, 985, 395);
		
		contentPane.add(scrollPane);
		
		shoppingCartTable.setToolTipText("Results of the shopping cart");
		shoppingCartTable.setFont(new Font("Courier New", Font.PLAIN, 14));
		shoppingCartTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ItemID", "ItemName", "Category", "Quantity", "Price", "Shipping"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		//Set up the Currency column(s)
		TableColumnModel model = shoppingCartTable.getColumnModel();
		model.getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		model.getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());
				
		scrollPane.setViewportView(shoppingCartTable);
		btnLoad.setToolTipText("Press to reload the shopping cart");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLoad_actionPerformed(arg0);
			}
		});
		btnLoad.setBounds(395, 429, 89, 23);
		
		contentPane.add(btnLoad);
		
		//Load the driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblSorting.setToolTipText("Indicates if there is sorting on the shopping cart");
		lblSorting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSorting.setBounds(27, 429, 72, 19);
		
		contentPane.add(lblSorting);
		lblSortingSet.setToolTipText("Indicates if there is sorting on the shopping cart");
		lblSortingSet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSortingSet.setBounds(80, 432, 133, 14);
		
		contentPane.add(lblSortingSet);
		lblFilterPrice.setToolTipText("Indicates if there is a filter price on the shopping cart");
		lblFilterPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFilterPrice.setBounds(169, 431, 72, 14);
		
		contentPane.add(lblFilterPrice);
		lblFilterPriceSet.setToolTipText("Indicates if there is a filter price on the shopping cart");
		lblFilterPriceSet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFilterPriceSet.setBounds(244, 431, 141, 18);
		
		contentPane.add(lblFilterPriceSet);
		lblFilterCategory.setToolTipText("Indicates if there is a filter category on the shopping cart");
		lblFilterCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFilterCategory.setBounds(494, 431, 120, 21);
		
		contentPane.add(lblFilterCategory);
		lblCategorySet.setToolTipText("Indicates if there is a filter category on the shopping cart");
		lblCategorySet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCategorySet.setBounds(595, 435, 400, 15);
		
		contentPane.add(lblCategorySet);
		
		
		Load();
	}
	
	//Load function that creates a connection to the database and runs a query that outputs everything based on the filter(s) and sort selected
	public void Load(){
		ResultSet rs = null;
		Statement stmt = null;
		
		//Establish the connection
		try {
			// //./sampleUpdated.accdb is using the current folder
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://./Flamazon.accdb");
			
			//Create the statement
			stmt = conn.createStatement();
			
			String query = "SELECT ItemID, ItemName, Category, Quantity, Price, Shipping FROM ShoppingCart ";
			query += getFilterPriceSQL() + getFilterCategorySQL() + getSortSQL();
			//System.out.println(query);
			//Execute the statement
			rs = stmt.executeQuery(query);
			
			//Process the results
			
			//THIS PART IS DIFFERENT WITH THE JTABLE OUTPUT!!!
			//Remove previously added rows from the JTable
			while(shoppingCartTable.getRowCount() > 0)
				((DefaultTableModel)shoppingCartTable.getModel()).removeRow(0);
			
			int numColumns = rs.getMetaData().getColumnCount();
			
			while(rs.next()){
				//Create an object to hold a record
				Object[] row = new Object[numColumns];
				for(int i = 0; i < numColumns; i++)
					row[i] = rs.getObject(i+1); //Arrays are zero-based, records are one-based
				
				//Insert that row into the table
				((DefaultTableModel)shoppingCartTable.getModel()).insertRow(rs.getRow()-1, row);
			}//While
			
			rs.close();
			conn.close();
		}//Try 
		catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		changeSetLabels();
	}
	
	//Runs the load function
	protected void do_btnLoad_actionPerformed(ActionEvent arg0) {		
		sortNum = 0;
		rdbtnmntmAZ.setSelected(false);
		rdbtnmntmZA.setSelected(false);
		rdbtnmntmLowHigh.setSelected(false);
		rdbtnmntmHighLow.setSelected(false);
		rdbtnmntmAZ1.setSelected(false);
		rdbtnmntmZA1.setSelected(false);
		filter.setFilterNum(0);
		filter.setElectronics(true);
		filter.setComputers(true);
		filter.setClothing(true);
		filter.setMusic(true);
		filter.setBooks(true);
		filter.setHomeGarden(true);
		filter.setMovies(true);
		filter.setSports(true);
		filter.setAutomotive(true);
		filter.setOther(true);
		filter.setAmountSelected(10);
		Load();
	}
	
	//Creates an add item frame
	protected void do_mntmAddItem_actionPerformed(ActionEvent arg0) {
		EllouganiFlAmazonAddItemFrame addItemFrame = new EllouganiFlAmazonAddItemFrame();
		addItemFrame.setVisible(true);
	}
	
	//Sets the sort to default
	protected void do_mntmDefault_actionPerformed(ActionEvent arg0) {
		sortNum = 0;
		rdbtnmntmAZ.setSelected(false);
		rdbtnmntmZA.setSelected(false);
		rdbtnmntmLowHigh.setSelected(false);
		rdbtnmntmHighLow.setSelected(false);
		rdbtnmntmAZ1.setSelected(false);
		rdbtnmntmZA1.setSelected(false);
		Load();
	}
	
	//Runs the deselect function, sets the sort num, and then loads
	protected void do_rdbtnmntmAZ_actionPerformed(ActionEvent arg0) {
		deSelect(rdbtnmntmAZ);
		sortNum = 1;
		Load();
	}
	
	//Runs the deselect function, sets the sort num, and then loads
	protected void do_rdbtnmntmZA_actionPerformed(ActionEvent arg0) {
		deSelect(rdbtnmntmZA);
		sortNum = 2;
		Load();
	}
	
	//Runs the deselect function, sets the sort num, and then loads
	protected void do_rdbtnmntmLowHigh_actionPerformed(ActionEvent arg0) {
		deSelect(rdbtnmntmLowHigh);
		sortNum = 3;
		Load();
	}
	
	//Runs the deselect function, sets the sort num, and then loads
	protected void do_rdbtnmntmHighLow_actionPerformed(ActionEvent arg0) {
		deSelect(rdbtnmntmHighLow);
		sortNum = 4;
		Load();
	}
	
	//Runs the deselect function, sets the sort num, and then loads
	protected void do_rdbtnmntmAZ_1_actionPerformed(ActionEvent arg0) {
		deSelect(rdbtnmntmAZ1);
		sortNum = 5;
		Load();
	}
	
	//Runs the deselect function, sets the sort num, and then loads
	protected void do_rdbtnmntmZA_1_actionPerformed(ActionEvent arg0) {
		deSelect(rdbtnmntmZA1);
		sortNum = 6;
		Load();
	}
	
	//Opens the Add Price filter frame
	protected void do_mntmByPrice_1_actionPerformed(ActionEvent arg0) {
		EllouganiFlAmazonAddPriceFilterFrame frame = new EllouganiFlAmazonAddPriceFilterFrame(filter);
		frame.setVisible(true);
	}
	
	//Deselects all the radio buttons, and then selects the one that is chosen
	public void deSelect(JRadioButtonMenuItem button){
		rdbtnmntmAZ.setSelected(false);
		rdbtnmntmZA.setSelected(false);
		rdbtnmntmLowHigh.setSelected(false);
		rdbtnmntmHighLow.setSelected(false);
		rdbtnmntmAZ1.setSelected(false);
		rdbtnmntmZA1.setSelected(false);
		button.setSelected(true);
	}
	
	//Returns an SQL string that sorts the shopping cart
	public String getSortSQL(){
		if(sortNum == 1){
			return " ORDER BY ItemName ASC";
		}else if(sortNum == 2){
			return " ORDER BY ItemName DESC";
		}else if(sortNum == 3){
			return " ORDER BY Price ASC";
		}else if(sortNum == 4){
			return " ORDER BY Price DESC";
		}else if(sortNum == 5){
			return " ORDER BY Category ASC";
		}else if(sortNum == 6){
			return " ORDER BY Category DESC";
		}else{
			return " ORDER BY ItemID";
		}
	}
	
	//Returns an SQL string that limits the shopping cart to only certain prices
	public String getFilterPriceSQL(){
		if(filter.getFilterNum() == 1){
			return "WHERE Price < " + filter.getLessThanPrice();
		}else if(filter.getFilterNum() == 2){
			return "WHERE Price > " + filter.getGreaterThanPrice();
		}else if(filter.getFilterNum() == 3){
			return "WHERE Price BETWEEN " + filter.getMinPrice() + " AND " + filter.getMaxPrice();
		}else{
			return "";
		}
	}
	
	//Returns an SQL string that limits the shopping cart to only certain categories
	public String getFilterCategorySQL(){
		String categorySQL = "";
		if(filter.getFilterNum() == 0){
			categorySQL += "WHERE Category = ";
			if(filter.getAmountSelected() > 1){
				if(filter.isElectronics()){
					categorySQL += "'Electronics' OR Category = ";
				}if(filter.isComputers()){
					categorySQL += "'Computers' OR Category = ";
				}if(filter.isClothing()){
					categorySQL += "'Clothing' OR Category = ";
				}if(filter.isMusic()){
					categorySQL += "'Music' OR Category = ";
				}if(filter.isBooks()){
					categorySQL += "'Books' OR Category = ";
				}if(filter.isMovies()){
					categorySQL += "'Movies' OR Category = ";
				}if(filter.isHomeGarden()){
					categorySQL += "'HomeGarden' OR Category = ";
				}if(filter.isSports()){
					categorySQL += "'Sports' OR Category = ";
				}if(filter.isAutomotive()){
					categorySQL += "'Automotive' OR Category = ";
				}if(filter.isOther()){
					categorySQL += "'Other' OR Category = ";
				}
				categorySQL += "''";
			}else if(filter.getAmountSelected() == 1){
				if(filter.isElectronics()){
					categorySQL += "'Electronics'";
				}if(filter.isComputers()){
					categorySQL += "'Computers'";
				}if(filter.isClothing()){
					categorySQL += "'Clothing'";
				}if(filter.isMusic()){
					categorySQL += "'Music'";
				}if(filter.isBooks()){
					categorySQL += "'Books'";
				}if(filter.isMovies()){
					categorySQL += "'Movies'";
				}if(filter.isHomeGarden()){
					categorySQL += "'HomeGarden'";
				}if(filter.isSports()){
					categorySQL += "'Sports'";
				}if(filter.isAutomotive()){
					categorySQL += "'Automotive'";
				}if(filter.isOther()){
					categorySQL += "'Other'";
				}
			}
		}else{
			if(filter.getAmountSelected() > 1){
				categorySQL += " AND (Category = ";
				if(filter.isElectronics()){
					categorySQL += "'Electronics' OR Category = ";
				}if(filter.isComputers()){
					categorySQL += "'Computers' OR Category = ";
				}if(filter.isClothing()){
					categorySQL += "'Clothing' OR Category = ";
				}if(filter.isMusic()){
					categorySQL += "'Music' OR Category = ";
				}if(filter.isBooks()){
					categorySQL += "'Books' OR Category = ";
				}if(filter.isMovies()){
					categorySQL += "'Movies' OR Category = ";
				}if(filter.isHomeGarden()){
					categorySQL += "'HomeGarden' OR Category = ";
				}if(filter.isSports()){
					categorySQL += "'Sports' OR Category = ";
				}if(filter.isAutomotive()){
					categorySQL += "'Automotive' OR Category = ";
				}if(filter.isOther()){
					categorySQL += "'Other' OR Category = ";
				}
				categorySQL += "'')";
			}else if(filter.getAmountSelected() == 1){
				categorySQL += " AND Category = ";
				if(filter.isElectronics()){
					categorySQL += "'Electronics'";
				}if(filter.isComputers()){
					categorySQL += "'Computers'";
				}if(filter.isClothing()){
					categorySQL += "'Clothing'";
				}if(filter.isMusic()){
					categorySQL += "'Music'";
				}if(filter.isBooks()){
					categorySQL += "'Books'";
				}if(filter.isMovies()){
					categorySQL += "'Movies'";
				}if(filter.isHomeGarden()){
					categorySQL += "'HomeGarden'";
				}if(filter.isSports()){
					categorySQL += "'Sports'";
				}if(filter.isAutomotive()){
					categorySQL += "'Automotive'";
				}if(filter.isOther()){
					categorySQL += "'Other'";
				}
			}
		}
		return categorySQL;
	}
	
	//Opens the filter category frame
	protected void do_mntmByCategory_1_actionPerformed(ActionEvent e) {
		EllouganiFlAmazonAddCategoryFilterFrame frame = new EllouganiFlAmazonAddCategoryFilterFrame(filter);
		frame.setVisible(true);
	}
	
	//Sets the price filter to default
	protected void do_mntmDefualtPrice_actionPerformed(ActionEvent e) {
		filter.setFilterNum(0);
		Load();
	}
	
	//Sets the category filter to default
	protected void do_mntmDefaultCategory_actionPerformed(ActionEvent e) {
		filter.setElectronics(true);
		filter.setComputers(true);
		filter.setClothing(true);
		filter.setMusic(true);
		filter.setBooks(true);
		filter.setHomeGarden(true);
		filter.setMovies(true);
		filter.setSports(true);
		filter.setAutomotive(true);
		filter.setOther(true);
		filter.setAmountSelected(10);
		Load();
	}
	
	//Sets the category and price filter to default
	protected void do_mntmAllDefault_actionPerformed(ActionEvent e) {
		filter.setElectronics(true);
		filter.setComputers(true);
		filter.setClothing(true);
		filter.setMusic(true);
		filter.setBooks(true);
		filter.setHomeGarden(true);
		filter.setMovies(true);
		filter.setSports(true);
		filter.setAutomotive(true);
		filter.setOther(true);
		filter.setAmountSelected(10);
		filter.setFilterNum(0);
		Load();
	}
	
	//Closes the frame
	protected void do_mntmExit_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	//Changes the labels, which indicates what sorting or filtering is on or off
	public void changeSetLabels(){
		if(filter.getFilterNum() != 0){
			//lblFilterPriceSet.setText("ON");
			if(filter.getFilterNum() == 1){
				lblFilterPriceSet.setText("Less than: " + filter.getLessThanPrice());
			}else if(filter.getFilterNum() == 2){
				lblFilterPriceSet.setText("Greater than: " + filter.getGreaterThanPrice());
			}else if(filter.getFilterNum() == 3){
				lblFilterPriceSet.setText("In Between: " + filter.getMinPrice() + " and " + filter.getMaxPrice());
			}
		}else{
			lblFilterPriceSet.setText("OFF");
		}
		
		if(sortNum != 0){
			if(sortNum == 1){
				lblSortingSet.setText("Item Name A-Z");
			}else if(sortNum == 2){
				lblSortingSet.setText("Item Name Z-A");
			}else if(sortNum == 3){
				lblSortingSet.setText("Price Low-High");
			}else if(sortNum == 4){
				lblSortingSet.setText("Price High-Low");
			}else if(sortNum == 5){
				lblSortingSet.setText("Category A-Z");
			}else if(sortNum == 6){
				lblSortingSet.setText("Category Z-A");
			}
		}else{
			lblSortingSet.setText("OFF");
		}
		
		if(filter.isAutomotive() && filter.isBooks() && filter.isClothing() && filter.isComputers() && filter.isElectronics() && filter.isHomeGarden() && filter.isMovies() && filter.isMusic() && filter.isOther() && filter.isSports()){
			lblCategorySet.setText("OFF");
		}else{
			String categories = "";
			if(filter.isAutomotive()){
				categories += "Automotive ";
			}if(filter.isBooks()){
				categories += "Books ";
			}if(filter.isClothing()){
				categories += "Clothing ";
			}if(filter.isComputers()){
				categories += "Computers ";
			}if(filter.isElectronics()){
				categories += "Electronics ";
			}if(filter.isHomeGarden()){
				categories += "HomeGarden ";
			}if(filter.isMovies()){
				categories += "Movies ";
			}if(filter.isMusic()){
				categories += "Music ";
			}if(filter.isOther()){
				categories += "Other ";
			}if(filter.isSports()){
				categories += "Sports ";
			}
			lblCategorySet.setText(categories);
		}
	}
	
	//Reloads the shoppingcart table if the window gains focus
	protected void do_this_windowGainedFocus(WindowEvent arg0) {
		Load();
	}
	
	//Opens the help frame
	protected void do_mntmHelp_actionPerformed(ActionEvent arg0) {
		EllouganiFlHelpFrame frame = new EllouganiFlHelpFrame();
		frame.setVisible(true);
	}

}
