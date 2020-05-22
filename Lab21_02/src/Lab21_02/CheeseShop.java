package Lab21_02;
import java.util.Scanner;
public class CheeseShop {

	public static void main(String[]args) { 
		Scanner input =new Scanner(System.in);
	
	System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
    System.out.println("Humboldt Fog: $25.0 per pound");
    System.out.println("Red Hawk: $40.5 per pound");
    System.out.println("Teleme: $17.25 per pound\n");
	
    System.out.print("Enter the amount of Humboldt Fog in lbs: ");
    double humboldt = readCheese(input);
    System.out.print("Enter the amount of Red Hawk lbs: ");
    double redHawk = readCheese(input);
    System.out.print("Enter the amount of Teleme lbs: ");
    double teleme = readCheese(input);
    System.out.println();

if(humboldt < 0 & redHawk < 0 & teleme < 0) {
	System.out.print("No items were purchased.");
}
   
    System.out.print("Display the itemized list? (1 for yes) ");
    int itemizedlist = input.nextInt();
   
    double subTotal = humboldt*25 + redHawk*40.50 + teleme*17.25;
    
    
    if (itemizedlist ==1) 
         if (humboldt >= 0.5)
            System.out.println(humboldt + " lbs of Humboldt Fog @ $25.00 = $" + humboldt*25);
         if (redHawk >= 0.5)
            System.out.println(redHawk + " lbs of Red Hawk @ $40.50 = $" + redHawk*40.50);
         if (teleme > 0)
            System.out.println(teleme + " lbs of Teleme @ $17.25 = $" + teleme*17.25+"\n\n");
     else {
    	System.out.println("No items were purchased.\n");
    }
    System.out.printf("%s %35s\n","SubTotal:",String.format("$%.2f", subTotal));
    System.out.println("Discounts...");
    if(humboldt >= 0.5) {
    System.out.printf("%s %10s\n","Humboldt Fog (Buy 1 Get 1 Free) :",String.format("-$%.2f",humboldt*12.5));
    }
    if(redHawk >= 0.5){

System.out.printf("%s %14s\n","Red Hawk (Buy 2 Get 1 Free) :",String.format("-$%.2f",redHawk*20.25/2));
    }
    else {
    	System.out.print("None\n" );
    }
   
  
   
	//  System.out.printf("%s %37s\n","Final Total:",String.format("$%.2f", subTotal - (total + total1)));
	//discounts//
	double humboldtDiscount = (int)((2 * humboldt)/2)* 0.5 * 25;
	
	double redhawkDiscount = (int)((2 * redHawk)/3) * 0.5 * 40.5; 
	
	
	double total = (double)subTotal - humboldtDiscount - redhawkDiscount;
	
	System.out.printf("%s %37s\n","Final Total:",String.format("$%.2f", (double) total));
	}
public static double readCheese(Scanner inp) {
    double cheese;
    cheese=inp.nextDouble();
    while(cheese<0 || cheese%0.5!=0) {
        if(cheese<0) {
        	
            System.out.print("Invalid input. Enter a value >= 0: ");
        }else {
            System.out.print("Invalid input. Enter a value that's multiple of 0.5 :");
        }
       
        cheese=inp.nextDouble();
    }
    return cheese;
    
	}
	}

	
	
	
	