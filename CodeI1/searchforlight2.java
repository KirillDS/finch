
package CodeI1;

/* This is the list of libraries that I have 
* imported into my program in order to get 
* the functions and or features to operate. 
* Also in the 'Referenced Libraries' section 
* you will see that I imported the 'finch.jar' 
* library in order to actually access the functions 
* and features of the Finch API. */
import java.awt.Color;
import java.io.IOException;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/* This is the class for my program, 
* the class is responsible for holding all 
* of the methods and variables that make up the program. */
/* Also a quick disclaimer, writing anything other 
* than the required user input will not result in 
* anything and might crash the system! */
public class searchforlight2 {

	static boolean exit = false;

	/*
	 * This is the static variable for the Finch, this variable can be called
	 * throughout the class and its' methods and it is linked to the Finch.
	 */
	static Finch myf = new Finch();

	/*
	 * This is the static array list that I created; this array list in
	 * responsible for storing the values of the both the Left Light Sensor and
	 * Right Light Sensor that can be accessed later.
	 */
	static ArrayList<Integer> statArray = new ArrayList<Integer>();

	/*
	 * This is the static variable that represents the limit of which the Finch
	 * robot will have to reach in terms of light in order to get a reaction
	 * from a function, this 'limit' was renamed as 'threshold'.
	 */
	static int threshold = 130;

	/*
	 * This 'maxthreshold' variable is responsible for holding the value that
	 * will make the Finch's nose turn 'brighter' when the light source is
	 * increased in terms of light sensor value. The 'maxcounter' is responsible
	 * for incrementing the timer for the amount that the light sensors found a
	 * light source greater than the threshold.
	 */
	static int maxthreshold = 180;
	static int maxcounter = 0;

	/*
	 * This is the static variable that is linked to the first position in the
	 * array list which is of course a '0', this will return the value of that
	 * position which happens to hold the value for the first recorded value of
	 * the left light sensor.
	 */
	static int startLightLeft() {
		return statArray.get(0);
	}

	/*
	 * This is the static variable that is linked to the second position in the
	 * array list which is of course a '1', this will return the value of that
	 * position which happens to hold the value for the first recorded value of
	 * the right light sensor.
	 */
	static int startLightRight() {
		return statArray.get(1);
	}

	/*
	 * This is the static variable that is linked to the array list mentioned
	 * above, the task of this variable is to display the max value recorded
	 * from that array list which starts from the beginning of the program and
	 * ends at the end of the program or when the user inputs 'yes' to see the
	 * statistic report.
	 */
	static int maxLight() {
		return Collections.max(statArray);
	}

	/*
	 * This is the static variable that is linked to the array list mentioned
	 * above, the task of this variable is to display the minimum value recored
	 * from that array list which starts from the beginning of the program and
	 * ends at the end of the program or when the user inputs 'yes' to see the
	 * statistic report.
	 */
	static int minLight() {
		return Collections.min(statArray);
	}

	/*
	 * This static variable is responsible for representing the whole run time
	 * of the program, starting from when the program is active to the point of
	 * which the user inputs 'yes' or 'no' to see the statistic report. This
	 * will be incrementing through out the entire run time of the program.
	 */
	static long runTime = 0;

	/*
	 * This static variable is responsible for holding the values of the amount
	 * of times that the Finch has detected a light source that is greater than
	 * the 'threshold', this will increment every time the 'foundLight' method
	 * is called.
	 */
	static int detectedAmount = 0;

	/*
	 * These two static integer variables are very important as they represent
	 * both the Left Light Sensor and the Right Light Sensor, code named as
	 * 'LSensor' and 'RSensor', these two variables are placed as a static
	 * integer variable because they are needed to be called in most if not all
	 * methods, and having them in the class and available to call in very
	 * beneficial; in terms of space management and changes (if necessary).
	 */
	static int LSensor = myf.getLeftLightSensor();
	static int RSensor = myf.getRightLightSensor();

	/*
	 * This is the main method for the program, this is the method that is first
	 * called when the program is active, this mention holds the 'runTime'
	 * variable that will start incrementing the time that can be later viewed,
	 * after the timer is active the 'startPosition' method is called. public
	 * static void main (String[] args) { runTime = System.currentTimeMillis();
	 * startPosition(); }
	 */

	/*
	 * This is the method that was created for the integration part of the task,
	 * this method will be called in the main menu part of the code that could
	 * call other methods.
	 */
	public static void searchforlight_Main() throws IOException {
		
		while (exit == false) {
			runTime = System.currentTimeMillis();
			startPosition();
		}
	}

