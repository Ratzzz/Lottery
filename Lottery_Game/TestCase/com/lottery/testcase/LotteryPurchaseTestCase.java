package com.lottery.testcase;

import org.junit.Test;

import com.lottery.customer.Lottery_Customer;
import com.lottery.resource.Lottery_Resource;
import com.lottery.seller.Lottery_Seller;

/**
 * Test cases for Purchase Operations
 * @author Saravanan
 *
 */
public class LotteryPurchaseTestCase {
	
    private int seqno = 0;
	private int potValue = 200;
	private int ballCount = 50;
	private String name = "test";
	
	private String purName = "ratzzz";
	
	Lottery_Seller seller =  new Lottery_Seller(name, potValue, ballCount);
	private static Lottery_Resource Seq = new Lottery_Resource();

	
	/**
	 * Test for purchase of ticket
	 *void
	 */
	@Test
	public void purchaseTest() {		
		Lottery_Customer cust = new Lottery_Customer(purName);
		int n = seller.purchase(cust);
		if(n != 0){
		System.out.println("Purchase Failure");
		}else{
			System.out.println("Purchase Success");
		}
	}
	
	/**
	 * Test for purchase of ticket more then ball range
	 *void
	 */
	@Test
	public void ExceedPurchaseTest(int count) {		
		
		for(int i = 0;i<count;i++)
		{
		Lottery_Customer cust = new Lottery_Customer(purName);
		int n = seller.purchase(cust);
		if(n != 0){
		System.out.println("Purchase Failure");
		}else{
			System.out.println("Purchase Success");
		}
	  }
	}
	
	/**
	 * Test for checking Unique sequence generation
	 *void
	 */
	@Test
	public void SeqPurchaseTest(int count) {
		seqno = Seq.getSequence();
		for(int i=0;i<count;i++)
		{
			int no = Seq.getSequence();
			if(seqno == no){
				System.out.println(" Same Seq No generation. Failure !");
			return;
			}
		}
		System.out.println("Unique Sequence Numbers generated !");
		return;
	}

}
