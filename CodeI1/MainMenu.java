package CodeI1;
//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
	public static boolean back =  false;
	private JPanel contentPane;
	private static LogArray log;

	public MainMenu() {
		log = new LogArray();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectTheShape = new JLabel("Select the shape you would  ");
		lblSelectTheShape.setFont(new Font("Century Schoolbook", Font.BOLD, 16));
		lblSelectTheShape.setBounds(97, 11, 240, 25);
		contentPane.add(lblSelectTheShape);
		
		JLabel lblNewLabel = new JLabel("like the Finch to draw");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 16));
		lblNewLabel.setBounds(111, 34, 212, 25);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblPleaseSelectOne = new JLabel("Please select one of the following");
		lblPleaseSelectOne.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblPleaseSelectOne.setBounds(111, 95, 212, 25);
		contentPane.add(lblPleaseSelectOne);

//--------------------------------------------------------------------------------------------------------
// These are my labels that I have created to give the user Information about which button will be pressed
// I have set the bounds so that they appear just above each button		
		JLabel lblDrawTrinagle = new JLabel("Trinagle");
		lblDrawTrinagle.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblDrawTrinagle.setBounds(35, 161, 74, 14);
		contentPane.add(lblDrawTrinagle);
		
		JLabel lblDrawRectangle = new JLabel("Rectangle");
		lblDrawRectangle.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblDrawRectangle.setBounds(130, 161, 82, 14);
		contentPane.add(lblDrawRectangle);
		
		JLabel lblAdditionalFunction = new JLabel("Regular Polygon");
		lblAdditionalFunction.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblAdditionalFunction.setBounds(215, 161, 90, 14);
		contentPane.add(lblAdditionalFunction);
		
		JLabel lblQuitAndWrite = new JLabel("Quit & Write Log");
		lblQuitAndWrite.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblQuitAndWrite.setBounds(315, 161, 82, 14);
		contentPane.add(lblQuitAndWrite);
		
//--------------------------------------------------------------------------------------------------------
// These are my buttons that call the methods of each shape I draw
// Each button has an action Listener so when that particular button is pressed there will be a specific task called 		
		
		JButton btnT = new JButton("T");
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			Triangle T = new Triangle(log);
			T.setVisible(true);
			}
		});
		btnT.setBounds(10, 186, 89, 36);
		contentPane.add(btnT);
		
		JButton btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rectangle R = new Rectangle(log);
				R.setVisible(true);
			}
		});
		btnR.setBounds(110, 186, 89, 36);
		contentPane.add(btnR);
		
		JButton btnP = new JButton("P");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				RegularPolygon P = new RegularPolygon();
				P.setVisible(true);
			}
		});
		btnP.setBounds(210, 186, 89, 36);
		contentPane.add(btnP);
		
		JButton btnQ = new JButton("Q");
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "look at console Application for the log","Log",JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Goodbye!!");
				log.PrintDataLog();
				dispose();
				
				try {
					IntegrationMenu.FinchMenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnQ.setBounds(310, 186, 89, 36);
		contentPane.add(btnQ);
	}
}
