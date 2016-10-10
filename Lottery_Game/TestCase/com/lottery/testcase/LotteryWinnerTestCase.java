package com.lottery.testcase;

import org.junit.Test;
import com.lottery.seller.Lottery_Seller;

/**
 * Test cases for Winner Operations
 * @author Saravanan
 *
 */
public class LotteryWinnerTestCase {
	
	private int potValue = 200;
	private int ballCount = 50;
	private String name = "test";
		
	Lottery_Seller seller =  new Lottery_Seller(name, potValue, ballCount);

	/**
	 * Test for Winners decided or not
	 *void
	 */
	@Test
	public void winnerBelowCountTest() {		
		int size = seller.getWinnersList().size();		 
		if(size < 3){
			System.out.println("Winners not decided");
		}
	}

}
