package Lab21_03;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		final int MAXCHEESE = (input.nextInt());//Amount of value can hold instead of final int MAXCHEESE = 10; //
		
		
// These are the arrays that were included in the lab already and added the PricesTotal[] array
		String[] names = new String[MAXCHEESE + 3];
		double[] prices = new double[MAXCHEESE + 3];
		double[] pricesTotal = new double[MAXCHEESE + 3];
		double[] amounts = new double[MAXCHEESE + 3];

//Depending on what the final int MAXCHEESE is, the 3 basic Cheese Types will show
		if (0 < MAXCHEESE) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.0;
		}

		if (1 < MAXCHEESE) {
			names[1] = "Red Hawk";
			prices[1] = 40.5;
		}

		if (2 < MAXCHEESE) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}

		//Continuing on with the Cheeses, it will now show how much each cheese is
		System.out.println("\nWe sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages)");


		if (0 < MAXCHEESE) {
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}                                                                                             

		if (1 < MAXCHEESE) {
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}

		if (2 < MAXCHEESE) {
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
		}
//---------------------------------------------------------------------------------------------------//
//Random price generator for the other types of Cheeses
		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

/* Starting from here, the program asks the user for the amount of
cheese and calculates the total individually
*/
		Scanner cheeseAmt = new Scanner(System.in);

		double humboldtFog = 0;
		double redHawk = 0, teleme = 0;
		double hfTotal = 0, rHTotal = 0, teleTotal = 0;
		double subTotal, DiffSubTotal = 0;

		for (int i = 0; i < MAXCHEESE;) {
			System.out.print("Enter the amount of Humboldt Fog in lbs: ");
			humboldtFog = cheeseAmt.nextDouble();
			hfTotal = humboldtFog * 25;
			
			
			while(humboldtFog < 0 || humboldtFog % 0.5 != 0){
		        if(humboldtFog <= 0){
		            System.out.print("Invalid input. Enter a value >=0: ");
		        }
		        else {
		            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		        }
		        humboldtFog = cheeseAmt.nextDouble();
		    }
		    break;
		}
		for (int i = 1; i < MAXCHEESE;) {
			System.out.print("Enter the amount of Red Hawk in lb: ");
			redHawk = cheeseAmt.nextDouble();
			rHTotal = redHawk * 40.5;
			
		
			while(redHawk < 0 || redHawk % 0.5 != 0){
		        if(redHawk <= 0){
		            System.out.print("Invalid input. Enter a value >=0: ");
		        }
		        else {
		            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		        }
		        redHawk = cheeseAmt.nextDouble();
		    }
		    break;
		
		}
		for (int i = 2; i < MAXCHEESE;) {
			System.out.print("Enter the amount of Teleme in lb: ");
			teleme = cheeseAmt.nextDouble();
			teleTotal = teleme * 17.25;

			while(redHawk < 0 || redHawk % 0.5 != 0){
		        if(redHawk <= 0){
		            System.out.print("Invalid input. Enter a value >=0: ");  
		        }
		        else {
		            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		        }
		        redHawk = cheeseAmt.nextDouble();
			}
			break;
		}

		for (int i = 3; i < MAXCHEESE; i++) {
			System.out.print("Enter the amount of " + names[i] + ":");
			amounts[i] = cheeseAmt.nextDouble();
			pricesTotal[i] = amounts[i] * prices[i];
			DiffSubTotal += pricesTotal[i];
		
			while(amounts[i] < 0 || amounts[i] % 0.5 != 0){
		        if(amounts[i] <= 0){
		            System.out.print("Invalid input. Enter a value >=0: ");
		        }
		        else {
		            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		        }
		        amounts[i] = cheeseAmt.nextDouble();
			}
			break;
		
		}
//total of all the cheeses
		subTotal = hfTotal + rHTotal + teleTotal + DiffSubTotal;

		double subDiscount = 0;
		double subDiscount1 = 0;
		double totalFinal = 0;

/*Conditional statement to determine whether or not the user will get a discount
or not */
		//if (subTotal >= 50) {  //
	//		totalFinal = subTotal - 10;
	//	   subDiscount = 10;//
		//	if (subTotal >= 100) {//
			//	totalFinal = subTotal - 25; //
		//		subDiscount = 25;  //
	//		}
	//	} else { //
	//		totalFinal = subTotal;
	//	}
