package com.lottery.customer;
/**
 * Customer Class represents customer details
 * @author Saravanan
 *
 */
public class Lottery_Customer {
	
private String CustName;

/**	
 * @param Firstname
 */
public Lottery_Customer(String Firstname) {
		this.CustName = Firstname;
}

/**
 * returns Customer Name
 * @return String
 */
public String getCustName() {
		return CustName;
}

}
