package CodeI1;

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
public class RegularPolygon extends JFrame {
	
	private JPanel contentPane;
	
	public int Side, Length;
	public RegularPolygon(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//--------------------------------------------------------------------------------------------------------		
		//again like the other GUI classes i use Labels to give information to my user. here I explain what a regular Polygon is just in the event the user is unsure 
		JLabel lblRegularPolygon = new JLabel("Draw Regular Polygon");
		lblRegularPolygon.setFont(new Font("Century Schoolbook", Font.BOLD, 16));
		lblRegularPolygon.setBounds(120, 11, 202, 28);
		contentPane.add(lblRegularPolygon);
		
		
		
		JLabel lblWhat = new JLabel("What is a Regular Polygon?");
		lblWhat.setFont(new Font("Century Schoolbook", Font.PLAIN, 13));
		lblWhat.setBounds(120, 45, 202, 28);
		contentPane.add(lblWhat);
		
		JLabel lblRPDefinition = new JLabel("A regular polygon is a polygon in which all sides are ");
		lblRPDefinition.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblRPDefinition.setBounds(95, 65, 400, 28);
		contentPane.add(lblRPDefinition);
		
		JLabel lblRPDefinition1 = new JLabel(" of all the same length and at the same angles");
		lblRPDefinition1.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblRPDefinition1.setBounds(100, 80, 400, 28);
		contentPane.add(lblRPDefinition1);
		
		JLabel lblEnterSides = new JLabel("1. Enter Number of sides between 5 & 9");
		lblEnterSides.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblEnterSides.setBounds(102, 130, 230, 20);
		contentPane.add(lblEnterSides);
		
		JLabel lblEnterLength = new JLabel("2. Enter Length of side between 20-80 cm");
		lblEnterLength.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblEnterLength.setBounds(102, 145, 235, 20);
		contentPane.add(lblEnterLength);
		
		JLabel lblclickOkTo = new JLabel("(click OK to continue)");
		lblclickOkTo.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		lblclickOkTo.setBounds(156, 160, 121, 14);
		contentPane.add(lblclickOkTo);
		
		
		JLabel lblSide = new JLabel("No. sides");
		lblSide.setBounds(50, 187, 60, 28);
		contentPane.add(lblSide);
		
		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(248, 187, 60, 28);
		contentPane.add(lblLength);
//--------------------------------------------------------------------------------------------------------		
		//here are the TextFields Formatted  to get the user input 
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(102, 190, 44, 20);
		contentPane.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(288, 190, 44, 20);
		contentPane.add(formattedTextField_1);
		
//--------------------------------------------------------------------------------------------------------	
		// this is the button used to check the user input as the Polygon check is called after getting the user input
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int Side, Length;
				try{
					Side = Integer.parseInt(formattedTextField.getText());
					Length = Integer.parseInt(formattedTextField_1.getText());
					PolygonCheck(Side,Length);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(null, "Please enter a valid sides and length\nSide between 5 and 9\nLength between 20 and 80","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		
		});
		btnNewButton.setBounds(172, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
//--------------------------------------------------------------------------------------------------------	
// my polygon Check checks the amount of sides the user input and the Length of that side 
	public void PolygonCheck(int Side, int Length){
		this.Side = Side;
		this.Length = Length;
		
		if(Side <5|| Side> 9)
		{
			JOptionPane.showMessageDialog(null, "Please enter a number of sides between 5 and 9","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if (Length <20 || Length>80)
		{
			JOptionPane.showMessageDialog(null, "Please enter value Length between 20 and 80cm","Error",JOptionPane.ERROR_MESSAGE);
		}
		else {
			RegularPolygonCheck shapes = new RegularPolygonCheck();// the uses of OOP is used here and in many places to call the method from another class
			shapes.PolygonSort(Side,Length);
			dispose();
		}
		
	}

}
