package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import model.dataaccess.DataAccess;

public class DishBeverageScreen extends JFrame implements ActionListener {
	
	
	private JPanel TopPanel, DishPanel, BeveragePanel, AddItemPanel, MainPanel, TablePanel, MenuPanel;
	
	private JLabel DishLabel, BeverageLabel, additemLabel;
	private JLabel TypeLabel, NameLabel, QuantityLabel, PriceLabel;
	
	private JButton DishButton, BeverageButton, CreateItemButton, OrderButton, CancelButton;
	
	private JComboBox DishDropdown, BeverageDropdown;
	
	private JTextField 	DishQuantityText, DishPriceText,
						BeverageQuantityText, BeveragePriceText,
						CreateItemNameText, CreateItemPriceText;
	
	private JTable OrderTable;
	
	private String[] tableColumns = {"Item", "Quantity", "Price", "Total Price"};
	private int tableRows = 30;
	
	
	public DishBeverageScreen() {
		
		this.initializeComponents();
		this.buildUI();
	}
	
	private void initializeComponents() {
		
		//Rows
		this.DishLabel = new JLabel("Add Dish to order");
		this.BeverageLabel = new JLabel("Add Beverage to order");
		this.additemLabel = new JLabel("Add item to Database");
		
		//Columns
		this.TypeLabel = new JLabel("Actions");
		this.NameLabel = new JLabel("Item Name");
		this.QuantityLabel = new JLabel("Quantity");
		this.PriceLabel = new JLabel("Price");
		
		//Buttons
		this.DishButton = new JButton("Add to order");
		this.DishButton.addActionListener(this);
		
		this.BeverageButton = new JButton("Add to order");
		this.BeverageButton.addActionListener(this);
		
		this.CreateItemButton = new JButton("Create item");
		this.CreateItemButton.addActionListener(this);
		
		this.OrderButton = new JButton("Order");
		this.OrderButton.addActionListener(this);
		
		this.CancelButton = new JButton("Cancel");
		this.CancelButton.addActionListener(this);
		//Dropdowns
		this.DishDropdown 			= new JComboBox();
		this.BeverageDropdown 		= new JComboBox();
		
		//Text Fields
		this.DishQuantityText 		= new JTextField();
		this.DishPriceText 			= new JTextField();
		this.BeverageQuantityText 	= new JTextField();
		this.BeveragePriceText 		= new JTextField();
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
		
		//Panels
		this.TopPanel = new JPanel();
		this.TopPanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
		this.DishPanel = new JPanel();
		this.DishPanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
		this.BeveragePanel = new JPanel();
		this.BeveragePanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
		this.AddItemPanel = new JPanel();
		this.AddItemPanel.setLayout((new GridLayout(0, 5, 10, 10)));
		
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
		this.TopPanel.add(this.QuantityLabel);
		this.TopPanel.add(this.PriceLabel);
		
		this.DishPanel.add(this.DishLabel);
		this.DishPanel.add(this.DishDropdown);
		this.DishPanel.add(this.DishQuantityText);
		this.DishPanel.add(this.DishPriceText);
		this.DishPanel.add(this.DishButton);
		
		this.BeveragePanel.add(this.BeverageLabel);
		this.BeveragePanel.add(this.BeverageDropdown);
		this.BeveragePanel.add(this.BeverageQuantityText);
		this.BeveragePanel.add(this.BeveragePriceText);
		this.BeveragePanel.add(this.BeverageButton);
		
		this.AddItemPanel.add(this.additemLabel);
		this.AddItemPanel.add(this.CreateItemNameText);
		this.AddItemPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.AddItemPanel.add(this.CreateItemPriceText);
		this.AddItemPanel.add(this.CreateItemButton);
		
		this.TablePanel.add(this.OrderTable);
		
		this.MainPanel.add(this.TopPanel);
		this.MainPanel.add(this.DishPanel);
		this.MainPanel.add(this.BeveragePanel);
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
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.CancelButton) {
			
			new MainScreen();
			dispose();
		}
		
	}
	
	public static void main(String args[]) {
		new DishBeverageScreen();
	}

}
