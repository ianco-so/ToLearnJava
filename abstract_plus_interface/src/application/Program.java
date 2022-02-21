package application;

import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;
import model.enums.Color;

public class Program {
	public static void main(String[] args) {
		
		Shape s1 = new Circle (Color.RED, 2.0);
		Shape s2 = new Rectangle (Color.BLUE, 5.0, 10.0);
		
		System.out.println(s1+"\n");
		System.out.println(s2);
	}
}
