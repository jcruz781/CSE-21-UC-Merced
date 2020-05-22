package Lab20_1;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Random;
public class BobcatHotel {
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner input = new Scanner(System.in);
//ROOMS--------------------------------------------------------
    	double Single = 50.50;
    	double Double = 75.00;
    	double Queen = 100.75;
    	double King = 150.25;
    	double Suite = 225.50; 
    	double RoomCost = 0;
//Answers to Questions-----------------------------------------
    	int guests = 0;
    	int nights = 0;
    	int rooms = 0;
    	int AAAMember = 0, Club = 0;
    	int meal = 0;
// Club Member-------------------------------------------------
    	Random randGen = new Random();
    	int numDis = randGen.nextInt(10);
    	double PretotalDis = 0;
    	double SubDis = 0;
    	int CMD = 0;
    	double CMD1 = 0;
//MEALS--------------------------------------------------------
    	double Complementary = 00.00;
    	double Standard = 30.00;
    	double Deluxe = 50.00;
    	double Indulgence = 85.00;
    	double MealCost = 0;
//Rooms Available -------------------------------------------------------------------------------  
    	System.out.println("ROOM OPTIONS");
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	
    	System.out.println("1. Single @ " + (formatter.format(Single)) + " per night");
    	System.out.println("2. Double @ " + (formatter.format(Double)) + " per night");
    	System.out.println("3. Queen @ " + (formatter.format(Queen)) + " per night");
    	System.out.println("4. King @ " + (formatter.format(King)) + " per night");
    	System.out.println("5. Master Suite @ " + (formatter.format(Suite)) + " per night");
    	System.out.println();
 	
    	System.out.print("Number of guests: ");
    	guests = input.nextInt();
    	
    	System.out.print("Please choose your choice of room");
    	System.out.println(" (enter 1/2/3/4/5 corresponding to the options shown above): ");
    	rooms = input.nextInt();
    	
    	
    	
  //-----------------------------------------------------------------------------------------------------  	
    	System.out.print("Please enter the number of nights: ");
    	nights = input.nextInt();
    	
    	switch (rooms) {
    	case 1:
     	RoomCost = Single * nights;
     	break;
    	
    	case 2:
     	RoomCost = Double * nights;
     	break;
    	
    	case 3:
     	RoomCost = Queen * nights;
      	break;
    	
    	case 4:
     	RoomCost = King * nights;
     	break;
    	
    	case 5:
     	RoomCost = Suite * nights;
     	break;
     	
     	default:
    	 System.out.println("Not Available");
    	 break;
    	}
    	System.out.print("Are you an AAA member (Enter 1 for yes, 0 for no)?");
    	AAAMember = input.nextInt();
    	
    	System.out.print("Are you a club member (Enter 1 for yes, 0 for no)?");
    	Club = input.nextInt();
    	System.out.println();
    	if (AAAMember == 1);
    	 SubDis = PretotalDis;
   	
    	switch (Club) {
    	 case 0:
    	  break;
    	 case 1:
            	randGen.nextInt(10);
           	if (numDis < 4) {
            	System.out.print("Unfortunately, you didn't qualify for our ");
            	System.out.println("\"Stay 4 nights get 1 free promotion\". Better luck next time!");
            	System.out.println();
            	Club = 0;
            	
          	} if (numDis >= 4) {
            	System.out.print("Congratulations! You've qualified for our ");
            	System.out.println("\"Stay 4 nights get 1 free promotion.\"\r\n" +
             	"Discount will be applied during checkout depending on the number of days");
            	System.out.println();
            	CMD = nights / 4;
            	CMD1 = (RoomCost / nights) * CMD;	
          	}
      	}
       	
  	//MEAL?   	
    	System.out.println("MEAL PACKAGES (PRICES SHOWN PER NIGHT)");
    	System.out.println("0. Complementary @ $0 per guest");    	
    	System.out.println("1. Standard @ $30 per guest");
    	System.out.println("2. Deluxe @ $50 per guest");
    	if(rooms == 5) {
    	System.out.println("3. Indulgence @ $85 per guest");
    	}
    	System.out.println();
    	if(rooms == 5)   	
    	System.out.print("Please select your desired meal package (enter 0/1/2/3 corresponding to the options shown above): ");
    	else
	System.out.print("Please select your desired meal package (enter 0/1/2 corresponding to the options shown above): ");
    	meal = input.nextInt();
    	
    	if (meal == 0)
    	 MealCost = Complementary;
    	else if (meal == 1)
    	 MealCost = Standard;
    	else if (meal == 2)
    	 MealCost = Deluxe;
    	else if (meal == 3)
    	 MealCost = Indulgence;
    	else if (meal < 0 || meal >= 4)
    	 System.out.println("Not Available");
    	System.out.println();
    	double MealCost1 = MealCost * nights * guests;
    	double PreCost = MealCost1 + RoomCost;
    	SubDis = PreCost * 0.1;
        	
    	System.out.println("CHECKOUT");
    	System.out.println("Room Cost: \t\t  $" + RoomCost);
        
        System.out.println("Meal Cost: \t\t +$" + MealCost1);
    	System.out.println("Preliminary Total Cost:   $" + PreCost);
    	switch (AAAMember) {
    	case 0:
    	 break;
    	case 1:
    	 System.out.println("AAA Discount: \t\t -$" + SubDis);
    	 break;
    	}
    	switch (Club) {
    	case 0:
    	 break;
    	case 1:
        	System.out.println("Club Member Discount:  \t -$" + CMD1);
        	break;
    	}
    	
    	if (AAAMember == 0 && Club == 0)
    	 System.out.println("No Discounts Applied");
    	
    	if(AAAMember == 0)
    	 SubDis = 0;
    	double totalCost = PreCost - SubDis - CMD1;
    	System.out.println("Total Cost of Booking:	  $" + totalCost );
 }
}