	/*
	 * This is the 'startPosition' method, this method is responsible for
	 * checking if the Finch is level before the program continues any further,
	 * the first validation will call the 'startWandering' if and only if the
	 * Finch is level, if the Finch is not level; then the second 'while loop'
	 * will be activated and the user will be informed about the necessary
	 * actions that they will need to take in order to continue.
	 */
	public static void startPosition() throws IOException {
		while ((myf.isFinchLevel()) && (exit == false)) {
			
			startWandering();
		}
		while ((myf.isFinchLevel() == false) && (exit == false)) {
			
			System.out.println("Finch must be Level!" + "\n");
			myf.saySomething("finch must be level!", 2000);
			if ((myf.isFinchLevel() == true)) {
				startWandering();
			}
		}
	}

	/*
	 * This is the 'startWandering' method, this is the method that can be
	 * called in different ways throughout the program, however the main purpose
	 * of this method is to make the Finch start looking/wandering 'mindlessly'
	 * until a light source is found, during the time that the Finch wanders and
	 * fails to locate a light source, a timer will be incrementing in the
	 * background and when that timer reaches 5 seconds, the Finch will need to
	 * stop and turn around, reset the timer and continue wandering, if a light
	 * source is found during the wandering stage (when the threshold is reached
	 * or it is higher), then the light will call the 'foundLight' method, also
	 * this method checks constantly for the position of the Finch and will end
	 * if it is not level. There is also a function that checks if upon making
	 * the Finch 'level', if the light source is greater than the threshold, if
	 * so then the program will immediately get the 'foundLight' method. LSensor
	 * is stored in the 0th position in the array list RSensor is stored in the
	 * 1st position in the array list.
	 */
	public static void startWandering() throws IOException {
		int timer = 0;
		statArray.add(LSensor);
		statArray.add(RSensor);
		
			while (((LSensor & RSensor) <= 129) && (exit == false)) {
				
				while (!(myf.isBeakUp())) {
					
					myf.setLED(Color.GREEN);
					myf.setWheelVelocities(60, 60, 1000);
					++timer;
					if (timer == 5) {
						myf.sleep(1000);
						myf.setWheelVelocities(95, -30, 3000);
						timer = 0;
					}
					LSensor = myf.getLeftLightSensor();
					RSensor = myf.getRightLightSensor();
					if ((LSensor | RSensor) > threshold) {
						myf.saySomething("Light Detected");
						foundLight();
						
					}
				}
				myf.stopWheels();
				endToStatistic();
				
				
			}
			while (((LSensor & RSensor) > 130) && (exit == false)) {
				
				foundLight();
			}
		
		
	}

	/*
	 * This method is called 'foundLight' because this method will follow the
	 * light source when the threshold is reached, this method will also
	 * increment the 'detectedAmount' whenever this mention is called; this can
	 * be viewed later in the statistic report. The 'while loop'(s) will
	 * constantly first check if the light source meets the required threshold,
	 * then the position of the Finch is tested; if it is not level, the program
	 * will end and the option to see the statistic report will be available,
	 * however if the light source is above the threshold and the position is
	 * 'level', then the Finch will continuously follow the light source,
	 * however if the light source is 'lost' or goes below the threshold, then
	 * the 'lostLight' method will be called. There is a 'if statement' that
	 * checks if the sensors detect a light source that is 'too great', if that
	 * is the case, then the light on the finch's nose will turn into a
	 * 'brighter' version of the colour, but the original code for Finch to
	 * follow the direction of the light source is always called after the
	 * correct level of brightness is displayed. As you can see at the start of
	 * this method, the 'detectedAmount' variable is called and is incremented,
	 * this means that whenever this method is called, only then will the
	 * variable be incremented by one.
	 */
	public static void foundLight() throws IOException {
		detectedAmount++;
		while ((LSensor > threshold) || (RSensor > threshold)) {
			
			while (!(myf.isBeakUp())) {
				
				statArray.add(LSensor);
				statArray.add(RSensor);
				if ((LSensor | RSensor) <= 129) {
					myf.stopWheels();
					lostLight();
				} else if (LSensor > RSensor) {
					if (LSensor >= maxthreshold) {
						maxcounter++;
						myf.setLED(Color.PINK);
					} else {
						myf.setLED(Color.RED);
					}
					myf.setWheelVelocities(0, 100);
					myf.buzz(400, 0);
				} else if (RSensor > LSensor) {
					if (RSensor >= maxthreshold) {
						maxcounter++;
						myf.setLED(Color.PINK);
					} else {
						myf.setLED(Color.RED);
					}
					myf.setWheelVelocities(100, 0);
					myf.buzz(400, 0);
				} else if (LSensor == RSensor) {
					if ((LSensor & RSensor) >= maxthreshold) {
						maxcounter++;
						myf.setLED(Color.PINK);
					} else {
						myf.setLED(Color.RED);
					}
					myf.setWheelVelocities(100, 100);
					myf.buzz(800, 0);
				}

				LSensor = myf.getLeftLightSensor();
				RSensor = myf.getRightLightSensor();
			}
			myf.stopWheels();
			endToStatistic();
		}
	}

