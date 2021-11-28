package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import model.dataaccess.DataAccess;

public class PaymentScreen extends JFrame implements ActionListener {
	
	private JPanel labelPanel, tablePanel, topPaymentPanel, botPaymentPanel, 
				   paymentPanel, optionPanel, successPaymentPanel, mainPanel;
	
	private JButton payButton, cancelButton, printButton;
	
	private JTextField cardNumber, cardDate, cardCCV;
	
	private JLabel nameLabel, quantityLabel, priceLabel, paymentLabel, 
				   cardNumberLabel, cardDateLabel, cardCcvLabel;
				   
	private JLabel paymentMethodLabel, paymentInfoLabel, customerLabel, customerTypeLabel,
		     	   transactionDateLabel, transactionTimeLabel;
	
	private JLabel paymentType, cardInfo, customerN, customerT, tDate, tTime;
	
	private JComboBox paymentMethod;
	
	private JTable orderTable, paymentSuccessTable;
	private DefaultTableModel model;
//	private String[] tableColumns = {"Item", "Quantity", "Price", "Total Price"};

	private int tableRows = 30;

	private String customerName, customerType;
	
	public PaymentScreen(TableModel tableModel, String customerName, int customerType) {
		
		this.model = (DefaultTableModel) tableModel;
		
		this.customerName = customerName;
		
		if(customerType == 0) {
			this.customerType = "Professor";
		}
		else {
			this.customerType = "Student";
		}
		
		this.initializeComponents();
		this.buildUI();
	}
	
	private void initializeComponents() {	
		
		// Columns
		this.nameLabel = new JLabel("Item Name");
		this.quantityLabel = new JLabel("Quantity");
		this.priceLabel = new JLabel("Price");
		
		// Rows
		this.paymentLabel = new JLabel("Payment method");
		this.cardNumberLabel = new JLabel("Card Number");
		this.cardDateLabel = new JLabel("EXP Date (MM/DD/YYYY)");
		this.cardCcvLabel = new JLabel("3-Digit CCV");
		
		// Buttons
		this.payButton = new JButton("Pay");
		this.payButton.addActionListener(this);
		
		this.cancelButton = new JButton("Cancel");
		this.cancelButton.addActionListener(this);
		
		this.printButton = new JButton("Print");
		this.printButton.addActionListener(this);
		
		// Drop down menus
		this.paymentMethod = new JComboBox();
		this.paymentMethod.addItem("Credit Card");
		this.paymentMethod.addItem("Debit Card");
		
		// Text Fields
		this.cardNumber = new JTextField();
		this.cardDate = new JTextField();
		this.cardCCV = new JTextField();
		
		// Table
		this.orderTable = new JTable(model);

		
		//Payment Success , different model??
		this.paymentMethodLabel = new JLabel("Payment Method:");
		this.paymentInfoLabel = new JLabel("Payment Info:");
		this.customerLabel = new JLabel("Customer:");
		this.customerTypeLabel = new JLabel("Customer Type:");
		this.transactionDateLabel = new JLabel("Transaction Date:");
		this.transactionTimeLabel = new JLabel("Transaction Time:");
		
		this.paymentType = new JLabel("");
		this.cardInfo = new JLabel("");
		this.customerN = new JLabel("");
		this.customerT = new JLabel("");
		this.tDate = new JLabel("");
		this.tTime = new JLabel("");
		
		// Panels
		this.labelPanel = new JPanel();
		this.labelPanel.setLayout((new GridLayout(0, 4, 100, 10)));
		
		this.tablePanel = new JPanel();
		this.tablePanel.setSize(800, 400);
		
		this.topPaymentPanel = new JPanel();
		this.topPaymentPanel.setLayout((new GridLayout(0, 2, 10, 10)));
		
		this.botPaymentPanel = new JPanel();
		this.botPaymentPanel.setLayout((new GridLayout(0, 2, 10, 10)));
		
		this.successPaymentPanel = new JPanel();
		this.successPaymentPanel.setLayout((new GridLayout(6, 1, 10, 2)));
		
		this.paymentPanel = new JPanel();
		this.paymentPanel.setLayout((new GridLayout(0, 1, 0, 10)));
		this.paymentPanel.setSize(200, 400);
		
		this.optionPanel = new JPanel();
		this.optionPanel.setLayout(new GridLayout(0, 4, 0, 0));
		this.optionPanel.setSize(100, 200);
		
		
	}
	
