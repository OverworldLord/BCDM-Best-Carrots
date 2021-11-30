package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.util.Calendar;
import java.util.Date;

import model.dataaccess.ConnectionFactory;
import model.dataaccess.DataAccess;

public class DishBeverageScreen extends JFrame implements ActionListener {
	
	
	private JPanel TopPanel, DishPanel, AddItemPanel, orderOptionsPanel,  MainPanel, TablePanel, MenuPanel;
	
	private JLabel DishLabel, additemLabel;
	private JLabel TypeLabel, NameLabel, QuantityLabel, PriceLabel;
	
	private JButton DishButton, CreateItemButton, OrderButton, CancelButton, RemoveButton, FinalizeButton;
	
	private JComboBox DishDropdown;
	
	private JTextField 	DishQuantityText, DishPriceText,
						CreateItemNameText, CreateItemPriceText;
	
	private JTable OrderTable;
	
	private String[] tableColumns = {"Item", "Quantity", "Price", "Total Price"};
	private int tableRows = 1;
	
	
	private String customerName;
	private int discountType;
	
	
	public DishBeverageScreen(String customerName, int discountType) throws ClassNotFoundException, SQLException {
		
		this.customerName = customerName;
		this.discountType = discountType;
		this.initializeComponents();
		this.buildUI();
	}
	
	private void initializeComponents() throws ClassNotFoundException, SQLException {
		
		//Rows
		this.DishLabel = new JLabel("Add Dish to order");
		this.additemLabel = new JLabel("Add item to Database");
		
		//Columns
		this.TypeLabel = new JLabel("Actions");
		this.NameLabel = new JLabel("Item Name");
		this.QuantityLabel = new JLabel("Quantity");
		this.PriceLabel = new JLabel("Price");
		
		//Buttons
		this.DishButton = new JButton("Add to order");
		this.DishButton.addActionListener(this);
		
		this.CreateItemButton = new JButton("Create item");
		this.CreateItemButton.addActionListener(this);
		
		this.RemoveButton = new JButton("Remove");
		this.RemoveButton.addActionListener(this);
		
		this.FinalizeButton = new JButton("Finalize");
		this.FinalizeButton.addActionListener(this);
		
		this.OrderButton = new JButton("Order");
		this.OrderButton.addActionListener(this);
		
		this.CancelButton = new JButton("Cancel");
		this.CancelButton.addActionListener(this);
		
		
		//Dropdowns
		this.DishDropdown 			= new JComboBox();
		
		this.DishDropdown.addItem("(Select Item)");
		
		// Grab list of food items from fooditem table
		try {
			ResultSet rs = DataAccess.queryDB("SELECT name FROM fooditem");
		
			while(rs.next()) {
		
				this.DishDropdown.addItem(rs.getString(1));
		
			}
		}
		catch(Exception e) {
			
			// Display Error message
			JOptionPane.showMessageDialog(this, e, "Can't populate dish dropdown", JOptionPane.ERROR_MESSAGE);
		}
		
		// Populate dropdown with items from database
		this.DishDropdown.addActionListener(this);
		
		
		//Text Fields
		this.DishQuantityText 		= new JTextField();
		this.DishQuantityText.addActionListener(this);
		this.DishPriceText 			= new JTextField();
		this.DishPriceText.setEditable(false);
		this.CreateItemNameText 	= new JTextField();
		this.CreateItemPriceText 	= new JTextField();
		
		//Table
		DefaultTableModel model = new DefaultTableModel(this.tableRows, this.tableColumns.length);
		model.setColumnIdentifiers(this.tableColumns);
		this.OrderTable = new JTable(model);
		TableColumn column = this.OrderTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(180);
		column = this.OrderTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(180);
		column = this.OrderTable.getColumnModel().getColumn(2);
		column.setPreferredWidth(180);
		column = this.OrderTable.getColumnModel().getColumn(3);
		column.setPreferredWidth(180);
		
		// Name the first row of the table
		model.setValueAt("Item", 0, 0);
		model.setValueAt("Quantity", 0, 1);
		model.setValueAt("Price", 0, 2);
		model.setValueAt("Total Price", 0, 3);
		
		//Panels
		this.TopPanel = new JPanel();
		this.TopPanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
		this.DishPanel = new JPanel();
		this.DishPanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
		this.AddItemPanel = new JPanel();
		this.AddItemPanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
		this.orderOptionsPanel = new JPanel();
		this.orderOptionsPanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
		this.TablePanel = new JPanel();
		this.TablePanel.setSize(800, 400);
		
		this.MainPanel = new JPanel();
		this.MainPanel.setLayout(new GridLayout(0, 1, 0, 10));
		this.MainPanel.setSize(200, 800);
		
		this.MenuPanel = new JPanel();
		this.MenuPanel.setLayout(new GridLayout(0, 4, 0, 0));
		this.MainPanel.setSize(200, 200);
		

		
	}
	
