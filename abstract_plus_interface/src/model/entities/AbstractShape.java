package model.entities;

import model.enums.Color;

public abstract class AbstractShape implements Shape{
	private Color color;

	protected AbstractShape(Color color) {
		this.color = color;
	}

	protected Color getColor() {
		return color;
	}
	protected void setColor(Color color) {
		this.color = color;
	}
}