package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private String amount;
	private String months;
	private String interest;
	private Double amountInterest;
	private Double monthlyRate;

	@Inject
	FacesContext ctx;


	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Double getRamountInterest() {
		return amountInterest;
	}

	public Double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(Double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public void setAmountInterest(Double amountInterest) {
		this.amountInterest = amountInterest;
	}

	public boolean calculate() {
		try {
			double amount = Double.parseDouble(this.amount);
			double months = Double.parseDouble(this.months);
			double interest = Double.parseDouble(this.interest);
			

			amountInterest = (interest/100)*(amount/months);
			monthlyRate = amountInterest + amount/months;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String monthlyRate() {
		if (calculate()) {
			return "showresult";
		}
		return null;
	}

	


}
