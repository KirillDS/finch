package CodeI1;

import java.util.ArrayList;

//import org.apache.log4j.chainsaw.Main;


public class LogArray {
	private static ArrayList<LogData> logArray = new ArrayList<LogData>();;// i have created a container clas called Log Data and i Call that container in this class LogArray
// the reason the methods in this class are Static is because This means this method will not be affectd by things happening in other classes.
	//i have done this because previously each time i made an array, when the GUI moved from the frame that the shape was Drawn the Array would reset.

	public LogArray() {
	}
	
	public static void addData(LogData data){
		logArray.add(data);
	}
	
	public static void addData(int L1,int L2,int L3,double A1d,double A2d,double A3d,int AreaT,int W, int H,int AreaR){
		LogData logdata = new LogData(L1,L2,L3,A1d,A2d,A3d,AreaT,W,H,AreaR);
		addData(logdata);
	}
	
	
	public static  void PrintDataLog() // here i get information from the container class on the format of how to print the ArrayList and then i put the array list thorough a loop to call each element  
{
		System.out.println("-------------------------------------------------------------------");
		System.out.println();
		System.out.println("Printing Log array....");
		System.out.println();
	for(int i=0;i<logArray.size();++i)
	{
		System.out.println("shape " +(i+1));
		
		logArray.get(i).PrintTriangle();
		
		}	
		
}
}