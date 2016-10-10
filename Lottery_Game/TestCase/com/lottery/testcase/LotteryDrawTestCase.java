package com.lottery.testcase;

import org.junit.Test;

import com.lottery.customer.Lottery_Customer;
import com.lottery.seller.Lottery_Seller;

/**
 * Test case for draw operations
 * @author Saravanan
 *
 */
public class LotteryDrawTestCase {

	private int potValue = 200;
	private int ballCount = 50;
	private String name = "test";
	private int key = 2;

	
	Lottery_Seller seller =  new Lottery_Seller(name, potValue, ballCount);
	Lottery_Customer cust = new Lottery_Customer(name);

	/**
	 * Test for draw happening < then 3 tickets sold
	 *void
	 */
	@Test
	public void drawBelowCountTest() {
		
		int number = seller.getSoldList().size();
		if(number < 3)
		{
			boolean check = seller.drawWinners();
			if(check)
				System.out.println("Draw test failure");
			else
				System.out.println("Draw test success");
		}
	}
	
	/**
	 * Test for adding duplicate tickets
	 *void
	 */
	@Test
	public void addDuplicateTicket(int count) {		
		try{
			for(int i=0;i<count;i++){
				seller.addSoldList(key, cust);
			}
		}catch(Exception e){
			System.out.println("Add duplication Failed");
		}
	}

}
