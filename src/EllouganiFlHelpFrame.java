import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EllouganiFlHelpFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblFile = new JLabel("File:");
	private final JLabel lblExit = new JLabel("Exit:");
	private final JLabel lblExitsTheApplication = new JLabel("Exits the application");
	private final JLabel lblTools = new JLabel("Tools:");
	private final JLabel lblAddItem = new JLabel("Add Item:");
	private final JLabel lblAddItemDescription = new JLabel("Pops up a new window where you are prompted to enter information to add an item");
	private final JLabel lblSetSort = new JLabel("Set Sort:");
	private final JLabel lblSetSortDescription = new JLabel("Click any of the following sorting mechanisms to sort the shopping cart table");
	private final JLabel lblSetFilterbyPrice = new JLabel("Set Filter(By Price):");
	private final JLabel lblSetPriceFilterDescription = new JLabel("Click one of the filter by price options and fill out the fields to limit the shopping cart table");
	private final JLabel lblSetFiltercategory = new JLabel("Set Filter(Category):");
	private final JLabel lblSetFilterCategoryDescription = new JLabel("Click one of the category options to limit the shopping cart table to desired categories");
	private final JLabel lblDefault = new JLabel("Default:");
	private final JLabel lblDefaultDescription = new JLabel("Click default under an menu to remove any of the sorting and/or filter options");
	private final JButton btnClose = new JButton("Close");


	/**
	 * Create the frame.
	 */
	public EllouganiFlHelpFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Ellougani Help");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 685, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFile.setBounds(10, 11, 46, 14);
		
		contentPane.add(lblFile);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExit.setBounds(20, 36, 46, 14);
		
		contentPane.add(lblExit);
		lblExitsTheApplication.setBounds(56, 38, 115, 14);
		
		contentPane.add(lblExitsTheApplication);
		lblTools.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTools.setBounds(10, 61, 46, 14);
		
		contentPane.add(lblTools);
		lblAddItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddItem.setBounds(20, 86, 74, 14);
		
		contentPane.add(lblAddItem);
		lblAddItemDescription.setBounds(90, 88, 484, 14);
		
		contentPane.add(lblAddItemDescription);
		lblSetSort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetSort.setBounds(20, 111, 89, 14);
		
		contentPane.add(lblSetSort);
		lblSetSortDescription.setBounds(90, 111, 456, 14);
		
		contentPane.add(lblSetSortDescription);
		lblSetFilterbyPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetFilterbyPrice.setBounds(20, 136, 136, 17);
		
		contentPane.add(lblSetFilterbyPrice);
		lblSetPriceFilterDescription.setBounds(149, 139, 557, 14);
		
		contentPane.add(lblSetPriceFilterDescription);
		lblSetFiltercategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetFiltercategory.setBounds(20, 164, 151, 17);
		
		contentPane.add(lblSetFiltercategory);
		lblSetFilterCategoryDescription.setBounds(159, 167, 500, 14);
		
		contentPane.add(lblSetFilterCategoryDescription);
		lblDefault.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDefault.setBounds(20, 192, 74, 14);
		
		contentPane.add(lblDefault);
		lblDefaultDescription.setBounds(79, 194, 456, 14);
		
		contentPane.add(lblDefaultDescription);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClose_actionPerformed(arg0);
			}
		});
		btnClose.setBounds(287, 227, 89, 23);
		
		contentPane.add(btnClose);
	}
	protected void do_btnClose_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
