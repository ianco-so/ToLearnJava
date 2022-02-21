package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerDay, pricePerHour;
	private TaxService taxService;
	
	public RentalService(Double pricePerDay, Double pricePerHour,TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long inicialTime = carRental.getStart().getTime();
		long finalTime = carRental.getFinish().getTime();
		double hours = (double)(finalTime-inicialTime)/1000/60/60;
		double basicPayment;
		
		if (hours <= 12.0)	{
			basicPayment = Math.ceil(hours)*this.pricePerHour;
			System.out.println(Math.ceil(hours));
		}
		else	basicPayment = Math.ceil(hours/24)*this.pricePerDay;
		
		double tax = this.taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}