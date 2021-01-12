package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	//Atributos
	private Contract contract; 
	private Integer months; 
	private OnlinePaymentService onlinePaymentService; 
	
	
	//Construtores 
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService; 
	}
	//Getters and Setters 
	public Integer getMonths() {
		return months; 
	}
	public void setMonths(Integer months) {
		this.months = months;
	}
	
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public void processContract(Contract contract, Integer months) {
		double basicQuota = contract.getTotalValue() / months; 
		for(int i = 1; i <= months;i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate, fullQuota)); 
		}
	}
	private Date addMonths(Date date, int n) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime(); 
	}
}
