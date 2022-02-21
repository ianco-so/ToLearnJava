package contract.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date dueDate;
	private double amount;
	
	public Installment() {
	}
	public Installment(Date dueDate, double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	public Date getDueDate() {
		return this.dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getAmount() {
		return this.amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + this.amount;
	}
	
	
}