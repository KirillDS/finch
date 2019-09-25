package CodeI1;

// import "Finch"
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
// import "Color" used to colour the Finch's beak 
import java.awt.Color;
// import "Random" to randomise numbers 
import java.util.Random;
// import "Scanner" to take in input 
import java.util.Scanner;

// create class "Curious_Finch"
public class Curious_Finch {

	// this is the mode that it ran
	static String Mode = "Curious Finch";
	// this is the start time of this execution - this will be used to calculate
	// the overall execution time in the end
	static long StartTime = System.currentTimeMillis();
	// this will keep track of the number of encountered objects
	static int EncounteredObject = 0;
	// this will start the five seconds when there is no obstacle present
	static long NoObjectStart;
	// this will ask whether they want to see the log
	static String Log;
	// this is a flag to make sure the user enters the correct option
	static boolean correctInput = false;

	
	// pass myFinch object from the main
	public void run(Finch MyFinch) {
		// while the Finch is not on its tail the program will run (in the main)
		System.out.println(
				Mode + " mode chosen." + "\n" + "To terminate, lift the Finch and put it on its tail at any time.");
		// "!" - logical negation (while the Finch's beak is not up)
		// this while loop will check the position of the beak regularly
		while (!MyFinch.isBeakUp()) {

			// if it encounters an object it will call the EncounterObject()
			// method
			// when the object moves the Follow() method from the
			// EncounterObject() method will be called which will follow the
			// object
			if (MyFinch.isBeakUp() == false) {
				if (EncounterObjectC(MyFinch) == true) {
					EncounterObjectC(MyFinch);
				}
				// when there is no object present it will call the
				// WanderRandom() method
				else {
					WanderRandom(MyFinch);
				}

			}
			// if within the while loop the Beak is up the while loop will break
			// this has to be in a separate if statement as it wont be called
			// otherwise
			if (MyFinch.isBeakUp() == true) {
				MyFinch.setWheelVelocities(0, 0);
				break;
			}

		}

		// calculate the total execution time and stop the finch from moving
		// when beak is up
		long ExecutionTime = System.currentTimeMillis() - StartTime;
		MyFinch.setWheelVelocities(0, 0);
		Scanner reader = new Scanner(System.in);
		correctInput = false;
		// set correctInput as false until the user inputs "y" or "n"
		while (correctInput == false) {
			// as the Finch's beak is up the user will be asked whether they
			// want to see the log
			System.out.println("You have terminated the program." + "\n" + "Do you want to see the log? (y/n)");
			// Scans the next token of the input as an
			// String to see whether the user wants to see the log 
			Log = reader.nextLine();
			if (Log.equalsIgnoreCase("y")) {
				// set correctInput as true
				correctInput = true;
				// if input is "y" print log of execution
				System.out.println("*************************************");
				System.out.println("**         Log of Execution        **");
				System.out.println("*************************************");
				System.out.println("Mode:" + " " + Mode);
				System.out.println("Number of encountered Objects:" + " " + EncounteredObject);
				System.out.println("Total execution Time:" + " " + ExecutionTime + " " + "milliseconds" + "\n");
			} else if (Log.equalsIgnoreCase("n")) {
				// set correctInput as true
				// this will exit the while loop and the whole method
				correctInput = true;
			}
		}
	}

	// this is the EncounterObject method
	// it returns true if an object is present and false if there is no object
	// present
	public static boolean EncounterObjectC(Finch MyFinch) {
		// set isObstaclePresent variable to false and return it
		boolean isObstaclePresent = false;
		// if an obstacle is present set isObstaclePresent variable to true and
		// return it
		if (MyFinch.isObstacle() == true) {
			isObstaclePresent = true;
		}
		return isObstaclePresent;
	}

	// this is the WanderRandom method
	public static void WanderRandom(Finch MyFinch) {
		// initialise random number generator
		Random rand = new Random();
		// as long as there are no objects present wander random
		if (EncounterObjectC(MyFinch) == false) {
			// Formula used: random.nextInt(max + 1 - min) + min
			// this will generate two random numbers between 255 and 5 and set
			// the two numbers to the left and right wheel
			// this will be called each time the WanderRandom is called, and
			// generate two different numbers each time
			// i decided to choose 5 as my minimum number as zero would mean
			// that the wheels would stop moving
			int RandomSpeedLeft = rand.nextInt(251)  + 5;
			int RandomSpeedRight = rand.nextInt(251) + 5;
			MyFinch.setLED(Color.GREEN);
			MyFinch.setWheelVelocities(RandomSpeedLeft, RandomSpeedRight);
			// start the 5 seconds timer when there are no objects present
			NoObjectStart = System.currentTimeMillis();
			// initialise finalTime to 0
			long finalTime = 0;
			// while finalTime is less than 5000
			while (finalTime <= 5000) {
				if (EncounterObjectC(MyFinch) == true) {
					// when an object is encountered turn LED red and stop
					MyFinch.setLED(Color.RED);
					MyFinch.setWheelVelocities(0, 0, 1000);
					EncounteredObject++;
					// after encountering the object call the Follow() method
					// which will follow the object
					Follow(MyFinch);
					// after following the object, break from the loop to
					// restart the 5 seconds timer again
					break;

				} else {
					// this checks each time whether the finch is on its tail
					// if it is it will break out of this while loop and go the
					// the if statement in the main
					// there if the finch is still on its tail it will break out
					// of the while loop and ask the user whether they want to
					// see
					// the log
					if (MyFinch.isBeakUp() == true) {
						break;
					} else {
						// if the finch is not on its tail this calcuation will
						// be done each time until finalTime is greater than
						// 5000 (5 seconds)
						finalTime = System.currentTimeMillis() - NoObjectStart;
					}
				}
			}
			// after the 5 seconds it will break out of the while loop
			// automatically
			// then it will check whether EncounterObject() returned true and if
			// it did it will start the 5 seconds timer again and move in a
			// different random direction again
			MyFinch.setWheelVelocities(0, 0, 1000);
			NoObjectStart = System.currentTimeMillis() - finalTime;
		}
	}

	public static void TurnLeft(Finch MyFinch) {
		// this is the TurnLeft() method
		// after some trial and error and found out that 10000 Hz would be an
		// appropriate frequency and the wheel velocity of 50 for the left wheel
		// and 150 for the right wheel will give me a smooth curve turning left
		MyFinch.buzz(10000, 0);
		MyFinch.setLED(Color.GREEN);
		MyFinch.setWheelVelocities(50, 150);
	}

	public static void TurnRight(Finch MyFinch) {
		// this is the TurnRight() method
		// after some trial and error I and found out that 10000 Hz would be an
		// appropriate frequency and the wheel velocity of 50 for the right
		// wheel
		// and 150 for the left wheel will give me a smooth curve turning right
		MyFinch.buzz(10000, 0);
		MyFinch.setLED(Color.GREEN);
		MyFinch.setWheelVelocities(150, 50);
	}

	public static void Follow(Finch MyFinch) {

		// this is the Follow() method
		while (EncounterObjectC(MyFinch) == true) {
			// if the object is present on the left it will turn left
			if (MyFinch.isObstacleRightSide() == false && MyFinch.isObstacleLeftSide() == true) {
				TurnLeft(MyFinch);
				// if the object is present on the right it will turn right
			} else if (MyFinch.isObstacleRightSide() == true && MyFinch.isObstacleLeftSide() == false) {
				TurnRight(MyFinch);
			}
			// this checks whether the finch's beak is up regularly
			if (MyFinch.isBeakUp() == true) {
				break;
			}
		}
	}
}
