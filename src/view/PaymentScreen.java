package view;

import javax.swing.*;
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
import javax.swing.table.TableModel;

import model.dataaccess.DataAccess;

public class PaymentScreen extends JFrame implements ActionListener {
	
	private JPanel labelPanel, tablePanel, topPaymentPanel, botPaymentPanel, 
				   paymentPanel, optionPanel, successPaymentPanel;
	
	private JButton payButton, cancelButton, printButton;
	
	private JTextField cardNumber, cardDate, cardCCV;
	
	private JLabel nameLabel, quantityLabel, priceLabel, paymentLabel, 
				   cardNumberLabel, cardDateLabel, cardCcvLabel;
				   
	private JLabel paymentMethodLabel, paymentInfoLabel, customerLabel, customerTypeLabel,
		     	   transactionDateLabel, transactionTimeLabel;
	
	private JComboBox paymentMethod;
	
	private JTable orderTable, paymentSuccessTable;
	private DefaultTableModel model;
//	private String[] tableColumns = {"Item", "Quantity", "Price", "Total Price"};

	private int tableRows = 30;
	
	public PaymentScreen(TableModel tableModel) {
		
		this.model = (DefaultTableModel) tableModel;
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
		
		// Text Fields
		this.cardNumber = new JTextField();
		this.cardDate = new JTextField();
		this.cardCCV = new JTextField();
		
		// Table
		this.orderTable = new JTable(model);

		
		//Payment Success , different model??
		paymentMethodLabel = new JLabel("Payment Method:");
		paymentInfoLabel = new JLabel("Payment Info:");
		customerLabel = new JLabel("Customer:");
		customerTypeLabel = new JLabel("Customer Type:");
		transactionDateLabel = new JLabel("Transaction Date:");
		transactionTimeLabel = new JLabel("Transaction Time:");
		
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
		this.successPaymentPanel.setLayout((new GridLayout(6, 0, 10, 2)));
		
		this.paymentPanel = new JPanel();
		this.paymentPanel.setLayout((new GridLayout(0, 1, 0, 10)));
		this.paymentPanel.setSize(200, 800);
		
		this.optionPanel = new JPanel();
		this.optionPanel.setLayout(new GridLayout(0, 4, 0, 0));
		this.optionPanel.setSize(200, 200);
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
		this.successPaymentPanel.add(this.paymentInfoLabel);
		this.successPaymentPanel.add(this.customerLabel);
		this.successPaymentPanel.add(this.customerTypeLabel);
		this.successPaymentPanel.add(this.transactionDateLabel);
		this.successPaymentPanel.add(this.transactionTimeLabel);
		
		this.optionPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.optionPanel.add(payButton);
		this.optionPanel.add(cancelButton);
		
		//this.getContentPane().add(this.labelPanel, BorderLayout.NORTH);
		this.getContentPane().add(this.tablePanel, BorderLayout.NORTH);
		this.getContentPane().add(this.paymentPanel, BorderLayout.CENTER);
		this.getContentPane().add(this.optionPanel, BorderLayout.SOUTH);
		
		this.setTitle("Payment");
		this.setBounds(400, 120, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);	
		
	}
	
	public void successPayment() {
			this.paymentPanel.remove(topPaymentPanel);
			this.paymentPanel.remove(botPaymentPanel);
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
			successPayment();
//			dispose();
		}
	}
	// hibernate functions
	
//	public static void main(String args[]) {
//		new PaymentScreen();
//	}
}
