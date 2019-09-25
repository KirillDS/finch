package CodeI1;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class FinchMovement  {
public static Finch myf = new Finch();
	
	public void DrawTriangle(double A1d, double A2d, double A3d, int L1,int L2,int L3){
		int speed = 130; // I have set my wheel Velocity to 130 on both wheels as a low speed 
		int AngleSpeed = 100;
		int MsperCm = 68;
		int MsperDgr = 18;
		double LeftTrim = 0.96;
		
		
		myf.setWheelVelocities((int)(LeftTrim*speed), speed, L1*MsperCm); // Straight line
		myf.sleep(200);
		myf.setWheelVelocities(0, AngleSpeed , (int) (MsperDgr*(180-A1d))); // Turn at an angle
		myf.sleep(200);
		
		myf.setWheelVelocities((int)(LeftTrim*speed), speed,L2*MsperCm);
		myf.sleep(200);
		myf.setWheelVelocities(0, AngleSpeed, (int) (MsperDgr*(180-A2d)));
		myf.sleep(200);
		
		myf.setWheelVelocities((int)(LeftTrim*speed), speed,L3*MsperCm);
		myf.buzz(2000, 2000);
	
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
		
	}
	
	
	
	public void DrawRectangle(int W,int H){
		int speed = 130;
		int MsPerCm = 68;
		int Ms90Dgr = 1620;
		int DgrSpeed = 100;
		double LeftTrim = 0.96;
		
		myf.setWheelVelocities((int)(LeftTrim*speed), speed, MsPerCm*H);
		myf.sleep(200);
		myf.setWheelVelocities(0, DgrSpeed, Ms90Dgr);
		myf.sleep(200);
		
		myf.setWheelVelocities((int)(LeftTrim*speed), speed, MsPerCm*W);
		myf.sleep(200);
		myf.setWheelVelocities(0, DgrSpeed, Ms90Dgr);
		myf.sleep(200);
		
		myf.setWheelVelocities((int)(LeftTrim*speed), speed, MsPerCm*H);
		myf.sleep(200);
		myf.setWheelVelocities(0, DgrSpeed, Ms90Dgr);
		myf.sleep(200);
		
		myf.setWheelVelocities((int)(LeftTrim*speed), speed, MsPerCm*W);
		myf.buzz(2000, 2000);
		
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
	}
	
//-------------------------------------------------------------------------------------------
//My additional functionality here is all the polygon draw shapes. 
	// i make use of for loops to iterate through the piece of code that makes the finch move
	// this is becuase regualr polygons have the same length and same angle degrees for each lenght and vertex accordingly.
	
	public void DrawPentagon(int Length,int Side){
		int speed = 130; // I have set my wheel Velocity to 130 on both wheels as a low speed 
		int AngleSpeed = 100;
		int MsperCm = 68;
		int MsperDgr = 18;
		int PenAngle = 108;// this is a measurement of the interior angle on a regular Pentagon
		

		
		for(int i = 0; i < Side;i++){
			myf.setWheelVelocities(speed, speed, Length*MsperCm); //side 1
			myf.sleep(200);
			myf.setWheelVelocities(0, AngleSpeed , (int) (MsperDgr*(180-PenAngle)));
		}
		
		
		myf.buzz(2000, 2000);
	}
	
	public void DrawHexagon(int Length,int Side){
		int speed = 130; // I have set my wheel Velocity to 130 on both wheels as a low speed 
		int AngleSpeed = 100;
		int MsperCm = 68;
		int MsperDgr = 18;
		int HexAngle = 120; // this is a measurement of the interior angle on a regular Hexagon 
		
		
		for(int i = 0; i < Side;i++){
		myf.setWheelVelocities(speed, speed, Length*MsperCm); //side
		myf.sleep(200);
		myf.setWheelVelocities(0, AngleSpeed , (int) (MsperDgr*(180-HexAngle)));
		}
		
		myf.buzz(2000, 2000);
	}
	
	public void DrawHeptagon(int Length,int Side)
	{
		int speed = 130; // I have set my wheel Velocity to 130 on both wheels as a low speed 
		int AngleSpeed = 100;
		int MsperCm = 68;
		int MsperDgr = 18;
		double HepAngle = 128.57;
		
		
		for(int i = 0; i < Side;i++){
		myf.setWheelVelocities(speed, speed, Length*MsperCm); 
		myf.sleep(200);
		myf.setWheelVelocities(0, AngleSpeed , (int) (MsperDgr*(180-HepAngle)));
		}

		myf.buzz(2000, 2000);
		
		
	}
	
	public void DrawOctagon(int Length,int Side){
		int speed = 130; // I have set my wheel Velocity to 130 on both wheels as a low speed 
		int AngleSpeed = 100;
		int MsperCm = 68;
		int MsperDgr = 18;
		int OctAngle = 135;
		
		
		for(int i = 0; i < Side;i++){
		myf.setWheelVelocities(speed, speed, Length*MsperCm); 
		myf.sleep(200);
		myf.setWheelVelocities(0, AngleSpeed , (int) (MsperDgr*(180-OctAngle)));
		}
		
		myf.buzz(2000, 2000);
		
	}
	
	public void DrawNonagon(int Length,int Side){
		int speed = 130; // I have set my wheel Velocity to 130 on both wheels as a low speed 
		int AngleSpeed = 100;
		int MsperCm = 68;
		int MsperDgr = 18;
		int NonAngle = 140;
		
		
		for(int i = 0; i < Side;i++){
		myf.setWheelVelocities(speed, speed, Length*MsperCm); 
		myf.sleep(200);
		myf.setWheelVelocities(0, AngleSpeed , (int) (MsperDgr*(180-NonAngle)));
		}
		
		myf.buzz(2000, 2000);
	}
}
