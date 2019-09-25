package CodeI1;
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Puzzled_Finch {

	// this is the mode that it is running
	static String Mode = "Puzzled Finch";
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
	// this is the flag I used for the Finch to move forward and backwards
	static boolean Movement = true;

	public void run(Finch MyFinch) {

		System.out.println(
				Mode + " mode chosen." + "\n" + "To terminate, lift the Finch and put it on its tail at any time.");
		// this while loop will check the position of the beak regularly
		while (!MyFinch.isBeakUp()) {

			if (MyFinch.isBeakUp() == false) {
				if (EncounterObjectP(MyFinch) == true) {
					EncounterObjectP(MyFinch);
				}

				else {
					WanderPuzzled(MyFinch);
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

		long ExecutionTime = System.currentTimeMillis() - StartTime;
		MyFinch.setWheelVelocities(0, 0);
		Scanner reader = new Scanner(System.in);
		correctInput = false;
		while (correctInput == false) {
			System.out.println("You have terminated the program." + "\n" + "Do you want to see the log? (y/n)");
			Log = reader.nextLine();// Scans the next token of the input as an
									// String
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

	// this is the encounterObject puzzled method
	public static boolean EncounterObjectP(Finch MyFinch) {
		boolean isObstaclePresent = false;

		if (MyFinch.isObstacle() == true) {
			MyFinch.buzz(10000, 1000);
			EncounteredObject = EncounteredObject + 1;
			isObstaclePresent = true;
		}

		return isObstaclePresent;
	}

	public static void WanderPuzzled(Finch MyFinch) {
		{
			Random rand = new Random();
			if (EncounterObjectP(MyFinch) == false) {
				// random.nextInt(max + 1 - min) + min
				int RandomSpeedLeft = rand.nextInt(256) - 0;
				int RandomSpeedRight = rand.nextInt(256) - 0;
				int LeftWheelback = rand.nextInt(256) - 255;
				int RightWheelback = rand.nextInt(256) - 255;

				// creates array called LEDColours and stores 6 colours
				String[] LEDColours;
				LEDColours = new String[] { "BLUE", "GREEN", "ORANGE", "PINK", "RED", "YELLOW" };
				// generates a random colour from the array using its array length 
				int rnd = new Random().nextInt(LEDColours.length);

				String Colour = LEDColours[rnd];

				// depending on the colour from the array the Finch's beak will
				// light up
				switch (Colour) {
				case "BLUE":
					MyFinch.setLED(Color.BLUE);
					break;
				case "GREEN":
					MyFinch.setLED(Color.GREEN);
					break;
				case "ORANGE":
					MyFinch.setLED(Color.ORANGE);
					break;
				case "PINK":
					MyFinch.setLED(Color.PINK);
					break;
				case "RED":
					MyFinch.setLED(Color.RED);
					break;
				case "YELLOW":
					MyFinch.setLED(Color.YELLOW);
					break;
				}

				// this flag will be used to alternate between moving forwards
				// and backwards every 5 seconds
				if (Movement == true) {
					MyFinch.setWheelVelocities(RandomSpeedLeft, RandomSpeedRight);
					Movement = false;
				} else {
					MyFinch.setWheelVelocities(LeftWheelback, RightWheelback);
					Movement = true;
				}

				// this will start the 5 seconds timer
				NoObjectStart = System.currentTimeMillis();
				long finalTime = 0;
				while (finalTime <= 5000) {
					if (EncounterObjectP(MyFinch) == true) {
						// this will generate 3 random colours to light up the
						// beak
						int RandomRED = rand.nextInt(256) - 0;
						int RandomGREEN = rand.nextInt(256) - 0;
						int RandomBLUE = rand.nextInt(256) - 0;
						MyFinch.setLED(RandomRED, RandomGREEN, RandomBLUE);
						MyFinch.setWheelVelocities(0, 0, 1000);
						Follow(MyFinch);
						break;
					} else {
						if (MyFinch.isBeakUp() == true) {
							break;
						} else {
							finalTime = System.currentTimeMillis() - NoObjectStart;
						}

					}

				}
				MyFinch.setWheelVelocities(0, 0, 1000);
				NoObjectStart = System.currentTimeMillis();

			}
		}
	}

	// this method will be called when there is an object on its right
	// as planned it will move the opposite direction
	public static void PuzzledLeft(Finch MyFinch) {

		MyFinch.buzz(10000, 0);
		MyFinch.setWheelVelocities(50, 150, 4000);

	}

	// this method will be called when there is an object on its left
	// as planned it will move the opposite direction
	public static void PuzzledRight(Finch MyFinch) {

		MyFinch.buzz(10000, 0);
		MyFinch.setWheelVelocities(150, 50, 4000);
	}

	// this method will call PuzzledLeft() and PuzzledRight() method accordingly
	public static void Follow(Finch MyFinch) {

		while (EncounterObjectP(MyFinch) == true) {
			if (MyFinch.isObstacleRightSide() == true && MyFinch.isObstacleLeftSide() == false)

			{
				PuzzledLeft(MyFinch);
			}

			else if (MyFinch.isObstacleRightSide() == false && MyFinch.isObstacleLeftSide() == true)

			{
				PuzzledRight(MyFinch);
			}

			if (MyFinch.isBeakUp() == true) {
				break;
			}

		}

	}
}
