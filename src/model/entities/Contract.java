package model.entities;

import java.util.ArrayList;
import java.util.Date;

import model.services.OnlinePaymentService;

public class Contract {
	
	private Integer number; 
	private Date date; 
	private Double totalValue; 
		
	ArrayList <Installment> installments = new ArrayList<>(); 
	
	public Contract() {
		
	}

	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public ArrayList<Installment> getInstallments() {
		return installments;
	}
	
	public void addInstallMent(Installment installment) {
		installments.add(installment);
	}
	
	public void removeInstallMent(Installment installment) {
		installments.remove(installment);
	}

	

	

}
