package CodeI1;

import java.util.Scanner;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

// this is the "Main_Class"
public class Main_Class {

	// this allows the user to choose a mode
	static String choice;
	// these are flags used for user input and the position of the Finch
	static boolean correctOption = false;
	static boolean CorrectRestart = false;
	static boolean Terminate = false;
	static boolean correctInput = false;
	// create a Finch object and pass is as a parameter
	static Finch MyFinch = new Finch();
	static boolean Exit = false;

	public static void main() {

		// this will introduce the user what the task is about
		System.out.println("Welcome to Task 5: Detect Object" + "\n"
				+ "This task is about the Finch following an object in three different ways depending on the chosen mode"
				+ "\n" + "When you place the Finch level on a flat surface, the program will start." + "\n"
				+ "If you would like to terminate the program, place the Finch on its tail at any time.");

		while (Exit == false) {
			// if Finch is level go to StartGame() method
			if (MyFinch.isFinchLevel() == true) {
				Game(MyFinch);
			}
			// check if beak is up, if it is go to Restart() method
			if (MyFinch.isBeakUp() == true) {
				Restart(MyFinch);
			}
		}

	}

	// this is the Game() method
	// this will allow the user to choose a mode
	public static void Game(Finch MyFinch) {
		// scanner class - allows to take an input
		Scanner reader = new Scanner(System.in);
		// error handling - while variable correctOption is false ask the user
		// to choose a mode
		while (correctOption == false) {
			System.out.println("Please type" + ""
					+ " ‘c’ for ‘Curious Finch’ mode, ‘s’ for ‘Scaredy Finch’ mode and ‘p’ for ‘Puzzled Finch’ mode to explore the different modes.");

			if (reader.hasNextLine()) {
				choice = reader.nextLine();
			} // Scans the next token of the input as a String
			else {
				choice = "";
			}
			// if choice is "c" create an object called "curious" and call the
			// Curious_Finch() class
			if (choice.equalsIgnoreCase("c")) {
				Curious_Finch curious = new Curious_Finch();
				curious.run(MyFinch);
				// set correctOption to true so that the while loop breaks
				correctOption = true;
				// after the class terminates, call the Restart() method
				Restart(MyFinch);
				// if choice is "p" create an object called "puzzled" and call
				// the Puzzled_Finch() class
			} else if (choice.equalsIgnoreCase("p")) {
				Puzzled_Finch puzzled = new Puzzled_Finch();
				puzzled.run(MyFinch);
				// set correctOption to true so that the while loop breaks
				correctOption = true;
				// after the class terminates, call the Restart() method
				Restart(MyFinch);
				// if choice is "s" create an object called "scaredy" and call
				// the Scaredy_Finch() class
			} else if (choice.equalsIgnoreCase("s")) {
				Scaredy_Finch scaredy = new Scaredy_Finch();
				scaredy.run(MyFinch);
				// set correctOption to true so that the while loop breaks
				correctOption = true;
				// after the class terminates, call the Restart() method
				Restart(MyFinch);
			}
		}
		// close the reader
		reader.close();
	}

	// this is the Restart() method
	// it will be called after the class of the chosen mode is ran
	public static void Restart(Finch MyFinch) {
		System.out.println("To restart, place the Finch back on a flat surface." + "\n"
				+ "To stop this program, place the Finch on its back.");
		// while Terminate is false check whether the Finch's beak is up or
		// upside down
		while ((Terminate == false) || (Exit == false)) {
			// if Finch is placed level, go to the Game() method
			if (MyFinch.isFinchLevel() == true) {
				// but before the Game() method, set correctOption() to false so
				// that it will enter the while loop
				correctOption = false;
				Game(MyFinch);
				// break the while loop
				break;

			}
			// if the Finch is placed upside down, terminate the program
			if (MyFinch.isFinchUpsideDown() == true) {
				System.out.println("Terminate...");
				Terminate = true;
				Exit = true;
			}

		}

	}

}
