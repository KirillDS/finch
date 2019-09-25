package CodeI1;



public class ConsoleUI2 {
//this class holds all the methods that prints something that the user sees in the console
	public static void main(String[] args) {
		

	}
	
	void WelcomeMessage(){
		//this method 
		System.out.println("");
	    System.out.println("------------------------Welcome to Navigate---------------------");
	    System.out.println(" Please place your finch on the floor where it has space to move");
	    System.out.println(" Making sure that you hold the wire above the finch as it moves !");
	   
	}
	void CommandMenu(){
		//this method outputs all the valid commands that user can choose from
		System.out.println("");
		System.out.println("****************************");
	    System.out.println("*    F - Forward           *");
	    System.out.println("*    B - Backward          *");
	    System.out.println("*    L - Left              *");
	    System.out.println("*    R - Right             *");
	    System.out.println("*    T - Trace             *");
	    System.out.println("*    W - Write             *");
	    System.out.println("*    X - Random Movement   *");
	    System.out.println("*    Q - Quit              *");
	    System.out.println("****************************");
	    System.out.println("Please enter a command");
	}
	void ERRORMessage(String Message){
		//this method prints out an error with the given message 
		//this is so it can be used for any error
		System.out.println("");
		System.out.println("***************************************************************************************************");
		System.out.println("ERROR - " + Message);
		System.out.println("***************************************************************************************************");
		System.out.println("");
	}
	void MovingMessage(String Command, int Speed, int Time){
		//this method prints out the message that tells the user how the finch is moving 
		//what command it is using 
		//with what speed and time
		System.out.println("");
		System.out.println("Moving " + Command);
		System.out.println("With Speed " + Speed);
		System.out.println("And Time " + Time);
		System.out.println("");
	}
	void RangeMessage(int min, int max, String data){
		//this method tells the user the range that a valid input is in 
		//data variable is either speed or time 
		//then the min and max is the range
		
		System.out.println("Please enter a " + data + " between " + min + " and " + max );
		
	}
	void TraceMessage(){
		//this method prints a message to ask how many movements the user wants to retrace
		System.out.println("Please enter how many movements you want to retrace");
		
	}
	void WriteMessage(String CurrentT, String fileName){
		//this method prints out that the Current time and commands have been written to the file 
		//with the name that the user gave
		System.out.println("");
		System.out.println(CurrentT + "\n Writing commands with current time to " + fileName +".txt");
		System.out.println("");
	}
	void QuitMessage(){
		//this method prints out a message so the user knows the program is closing
		System.out.println("");
		System.out.println("Quitting Program");
		System.out.println("");
	}
	void CorrectCommand(String Command, boolean File, String fileName){
		//this method prints whether it was the correct filename chosen or the correct command
		if (File == true){ //if file is true then it means its linked to the file
			System.out.println("Your file name will be " + fileName + " is that correct? true or false");
		}
		else{//if file is not true then its linked to the command 
			
			System.out.println("You chose the " + Command + " Command is this Correct? true or false");
			
		}
	}
	void GetFileNameText(){
		//this method prints a message to ask for the file name of the user's choice 
		System.out.println("");
		System.out.println("What would you like to name your file?");
		
	}
	

}


