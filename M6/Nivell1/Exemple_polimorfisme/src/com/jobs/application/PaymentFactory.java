package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	public static IPaymentRate createPaymentRateBoss(){
		return salaryPerMonth -> salaryPerMonth*1.5;
	}
	
	public static IPaymentRate createPaymentRateEmployee(){
		return salaryPerMonth -> salaryPerMonth*0.85;
	}

	public static IPaymentRate createPaymentRateManager(){
		return salaryPerMonth -> salaryPerMonth*1.1;
	}
}
