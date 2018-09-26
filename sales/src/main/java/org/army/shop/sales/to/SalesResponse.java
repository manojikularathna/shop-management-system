package org.army.shop.sales.to;

public class SalesResponse extends BaseResponse{

	private String billingInformation;

	public String getBillingInformation() {
		return billingInformation;
	}

	public void setBillingInformation(String billingInformation) {
		this.billingInformation = billingInformation;
	}
}
