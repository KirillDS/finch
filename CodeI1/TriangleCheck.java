package CodeI1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TriangleCheck {
static ArrayList<String> Log = new ArrayList<String>();
public double A1d, A2d, A3d;
public int AreaT ;
public String  formatted_A1d,formatted_A2d,formatted_A3d;
//--------------------------------------------------------------------------------------------------------
//This method checks if the lengths given can make a triangle 	
	public void ValidTriangle(int L1, int L2, int L3) {
		 if(L1 + L2> L3 & L1 + L3> L2) {
			 if(L2 +L3 >L1) {
				 
				 JOptionPane.showMessageDialog(null, "These lengths make a triangle ");
				 AngleCalculator(L1, L2, L3);
				 FinchMovement Draw = new FinchMovement();
				 Draw.DrawTriangle(A1d, A2d, A3d, L1, L2, L3);
				 
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "These lengths do not make a triangle ");
				 JOptionPane.showMessageDialog(null, "*hint* \n if L1+L3>L2, L1+L2>L3 and L3+L2>L1 a triangle can be made (e.g 20+30>30)");
			 }
		 }
		 else  {
			 
			 JOptionPane.showMessageDialog(null, "These lengths do not make a triangle ");
			 JOptionPane.showMessageDialog(null, "*hint* \n if L1+L3>L2, L1+L2>L3 and L3+L2>L1 a triangle can be made (e.g 20+30>30)");
		 }
		
		 
	}
	
//--------------------------------------------------------------------------------------------------------	
// This method calculates the Angles of the Triangles and the Area 	
	public void AngleCalculator(int L1, int L2, int L3) {
		double A1r,A2r,A3r;
		double A1d, A2d, A3d;
		int AreaT,S;
		
		
		
		// Angle calculation
		A1r = Math.acos( ( (L2*L2) + ( L3*L3) - (L1*L1) )/(2.0*L2*L3));
		A1d= A1r*180/Math.PI;
		A2r = Math.acos(((L1*L1) + (L3*L3) - (L2*L2) )/(2.0*L1*L3));
		A2d = A2r*180/Math.PI;
		A3r = Math.acos( ( ( L1*L1) + (L2*L2) - (L3*L3 ))/( 2.0*L1*L2));
		A3d = A3r*180/Math.PI;
		//Area calculation
		S = (L1+L2+L3)/2;
		AreaT = (int) Math.sqrt(S*(S-L1)*(S-L2)*(S-L3));
		
		
		this.A1d = A1d;
		this.A2d = A2d;
		this.A3d = A3d;
		this.AreaT = AreaT;
		
		
	}
	
}