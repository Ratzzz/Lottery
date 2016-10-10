package com.lottery.main;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import com.lottery.customer.Lottery_Customer;
import com.lottery.seller.Lottery_Seller;

/**
 * The main class where user provides the command options
 * @author Saravanan
 *
 */
public class Lottery_Application {
	
	private static Properties property = new Properties();
	private static InputStream in = null;
	private static boolean draw = false;

	public static void main(String[] args) {
		
		try{
			  in = new FileInputStream("lottery.properties");
			  property.load(in);
			  
			  Lottery_Seller seller = new Lottery_Seller(property.getProperty("seller"),
					                                     Integer.parseInt(property.getProperty("potCash")),
					                                     Integer.parseInt(property.getProperty("ballCount")));
			  
			 System.out.println("Welcome to Silanis Lottery \n");
			 System.out.println("Lottery Seller : "+property.getProperty("seller")+"\n");	
			 System.out.println("Enter what do you like to do ? \n Purchase \n Draw \n Winners \n Exit");
			 Scanner scan = new Scanner(System.in);
			 String option = scan.nextLine();
			  
			  do{
				  if(option.equalsIgnoreCase("Purchase"))
				  {
					  System.out.println("Please enter First Name for Purchase of Ticket :");
					  String purchaseName = scan.nextLine();
					  
					  if(purchaseName!=null){
						  int purchase = seller.purchase(new Lottery_Customer(purchaseName.trim()));
						  if(purchase!=0){
							  System.out.println("Lottery Ticket Purchased : \n First name :"+purchaseName+"\n Ticket No :"+purchase);
						  }else{
							  System.out.println("All the Tickets are Sold. Please Try again next time !!");
						  }
					  }					  
					  
				  }else if(option.equalsIgnoreCase("Draw"))
				  {
					  if(draw!=false){
						  System.out.println("Lottery Draw is already performed. Please see the Winners !!");
					  }else{
						  boolean win = seller.drawWinners();
			              if(win!=false){
			              draw = true;
			              System.out.println(" Lottery draw happened successfully !");
			              System.out.println("Winner : "+seller.getWinnersList().get(1).getCustomer().getCustName());
			              }else{
			               System.out.println(" Draw cannot happen now as Tickets are yet to be sold !!");
			              }
					  }					 
				  } else if(option.equalsIgnoreCase("Winners")) {	
					  if(draw!=false){
						  seller.printWinners();
						  System.out.println("Congratulations to all the Winners :) ");
			    		  System.exit(0);
					  }else{
						  System.out.println("Please Perform the draw to print the winners !!");						  
					  }					  
				  } else if(option.equalsIgnoreCase("Exit"))
				  {
					  System.out.println("Thank You for using Silanis Lottery ! Bubye :)");
					  System.exit(0);
				  }else{
					  System.out.println("Please provide a valid option ");
				  }
				  System.out.println("\n");
				  System.out.println("Enter what do you like to do ? \n Purchase \n Draw \n Winners \n Exit");
				  option = scan.nextLine();
			  }while(option !=null);			 
			  
			  scan.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
