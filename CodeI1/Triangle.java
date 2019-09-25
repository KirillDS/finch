package CodeI1;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Triangle extends JFrame {

	private JPanel contentPane;


	public int L1,L2,L3;
	
	private LogArray log;
	
	public Triangle(LogArray logArray) {
		log = logArray;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//--------------------------------------------------------------------------------------------------------			
		JLabel lblEnterTriangleLengths = new JLabel("Draw Triangle");
		lblEnterTriangleLengths.setFont(new Font("Century Schoolbook", Font.BOLD, 16));
		lblEnterTriangleLengths.setBounds(150, 11, 202, 28);
		contentPane.add(lblEnterTriangleLengths);
		
		JLabel lblEnterLenghts = new JLabel("Enter 3 lenghts between 20 and 80 cm");
		lblEnterLenghts.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblEnterLenghts.setBounds(116, 97, 202, 14);
		contentPane.add(lblEnterLenghts);
		
		JLabel lblclickOkTo = new JLabel("(Click OK to continue)");
		lblclickOkTo.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblclickOkTo.setBounds(153, 122, 127, 20);
		contentPane.add(lblclickOkTo);
		
		JLabel lblL = new JLabel("L1");
		lblL.setBounds(46, 187, 19, 14);
		contentPane.add(lblL);
		
		JLabel lblL_2 = new JLabel("L2");
		lblL_2.setBounds(174, 187, 19, 14);
		contentPane.add(lblL_2);
		
		JLabel lblL_1 = new JLabel("L3");
		lblL_1.setBounds(299, 187, 19, 14);
		contentPane.add(lblL_1);
//--------------------------------------------------------------------------------------------------------			
		
		
		JFormattedTextField TextFieldL1 = new JFormattedTextField();
		TextFieldL1.setBounds(66, 184, 50, 20);
		contentPane.add(TextFieldL1);
		
		JFormattedTextField TextFieldL2 = new JFormattedTextField();
		TextFieldL2.setBounds(192, 184, 50, 20);
		contentPane.add(TextFieldL2);
		
		JFormattedTextField TextFieldL3 = new JFormattedTextField();
		TextFieldL3.setBounds(317, 184, 50, 20);
		contentPane.add(TextFieldL3);
		
//--------------------------------------------------------------------------------------------------------
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Algorithm 2.1 implementation
				int L1,L2,L3;
				
				try {
					L1 = Integer.parseInt(TextFieldL1.getText());
					L2 = Integer.parseInt(TextFieldL2.getText());
					L3 = Integer.parseInt(TextFieldL3.getText());
				getUserInputAndCheckInput(L1, L2, L3);
				
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "You have entered invalid characters \n Please enter a valid integer between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			
			}
		});
		btnNewButton.setBounds(172, 227, 89, 23);
		
		contentPane.add(btnNewButton);
	}
	
//--------------------------------------------------------------------------------------------------------	
	// This checks if the user input is valid. if the input is valid then the program will continue to the valid triangle check which will in turn will check if the lengths make triangle 
	public void getUserInputAndCheckInput(int L1,int L2,int L3)	{
		this.L1 = L1;
		this.L2 = L2;
		this.L3 = L3;
		
		
		if(L1<20|| L1>80) {
			JOptionPane.showMessageDialog(null, "Please enter value L1 between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if (L2<20||L2>80) {
			JOptionPane.showMessageDialog(null, "Please enter value L2 between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if (L3<20||L3>80) {
			JOptionPane.showMessageDialog(null, "Please enter value L3 between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{
		TriangleCheck Validate = new TriangleCheck();
		Validate.ValidTriangle(L1, L2, L3);
		log.addData(L1, L2, L3, Validate.A1d, Validate.A2d, Validate.A3d, Validate.AreaT, -1,-1,-1);// this is the log i have created that adds all the data from my ussers input into one array. you may notice that there are -1's this is where the rectangle information would have gone.
		dispose();// this dispose is done after all the code for drawing the Finch has been run 
		}
		
	} 
	
	
	public LogArray getLog(){ // this is a get mwethod that returns the updated log to the the Quit function when entered showing the array 
		return log;
	}
	
	
			
}
	



