package contract.services;

import java.util.Calendar;
import java.util.Date;

import contract.entities.Contract;
import contract.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue()/months;
		for (int i = 1; i <= months; i++) {
			Date date = addMonths(contract.getDate(), i);
			double quota = basicQuota + this.onlinePaymentService.interest(basicQuota, i);
			double fullQuota = quota + this.onlinePaymentService.paymentFee(quota);
			contract.addInstallment(new Installment(date, fullQuota));
		}
	}
	private Date addMonths(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		return cal.getTime();
	}
}