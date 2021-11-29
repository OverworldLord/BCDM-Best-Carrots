package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainScreen extends JFrame implements ActionListener{
	
	private JButton studentReg, professorReg, foodItemReg, viewReport;
	
	private JPanel panel1, panel2;
	
	private JLabel orders;
	
	private Box buttonBox;
	
	public MainScreen() {
		
		this.initializeComponents();
		this.buildUI();
	}
	
	
	private void initializeComponents() {
		
		this.studentReg = new JButton("Student Registration");
		this.studentReg.addActionListener(this);
		this.professorReg = new JButton("Professor Registration");
		this.professorReg.addActionListener(this);
//		this.foodItemReg = new JButton("Dish/Beverage Registration");
//		this.foodItemReg.addActionListener(this);
		this.viewReport = new JButton("View Financial Report");
		this.viewReport.addActionListener(this);
		
		this.orders = new JLabel("Orders Placeholder");
		
		this.buttonBox = Box.createVerticalBox();
		
		this.panel1 = new JPanel();
		this.panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
	}
	
	private void buildUI() {
		
		
//		this.panel1.add(this.studentReg);
//		this.panel1.add(this.professorReg);
//		this.panel1.add(this.foodItemReg);
//		this.panel1.add(this.viewReport);
		
		this.panel2.setLocation(400, 0);
		
		this.buttonBox.add(Box.createRigidArea(new Dimension(20, 20)));
		this.buttonBox.add(this.studentReg);
		this.buttonBox.add(Box.createRigidArea(new Dimension(20, 20)));
		this.buttonBox.add(this.professorReg);
		this.buttonBox.add(Box.createRigidArea(new Dimension(20, 20)));
//		this.buttonBox.add(this.foodItemReg);
		this.buttonBox.add(Box.createRigidArea(new Dimension(20, 20)));
		this.buttonBox.add(this.viewReport);
		
		this.panel1.setSize(300, 800);
		this.panel2.setSize(300, 800);
		
		this.panel1.add(this.buttonBox);
		
		this.panel2.add(this.orders);
		
		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.NORTH);

		this.setTitle("Main Menu");
		this.setBounds(400, 120, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainScreen();
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == this.studentReg) {
			
			new StudentRegScreen(0);
			dispose();
		} else if(event.getSource() == this.professorReg) {
			new StudentRegScreen(1);
			dispose();
		}
//		} else if(event.getSource() == this.foodItemReg) {
//			
//			try {
//				new DishBeverageScreen();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			dispose();
//		}
		
	}
	
//	public void actionPerformed(ActionEvent event) {
//		
//		
//	}

}