	private void buildUI() {
		
		this.TopPanel.add(this.TypeLabel);
		this.TopPanel.add(this.NameLabel);
		this.TopPanel.add(this.PriceLabel);
		this.TopPanel.add(this.QuantityLabel);

		
		this.DishPanel.add(this.DishLabel);
		this.DishPanel.add(this.DishDropdown);
		this.DishPanel.add(this.DishPriceText);
		this.DishPanel.add(this.DishQuantityText);
		this.DishPanel.add(this.DishButton);

		this.AddItemPanel.add(this.additemLabel);
		this.AddItemPanel.add(this.CreateItemNameText);
		this.AddItemPanel.add(this.CreateItemPriceText);
		this.AddItemPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.AddItemPanel.add(this.CreateItemButton);
		
		this.orderOptionsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.orderOptionsPanel.add(this.RemoveButton);
		this.orderOptionsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.orderOptionsPanel.add(this.FinalizeButton);
		this.orderOptionsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		this.TablePanel.add(this.OrderTable);
		this.TablePanel.add(this.orderOptionsPanel);
		
		this.MainPanel.add(this.TopPanel);
		this.MainPanel.add(this.DishPanel);
		this.MainPanel.add(this.AddItemPanel);
		
		this.MenuPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.MenuPanel.add(this.OrderButton);
		this.MenuPanel.add(this.CancelButton);
		
		
		this.getContentPane().add(this.MainPanel, BorderLayout.NORTH);
		this.getContentPane().add(this.TablePanel, BorderLayout.CENTER);
		this.getContentPane().add(this.MenuPanel, BorderLayout.SOUTH);
		
		this.setTitle("Order Registration");
		this.setBounds(400, 120, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);	
	}
	