//---------------------------------------------------------------------------//
		Scanner choice = new Scanner(System.in);

		int numChoice = 0;

/*Asks the user whether or not they want their list of cheeses to be displayed
along with their total prices. */
		for (int i = 0; i < MAXCHEESE; ++i) {
		System.out.print("Display the itemized list? (1 for yes)");
		numChoice = choice.nextInt();
		break;
		}

/* If the amount of cheese the user picks is 0, then that cheese will not be
displayed for the purpose of organization */
		if (numChoice == 1) {
			if (humboldtFog != 0) {
				System.out.println(humboldtFog + " lbs of Humboldt Fog @ $25.0 = " + "$" + hfTotal);
			}
			if (redHawk != 0) {
				System.out.println(redHawk + " lbs of Red Hawk @ $40.5 = " + "$" + rHTotal);
			}
			if (teleme != 0) {
				System.out.println(teleme + " lbs of Teleme @ $17.25 = " + "$" + teleTotal);
			}
		}

		for (int i = 3; i < MAXCHEESE; i++) {
			if (amounts[i] != 0) {
				System.out.println(amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = " + "$" + pricesTotal[i]);
			}
		}

/* Prints out the subTotal of the cheeses, the discount, and the Final Total
with the Discount */
		System.out.println();

		
		
		
		
		
		System.out.printf("%s %37s\n","Original Sub Total",String.format("$%.2f",subTotal));
		System.out.printf("Specials...");
		
		//--------------------------------------------------------------------------------------------//
		
		double dishumboldtFog = (int)((2 * humboldtFog)/2)* 0.5 * 25;
		
		double disredHawk = (int)((2 * redHawk)/3) * 0.5 * 40.5; 
		
		if(humboldtFog >= 1) {
		   dishumboldtFog = (int)(dishumboldtFog) * 12.5;
		   hfTotal = hfTotal - dishumboldtFog;
		   System.out.printf("%s %37s\n","\nHumboldt Fog (Buy 1 Get 1 Free):   ",String.format("$%.2f",subDiscount));
		}
		
		if(disredHawk >= 1.5) {
			   disredHawk= (int)(disredHawk) * 40.50;
			   rHTotal = rHTotal - disredHawk;
			   System.out.printf("%s %37s\n","Red Hawk (Buy 1 Get 1 Free):   ",String.format("$%.2f", subDiscount1 ));
			}
		
		
//-------------------------------------------------------------------------------------------------------------------------//		
		
		double newsubTotal = 0;
		
		System.out.printf("%s %37s\n","New Sub Total    ",String.format("$%.2f", newsubTotal));
		
		
//--------------------------------------------------------------------------------------------------------------------------//		
		double addDis = 0;
		double totaladdDiscount = 0;
		
		if(newsubTotal >= 150) {
			
		    System.out.printf("%s %37s\n","Additional" + addDis + "% Discount: " ,String.format("$%.2f", totaladdDiscount));
		}
		
		
		if(newsubTotal >= 250) {
		
			System.out.printf("%s %37s\n","\nAdditional" + addDis + "% Discount: " ,String.format("$%.2f", totaladdDiscount));
		}
		
		
	//----------------------------------------------------------------------------------------------------------//	
		
		System.out.printf("%s %37s\n","Final Total      ",String.format("$%.2f", totalFinal));
		
		
		
	//-----------------------------------------------------------//
		if (MAXCHEESE == 0){
			System.out.println("\nWe sell 0 kinds of Cheese (in 0.5 lb packages)");
			System.out.println("");
			System.out.println("");
            System.out.printf("%s %37s\n","Original Sub Total     ",String.format("$%.2f", + 0.0));
			System.out.println("Specials...");
			System.out.printf("%s %37s\n","None                   ",String.format("$%.2f",+ 0.0));
	        System.out.printf("%s %37s\n","New Sub Total:         ",String.format("$%.2f",+ 0.0));
	        System.out.printf("%s %37s\n","Additional 0% Discount:",String.format("$%.2f",+ 0.0));
	        System.out.printf("%s %37s\n","Final Total:           ",String.format("$%.2f", + 0.0));
		}
	}
}