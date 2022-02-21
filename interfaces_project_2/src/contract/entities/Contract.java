package contract.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private int number;
	private double totalValue;
	private Date date;
	private List<Installment> installments = new ArrayList<>();
	
	public Contract() {
	}
	public Contract(int number, double totalValue, Date date) {
		this.number = number;
		this.totalValue = totalValue;
		this.date = date;
	}
	
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTotalValue() {
		return this.totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public List<Installment> getInstallment() {
		return this.installments;
	}
	
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
	
	
}