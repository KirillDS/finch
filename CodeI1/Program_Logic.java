package CodeI1;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Character;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Program_Logic{
	//This is the main class which creates objects from the Finch Class and 2 Classes I wrote myself; FinchMove and ConsoleUI Class
	static Finch myFinch = new Finch();
	static FinchMoveT finchMove = new FinchMoveT();
	static ConsoleUI2 consoleUI = new ConsoleUI2();
	static boolean ttexit = false;
	
	public static Scanner sc; //Global Variable as its called in many methods and is not assigned a value.
	
	public static void navigateMain() throws IOException{
		//This is the main method, which calls methods 

				consoleUI.WelcomeMessage();
				
				//The 2 main arrays 
			    ArrayList<ArrayList<Integer>> PrevC = new ArrayList<ArrayList<Integer>>(); 
			    //PrevC = Previous Commands
			    //Stores all the commands for the Trace Command
			    ArrayList<ArrayList<Integer>> PrevCT = new ArrayList<ArrayList<Integer>>();
			    //PrevCT = Previous Commands including T
			    //Stores all the commands apart from T for the Write Command
			    
			    
			    while (ttexit == false) //this will continuously loop until the quit command has been selected
			    { 
			    	char Command;
			    	Command = ValidCommand();
			    	
			    	ArrayList<Integer> CommandArray = null;
			    	
			    	CommandArray = RunCommand(Command, PrevC, PrevCT);
			    	//The RunCommand will return the CommandArray which will either contain values or be equal to null
			    	//If a movement command (F,B,L,R) or T was confirmed then it will contain values 
			    	//If another command is entered or the above wasn't confirmed then CommandArray = null
			    	//When null it wont be added to the 2 main ArrayLists
			    	
			    	if (CommandArray != null)
			    	{ 
			    		//all CommandArrays not = null will be added to the PrevCT ArrayList
			    		PrevCT.add(CommandArray);
			    		if (Command != 'T')
			    		{ 
			    			//all apart from T will be added to PrevC
			    			PrevC.add(CommandArray);
			    		}
			    	} 
			    }
	}
	public static char ValidCommand() {
		//this method gets the command and checks that it is a valid input
		char Command = 0; 
		sc = new Scanner(System.in);
		
		boolean error = true;
		
		while (error == true){
			try{
				consoleUI.CommandMenu();
				
				Command = sc.next().charAt(0);
				//this makes it read the first  character that the user inputs from a string. 
				//if they entered forward then it would read just the f and take it as the forward command
				Command = Character.toUpperCase(Command);
				//this changes their input to upper case so the program is more usable
				if (Command == 'F' ||Command == 'B' || Command== 'L' || Command == 'R' ||Command== 'W' ||Command == 'T' || Command == 'Q' || Command == 'X')
				{
					error = false;
				}
				else{
					consoleUI.ERRORMessage("You entered an invalid command");
					error = true;
				}
			}
			catch(Exception e){// this catches if it would cause an error if they entered in the wrong data type
				consoleUI.ERRORMessage("You entered an invalid command");
				error = true;
			}
		}
		return Command;
	}
	
	public static ArrayList<Integer> RunCommand(char Command,ArrayList PrevC,ArrayList PrevCT) throws IOException
	{
		ArrayList<Integer> CommandArray = new ArrayList<Integer>();
		//this array stores the command, time and speed which is then stored in the 2 main arrays in main

		if (Command == 'F')
		{
			boolean Correct = CorrectChoice("Forward", false, "");
			if  (Correct == true)
			{
				int Time = InputTime();
				int Speed = InputSpeed();
				CommandArray = WritetoArray(Time, Speed, 0); 
				//returns the ArrayList which stores the command, time and speed
				//each command is linked to a number so can be stored in an Integer ArrayList
				//Forward = 0
				//Backward = 1
				//Left = 2
				//Right = 3
				//Trace = 4
				Forward(Time, Speed);
			}
			else
			{
				CommandArray = null;
				//if the user did not want to go ahead or change their mind with the command they choose then 
				//CommandArray will be equal to null so not stored in the 2 main arrays
			}
			
		}
		else if (Command == 'B')
		{
			boolean Correct = CorrectChoice("Backward", false, "");
			if  (Correct == true)
			{
				int Time = InputTime();
				int Speed = InputSpeed();
				CommandArray = WritetoArray(Time, Speed, 1);
				Backward(Time, Speed);
			}
			else
			{
				CommandArray = null;
			}
		}
		else if (Command == 'L')
		{
			boolean Correct = CorrectChoice("Left", false , "");
			if  (Correct == true)
			{
				int Time = InputTime();
				int Speed = InputSpeed();
				CommandArray = WritetoArray(Time, Speed, 2);
				Left(Time, Speed);
			}
			else
			{
				CommandArray = null;
			}
		}
		else if (Command == 'R')
		{
			boolean Correct = CorrectChoice("Right", false, "");
			if  (Correct == true)
			{
				int Time = InputTime();
				int Speed = InputSpeed();
				CommandArray = WritetoArray(Time, Speed, 3);
				Right(Time, Speed);
			}
			else
			{
				CommandArray = null;
			}
		}
		else if (Command == 'T')
		{
			boolean Correct = CorrectChoice("Trace", false, "");
			if (Correct == true)
			{
				CommandArray = Trace(PrevC);
			}
			else 
			{
				CommandArray = null;
			}
			 
		}
		else if (Command == 'W')
		{
			boolean Correct = CorrectChoice("Write", false, "");
			if (Correct == true)
			{
				Write(PrevCT);
			}
			else 
			{
				CommandArray = null;
			}
			 
		}
		else if (Command == 'T')
		{
			boolean Correct = CorrectChoice("Trace", false, "");
			if (Correct == true)
			{
				CommandArray = Trace(PrevC);
			}
			else 
			{
				CommandArray = null;
			}
			 
		}
		else if (Command == 'X')
		{
			boolean Correct = CorrectChoice("Random", false, "");
			if (Correct == true)
			{
				CommandArray = Random();
			}
			else 
			{
				CommandArray = null;
			}
			 
		}
		else if (Command == 'Q')
		{
			boolean Correct = CorrectChoice("Quit", false, "");
			if (Correct == true)
			{
				Quit();	
				ttexit = true;

			}
			else 
			{
				CommandArray = null;
			}
			
			
		}
		//returns the CommandArray returned from each command method to main to be added to the main arrays if they have values in them
		return CommandArray;
	}
	
	public static ArrayList<Integer> WritetoArray(int Time, int Speed, int CommandNo){
		//this method creates the ArrayList which stores the commands which will then be returned back and stored in the 1 or both of the main arrays
		
		ArrayList<Integer> CommandArray = new ArrayList<Integer>();
		//Adds the corresponding number for the command (F = 0, B = 1 ... etc) as CommandNo
		//and Speed and time to the array
		
		CommandArray.add(CommandNo);
		CommandArray.add(Speed);
		CommandArray.add(Time);
		
		return CommandArray;
		
	}
	
	public static boolean CorrectChoice(String Command, boolean file, String fileName){
		//This method asks the user whether they made the correct choice
		//Whether it is the correct command or correct fileName
		boolean Correct = false; 
		boolean error = true;
		while (error == true)
		{
			try {
				sc = new Scanner(System.in);
				consoleUI.CorrectCommand(Command, file, fileName);
				//this uses the method from the ConsoleUI Class to print out the appropriate statement 
				//either about the command or file name
				Correct = sc.nextBoolean();
				error = false;
			}
			catch (Exception e){
				consoleUI.ERRORMessage("You need to enter true or false");
				error = true;
			}
		}
		
		return Correct;
	}
	
	public static void Forward(int Time, int Speed) {
	//this method uses the methods for the finch to move forward and print a message to tell the user its moving forward
		//with the time and speed they entered 
		
		consoleUI.MovingMessage("Forward", Speed, Time);
		 
		//to turn the seconds to milliseconds
		Time = Time * 1000;
		
		finchMove.MoveStraight(Time, Speed, myFinch);
		//you have to use the myFinch as a parameter so the 
		
		
	}
	
	public static void Backward(int Time, int Speed) {
		//this method uses the methods for the finch to move backward and print a message to tell the user its moving backward
		//with the speed and time they entered
		
		consoleUI.MovingMessage("Backward", Speed, Time);
		
		Time = Time * 1000; //to turn the seconds to milliseconds
		Speed = Speed * -1; //makes the wheels go backwards 
			
		finchMove.MoveStraight(Time, Speed, myFinch);

	}
	
	public static void Left(int Time, int Speed) {
		//this method uses the methods for the finch to move left and print a message to tell the user its moving left
		//using the time and speed that the user entered 
		consoleUI.MovingMessage("Left", Speed, Time);
		 
			
		int turnTime = finchMove.Left(myFinch); // returns the time it took to turn 
		
		Time = ((Time * 1000) - turnTime); // the time that the user entered minus the time it took to turn 
		//this is because the move duration must not be longer than 6 seconds
		if (Time > 0){// this stops the finch moving infinitely if the user wrote a time less than the time taken to turn
			finchMove.MoveStraight(Time, Speed, myFinch);
			//once it turns it then moves straight with the speed entered and the left over time
		}
		
		
	
	}
	
	public static void Right(int Time, int Speed) {
		//this method uses the methods for the finch to move right and print a message to tell the user its moving right
		
		consoleUI.MovingMessage("Right", Speed, Time);
		
		int turnTime = finchMove.Right(myFinch);//returns time taken to turn
		
		Time = ((Time * 1000) - turnTime);//time that the user inputed minus time taken to turn
		if (Time > 0){ 
			finchMove.MoveStraight(Time, Speed, myFinch);
		}
		
			
	
	}
	
	public static int InputTime() {
		//this method gets and checks that the time inputed is valid 
		//then returns it so it can be used for the movement of the finch 
		
		int Time = -1; //this is so it goes into the while loop

		while (Time > 6 || Time < 1)
		{
			try {
				sc = new Scanner(System.in);
				
				consoleUI.RangeMessage(1, 6, "Time" );
				
				Time = sc.nextInt();
				if (Time > 6 || Time < 1) //time has to be between 1 and 6
				{
					consoleUI.ERRORMessage("Your time needs to be between 1 and 6");
				}
				
			}
			catch (Exception e)//if another data type it stops the program from crash 
			{
				consoleUI.ERRORMessage("Your time needs to be a whole number between 1 and 6");
			}
		}
		
		return Time;
		
	}
	
	public static int InputSpeed() {
		//this method gets and checks that the value the user inputed is a suitable speed
		//then returned so it can be used for the movement of the finch
		int Speed = -1;
		
		while (Speed > 200 || Speed < 1)
		{
			
			try {
				
				sc = new Scanner(System.in);
				
				consoleUI.RangeMessage(1, 200, "Speed");
				Speed = sc.nextInt();
				if (Speed > 200 || Speed < 1)//the speed has to be between 1 and 200
				{
					consoleUI.ERRORMessage("Your speed needs to be between 1 and 200");
					
				}
				
			}
			catch (Exception E)//if another data type then it stops the program from crashing
			{
				consoleUI.ERRORMessage("Your speed needs to be a whole number between 1 and 200");
			}
		}
		
		return Speed;
	}

	public static void Write(ArrayList PrevCT) throws IOException  {
		//this method writes the ArrayList and Current time to a text file 
	
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat Date = new SimpleDateFormat("HH:mm:ss"); 
	   
	    String CurrentT = ( Date.format(cal.getTime()) );
	    //this gets the Current time in the format HH:mm:ss
	    
	    consoleUI.GetFileNameText();
	    
	    String fileName = sc.next(); //the user enters a file name of their choice 
	    
	    boolean correct = CorrectChoice("", true, fileName); //this asks if the filename was the correct choice 
	    //if was correct then it saves the commands and time to that name
	    if (correct == true) {
	    	consoleUI.WriteMessage(CurrentT, fileName); 
		    
			FileWriter fw = new FileWriter("H:" + fileName + ".txt"); //this saves it with the name that they entered
				
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(CurrentT); //this writes the current time to the file
			for (int i = 0; i < (PrevCT.size()); i++) {
				
				ArrayList<Integer> CommandArray = (ArrayList<Integer>) (PrevCT.get(i));
				//for every index it makes it back to an ArrayList like it was created
				//as F = 0, B = 1, L = 2, R = 3 and T = 4. It would be confusing for the user to have the numbers in the file
				//so the following code sees which command the CommandArray is talking about and writes to file with strings 
				//showing which command it was
				if (CommandArray.get(0) == 0){
					bw.newLine();
					bw.write("Forward : [ "); 
		
				}
				else if (CommandArray.get(0) == 1){
					bw.newLine();
					bw.write("Backward : [ ");
					
				}
				else if (CommandArray.get(0) ==2){
					bw.newLine();
					bw.write("Left : [ ");
					
				}
				else if (CommandArray.get(0) == 3){
					bw.newLine();
					bw.write("Right : [ ");
					
				}
				else if (CommandArray.get(0) == 4){
					bw.newLine();
					bw.write("Trace : [ Movements retraced = ");
					bw.write(CommandArray.get(1) + " ] ");
					
					
				}
				if (CommandArray.get(0) != 4){ //if not equal to 4 as the speed and time does not apply to the trace command
					bw.write("Speed =  " + CommandArray.get(1));
					bw.write(" & Time =  " + CommandArray.get(2));
					bw.write(" ]");
				}
				
				
			}
			bw.close();
			fw.close();
	    }
	    else if (correct == false) {
	    	Write(PrevCT); //if the file name was not correct then the method is called again so the user enters a new file name
	    }
	    
		
	}
	
	
	public static ArrayList<Integer> Trace(ArrayList PrevC) {
		//this method asks the user how many movements they would like to retrace and makes sure its a valid value
		
		ArrayList<Integer> CommandArray = new ArrayList<Integer>();
		
		
		int ArraySize = PrevC.size(); //it uses the array that doesnt include T
		
		if (ArraySize == 0){
			consoleUI.ERRORMessage("Trace command cannot be called as no previous movements have been made");
			CommandArray = null;
		}
		else{
			consoleUI.TraceMessage();
			
			int Moves = sc.nextInt();
			
			
			while (Moves > ArraySize || Moves < 1) //the moves to be retraced needs to be >= 1 or <= the size of the array
			{
				
				String Message = ("Your number of Movements to retrace needs to be 1-" + ArraySize);
				consoleUI.ERRORMessage(Message);
				consoleUI.TraceMessage();
				Moves = sc.nextInt();
			}
			
			
			CommandArray.add(4); //this adds the Command with the amount of moves retraced to the array which is then returned 
			CommandArray.add(Moves);//to be stored in the PrevCT ArrayList in main
			
			int N = 1;
			while (N <= Moves) //if N > Moves then all moves have been retraced that the user has entered
				//this iterates through the array to run the Previous Commands 
			{
				RunPreviousC(PrevC, ArraySize, N);
				N = N + 1; //after it has run a command it adds one to the counter 
				
			}
		}
		
		
		return CommandArray;
	}
	
	public static void RunPreviousC(ArrayList PrevC, int ArraySize, int N) {
		//this method runs the next command to be retraced
		int index = (ArraySize - N); //this works backwards to if the Moves entered to retrace is 3 and N initially equal to 1
		//the first index would be the size (e.g. 5) minus N so the first command to be retraced would be index 4, then 3, then 2
		//now N is is 4 it is bigger than Moves so RunPreviousC (this method) is not ran again.
		
		ArrayList<Integer> CommandArray = (ArrayList<Integer>) (PrevC.get(index));
		//declares a CommandArray for the current index of the main ArrayList
		
		//when the command is stored to the CommandArray it is stored in the order , Command, Speed and Time 
		//this tells us which index is equal to what variable
		int Command = (CommandArray.get(0)); 
		int Speed = (CommandArray.get(1));
		int Time = (CommandArray.get(2));
		
		
		Time = Time * 1000;  
		
		if (Command == 0) //for each command it prints the speed and time being used 
		{
			consoleUI.MovingMessage("Forward", Speed, (Time/1000)); //to divide the time by 1000 so its readable for the user
			finchMove.MoveStraight(Time, Speed, myFinch);
		}
		else if (Command == 1)
		{
			
			consoleUI.MovingMessage("Backward", Speed, (Time/1000));
			Speed = Speed * -1;
			
			finchMove.MoveStraight(Time, Speed, myFinch);
		}
		else if (Command == 2)
		{
			consoleUI.MovingMessage("Left", Speed, (Time/1000));
			 
			
			int turnTime = finchMove.Left(myFinch);//returns how long the finch took to turn 
			Time = (Time - turnTime); //the time minus the time took to turn 
			finchMove.MoveStraight(Time, Speed, myFinch);
		}
		else if (Command == 3)
		{
			consoleUI.MovingMessage("Right", Speed, (Time/1000));
			 
			
			int turnTime = finchMove.Right(myFinch);//returns how long the finch took to turn
			Time = (Time - turnTime);
			finchMove.MoveStraight(Time, Speed, myFinch);
		}

	}
	
	public static ArrayList<Integer> Random() {
		//this method is one of my additional functions 
		// this produces a random command out of all the available values that the user could have entered
		ArrayList<Integer> CommandArray = new ArrayList<Integer>();
		//this command produced is still added to the main arrays
		
		Random rand = new Random();
		int Command = rand.nextInt(4); //randomises a number from 0-4
		int Speed = rand.nextInt(201); //randomises a number from 1-200
		int Time = rand.nextInt(7); // randomises a number from 1-6
		
		System.out.println("Making Random Movement");
		if (Command == 0)
		{
			CommandArray = WritetoArray(Time, Speed, 0); //this writes to the CommandArray about the command randomised
			//So this can be used for the trace and write commands.
			Forward(Time, Speed);
		}
		else if (Command == 1)
		{
			
			CommandArray = WritetoArray(Time, Speed, 1);
			Backward(Time, Speed);
		}
		else if (Command == 2)
		{
			
			CommandArray = WritetoArray(Time, Speed, 2);
			Left(Time, Speed);
		}
		else if (Command == 3)
		{
			
			CommandArray = WritetoArray(Time, Speed, 3);
			Right(Time, Speed);
		}
		
		return CommandArray;
	}
	
	public static void Quit() throws IOException {
		//this command quits the program 
			consoleUI.QuitMessage();
			//this produces a message to tell the user the program is quiting 
			
			return;
			
			
		
	}


}
