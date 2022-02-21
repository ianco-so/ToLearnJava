package model.entities;

import model.enums.Color;

public class Rectangle extends AbstractShape {
	private double height;
	private double widht;
	
	public Rectangle(Color color, double height, double widht) {
		super(color);
		this.height = height;
		this.widht = widht;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidht() {
		return widht;
	}
	public void setWidht(double widht) {
		this.widht = widht;
	}

	@Override
	public double area() {
		return this.height*this.widht;
	}
	@Override
	public String toString() {
		return "Rectangle color: " +getColor()+"\nRectangle area: "+String.format("%.2f",area());
	}
}