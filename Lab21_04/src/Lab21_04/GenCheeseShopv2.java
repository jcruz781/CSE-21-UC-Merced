package Lab21_04;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class GenCheeseShopv2 {
	
	public static double round(double num) {
		num = Math.round(num * 100.0) / 100.0;
		return num;
	}
	//method to display cheese
	public static void intro(String[] cheese, double[] cheesePrice) {
		System.out.println("\nWe sell " + cheese.length +" kinds of Cheese (in 0.5 lb packages):");
		
		for(int i = 0; i < cheese.length; i++) {
			System.out.println(cheese[i] + ": $" + round(cheesePrice[i]) + " per pound");
		}
	}
	
	//this method will populate the cheeseAmount array
	public static double[] getAmount(Scanner scan, String[] cheeseTypes) {
		double[] cheeseAmount = new double[cheeseTypes.length];
		for(int i = 0; i < cheeseTypes.length; i++) {
			System.out.print("Enter the amount of " + cheeseTypes[i] + " in lbs: ");
			cheeseAmount[i] = getValidAmount(scan);
		}
		return cheeseAmount;
	}
	
	//this method will get a valid number from the user and check its validity
	public static double getValidAmount(Scanner scan) {
		double userNum = scan.nextDouble();
		
		//checking for the validity of the user number
		while(true) {
			if(userNum % 0.5 != 0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				userNum = scan.nextDouble();
				continue;
			}
			if(userNum < 0 ) {
				System.out.print("Enter a value >= 0: ");
				userNum = scan.nextDouble();
				continue;
			}
			break; //if the user input satisfies both conditions then the loop will terminate
		}
		return userNum;	
	}
	
	public static void itemizedList(Scanner scan, String[] cheeseTypes, double[] cheesePrice, double[] cheeseAmount) {
		System.out.print("Display the itemized list? (1 for yes) ");
		int yesNo = scan.nextInt();
		if(yesNo == 1) {
			for(int i = 0; i < cheeseTypes.length; i++) {
				if(cheeseAmount[i] == 0)
					continue;
				else {
					System.out.println(cheeseAmount[i] + " lb of " + cheeseTypes[i] + " @ $" + round(cheesePrice[i]) + " = $" + round((cheesePrice[i] * cheeseAmount[i])));
				}
			}
		}
	}
	
	
	//will display sub total, discount, and total.
	public static void displayTotalPrice(String[] cheeseTypes, double[] cheesePrice, double[] cheeseAmount) {
		double subTotal = 0;
		double total = 0;
		double humboldtDisc = 0;
		double redHawkDisc = 0;
		double temp = 0;
		double tenPercent = 0;
		double fifteenPercent =0;
		
		if(cheesePrice.length != 0) {
			for(int i = 0; i < cheesePrice.length; i++) {
				subTotal += cheesePrice[i] * cheeseAmount[i];
			}
		int i = 0;
		temp = (int)((cheeseAmount[i]/0.5)/2);
		humboldtDisc = (temp/2) * cheesePrice[i];
		
		int k = 0;
		temp = (int)((cheeseAmount[k]/0.5)/3);
		redHawkDisc = (temp/2) * cheesePrice[k];
		}
		
		System.out.println("Sub total:                        $" + subTotal);
		System.out.println("Specials...");
		if(humboldtDisc!= 0)
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + humboldtDisc);
		if(redHawkDisc != 0)
			System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$" + redHawkDisc);
		if(humboldtDisc == 0 && redHawkDisc == 0)
			System.out.println("None                             -$0.00");
		 
		total = subTotal - redHawkDisc - humboldtDisc;
		System.out.println("New Subtotal:                     $" + total);
		if (subTotal >= 150) {
			tenPercent = .1;
			System.out.println("Additional 10% Discount:         -$" + round(total * tenPercent));
		}
		if(subTotal >= 250) {
			fifteenPercent = .15; 
			System.out.println("Additional 15% Discount:         -$" + round(total * fifteenPercent));
		}
		total = total - (total*tenPercent) - (total*fifteenPercent);
		
		
		
		
		System.out.println("Total:                            $" + round(total));
		
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop set up: ");
		
		int cheeseTypesSize = scan.nextInt();
		double[] cheesePrice = new double[cheeseTypesSize];
		String[] cheeseTypes = new String[cheeseTypesSize];
		//Will store the number of cheese pounds the user wants
		double[] cheeseAmount = new double[cheeseTypes.length];
		
		if(cheeseTypesSize > 2) {
			cheeseTypes[0] = "Humboldt Fog";
			cheesePrice[0] = 25.00;

			cheeseTypes[1] = "Red Hawk";
			cheesePrice[1] = 40.50;
		
			cheeseTypes[2] = "Teleme";
			cheesePrice[2] = 17.25;
			
			Random ranGen = new Random(100);

			for (int i = 3; i < cheeseTypesSize; i++) {
				cheeseTypes[i] = "Cheese Type " + (char)('A' + i);
				cheesePrice[i] = ranGen.nextInt(1000)/100.0;
				cheeseAmount[i] = 0;	
			}
		}else if(cheeseTypesSize == 2) {
			cheeseTypes[0] = "Humboldt Fog";
			cheesePrice[0] = 25.00;

			cheeseTypes[1] = "Red Hawk";
			cheesePrice[1] = 40.50;
			
		}else if (cheeseTypesSize == 1) {
			cheeseTypes[0] = "Humboldt Fog";
			cheesePrice[0] = 25.00;
		}
		
		//displays cheese options
		intro(cheeseTypes, cheesePrice);
		System.out.println();
		//populating cheeseAmount array with the user's inputs
	
		//will display cheese with total price amount 
		if(cheeseTypesSize != 0) {
			cheeseAmount = getAmount(scan, cheeseTypes);
			System.out.println();
			itemizedList(scan, cheeseTypes, cheesePrice, cheeseAmount);
		}else {
			System.out.print("Display the itemized list? (1 for yes) ");
			int yesNo = scan.nextInt();
			if(yesNo == 1) 
				System.out.println("No items were purchased.");
		}
		
		System.out.println();
		
		displayTotalPrice(cheeseTypes, cheesePrice, cheeseAmount);
	}

}
