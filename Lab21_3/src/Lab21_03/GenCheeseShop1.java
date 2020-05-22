package Lab21_03;
import java.util.Random;
import java.util.Scanner;
public class GenCheeseShop1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		final int MAXCHEESE = (input.nextInt());//Amount of value can hold instead of final int MAXCHEESE = 10; //
		
		String[] names = new String[MAXCHEESE ];
		double[] prices = new double[MAXCHEESE ];
		double[] amounts = new double[MAXCHEESE ]; //Array sizes
		double total =  0;

		// Special 3 Cheeses
		
		int i;
		if (0 < MAXCHEESE & MAXCHEESE<21){	
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			
			
			if (1 < MAXCHEESE){
			names[1] = "Red Hawk";
			prices[1] = 40.5;
			}
			
			if (2 < MAXCHEESE){
			names[2] = "Teleme";
			prices[2] = 17.25;
			
			}
			
			System.out.println("\nWe sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages)");
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
			
			
			
			if (1 < MAXCHEESE)
				System.out.println(names[1] + ": $" + prices[1] + " per pound");
	
				
			if (2 < MAXCHEESE)
				System.out.println(names[2] + ": $" + prices[2] + " per pound");
			
        //----------------------------------------------------------------------------------------------//		
			
			Random ranGen = new Random(100);	
			
			for (int i = 3; i < MAXCHEESE; i++) {
				names[i] = "Cheese Type " + (char)('A'+i);
				prices[i] = ranGen.nextInt(1000)/100.0;
			   amounts[i] = 0;
		//-----------------------------------------------------------------------------------------------//		
			System.out.println(names[i] + ": $" + prices[i] + " per pound");
			}
			
			for (int i = 0; i <MAXCHEESE; i++) {
				System.out.print("\nEnter the amount of " + names[i] + ":");
				amounts[i] = input.nextDouble();
				
				while(amounts[i] < 0 || amounts[i] % 0.5 != 0){
			        if(amounts[i] <= 0){
			            System.out.print("Invalid input. Enter a value >=0: ");
			        }
			        else {
			            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
			        }
			        amounts[i] = (input.nextDouble());
			    }
			    
			}
			
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int itemizedlist = input.nextInt();
			System.out.print("");
			
			
			double discount = 0;
			if (total >= 100)
				discount = 25;
			else if (total >=50)
				discount = 10;
			{	
			
			
		}
			if (itemizedlist == 1){
				for (int i = 0; i < MAXCHEESE; i++){
				
					if ( amounts[i] > 0)
						System.out.println(amounts[i] + " lb of " + names[i] + " @ " + prices[i] + " = $" + amounts[i]*prices[i]);
					
				}
			}
				System.out.println("");
	
				double originalsubTotal = 0;
				for(int = 0; i < MAXCHEESE; i++) {
		             originalsubTotal = amounts[i]*prices[i]; 
				}
				System.out.printf("%s %37s\n","Original Sub Total     ",String.format("$%.2f", ));
				
			    
			    System.out.println("Specials...");
		        System.out.printf("%s %10s\n","Humboldt Fog (Buy 1 Get 1 Free):                  ",String.format("-$%.2f",));
				System.out.printf("%s %14s\n","Red Hawk (Buy 2 Get 1 Free):                  ",String.format("-$%.2f",));
				System.out.print("None\n" );
	    }
		        System.out.printf("%s %37s\n","New Sub Total:         ",String.format("$%.2f",+ amounts[i]*prices[i]-12.5));
		        
		        
		        
		        System.out.printf("%s %37s\n","Additional 0% Discount:",String.format("-$%.2f",+ 0.0));
		        
		        if(amounts[i] > 0) {
		        System.out.printf("%s %37s\n","Final Total:           ",String.format("$%.2f", + amounts[i]*prices[i]-12.5));
		        }
		        if(amounts[i] > 1) {
			    System.out.printf("%s %37s\n","Final Total:           ",String.format("$%.2f", + amounts[i]*prices[i]-20.25/2));
			        }
		
		
		
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

