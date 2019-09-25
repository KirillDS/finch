package CodeI1;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchMoveT {
	//this class holds all the code that makes the finch move
	
		
	
	public static void main(String[] args) {
		
		
	}
	
	void MoveStraight(int Time,int Speed, Finch myFinch){
		//this method makes the finch go straight as both wheels are set with the same speed 
		myFinch.setWheelVelocities(Speed, Speed, Time);
	}
	int Left(Finch myFinch){
		//this method makes the finch turn a right angle left using the right wheel
		myFinch.setWheelVelocities(0, 100, 1350);
		//returns the time taken to turn 
		return (1350);
	}
	int Right(Finch myFinch){
		//this method makes the finch turn a right angle right using the left wheel
		myFinch.setWheelVelocities(100, 0, 1350);
		//it returns the time taken to turn 
		return(1350);
	}
	
	
}
