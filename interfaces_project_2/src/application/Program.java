package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import contract.entities.Contract;
import contract.entities.Installment;
import contract.services.ContractService;
import contract.services.PaypalService;

public class Program {
	public static void main (String [] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date contractDate;
		int contractNumber, installmentsNumber;
		double contractValue;
		
		
		System.out.println("Enter contrat data:");
		System.out.print("Number: ");
		contractNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Date: ");
		contractDate = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		contractValue = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber, contractValue, contractDate);
		
		System.out.print("Number of installments: ");
		installmentsNumber = sc.nextInt();
		System.out.println("INSTALLMENTS: ");
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, installmentsNumber);
		for(Installment x : contract.getInstallment()) System.out.println(x.toString());
		
		sc.close();
	}
}