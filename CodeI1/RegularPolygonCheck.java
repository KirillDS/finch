package CodeI1;

import javax.swing.JOptionPane;

public class RegularPolygonCheck {
// This Class Checks the value the user has input against the number of sides each shape has. With this I am able to call the correct method to draw that shape
	public void PolygonSort(int Side,int Length){
		if (Side == 5)
		{
			JOptionPane.showMessageDialog(null, "This shape is a Pentagon");
			FinchMovement Pen = new FinchMovement();
			Pen.DrawPentagon(Length,Side);
			MainMenu menu = new MainMenu();
			menu.setVisible(true);
		}
		else if (Side == 6)
		{
			JOptionPane.showMessageDialog(null, "This shape is a Hexagon");
			FinchMovement Hex = new FinchMovement();
			Hex.DrawHexagon(Length,Side);
			MainMenu menu = new MainMenu();
			menu.setVisible(true);
		}
		else if (Side == 7)
		{
			JOptionPane.showMessageDialog(null, "This shape is a Heptagon or Septagon ");
			FinchMovement Hep = new FinchMovement();
			Hep.DrawHeptagon(Length,Side);
			MainMenu menu = new MainMenu();
			menu.setVisible(true);
		}
		else if (Side == 8)
		{ 
			JOptionPane.showMessageDialog(null, "This shape is a Octagon");
			FinchMovement Oct = new FinchMovement();
			Oct.DrawOctagon(Length,Side);
			MainMenu menu = new MainMenu();
			menu.setVisible(true);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "This shape is a Nonagon");
			FinchMovement Non = new FinchMovement();
			Non.DrawNonagon(Length,Side);
			MainMenu menu = new MainMenu();
			menu.setVisible(true);
		}
	}
}
