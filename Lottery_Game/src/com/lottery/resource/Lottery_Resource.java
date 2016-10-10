package com.lottery.resource;

import java.util.Random;

/**
 * Class represents needed methods for lottery operations
 * @author Saravanan
 *
 */
public class Lottery_Resource {

   int val = 0;
	
   /**
    * returns seq value
    * @return int
    */
	public int getSequence() {
		return ++val;
	} 

   /**
    * returns random value by range
    * @param maximum
    * @param minimum
    * @return int
    */
   public int getRandom(int maximum, int minimum){ 
	   return ((int) (Math.random()*(maximum - minimum))) + minimum;
   }
   
   /**
    * returns random value next to value
    * @param size
    * @return int
    */
   public int getRandom(int size){ 
	   Random rand = new Random();
	   return rand.nextInt(size);
   }
}
