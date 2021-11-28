package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.dataaccess.DataAccess;

public class StudentRegScreen extends JFrame implements ActionListener{
	
	private JLabel firstName, lastName, DOB, phone, address, broncoID, enterDate, gradDate, major, minor, department, office, research;
	
	private JTextField firstNameTF, lastNameTF, DOBTF, phoneTF, addressTF, broncoIDTF, enterDateTF, gradDateTF, 
			majorTF, minorTF, departmentTF, officeTF, researchTF;
	
	private JButton regSButton, cancelSButton, regPButton, cancelPButton;
	
	private JTabbedPane tabs;
	
	private JPanel panelM, panelA, panel1, panel2;
	
	private int startingTab;
	

	public StudentRegScreen(int startingTab) {
		this.startingTab = startingTab;
		this.initializeComponents();
		this.buildUI();
		
	}
	
	private void initializeComponents() {
		
		this.firstName = new JLabel("First name: ");
		this.lastName = new JLabel("Last name: ");
		this.DOB = new JLabel("DOB: ");
		this.phone = new JLabel("Phone: ");
		this.address = new JLabel("Address: ");
		this.broncoID = new JLabel("Bronco ID: ");
		this.enterDate = new JLabel("Enter Date: ");
		this.gradDate = new JLabel("Grad Date: ");
		this.major = new JLabel("Major: ");
		this.minor = new JLabel("Minor: ");
		this.department = new JLabel("Department: ");
		this.office = new JLabel("Office: ");
		this.research = new JLabel("Research: ");
		
		this.firstNameTF = new JTextField();
		this.lastNameTF = new JTextField();
		this.DOBTF = new JTextField();
		this.phoneTF = new JTextField();
		this.addressTF = new JTextField();
		this.broncoIDTF = new JTextField();
		this.enterDateTF = new JTextField();
		this.gradDateTF = new JTextField();
		this.majorTF = new JTextField();
		this.minorTF = new JTextField();
		this.departmentTF = new JTextField();
		this.officeTF = new JTextField();
		this.researchTF = new JTextField();
	
		
		this.regSButton = new JButton("Register");
		this.regSButton.addActionListener(this);
		this.cancelSButton = new JButton("Cancel");
		this.cancelSButton.addActionListener(this);
		this.regPButton = new JButton("Register");
		this.regPButton.addActionListener(this);
		this.cancelPButton = new JButton("Cancel");
		this.cancelPButton.addActionListener(this);
		
		this.panelM = new JPanel();
		this.panelM.setLayout(new GridLayout(0, 1, 0, 0));
		this.panelM.setSize(800, 800);
		
		this.panelA = new JPanel();
		this.panelA.setLayout((new GridLayout(0, 4, 10, 10)));
		this.panelA.setSize(800, 800);
		
		
		this.panel1 = new JPanel();
		this.panel1.setLayout((new GridLayout(0, 4, 10, 10)));
		this.panel1.setSize(800, 800);
		
		this.panel2 = new JPanel();
		this.panel2.setLayout((new GridLayout(0, 4, 10, 10)));
		this.panel2.setSize(800, 800);
		
		this.tabs = new JTabbedPane();
		
	}
	
	private void buildUI(){
		
	
		this.panelA.add(this.firstName);
		this.panelA.add(this.firstNameTF);
		
		this.panelA.add(this.lastName);
		this.panelA.add(this.lastNameTF);
		
		this.panelA.add(this.DOB);
		this.panelA.add(this.DOBTF);
		
		this.panelA.add(this.phone);
		this.panelA.add(this.phoneTF);
		
		this.panelA.add(this.address);
		this.panelA.add(this.addressTF);
		
		this.panelA.add(this.broncoID);
		this.panelA.add(this.broncoIDTF);
		
		this.panel1.add(this.enterDate);
		this.panel1.add(this.enterDateTF);
		
		this.panel1.add(this.gradDate);
		this.panel1.add(this.gradDateTF);
		
		this.panel1.add(this.major);
		this.panel1.add(this.majorTF);
		
		this.panel1.add(this.minor);
		this.panel1.add(this.minorTF);
		
		this.panel1.add(Box.createRigidArea(new Dimension(20, 20)));
		
		this.panel1.add(this.regSButton);
		this.panel1.add(this.cancelSButton);
		
		this.panel2.add(this.department);
		this.panel2.add(this.departmentTF);
		
		this.panel2.add(this.office);
		this.panel2.add(this.officeTF);
		
		this.panel2.add(this.research);
		this.panel2.add(this.researchTF);

		this.panel2.add(Box.createRigidArea(new Dimension(20, 20)));
		this.panel2.add(Box.createRigidArea(new Dimension(20, 20)));
		this.panel2.add(Box.createRigidArea(new Dimension(20, 20)));
	
		this.panel2.add(this.regPButton);
		this.panel2.add(this.cancelPButton);
		
		tabs.addTab("Student Tab", panel1);
		tabs.addTab("Professor Tab", panel2);
		tabs.setSelectedIndex(this.startingTab);
		
		this.panelM.add(this.panelA);
		this.panelM.add(this.tabs);
		
		this.getContentPane().add(panelM, BorderLayout.NORTH);
//		this.getContentPane().add(panel1, BorderLayout.NORTH);
//		this.getContentPane().add(panel2, BorderLayout.NORTH);
		

		this.setTitle("Customer Registration");
		this.setBounds(350, 140, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == this.cancelSButton || event.getSource() == this.cancelPButton) {
			
			new MainScreen();
			dispose();
		} else if(event.getSource() == this.regSButton || event.getSource() == this.regPButton) {
			
			int discountType = 0;
			
			String DBname;
			DBname = "student";
			String output;
			output =  "('" + this.firstNameTF.getText() + ' ' + this.lastNameTF.getText() 	+ "', '";
			output += 		this.DOBTF.getText() 										  	+ "', '";
			output += 		this.phoneTF.getText() 											+ "', '";
			output += 		this.addressTF.getText() 										+ "', '";
			output += 		this.broncoIDTF.getText() 										+ "', '";
			if(event.getSource() == this.regSButton)
			{
				
				discountType = 0;
				output += 	this.enterDateTF.getText() 										+ "', '";
				output += 	this.gradDateTF.getText()										+ "', '";
				output += 	this.majorTF.getText() 											+ "', '";
				output += 	this.minorTF.getText() 											+ "')";
				
				//Output to student DB
				DBname = "student";
				
			} else if (event.getSource() == this.regPButton) {
				
				discountType = 1;
				output += 	this.departmentTF.getText() + "', '";
				output += 	this.officeTF.getText() 	+ "', '";
				output += 	this.researchTF.getText() 	+ "')";
				
				//Output to prof DB
				DBname = "professor";
			}
			
			try {
				DataAccess.insertIntoDBValues(DBname, output);
				
				//print success message
				JOptionPane.showMessageDialog(this,"Successfully added customer.");
			}
			catch(Exception e) {
				//print fail message
				JOptionPane.showMessageDialog(this,e,"Failed to add customer",JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				
				new DishBeverageScreen((this.firstNameTF.getText() + " " + this.lastNameTF.getText()),
										discountType);
				
			} catch (ClassNotFoundException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
	}
}