	@Override
	public void actionPerformed(ActionEvent event){
		
		// This returns to the main screen
		if(event.getSource() == this.CancelButton) {
			
			new MainScreen();
			dispose();
		}
		
		// This takes the current selected item in the dropdown,
		// then update the price textfield to display price of that item
		if(event.getSource() == this.DishDropdown) {
			
			float itemPrice;
			
			String itemName = (String) this.DishDropdown.getSelectedItem();
			
			int itemID = 0;
			
			ResultSet rs;
			
			try {
				
				rs = DataAccess.queryDB("SELECT (\"itemID\")  FROM fooditem WHERE name='" + itemName + "'");
				
				if(rs.next()) {
					
					itemID = rs.getInt(1);
				}
				
				rs = DataAccess.queryDB("SELECT price FROM price WHERE \"itemID\"=" + itemID);
				
				if(rs.next()) {
					
					this.DishPriceText.setText(rs.getString(1));
				}

				
			} catch (Exception e) {
				
				// Display error message
				JOptionPane.showMessageDialog(this, e, "Please select an dish/beverage", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		// This is the "Add to Order" button. Once pressed, this will take what is
		// currently selected in the dish dropdown, the text in the price textfield,
		// and information typed in the quantity text field
		if(event.getSource() == this.DishButton) {
			
			String itemName = (String) this.DishDropdown.getSelectedItem();
			int quantity = Integer.valueOf(this.DishQuantityText.getText());
			Float price = Float.valueOf(this.DishPriceText.getText());
			
			DecimalFormat df = new DecimalFormat("0.00");
			
			// Calculate the price of item * quantity entered
			Float totalPrice = Float.valueOf(df.format(quantity * price));
			
			// Put the item name, quantity, price, and its totalPrice in an array
			Object[] rowData = {itemName, quantity, price, totalPrice};
			
			DefaultTableModel model = (DefaultTableModel) this.OrderTable.getModel();
			
			// Add array into a row of data for the table, then add that row to update the table
			model.addRow(rowData);
			
		}
		
		// This adds a food item to the database
		if(event.getSource() == this.CreateItemButton) {
			
			String DBname1 = "fooditem";
			String DBname2 = "price";
			String itemOutput;
			String priceOutput;
			
			int itemID = 0;
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			String stringDate = formatter.format(date);
			
			// Query the highest ID value and increment
			try {
				
				ResultSet rs = DataAccess.queryDB("SELECT MAX(\"itemID\")  FROM fooditem");

				if(rs.next()) {
					
					itemID = 1  + rs.getInt(1);
				}
				
				
			} catch (Exception e) {
				
				itemID = 1;
			}
		
			
			itemOutput = "( " + itemID + ", '" +  this.CreateItemNameText.getText() + "')";
			
			priceOutput = "( " + itemID + ", '" + stringDate + "', '" +
							this.CreateItemPriceText.getText() + "', " + itemID + ")";
			
			ResultSet rs;
			
			// Insert the new food items into the database
			try {
				
				DataAccess.insertIntoDBValues(DBname1, itemOutput);
				DataAccess.insertIntoDBValues(DBname2, priceOutput);
				
				rs = DataAccess.queryDB("SELECT name FROM fooditem");
				
				// Refresh the dish dropdown and repopulate it with the new dish item
				this.DishDropdown.removeAllItems();
				
				this.DishDropdown.addItem("Select Item");
				
				while(rs.next()) {
					
					this.DishDropdown.addItem(rs.getString(1));
				}
				
				JOptionPane.showMessageDialog(this, "Successfully added item.");
				
			}
			
			catch (Exception e) {
				
				JOptionPane.showMessageDialog(this, "Item Registration failed.");
			}
			
		}
		
		// If a row in the table is selected, then the "Remove" button is pressed,
		// that row will be removed from the table
		if(event.getSource() == this.RemoveButton) {
			
			DefaultTableModel model = (DefaultTableModel) this.OrderTable.getModel();
			
			if(this.OrderTable.getSelectedRow() != -1) {
				
				model.removeRow(this.OrderTable.getSelectedRow());
			}
			
		}
		
		// When "Finalize" button is pressed, the table will be updated
		if(event.getSource() == this.FinalizeButton) {
			
			String dct;
			
			Float priceDiscount = 0.00f;
			
			Float totalPrice = 0.00f;

			// Discount for student
			if(this.discountType == 0) {
				
				dct = "50%";
				priceDiscount = 0.50f;
				
			}
			
			// Discount for professor
			else {
				
				dct = "25%";
				priceDiscount = 0.25f;
			}
			
			// Add the discount row to table
			Object[] rowData1 = {"Discount", dct};
			
			DefaultTableModel model = (DefaultTableModel) this.OrderTable.getModel();
			
			
			// Calculate total price by adding up all the price in the 4th row
			for(int i = 1; i < model.getRowCount(); i++) {
				
				totalPrice += (float) model.getValueAt(i, 3);
			}
			
			model.addRow(rowData1);
			
			DecimalFormat df = new DecimalFormat("0.00");
			
			// Add the final total price into the table
			totalPrice = Float.valueOf(df.format(totalPrice - (totalPrice * priceDiscount)));
			
			
			Object[] rowData2 = {"Total", "", "", totalPrice};
			
			model.addRow(rowData2);
			
		}
		
		// This will take us to the payment screen with the order table, customer name, and discount type
		// being passed
		if(event.getSource() == this.OrderButton) {

			new PaymentScreen(this.OrderTable.getModel(), this.customerName, this.discountType);
			dispose();
		}
		
	}
	

}


