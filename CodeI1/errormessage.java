package CodeI1;

import java.util.InputMismatchException;

import java.util.Scanner;

public class errormessage extends IntegrationMenu {

	// declaring and initialising variable
	int Time = 0;

	public void scanner() {

		// creating a scanner object
		Scanner user = new Scanner(System.in);
		{

			while (Time < 1 || Time > 20) {

				// error message

				try {
					System.out.println("Enter an integer between 1 to 20 for the tilt to be recorded: ");

					Time = user.nextInt();
				} catch (InputMismatchException ex) {

					// System.out.println(ex);

					user.next();
					{
						// end of error message
						System.out.println("user entered: " + Time);
					}
				}
			}
		}
	}
}
