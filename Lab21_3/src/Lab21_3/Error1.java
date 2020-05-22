package Lab21_3;
import java.util.Random;
public class Error1 {

	public static void main(String[] args) {

		final int MAXCHEESE = 10; //Amount of value can hold 
		
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE]; //Array sizes

		// Special 3 Cheeses
		
		if (0 < MAXCHEESE & MAXCHEESE<21){	//without this statement the 0 to 20 wont be able to appear especially 0,1,2//
		names[0] = "Humboldt Fog";
		prices[0] = 25.00;
		
		if (1 < MAXCHEESE){ //if maxcheese is 2 or greater redhawk will appear//
		names[1] = "Red Hawk";
		prices[1] = 40.5;
		}
		
		if (2 < MAXCHEESE){  //if maxcheese is 3 or greater teleme will appear//
		names[2] = "Teleme";
		prices[2] = 17.25;
		}
		
 		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese");
 		
		System.out.println(names[0] + ": $" + prices[0] + " per pound");
		
		if (1 < MAXCHEESE)
		System.out.println(names[1] + ": $" + prices[1] + " per pound");
		
		if (2 < MAXCHEESE)
		System.out.println(names[2] + ": $" + prices[2] + " per pound");

	Random ranGen = new Random(100);

	
		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A'+i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;
		
			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
		
		}
		
		if (MAXCHEESE == 0)// this is if maxcheese is zero//
 		System.out.println("We sell 0 kinds of Cheese (in 0.5 lb packages)");
		
	}
	
		
}
