package CodeI1;

import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Scaredy_Finch {

	// this is the mode that it ran
	static String Mode = "Scaredy Finch";
	// this is the start time of this execution - this will be used to calculate
	// the overall execution time in the end
	static long StartTime = System.currentTimeMillis();
	// this will keep track of the number of encountered objects
	static int EncounteredObject = 0;
	// this will start the five seconds when there is no obstacle present
	static long NoObjectStart;
	// this will ask whether they want to see it
	static String Log;
	// this is a flag to make sure the user enters the correct option
	static boolean correctInput = false;

	
	public void run(Finch MyFinch) {
		System.out.println(
				Mode + " mode chosen." + "\n" + "To terminate, lift the Finch and put it on its tail at any time.");
		// this while loop will check the position of the beak regularly
		while (!MyFinch.isBeakUp()) {

			// if it encounters an object it will call the EncounterObject
			// method
			// when the object moves the WanderBackwards method will be called which will
			// run away from the object
			if (MyFinch.isBeakUp() == false) {
				if (EncounterObjectS(MyFinch) == true) {
					EncounterObjectS(MyFinch);
				}
				// when there is no object present it will call the wander
				// random method
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

		// when the Finch's beak is up the user will be asked whether they want
		// to see the log
		long ExecutionTime = System.currentTimeMillis() - StartTime;
		MyFinch.setWheelVelocities(0, 0);
		Scanner reader = new Scanner(System.in);
		correctInput = false;
		while (correctInput == false) {

			System.out.println("You have terminated the program." + "\n" + "Do you want to see the log? (y/n)");
			// Scans the next token of the input as an
			// String to see whether the user wants to see the log
			Log = reader.nextLine();
			if (Log.equalsIgnoreCase("y")) {
				System.out.println("***************************************");
				System.out.println("           Log of Execution            ");
				System.out.println("***************************************");
				System.out.println("Mode:" + " " + Mode);
				System.out.println("Number of encountered Objects:" + " " + EncounteredObject);
				System.out.println("Total execution Time:" + " " + ExecutionTime + " " + "milliseconds" + "\n");
				correctInput = true;
			} else if (Log.equalsIgnoreCase("n")) {
				correctInput = true;

			}

		}

	}

	// this is the EncounterObject method
	// it returns true if an object is present and false if there is no object
	// present
	// additionally to the Curious Finch method, it will also buzz which is one the requirements 
	public static boolean EncounterObjectS(Finch MyFinch) {
		boolean isObstaclePresent = false;

		if (MyFinch.isObstacle() == true) {

	
			MyFinch.buzz(10000, 1000);
			isObstaclePresent = true;
		}

		return isObstaclePresent;

	}

	// this is the WanderRandom method
	public static void WanderRandom(Finch MyFinch) {
		Random rand = new Random();
		if (EncounterObjectS(MyFinch) == false) {
			// randomly generates two numbers for the wheels 
			int RandomSpeedLeft = rand.nextInt(251)  + 5;
			int RandomSpeedRight = rand.nextInt(251) + 5;
			MyFinch.setLED(Color.GREEN);
			MyFinch.setWheelVelocities(RandomSpeedLeft, RandomSpeedRight);
			// start the 5 seconds 
			NoObjectStart = System.currentTimeMillis();
			long finalTime = 0;
			while (finalTime <= 5000) {
				if (EncounterObjectS(MyFinch) == true) {
					EncounteredObject ++;
					WanderBackwards(MyFinch);
					break;
				} else {
					// check whether the Finch's beak is up
					if (MyFinch.isBeakUp() == true) {
						break;
					} else {
						// checks whether finalTime is greater than 5000 
						finalTime = System.currentTimeMillis() - NoObjectStart;
					}

				}

			}
			
			MyFinch.setWheelVelocities(0, 0, 1000);
			// reset NoObjectStart 
			NoObjectStart = System.currentTimeMillis() - finalTime;
		}

	}

	// this method allows the Finch to run away randomly when the it encounters an object  
	public static void WanderBackwards(Finch MyFinch) {
		if (EncounterObjectS(MyFinch) == true) {
			
			Random rand = new Random();
			MyFinch.setLED(Color.RED);
			int LeftWheelback = rand.nextInt(256) - 255;
			int RightWheelback = rand.nextInt(256) - 255;
			// random.nextInt(max + 1 - min) + min
			MyFinch.setWheelVelocities(LeftWheelback, RightWheelback, 2000);

		}
		

		}
	}

