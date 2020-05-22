package Lab21_02;
import java.util.Scanner;
public class CheeseShop1 {

	public static void main(String[]args) { 
		Scanner input =new Scanner(System.in);
	
	System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
    System.out.println("Humboldt Fog: $25.0 per pound");
    System.out.println("Red Hawk: $40.5 per pound");
    System.out.println("Teleme: $17.25 per pound\n");
	
     //price of each type per pound
    double humboldtPrice = 25.0;
    double redHawkPrice = 40.5;
    double telemePrice = 17.25;

    System.out.println();

    //get the value of each type one by one and validation for each input
    System.out.print("Enter the amount of Humboldt Fog in lbs: ");
    double humboldtFogQty = Double.parseDouble(input.nextLine());

    while(humboldtFogQty <= 0 || humboldtFogQty % 0.5 != 0){
        if(humboldtFogQty <= 0){
            System.out.print("Invalid input. Enter a value >=0: ");
        }
        else {
            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
        }
        humboldtFogQty = Double.parseDouble(input.nextLine());
    }
    
    //convert input lns to packets
    int humboldtFogPacket = (int)(humboldtFogQty / 0.5);

    System.out.print("Enter the amount of Red Hawk in lbs: ");
    double redHawkQty = Double.parseDouble(input.nextLine());

    while(redHawkQty <= 0 || redHawkQty % 0.5 != 0){
        if(redHawkQty <= 0){
            System.out.print("Invalid input. Enter a value >=0: ");
        }
        else {
            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
        }
        redHawkQty = Double.parseDouble(input.nextLine());
    }

    //convert input lns to packets
    int redHawkPacket = (int)(redHawkQty / 0.5);

    System.out.print("Enter the amount of Teleme Fog in lbs: ");
    double telemeQty = Double.parseDouble(input.nextLine());

    while(telemeQty<= 0 || telemeQty % 0.5 != 0){
        if(telemeQty <= 0){
            System.out.print("Invalid input. Enter a value >=0: ");
        }
        else {
            System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
        }
        telemeQty = Double.parseDouble(input.nextLine());
    }

    //convert input lns to packets
    int telemePacket = (int)(telemeQty / 0.5);

    //ask user if need to show itemized list
    System.out.print("Display the itemized list? (1 for yes) ");
    int choice = Integer.parseInt(input.nextLine());

    //calculate extra packet required.
    int humboldtFogExtraPacket = humboldtFogPacket;
    int redHawkExtraPacket = redHawkPacket / 2;

    //get the total packet count 
    double humboldtFogTotalPacket = humboldtFogPacket + humboldtFogExtraPacket;
    double redHawkTotalPacket = redHawkPacket + redHawkExtraPacket;

    //if user wants to see the list
    if(choice == 1){
        //print the details
        System.out.println((humboldtFogTotalPacket/2) + " of Humboldt Fog @ $" + humboldtPrice + " = $" + (humboldtFogTotalPacket * (humboldtPrice/2)));
        System.out.println((redHawkTotalPacket/2) + " of Red Hawk @ $" + redHawkPrice + " = $" + (redHawkTotalPacket * (redHawkPrice/2)));
        System.out.println(telemeQty + " of Teleme @ $" + telemePrice + " = $" + (telemePacket * (telemePrice/2)));
    }
    
    //calculate the sub total
    double subTotal = (humboldtFogTotalPacket * (humboldtPrice/2)) + (redHawkTotalPacket * (redHawkPrice/2)) + (telemePacket * (telemePrice/2));
    System.out.println("Sub total:                        $" + subTotal);
    System.out.println("Discounts...");
    //print the discount details
    System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + (humboldtFogExtraPacket * (humboldtPrice/2)));
    System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$" + (redHawkExtraPacket * (redHawkPrice/2)));
    //calculate total discount
    double discount = (humboldtFogExtraPacket * (humboldtPrice/2)) + (redHawkExtraPacket * (redHawkPrice/2));
    //print the total price
    System.out.println("Total:                            $" + (subTotal - discount));
}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	