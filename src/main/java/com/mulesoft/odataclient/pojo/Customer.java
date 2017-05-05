package com.mulesoft.odataclient.pojo;

import org.mule.modules.odata.annotation.Guid;

//com.mulesoft.odataclient.pojo.Customer
public class Customer {
	
	private String companyName;
	private String contactName;
	private String contactTitle;
	@Guid
	private String customerID;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public int getSize() {
		return 1;
	}
}
