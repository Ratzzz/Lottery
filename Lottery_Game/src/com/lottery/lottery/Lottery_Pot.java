package com.lottery.lottery;

import java.util.ArrayList;
import java.util.List;

import com.lottery.customer.Lottery_Winners;
import com.lottery.resource.Lottery_Resource;

/**
 * Class represents Lottery Pot of Price amount
 * @author Saravanan
 *
 */
public class Lottery_Pot {
	
	private final int TOTAL_BALLS;
	
	private int totalPotPrice;
	private int availPotPrice;
	
	private static Lottery_Resource seq = new Lottery_Resource();
	
	private List<Lottery_Ball> balls = new ArrayList<Lottery_Ball>();
	
	/**
	 * constructor for lottery Pot
	 * @param value
	 * @param countBalls
	 */
	public Lottery_Pot(int value, int countBalls) {
		this.totalPotPrice = value;
		this.availPotPrice = value;
		this.TOTAL_BALLS = countBalls;
		for(int i = 0; i < TOTAL_BALLS; i++) {
			Lottery_Ball ball = new Lottery_Ball(i + 1);
			balls.add(ball);
		}
	}
    
	/**
	 * returns random ball
	 * @return Lottery_Ball
	 */
	public Lottery_Ball performDraw() {
		int no = seq.getRandom(TOTAL_BALLS,1);
		Lottery_Ball ball = balls.get(no);
		return ball;
	}
    
	/**
	 * Sets price for Winner
	 * @param price
	 */
	public void fixPrice(int price) {	
		this.availPotPrice = this.availPotPrice - price;
	}
	
	/**
	 * returns Price for Winner
	 * @param win
	 * @return int
	 */
	public int getPrice(Lottery_Winners win) {
		return (int) (long) Math.round(this.totalPotPrice * (0.50 *(getPricePercent(win.getSeq()))));
	}
	
	/**
	 * returns percentage of price money
	 * @param sequence
	 * @return double
	 */
	private double getPricePercent(int sequence) {
	 if(sequence == 1) return 0.75;
	 else if(sequence == 2) return 0.15;
	 else if(sequence == 3) return 0.10;
	 else return 0;
	 }
	
	/**
	 * returns ball list
	 * @return List<Lottery_Ball>
	 */
	public List<Lottery_Ball> getBallList(){
		return this.balls;
	}

	
}