	/*
	 * This is the 'lostLight' method, this method is responsible for many
	 * functions as well as calling different methods, firstly when the Finch
	 * loses its' light source, it will start a timer that will increment for 5
	 * seconds, if the light is found during that time, then the Finch will call
	 * the 'foundLight' and follow the light, if the timer is up and there is no
	 * light source, then the Finch will alert the user and then turn in a
	 * different direction before giving the user the option to 'end the
	 * program'; 'yes' will then give the user the option to view the statistic
	 * report, 'no' will call the 'startWandering' method, all values recorded
	 * in the array list will remain, and continue to add on. The 'yes' or 'no'
	 * user input can be written in not case-sensitive. if the Finch's position
	 * is changed whilst the timer is active, then the 'endToStatistic' method
	 * will be called.
	 */
	public static void lostLight() throws IOException {
		int timer = 0;
		while (!(myf.isBeakUp())) {
			
			while ((LSensor | RSensor) <= 129) {
				
				++timer;
				if ((LSensor | RSensor) > threshold) {
					foundLight();
				}
				LSensor = myf.getLeftLightSensor();
				RSensor = myf.getRightLightSensor();
				if (timer == 5) {
					myf.saySomething("The Light has been Lost", 3000);
					myf.setWheelVelocities(100, 0, 3000);
					myf.saySomething("Look at the Graphical Interface for more details");
					String programtoEnd = JOptionPane
							.showInputDialog("Do you want the Program to End?\n(Answer only using 'yes' or 'no')");
					if (programtoEnd.equalsIgnoreCase("yes")) {
						
						endToStatistic();
					} else if (programtoEnd.equalsIgnoreCase("no")) {
						startWandering();
					}
				}
			}
		}
		//endToStatistic();
	}

	/*
	 * This is the final method in the program; 'endToStatistic' will be called
	 * when the user changes the position of the Finch or when they choose to
	 * end the program, this method's job isn't necessarily call another
	 * methods, it mostly returns the values of recorded data. There is a
	 * question regarding the option to view a report, this report will display
	 * a list of different functions and features that were recorded during the
	 * entire run time of the program until the moment that they choose to view
	 * the report, when answered if they want to see the Finch's report; 'yes'
	 * will display the entire report, then the user will need to type either
	 * 'yes' or 'no' after they click on the 'OK' button then is displayed at
	 * the bottom of the report, their answer will be based for the question
	 * 'restart the program?'; this function has two outcomes, 'yes' will result
	 * in the program starting from the beginning, whilst answering 'no' will
	 * end the program completely. All answer ('yes' and 'no') are not
	 * case-sensitive.
	 */
	public static void endToStatistic() throws IOException {
		myf.saySomething("Do you want to see the Finch's Report?", 3000);
		String programshowReport = JOptionPane
				.showInputDialog("Do you want to see the Finch's Report?\n(Answer only using 'yes' or 'no')");
		if (programshowReport.equalsIgnoreCase("yes")) {
			runTime = System.currentTimeMillis() - runTime;
			myf.saySomething("Press 'OK' to Close the Report", 5000);
			String allInformation = "------------------------------------------------------"
					+ "\nStarting Left Sensor Value: " + startLightLeft() + "\nStarting Right Sensor Value: "
					+ startLightRight() + "\nHighest Recorded Sensor Value: " + maxLight()
					+ "\nLowest Recorded Sensor Value: " + minLight() + "\nProgram Duration: " + runTime / 1000
					+ " Seconds" + "\nLight was Detected: " + detectedAmount + " time(s)"
					+ "\nLight was too Bright for: " + maxcounter / 10 + " Second(s)"
					+ "\n------------------------------------------------------"
					+ "\nClick on 'OK' to Close the Report";
			JOptionPane.showMessageDialog(null, allInformation);
		} else if (programshowReport.equalsIgnoreCase("no")) {

		}
		myf.saySomething("Would you like to restart the Program?");
		String repeatProgram = JOptionPane.showInputDialog("Restart the Program?\n(Answer 'yes' or 'no)");
		if (repeatProgram.equalsIgnoreCase("yes")) {
			searchforlight_Main();
		} else if (repeatProgram.equalsIgnoreCase("no")) {
			
			exit = true;
		}

	}
}
