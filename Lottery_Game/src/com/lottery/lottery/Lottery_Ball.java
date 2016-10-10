package com.lottery.lottery;

/**
 * Class representing Lottery ball
 * @author Saravanan
 *
 */
public class Lottery_Ball {
	
	private int ballNo;
	
	/**
	 * Constructor Lottery ball
	 * @param value
	 */
	public Lottery_Ball(int value){
		this.ballNo = value;
	}
	
	/**
	 * returns ball no
	 * @return int
	 */
	public int getBallNo(){
		return ballNo;		
	}

}
