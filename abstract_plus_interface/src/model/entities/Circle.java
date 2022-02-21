package model.entities;

import model.enums.Color;

public class Circle extends AbstractShape {
	private double radius;
	
	public Circle(Color color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.pow(this.radius, 2)*Math.PI;
	}

	@Override
	public String toString() {
		return "Circle color: " +getColor()+"\nCircle area: "+String.format("%.2f",area());
	}
}