package Lab21_04;
import java.util.Random;
import java.util.Scanner;


public class GenCheeseShopv21 {
	public static void intro(String[] names, double[]prices, int[] amounts) {
		
		System.out.println("\nWe sell " + names.length + " kinds of Cheese(0.5 in lb packages)");
	
		if (0 < names.length & names.length<21){	
		names[0] = "Humboldt Fog";
		prices[0] = 25.0;
		
		
		if (1 < names.length){
		names[1] = "Red Hawk";
		prices[1] = 40.50;
		}
		
		if (2 < names.length){
		names[2] = "Teleme";
		prices[2] = 17.25;
		
		}
		System.out.println(names[0] + ": $" + prices[0] + " per pound");
	
		
		if (1 < names.length)
			System.out.println(names[1] + ": $" + prices[1] + " per pound");

			
		if (2 < names.length)
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
	
	Random ranGen = new Random(100);	

	for (int i = 3; i < names.length; i++) { //Question; i=3 because the three cheeses were given already
		names[i] = "Cheese Type " + (char)('A'+i);
		prices[i] = ranGen.nextInt(1000)/100.0;
		amounts[i] = 0;
		
	System.out.println(names[i] + ": $" + prices[i] + " per pound");
	
	}
		}
		}


public static int[] getAmount(Scanner input, String[] names, int[] amounts) {
	
	
	for(int i = 0; i < names.length; i++) {
	System.out.print("\nEnter the amount of " + names[i] + ": ");
	amounts[i] = input.nextInt();
	} 

	return amounts;
}

public static void itemizedList(String[] names, double[]prices, int[] amounts) {
	
	for(int i = 0; i < names.length; i++) {
	if (amounts[i] > 0) {
	
	System.out.println(amounts[i] + " lb of " + names[i] + " @ " + "$" +prices[i] + " = $" + (amounts[i]*prices[i]));
	
	}
	
	}
}

public static double calcSubTotal(double[] prices, int[] amounts) {
	double sub = 0;

	for(int i = 0; i < amounts.length; i++) {
	sub = prices[i]*amounts[i]+sub;
	} 

	return sub;
}

public static int discount(double subTotal){
	int d = 0;
	if (subTotal >= 50 && subTotal < 100) {
		d = 10;
	} else if (subTotal >= 100) {
		d = 25;
	}
	
	return d;
}

public static void printTotal(double subTotal, int discount) {

	System.out.println("Original Sub Total: $" + subTotal);
	System.out.println("Specials...");
	System.out.println("-Discount: $" + (double) discount);
		System.out.println("Total : $" + (subTotal - discount));

}
public static void main(String[] args) {
	
	final int MAXCHEESE;
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the number of Cheeses for shop setup: ");
	MAXCHEESE = sc.nextInt();

	// DO NOT CHANGE ANYTHING BELOW
	String[] names = new String[MAXCHEESE];
	double[] prices = new double[MAXCHEESE];
	int[] amounts = new int[MAXCHEESE];

	intro(names, prices, amounts);

	getAmount(sc, names, amounts);

	double total = calcSubTotal(prices, amounts);
	
	if (MAXCHEESE > 0) {
		System.out.print("Display the itemized list? (1 for yes) ");
		int itemized = sc.nextInt();

		if (itemized == 1) {
			itemizedList(names, prices, amounts);
		}
	}

	System.out.println();

	printTotal(total,discount(total));

	
if ( MAXCHEESE == 0) {
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