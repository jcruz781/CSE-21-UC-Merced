 package Project01_21;
import java.util.Scanner;


public class Shop1 {
	private Item[] itemsArr;
	private double dollarDisc = 0;
	private double rateDisc = 0;
	Scanner scan = new Scanner(System.in);


	public Shop1() {

	}

	public static String numSuffix(int i) {
		int rem = i % 10;
		switch(rem) {
		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return (i + "th");
		case 1:
			if (i % 100 != 11)
				return (i + "st");
			else
				return (i + "th");
		case 2: 
			if (i % 100 != 12)
				return (i + "nd");
			else 
				return (i + "th");
		case 3:
			if(i % 100 != 13)
				return(i + "rd");
			else
				return(i + "th");
		default:
			break;
		}
		return "";

	}
	public boolean checkAmountValidity(int number) {
		if( number < 0) {
			System.out.print("Invalid input. Enter a value >= 0: ");;
			return true;
		}
		return false;

	}
	public boolean checkAmountValidity(double number) {
		if(number < 0) {
			System.out.print("Invalid input. Enter a value >= 0: ");
			return true;
		}
		return false;
	}

	public boolean checkPercentRate(double percentRate) {
		if (percentRate < 0 || percentRate > .5) {
			System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
			return true;
		}
		return false;
	}


	//Setup Shop (I)
	public void setUpShop(int numItems) {
		itemsArr = new Item[numItems];

		//for loop needed because when you enter items after that it has to keep looping

		for (int i = 0; i < numItems; i++) { 

			System.out.print("Enter name of the " + numSuffix(i+1) + " product: "); //2. For each item
			String name = scan.next(); // Ask for number of the item

			System.out.print("Enter the per package price of " + name + ": ");
			double price = 0;
			boolean priceFlag = true;
			while(priceFlag) {
				price = scan.nextDouble();
				priceFlag = checkAmountValidity(price);
			}

			System.out.print("Enter the number of packages ('x') to qualify for Special Discount \n(buy 'x' get 1 free) for " + name + 
					" , or 0 if no Special Discount offered: ");

			//3. Discount
			int discountPckg = 0;
			boolean discFlag = true;
			while(discFlag) {
				discountPckg = scan.nextInt();
				discFlag = checkAmountValidity(discountPckg);
			}
			//lets initialize array with Item objects
			itemsArr[i] = new Item(name, price, discountPckg);
		}
		System.out.print("\nEnter the dollar amount amount to qualify for Additional Discount (or 0 if none offered): ");
		dollarDisc = scan.nextDouble();
		if(dollarDisc != 0) {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			boolean flag = true;
			while(flag) {
				rateDisc = scan.nextDouble();
				flag = checkPercentRate(rateDisc);

			}
		}
	}

	//Buy Items (II)

	public void Buy() {
		for (int i = 0; i < itemsArr.length; i++) {
			System.out.print("Enter the number of " + itemsArr[i].getName() + " packages to buy: ");
			boolean flag = true;
			int amount = 0;
			while(flag) {
				amount = scan.nextInt();
				flag = checkAmountValidity(amount);
			}
			itemsArr[i].setNumPurchased(amount);
		}
	}

	// List of Items (III)
	public void itemizedList() {
		int amount = 0;
		for(int i = 0; i < itemsArr.length; i++) {
			amount += itemsArr[i].getAmount();
			if (itemsArr[i].getAmount() > 0) {
				double price = itemsArr[i].getPrice();
				double amt = itemsArr[i].getAmount();
				String name = itemsArr[i].getName();

				System.out.printf("%.1f packages of %s @ $%.2f per pkg = $%.2f\n", amt, name, price, price * amt);
			}

		}
		if(amount == 0)
			System.out.println("No items were purchased");
	}

	//Check Out (IV)
	public void checkout() {
		double subTotal = 0, specialDisc = 0;
		for(int i = 0; i < itemsArr.length; i++) {
			subTotal += itemsArr[i].getPrice() * itemsArr[i].getAmount();
		}
		System.out.println("Original Sub Total:              $" + subTotal);

		for(int i = 0; i < itemsArr.length; i++) {
			specialDisc += itemsArr[i].getSpecialDisc();
		}
		if(specialDisc == 0)
			System.out.println("You did not qualify for special discounts.");
		else 
			System.out.println("Special Discounts:               -$" + specialDisc);
		System.out.println("New Sub Total:                    $" + (subTotal = subTotal - specialDisc));

		if(dollarDisc == 0 || subTotal < dollarDisc){
			System.out.println("You did not qualify for an Additional Discount");
		}else if(subTotal >= dollarDisc) {
			double percentageDisc = subTotal * rateDisc;
			subTotal = subTotal - percentageDisc;
			System.out.println("Additional " + (rateDisc*100) + "% Discount:       -$" + percentageDisc);
		}
		System.out.println("Final Sub Total:                  $" + subTotal);
		System.out.println("\nThanks for coming!");
	}

	public void displayOptions() {
		System.out.println("\nThis program supports 4 functions:");
		System.out.println("1. Setup Shop");
		System.out.println("2. Buy");
		System.out.println("3. List Items");
		System.out.println("4. Checkout");
		System.out.print("Please choose the function you want: ");
	}
	public void runShop() {
		boolean[] boolArr = {false, false};
		String[] responseArr = {"\nShop is not set up yet!", "\nYou have not bought anything!"};


		while(true) {
			displayOptions();
			int userChoice = scan.nextInt();

			if(userChoice == 1) {
				System.out.print("Please enter the number of items to setup shop: ");

				int numItems = scan.nextInt();
				setUpShop(numItems);
				boolArr[0] = true;
			}
			if(userChoice == 2 && boolArr[0]) {
				Buy();
				boolArr[1] = true;
			}else if(userChoice == 2 && !boolArr[0]) {
				System.out.println(responseArr[0]);
			}
			if(userChoice == 3 && boolArr[1] && boolArr[0]) {
				itemizedList();
			}else if(userChoice == 3 && !boolArr[0]) {
				System.out.println(responseArr[0]);
			}else if(userChoice == 3 && !boolArr[1]) {
				System.out.println(responseArr[1]);
			}
			if(userChoice == 4 && boolArr[1] && boolArr[0]) {
				checkout();
				System.out.println("---------------------------------------------------");
				System.out.println("\nWould you like to re-run (1 for yes, 0 for no)? "); 
				int userInput = scan.nextInt();
				System.out.println("---------------------------------------------------");
				if (userInput == 1)
					runShop();
				else 
					break;
			}
			else if(userChoice == 4 && !boolArr[0]) {
				System.out.println(responseArr[0]);

			}
			else if(userChoice == 4 && !boolArr[1]) {			
				System.out.println(responseArr[1]);

			}

		}
	}

}			

