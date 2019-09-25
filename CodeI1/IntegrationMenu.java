package CodeI1;




	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.IOException;
	
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
	public class IntegrationMenu {
		
		static JFrame f;
		static JPanel p;
		static JLabel l;
		static boolean con;
		
		
		
		public static void main(String[] args) throws IOException {
			
			
			
			FinchMenu();
		}
		
		
		static void FinchMenu() throws IOException
		{
		
			f=new JFrame("Yellow 9 Finch integration");   
		    final JLabel label = new JLabel();          
		    label.setHorizontalAlignment(JLabel.CENTER);  
		    label.setSize(400,100);  
		    JButton b=new JButton("RUN");  
		    b.setBounds(200,100,75,20);  
		    String languages[]={"Search For Light","Draw Shape","Navigate","Detect Object","Dance","Tilt Control", "Quit"};        
		    final JComboBox cb=new JComboBox(languages);    
		    cb.setBounds(50, 100,90,20);    
		    f.add(cb); f.add(label); f.add(b);    
		    f.setLayout(null);    
		    f.setSize(350,350);    
		    f.setVisible(true);    
		    b.addActionListener(new ActionListener() {  
		        public void actionPerformed(ActionEvent e) {  
		        	String data = "Command Selected: "   + cb.getItemAt(cb.getSelectedIndex()); 
		        	if ((cb.getItemAt(cb.getSelectedIndex())).equals("Search For Light") == true)
		        	{
		        		SearchForLight();
		        	
		        	}
		        	if ((cb.getItemAt(cb.getSelectedIndex())).equals("Draw Shape") == true)
		        	{
		 
		        		DrawShape();
		        		
		        	}
		        	if ((cb.getItemAt(cb.getSelectedIndex())).equals("Navigate") == true)
		        	{
		        		Navigate();
		        	
		        	}

		        	if ((cb.getItemAt(cb.getSelectedIndex())).equals("Detect Object") == true)
		        	{
		        		
		        		DetectObject();
		        	}
		        	if ((cb.getItemAt(cb.getSelectedIndex())).equals("Dance") == true)
		        	{
		        		
		        		Dance();
		        	}
		        	if ((cb.getItemAt(cb.getSelectedIndex())).equals("Tilt Control") == true)
		        	{
		        		TiltControl();
		        		
		        	}
		        	if ((cb.getItemAt(cb.getSelectedIndex())).equals("Quit") == true)
		        	{
		        		System.exit(0);
		        	}
		        	else 
		        	{
		        		label.setText(data);
		        	}
		        	
		        }  
		    });           
		    
		}
		public static void Navigate(){
			f.setVisible(false);
    		
    		try {
    			
    				Program_Logic.ttexit = false;
    				Program_Logic.navigateMain();
    				f.setVisible(true);
    				
    			
    					
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		public static void SearchForLight(){
			f.setVisible(false);
			
			try{
				
				searchforlight2.exit = false;
				searchforlight2.searchforlight_Main();
				f.setVisible(true);
				
				
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		
		public static void TiltControl(){
			
			f.setVisible(false);
			
			try{
			
				maincodeoftilt.main();
				
				f.setVisible(true);
				
				
			}catch(Exception e1){
				e1.printStackTrace();
			}	
			
		}
		public static void DetectObject(){
			f.setVisible(false);
			
			try{
				Main_Class.Exit = false;
				Main_Class.main();
				
				f.setVisible(true);
				
				
			}catch(Exception e1){
				e1.printStackTrace();
			}	
			
		}
		public static void Dance(){
			f.setVisible(false);
			
			try{
				FinchDance.playAgain = true;
				FinchDance.danceMain();
				f.setVisible(true);
				
				
			}catch(Exception e1){
				e1.printStackTrace();
			}	
			
		}

		public static void DrawShape(){
			f.setVisible(false);
			try{
    		MainMenu menu = new MainMenu();
    		
    		menu.setVisible(true);
    		
    		
			}catch(Exception e1){
				e1.printStackTrace();
			}
    
    		
    		
		}
			
		}


