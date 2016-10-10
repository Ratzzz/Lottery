package com.lottery.seller;

import java.util.HashMap;
import java.util.Map;

import com.lottery.customer.Lottery_Customer;
import com.lottery.customer.Lottery_Winners;
import com.lottery.lottery.Lottery_Ball;
import com.lottery.lottery.Lottery_Pot;
import com.lottery.resource.Lottery_Resource;

/**
 * Class represents Lottery Seller
 * @author Saravanan
 *
 */
public class Lottery_Seller {
	
	private String sellerName;
	private Lottery_Pot lotteryPot ;
	private static Lottery_Resource lotterySeq = new Lottery_Resource();
	private int ball_MaxCount;
	private int potValue;
	private int winCount = 3;
	
	public Lottery_Seller(String sell_Name, int pot_value, int ball_count) {
		this.sellerName = sell_Name;
		this.ball_MaxCount = ball_count;
		this.potValue = pot_value;
		lotteryPot = new Lottery_Pot(pot_value,ball_count);
		
	}

	private Map<Integer,Lottery_Winners> winnersList = new HashMap<Integer,Lottery_Winners>(); 
	private Map<Integer, Lottery_Customer> soldTicketsList = new HashMap<Integer,Lottery_Customer>();
	
	/**
	 * Displays Winners from Draw
	 *@return void
	 */
	public void printWinners() {
		System.out.println("1st ball\t\t\t2nd ball\t\t\t3rd ball");
		for(int i = 1; i <= winnersList.size(); i++) {
			Lottery_Winners win = winnersList.get(i);
			System.out.printf(win.getCustomer().getCustName()+": "+win.getPrice()+"$");
			System.out.print("\t\t\t");
		}
		System.out.println();

	}
    
	/**
	 * Purchase lottery from seller
	 * @param custName
	 * @return int
	 */
	public int purchase(Lottery_Customer custName) {		
		int ballNo = lotterySeq.getSequence();		
		while(soldTicketsList.containsKey(ballNo)){
			ballNo = lotterySeq.getSequence();
		}		
		if(ballNo <= ball_MaxCount){
			soldTicketsList.put(ballNo, custName);
			return ballNo;
		}
		return 0;
	}
    
	/**
	 * Performs draw operation
	 * @return boolean
	 */
	public boolean drawWinners() {	
		if(soldTicketsList.size()>=winCount){
			for(int i=1;i<=winCount;i++){
				boolean check = false;
				while(!check){
					Lottery_Ball lotball = lotteryPot.performDraw();
					int ballNo = lotball.getBallNo();
					check = soldTicketsList.containsKey(ballNo);
					if(check) {
						Lottery_Winners win = new Lottery_Winners(soldTicketsList.get(ballNo));
						soldTicketsList.remove(ballNo);
						int price = lotteryPot.getPrice(win);
						win.setPrice(price);
						lotteryPot.fixPrice(price);
						winnersList.put(new Integer(i), win);						
					}
				}
			}
			return true;			
		}else{
			return false;
		}				
	}
    
	/**
	 * add tickets to sold list. Testing purpose
	 * @return void
	 */
	public void addSoldList(int key, Lottery_Customer cust){
		soldTicketsList.put(key, cust);			
	}
	
	/**
	 * returns ticket sold list
	 * @return Map<Integer,Lottery_Customer>
	 */
	public Map<Integer, Lottery_Customer> getSoldList(){
		return soldTicketsList;		
	}
	
	/**
	 * returns Winners List
	 * @return Map<Integer,Lottery_Winners>
	 */
	public Map<Integer, Lottery_Winners> getWinnersList(){
		return winnersList;		
	}
	
	/**
	 * returns pot value
	 * @return String
	 */
	public String getPotvalue()	{
		return new String("Pot value :"+this.potValue+"\n Ball count :"+this.ball_MaxCount);
	}
	
	/**
	 * returns seller name
	 * @return String
	 */
	public String getSellerName()	{
		return this.sellerName;
	}
}