	private void buildUI() {
		
		//this.labelPanel.add(this.nameLabel);
		//this.labelPanel.add(this.priceLabel);
		//this.labelPanel.add(this.quantityLabel);
		//this.labelPanel.add(new JLabel ("l"));
		
		this.tablePanel.add(this.orderTable);
		
		this.topPaymentPanel.add(this.paymentLabel);
		this.topPaymentPanel.add(this.paymentMethod);
		this.topPaymentPanel.add(this.cardNumberLabel);
		this.topPaymentPanel.add(this.cardNumber);
		
		this.botPaymentPanel.add(this.cardDateLabel);
		this.botPaymentPanel.add(this.cardDate);
		this.botPaymentPanel.add(this.cardCcvLabel);
		this.botPaymentPanel.add(this.cardCCV);
		
		this.paymentPanel.add(topPaymentPanel);
		this.paymentPanel.add(botPaymentPanel);
		

		this.successPaymentPanel.add(this.paymentMethodLabel);
		this.successPaymentPanel.add(this.paymentType);
		this.successPaymentPanel.add(this.paymentInfoLabel);
		this.successPaymentPanel.add(this.cardInfo);
		this.successPaymentPanel.add(this.customerLabel);
		this.successPaymentPanel.add(this.customerN);
		this.successPaymentPanel.add(this.customerTypeLabel);
		this.successPaymentPanel.add(this.customerT);
		this.successPaymentPanel.add(this.transactionDateLabel);
		this.successPaymentPanel.add(this.tDate);
		this.successPaymentPanel.add(this.transactionTimeLabel);
		this.successPaymentPanel.add(this.tTime);
		
		this.optionPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.optionPanel.add(payButton);
		this.optionPanel.add(cancelButton);
		
		//this.getContentPane().add(this.labelPanel, BorderLayout.NORTH);
		this.getContentPane().add(this.tablePanel);
		this.getContentPane().add(this.paymentPanel);
		this.getContentPane().add(this.optionPanel);
		this.setLayout(new GridLayout(4, 1));
		
		this.setTitle("Payment");
		this.setBounds(400, 120, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);	
		
	}
	
	public void successPayment(String payMethod, String payInfo, String custName, String custType,
							   String tDate, String tTime) {
		
			this.setTitle("Payment Success");
		
			this.paymentPanel.remove(topPaymentPanel);
			this.paymentPanel.remove(botPaymentPanel);
			
			this.paymentType.setText(payMethod);
			this.cardInfo.setText(payInfo);
			this.customerN.setText(custName);
			this.customerT.setText(custType);
			this.tDate.setText(tDate);
			this.tTime.setText(tTime);
			
			this.paymentPanel.add(successPaymentPanel);
			this.optionPanel.remove(payButton);
			this.optionPanel.remove(cancelButton);
			this.optionPanel.add(printButton);
			this.optionPanel.add(cancelButton);
			paymentPanel.revalidate();
			paymentPanel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == this.cancelButton) {
			new MainScreen();
			dispose();
		}
		
		if(event.getSource() == this.payButton) {
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
			
			Date date = new Date();
			
			int orderID = 0;
			int broncoID = 0;
			
			int status = 1;
			
			String orderIDRequest = "SELECT MAX(\"OrderID\") FROM \"order\"";
			
			String broncoIDRequest = "";
			

			
			ResultSet rs;
			
			if(this.customerType == "Professor") {
				
				broncoIDRequest = "SELECT \"broncoID\" FROM professor WHERE name='" + this.customerName + "'";
			}
			
			else {
				
				broncoIDRequest = "SELECT \"broncoID\" FROM student WHERE name='" + this.customerName + "'";
			}
			
			successPayment((String) this.paymentMethod.getSelectedItem(), this.cardNumber.getText(), this.customerName,
					   this.customerType, dateFormatter.format(date), timeFormatter.format(date));
			
			try {
				
				rs = DataAccess.queryDB(orderIDRequest);
				
				if(rs.next()) {
					
					orderID = 1 + rs.getInt(1);
					
					System.out.println(orderID);
					
				}
				
				rs = DataAccess.queryDB(broncoIDRequest);
				
				if(rs.next()) {
					
					broncoID = rs.getInt(1);
					System.out.println(broncoID);

				}
				

			}
			catch(Exception e) {
				
				orderID = 1;
				
				JOptionPane.showMessageDialog(this,e,"Payment failed. Try Again",JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				
				System.out.println("(" + orderID + ", " + broncoID + ", " + status + ", '"
						  + dateFormatter.format(date) + "')");
				
				DataAccess.insertIntoDBValues("\"order\"", "(" + orderID + ", " + broncoID + ", " + status + ", '"
						  + dateFormatter.format(date) + "')");
				
			}
			
			catch(Exception e) {
				
				JOptionPane.showMessageDialog(this,e,"Failed to add order",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(event.getSource() == this.printButton) {
			
			
			
			
		}
		
	}
	// hibernate functions
	
//	public static void main(String args[]) {
//		new PaymentScreen();
//	}
}
