package CodeI1;


import java.text.DecimalFormat;
//Here i declare my private variables as different names so that i can then assign the to the variables that i have recoeved from the user 
public class LogData {
	private int Length1;
	private int Length2;
	private int Length3;
	private int TriangleArea;
	private int RectangleArea;
	private double Angle1;
	private double Angle2;
	private double Angle3;
	private int Width;
	private int Height;
	
	// this log Data is the container which uses the same name as the class this. this is to declare the elements that will be in my array 
	LogData(int L1,int L2,int L3,double A1d,double A2d,double A3d,int AreaT,int W, int H,int AreaR){
		TriangleArea= AreaT;
		setRectangleArea(AreaR);
		setLength1(L1);
		setLength2(L2);
		setLength3(L3);
		setAngle1(A1d);
		setAngle2(A2d);
		setAngle3(A3d);
		setWidth(W);
		setHeight(H);
		
	}
	//---------------------------------------------------------------------------------------------------------
	// this part is long as i use the get and set method to assign the values to all the variables i created as private variables.
	public int GetAreaT()
	{
		return (TriangleArea);
		
	}
	
	public int getLength1() {
		return Length1;
	}
	public void setLength1(int length1) {
		Length1 = length1;
	}
	public int getLength2() {
		return Length2;
	}
	public void setLength2(int length2) {
		Length2 = length2;
	}
	public int getLength3() {
		return Length3;
	}
	public void setLength3(int length3) {
		Length3 = length3;
	}
	public int getRectangleArea() {
		return RectangleArea;
	}
	public void setRectangleArea(int rectangleArea) {
		RectangleArea = rectangleArea;
	}
	public double getAngle1() {
		return Angle1;
	}
	public void setAngle1(double angle1) {
		Angle1 = angle1;
	}
	public double getAngle2() {
		return Angle2;
	}
	public void setAngle2(double angle2) {
		Angle2 = angle2;
	}
	public double getAngle3() {
		return Angle3;
	}
	public void setAngle3(double angle3) {
		Angle3 = angle3;
	}
	public int getWidth() {
		return Width;
	}
	public void setWidth(int width) {
		Width = width;
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	//-----------------------------------------------------------------------------------------------------------------
	public void PrintTriangle()
	{
		// before setting the format in which my array will be printed. i first take the time to use the DecimalFormat function in order to round my angles to 2dp which is better for the user
		DecimalFormat A1d_format = new DecimalFormat("#.##");
		String formatted_A1d = A1d_format.format(Angle1);
		
		DecimalFormat A2d_format = new DecimalFormat("#.##");
		String formatted_A2d = A2d_format.format(Angle2);
		
		
		DecimalFormat A3d_format = new DecimalFormat("#.##");
		String formatted_A3d = A3d_format.format(Angle3);
		
		if(Length1 == -1){
			System.out.println(("Rectangle Area: " + getRectangleArea()+"cm"));
			System.out.println("Rectangle Width: "+ getWidth()+ "cm");
			System.out.println("Rectangle Height: " + getHeight()+ "cm");
			System.out.println("-------------------------------------------------------------------");
			
		}
		else{
			System.out.println(("Triangle Area: " + GetAreaT()+"cm") );
			System.out.println("Triangle Lengths:"+Length1 + "cm, "+ Length2+ "cm, " + Length3+"cm");
			System.out.println("Triangle Angles:"+ formatted_A1d+ ","+formatted_A2d+","+formatted_A3d);
			System.out.println("-------------------------------------------------------------------");
			
		}
		
		}	
		
	


	
}
