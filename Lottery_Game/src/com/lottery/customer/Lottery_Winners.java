package com.lottery.customer;


/**
 * Winner Class representing winning customers
 * @author Saravanan
 *
 */
public class Lottery_Winners {
	
	private static Lottery_Sequence seq = new Lottery_Sequence();
	private Lottery_Customer Customer;
	private int price;
	private boolean isSet = false;
	private int sequence = 0;
	
	/**
	 * Constructor with customer desc
	 * @param cust
	 */
	public Lottery_Winners(Lottery_Customer cust) {
		this.Customer = cust;	
		this.sequence= seq.getSequence();
	}
	
	/**
	 * returns Winner Info
	 * @return Lottery_Customer
	 */
	public Lottery_Customer getCustomer() {
		return Customer;
	}
	
	/**
	 * returns Winner SeqNO
	 * @return int
	 */
	public int getSeq() {
		return sequence;
	}
	
	/**
	 * Sets Winner Price
	 * @param amount
	 */
	public void setPrice(int amount){		
		if(!this.isSet) {
			this.price = amount;
			this.isSet = true;
		}
	}
	
	/**
	 * returns winner price
	 * @return int
	 */
	public int getPrice() {
		return price;
	}

}

/**
 * Inner Class for sequence generation
 */
class Lottery_Sequence {
	int value = 0;
	
	int getSequence() {
		return ++value;
	}
}
