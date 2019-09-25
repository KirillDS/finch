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

public class Rectangle extends JFrame {

	private JPanel contentPane;
	private LogArray log;

	
	public int W, H,AreaR;
	public Rectangle(LogArray logArray) {
		log = logArray;	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//--------------------------------------------------------------------------------------------------------		
		// here are my labels i have set that give the user information about what to do in this frame 
		JLabel lblEnterWidthAnd = new JLabel("Enter Width and Height of the Rectangle ");
		lblEnterWidthAnd.setFont(new Font("Century Schoolbook", Font.BOLD, 16));
		lblEnterWidthAnd.setBounds(40, 23, 353, 42);
		contentPane.add(lblEnterWidthAnd);
		
		JLabel lblEnterWAnd = new JLabel("Enter W and H between 20 and 80 cm ");
		lblEnterWAnd.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblEnterWAnd.setBounds(102, 96, 230, 20);
		contentPane.add(lblEnterWAnd);
		
		JLabel lblclickOkTo = new JLabel("(click OK to continue)");
		lblclickOkTo.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblclickOkTo.setBounds(156, 127, 121, 14);
		contentPane.add(lblclickOkTo);
		
		JLabel lblW = new JLabel("W");
		lblW.setBounds(76, 190, 16, 14);
		contentPane.add(lblW);
		
		JLabel lblH = new JLabel("H");
		lblH.setBounds(266, 190, 16, 14);
		contentPane.add(lblH);
//--------------------------------------------------------------------------------------------------------		
		//here are my formatted textfields which take in the user data. see where the data is passed to below 
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(102, 187, 44, 20);
		contentPane.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(288, 187, 44, 20);
		contentPane.add(formattedTextField_1);
//--------------------------------------------------------------------------------------------------------		
		
		// when the OK button is pressed I use the parseInt method to get the string of text that the user input and turn it into an integer for me to do calculations with 
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int W, H; 
				try { 
					W = Integer.parseInt(formattedTextField.getText());
					H = Integer.parseInt(formattedTextField_1.getText());
					RectangleCheck(W,H,AreaR);
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter valid integer between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
				}// i use the try catch method to ensure all possible inputs have been accounted for including characters and strings. because i use the parseInt method if the user enterd a string that could not 
				// be converted this would result in my program crashing 
				
			}
		});
		btnNewButton.setBounds(172, 227, 89, 23);
		contentPane.add(btnNewButton);
		
	}
	public void RectangleCheck(int W, int H,int AreaR){
		this.W = W;
		this.H = H;
		
		if( W < 20 || W>80) {
			JOptionPane.showMessageDialog(null, "Please enter value W between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if (H< 20 ||H>80) {
			JOptionPane.showMessageDialog(null, "Please enter value H between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{
			FinchMovement Draw = new FinchMovement();
			Draw.DrawRectangle(W, H);
			AreaR =W*H;
			log.addData(-1, -1, -1, -1, -1, -1, -1, W, H, AreaR);
			dispose();
		}
		this.AreaR = AreaR; 
	}// i did the rectangle check here because I can set the variables the user has input to global variables using the this.method this allows me to 
}// call the variables in other classes
