package CodeI1;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class FinchDance {
	//i have made all of these variables public so they can be used anywhere in the program
	public static int Red, Green, Blue, speed, dec, frequency;
	public static String digits = "0123456789ABCDEF", st;
	public static Finch myFinch = new Finch();
	public static int binary[] = new int[8];
	public static int octal[] = new int[8];
	public static String hex;
	public static boolean playAgain = true;
	public static Writer writer = null;
	
	
	public static void danceMain()throws IOException { //interprets any inputs or outputs

		//"writer" allows text to to be written to the text file HexInput.txt, "utf-8" means the text file is in string format, contains strings
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("HexInput.txt"), "utf-8" ));
		
		//welcome message
		System.out.println("Welcome to Finch Dance! This program will ask you to enter a hexadecimal value consisting of maximum 2 characters and of letters and numbers. It will then convert this into decimal, octal and binary and use these values to set the speed movements and colour of the Finch.");
		
		//this while loop is used so that the user is able to restart the program if they need to
		while (playAgain){
		//scanner reads users inputs
	     Scanner scan = new Scanner(System.in);
	     	
	     System.out.println("Enter a hexadecimal number : ");
	     //hex number will be set to the value that the user inputs
	     hex = scan.nextLine();
	     System.out.println("The Hex Number is " + hex);
	     
	     //This while loop used for the validation of the hex input
	     while ((hex.length() >2 ) || (!hex.matches("[a-f0-9]{2}")))
	     {
	    	 //If the length of the input is bigger than 2 the error message will appear and the user will be asked to enter a new value
	    	 if (hex.length() > 2)
	    	 {
	    		 System.out.println("The hexadecimal value must be no longer than 2 characters");
	    		 System.out.println("Enter a hexadecimal number: ");
	    		 hex = scan.nextLine();
	    	 }
	    	 
	    	 //If the input does not contain the characters in range and consist of 2 characters then the error message will be displayed
	    	 if (!hex.matches("[a-f0-9]{2}"))
	    	 {
	    		 System.out.println("The hexadecimal value must be a-f or 0-9");
	    		 System.out.println("Enter a hexadecimal number: ");
	    		 hex = scan.nextLine();
	    	 }
	    	 
	     }
	     
	     
	     //This writes the hex input to the text file HexInput.txt that was created at the beginning	     
	     writer.write(hex);
	     //creates a new line so all the hex values are written on separate lines
	     writer.write("\r\n");
	     
	     //Sets the decimal value to the value returned from the hexToDec method. The value hex must be passed to this method
		 dec = hexToDec(hex);
				
		 System.out.println("The Equivalent Decimal Number is " + dec);
		 
		 //rest of the methods in the program are called, also shows which values are to be passed to these modules
		 decToBinary(dec);
		 decToOctal(dec);
		 LED(dec);
		 buzz(dec);
		 finchSpeed();
		 finchDance();
		     
		  //asks the user if they would like to restart the program   
		  System.out.println("\r\nWould you like to restart the program? if you would press 1, if not, press 0");
		  int userInt=scan.nextInt();
		  
		  //if the user inputs 1 then playAgain is true and the while loop will run again
		  if(userInt==1){
			  playAgain=true;
		   }
		  
		  //if the user enters 0 the while loop will end
		   else if(userInt==0)
		   {
			   playAgain = false;
		   }
	}
		//The text file is closed once the program is finished
		writer.close();
		playAgain = false;
	
	}
	
	//this method converts the hex input to decimal	
	public static int hexToDec(String s)
	{	
		//converts the string hex input into upper case
        s = s.toUpperCase();
        
        
        int val = 0;
        //val is set to 0 and then i which is the index counter is set to 0 and then incremented
        for (int i = 0; i < s.length(); i++)
        {	
        	//c is set to the character at the index
            char c = s.charAt(i);
            //d is the digit at the of the index of c. the digits variable is set at the top of the program and contains the hexadecimal alphabet
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;

	}
	
	//This method is used to convert from decimal to binary. The decimal value calculated is passed through
	public static void decToBinary(int dec)
	{
			//index set to 0
		    int i = 0;
		    
		    //while loop that only executes the code if the decimal value is above 0
		    while (dec > 0){
		    	//this finds the remainder when dividing the decimal value by 2 and then keeps doing this until it gets to 0. The remainders give the binary value and stores it in an array
		        binary[i] = dec%2;
		        i++;
		        dec = dec/2;
		    }
		    
		    //the binary length must be 8 otherwise an error will be shown
		    while (binary.length < 8)
		    {
		    	System.out.println("ERROR LENGTH");
		    }
		    
		    
		    System.out.print("The Equivalent Binary Number is ");
		    
		    //this deincrements the binary array so that it will be printed in the correct order when shown to the user
		    for (int j = i -1 ; j >= 0 ; j--)
		    {
		        System.out.print(binary[j]);
		    }
		    
	}
	
	
	//This method converts decimal to octal. the decimal value calculated is passed through
	public static void decToOctal(int dec)
	{

	    int i = 0;
	    
	    //this is calculated in the same way as the binary value, however it is divided by 8 to find the remainder not 2
	    while (dec > 0){
	        octal[i] = dec%8;
	        i++;
	        dec = dec/8;
	    }
	    
	    System.out.print("\r\nThe Equivalent Octal Number is ");
	    
	    //This deincrements the octal array so that it will be printed in the correct order
	    for (int j = i -1 ; j >= 0 ; j--)
	    {	
	        System.out.print(octal[j]);
	        st = st + octal[j];
	    }
	}
	
	//This is where the LED colours are set and the decimal value is passed through to this method earlier in the main method
	public static void LED(int x)
	{
		Red = x; //Red is set to the decimal value
		Green = ((x % 80) +60); //Green is the decimal value MOD 80 and then added to 60
		Blue = ((Red + Green)/2); //Blue is red and green added together then divided by 2
		
		System.out.println("\r\nRed= " + Red);
		System.out.println("Green= " + Green);
		System.out.println("Blue= " + Blue);
		
		
	}
	
	//this is my additional feature which is that the Finch will make a buzzing sound. the frequency is determined by the decimal value
	public static void buzz(int dec)
	{
		//This does the decimal value multiplied by 100
		frequency = (dec*100);
		
		//as the maximum frequency is 20000 if the calculated value is above this then the frequency will be set to the maximum
		if (frequency > 20000)
		{
			frequency = 20000;
		}
	}
	
	//This method sets the Finchs speed using octal
	public static void finchSpeed()
	{	
		//st is equal to the octal array. it is assigned this in the decimal to octal method
		String str = st.substring(4, 7);
		
		//speed set to the octal value unless it is below 60, in which case it is added to 30 
		speed = Integer.parseInt(str);
		if (speed < 60 )
		{
			speed = speed + 30;
		}
		
		//as 255 is the finch speed limit if the octal value exceeds this then it is set to 255
		else if (speed > 255)
		{
			speed = 255;
		}
		
		System.out.println("Speed= " + speed);
	}
	
	//This method controls the forward and backward movements of the Finch that is calculated by the binary value. 1 is forward 0 is backwards
	public static void finchDance()
	{
		//commands the finch to set its LED lights and buzz to the reuqired frequency
		myFinch.setLED(Red,Green,Blue);
		myFinch.buzz(frequency, 1000);
		
		//runs through the binary value to check if the value is 1 or 0
		for (int i = 0; i < binary.length; i++)
		{
			if (binary[i] == 1)
			{
				//Moves the finch forward to the speed calculated in the method above
				myFinch.setWheelVelocities(speed, speed, 1000);
			}
			else if (binary[i] == 0)
			{
				//Moves the Finch backwards (-speed) to the speed calculated
				myFinch.setWheelVelocities(-speed, -speed, 1000);
			}
		}
		
		//turns off the Finch lights once the Finch has finished its dance
		myFinch.setLED(0,0,0);
	}
	
	
}
