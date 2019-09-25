package CodeI1;



	import java.util.Arrays;


	import edu.cmu.ri.createlab.terk.robot.finch.Finch;

	import java.util.Random;





public class maincodeoftilt extends IntegrationMenu {

		// declaring objects class
		
		
		  public static errormessage Outofrange = new errormessage();
		static Thread thread = new Thread();// check meaning
		public static void main ()throws InterruptedException {// check the meaning

			// creating array to hold data
			String[] Orientation1 = new String[5];

			// main method
			// creating object finch
			

			// new code to work on myfinch.setLED(255,0,0,1000);
			// testing first condition

			

			
			
		
			
		Outofrange.scanner();
		Finch myfinch = new Finch();
			 
			 
		System.out.println("recording started");
		myfinch.saySomething("recording started");
				//declaring variable
				
			myfinch.setLED(255,0,0);
			//declaring and initialising variable

				for (; Outofrange.Time<20; ++Outofrange.Time){
			
			
		
			

					
				
					//created if conditions to store string variable in array when user tilts flinch
				if (myfinch.isBeakUp()) {
				Orientation1[0] = Objects.Finchbeakup;

				System.out.println("tilted up");	
				}

			Thread.sleep(1000);
			//created if conditions to store string variable in array when user tilts flinch
				if (myfinch.isLeftWingDown()) {

					Orientation1[2] = Objects.Finchleftwing;
					System.out.println("left wing tilted");
				}

				//created if conditions to store string variable in array when user tilts flinch
				if (myfinch.isRightWingDown()) {

					Orientation1[3] = Objects.Finchrightwing;
					System.out.println("right wing tilted");
				}
				
				//created if conditions to store string variable in array when user tilts flinch
				if (myfinch.isFinchLevel()) {

					Orientation1[4] = Objects.Finchlevel;
					System.out.println("finch level");
				}


			//created if conditions to store string variable in array when user tilts flinch
				if(myfinch.isBeakDown()) {

				Orientation1[1] = Objects.Finchbeakdown;
				System.out.println("tilted down");	
				
			
				
				}
					
				}
				myfinch.saySomething("End of recording");
				System.out.println("End of recording");
		
		myfinch.setLED(0,0, 0);
		myfinch.buzz(440,500);		
				
					

		// declaring random object 

					int Min = -255;
							int Max = -1;

							Random reverse = new Random();
							int R = reverse.nextInt(Max - Min) + Min;

							// accelerating WHEELS randomly
							int MIN = 1;
							int MAX = 255;

							Random Accelerate = new Random();
							int F = Accelerate.nextInt(MAX - MIN) + MIN;
							

			
				
				Thread.sleep(2000);
				
			myfinch.setLED(0,255,0);
			System.out.println("Executing movements");
			myfinch.saySomething("executing movements");
				
			//1 created if conditions to check the data within array
			if (Orientation1[0] == Objects.Finchbeakup) {
					
					myfinch.setWheelVelocities(F,F,500);

					}
			Thread.sleep(500);
			
			
			// 4 created if conditions to check the data within array
			
			if (Orientation1[2] == Objects.Finchleftwing) {	
				myfinch.setWheelVelocities(R,F,500);
				
				}
	Thread.sleep(500);
				
					if (Orientation1[1] == Objects.Finchbeakdown) {
					myfinch.setWheelVelocities(R,R,500);
					
					}
				Thread.sleep(500);
				// 3 created if conditions to check the data within array
				
			if (Orientation1[3] == Objects.Finchrightwing) {

			myfinch.setWheelVelocities(F,R,500);
			

			}
			Thread.sleep(500);
			
			// 4 created if conditions to check the data within array
			if (Orientation1[4] == Objects.Finchlevel) {


			myfinch.setWheelVelocities(0,0);
			
				Thread.sleep(500);
			}	
		
		
				else 
				{
					
				}
			
			
			myfinch.buzz(440,500);
					Thread.sleep(1000);
						myfinch.buzz(440,500);
					myfinch.setLED(0,0,0);
				
					Thread.sleep(1000);
			
			
			
				System.out.println(Arrays.toString(Orientation1)) ;
				myfinch.saySomething("End of program");
				System.out.println("End of program");
				
				myfinch.setWheelVelocities(180,0,2000);
				myfinch.setWheelVelocities(180,0,2000);
			
				}
		}


	
