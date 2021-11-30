package view;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialReportScreen extends JFrame implements ActionListener {
	
	private JLabel customer, period, fromDate, toDate;
	
	private JTextField fromDateTF, toDateTF;
	
	private JButton viewReport, cancel;
	
	private JComboBox customerDropDown;
	
	private JPanel customerPanel, periodPanel, buttonPanel;
	
	public FinancialReportScreen() {
		
		this.initializeComponents();
		this.buildUI();
		
		
	}
	
	private void initializeComponents() {
		
		// Labels
		this.customer = new JLabel("Customer: ");
		this.period = new JLabel("Period: ");
		this.fromDate = new JLabel("From: ");
		this.toDate = new JLabel("To: ");
		
		// Dropdowns
		this.customerDropDown = new JComboBox();
		
		// Textfields
		this.fromDateTF = new JTextField(10);
		this.toDateTF = new JTextField(10);
		
		// Buttons
		this.viewReport =  new JButton("View Report");
		this.viewReport.addActionListener(this);
		
		this.cancel = new JButton("Cancel");
		this.cancel.addActionListener(this);
		
		// Panels
		this.customerPanel = new JPanel();
		this.customerPanel.setLayout((new GridLayout(0, 4, 10, 10)));
		
		this.periodPanel = new JPanel();
		this.periodPanel.setLayout((new FlowLayout(FlowLayout.LEFT)));
		
		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout((new FlowLayout(FlowLayout.CENTER)));

	}
	
	private void buildUI() {
		

		this.customerPanel.add(this.customer);
		this.customerPanel.add(this.customerDropDown);
		this.customerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.customerPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		this.periodPanel.add(this.period);
		this.periodPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.periodPanel.add(this.fromDate);
		this.periodPanel.add(this.fromDateTF);
		this.periodPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.periodPanel.add(this.toDate);
		this.periodPanel.add(this.toDateTF);
		
		this.buttonPanel.add(this.viewReport);
		this.buttonPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		this.buttonPanel.add(this.cancel);
		
		this.periodPanel.setPreferredSize(new Dimension(400, 800));
		
		this.getContentPane().add(this.customerPanel, BorderLayout.NORTH);
		this.getContentPane().add(this.periodPanel, BorderLayout.CENTER);
		this.getContentPane().add(this.buttonPanel, BorderLayout.SOUTH);
		
		this.setTitle("View Financial Report");
		this.setBounds(400, 120, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		// This returns to the main menu
		if(event.getSource() == this.cancel) {
			
			new MainScreen();
			dispose();
		}
		
	}
	

}
