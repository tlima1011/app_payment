package model.services;

import java.util.Date;

public class PaypalService implements OnlinePaymentService {
	
	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01; 
	
	@Override
	public Double paymentFee(Double amount) {
		return PAYMENT_FEE * amount;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		return amount * months * MONTHLY_INTEREST;
	}
}
