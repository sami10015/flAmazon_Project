import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EllouganiFlAmazonAddCategoryFilterFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblAddAnyOf = new JLabel("Select any of the following categories:");
	private final JCheckBox chckbxElectronics = new JCheckBox("Electronics");
	private final JCheckBox chckbxComputers = new JCheckBox("Computers");
	private final JCheckBox chckbxClothing = new JCheckBox("Clothing");
	private final JCheckBox chckbxMusic = new JCheckBox("Music");
	private final JCheckBox chckbxMovies = new JCheckBox("Movies");
	private final JCheckBox chckbxBooks = new JCheckBox("Books");
	private final JCheckBox chckbxHomegarden = new JCheckBox("HomeGarden");
	private final JCheckBox chckbxSports = new JCheckBox("Sports");
	private final JCheckBox chckbxAutomotive = new JCheckBox("Automotive");
	private final JCheckBox chckbxOther = new JCheckBox("Other");
	private final JButton btnOk = new JButton("OK");
	private final JButton btnCancel = new JButton("Cancel");
	private Filter thing = new Filter();

	/**
	 * Create the frame.
	 */
	public EllouganiFlAmazonAddCategoryFilterFrame(Filter filter) {
		thing = filter;
		jbInit();
	}
	private void jbInit() {
		setTitle("Ellougani Add Category Frame");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblAddAnyOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddAnyOf.setBounds(10, 11, 283, 17);
		
		contentPane.add(lblAddAnyOf);
		chckbxElectronics.setToolTipText("Select to filter by Electronics");
		chckbxElectronics.setBounds(65, 35, 97, 23);
		
		contentPane.add(chckbxElectronics);
		chckbxComputers.setToolTipText("Select to filter by Computers");
		chckbxComputers.setBounds(65, 77, 97, 23);
		
		contentPane.add(chckbxComputers);
		chckbxClothing.setToolTipText("Select to filter by Clothing");
		chckbxClothing.setBounds(65, 120, 97, 23);
		
		contentPane.add(chckbxClothing);
		chckbxMusic.setToolTipText("Select to filter by Music");
		chckbxMusic.setBounds(65, 159, 97, 23);
		
		contentPane.add(chckbxMusic);
		chckbxMovies.setToolTipText("Select to filter by Movies");
		chckbxMovies.setBounds(228, 35, 97, 23);
		
		contentPane.add(chckbxMovies);
		chckbxBooks.setToolTipText("Select to filter by Books");
		chckbxBooks.setBounds(228, 77, 97, 23);
		
		contentPane.add(chckbxBooks);
		chckbxHomegarden.setToolTipText("Select to filter by HomeGarden");
		chckbxHomegarden.setBounds(228, 120, 140, 23);
		
		contentPane.add(chckbxHomegarden);
		chckbxSports.setToolTipText("Select to filter by Sports");
		chckbxSports.setBounds(228, 159, 97, 23);
		
		contentPane.add(chckbxSports);
		chckbxAutomotive.setToolTipText("Select to filter by Automotive");
		chckbxAutomotive.setBounds(65, 196, 97, 23);
		
		contentPane.add(chckbxAutomotive);
		chckbxOther.setToolTipText("Select to filter by Other");
		chckbxOther.setBounds(228, 196, 97, 23);
		
		contentPane.add(chckbxOther);
		btnOk.setToolTipText("Click when done");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnOk_actionPerformed(e);
			}
		});
		btnOk.setBounds(75, 226, 89, 23);
		
		contentPane.add(btnOk);
		btnCancel.setToolTipText("Click to cancel filter");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(215, 226, 89, 23);
		
		contentPane.add(btnCancel);
	}
	
	//Closes the window and doesn't set a category filter
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	//First checks if one of the checkboxes is selected and if it is, then it setls all the booleans to false and then sets the booleans to 
	//true if their corresponding checkbox is selected
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		if(chckbxElectronics.isSelected() == false && chckbxComputers.isSelected() == false && chckbxClothing.isSelected() == false && chckbxMusic.isSelected() == false && chckbxBooks.isSelected() == false && chckbxHomegarden.isSelected() == false && chckbxSports.isSelected() == false && chckbxAutomotive.isSelected() == false && chckbxOther.isSelected() == false){
			JOptionPane.showMessageDialog(this, "Pick a category!", "Missing Values", 0);
		}else{
			deSetAllFalse();
			setBooleans();
			this.dispose();
		}
	}
	
	//Sets all the booleans of the categories to false
	public void deSetAllFalse(){
		thing.setElectronics(false);
		thing.setComputers(false);
		thing.setClothing(false);
		thing.setMusic(false);
		thing.setBooks(false);
		thing.setHomeGarden(false);
		thing.setMovies(false);
		thing.setSports(false);
		thing.setAutomotive(false);
		thing.setOther(false);
	}
	
	//Sets the booleans of the corresponding category to true if it is selected
	public void setBooleans(){
		int i = 0;
		
		if(chckbxElectronics.isSelected()){
			thing.setElectronics(true);
			i++;
		}if(chckbxComputers.isSelected()){
			i++;
			thing.setComputers(true);
		}if(chckbxClothing.isSelected()){
			i++;
			thing.setClothing(true);
		}if(chckbxMusic.isSelected()){
			i++;
			thing.setMusic(true);
		}if(chckbxMovies.isSelected()){
			i++;
			thing.setMovies(true);
		}if(chckbxSports.isSelected()){
			i++;
			thing.setSports(true);
		}if(chckbxAutomotive.isSelected()){
			i++;
			thing.setAutomotive(true);
		}if(chckbxOther.isSelected()){
			i++;
			thing.setOther(true);
		}if(chckbxBooks.isSelected()){
			i++;
			thing.setBooks(true);
		}if(chckbxHomegarden.isSelected()){
			i++;
			thing.setHomeGarden(true);
		}
		
		thing.setAmountSelected(i);
	}
}
