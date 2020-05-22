package Lab21_1;
import java.util.Scanner;
public class ReminderFunc {  //class

	public static void main(String[] args) {  //method (everyone, one per class, returns nothing, name, array of parameters)
		 
		Scanner input = new Scanner(System.in);  //to get input from user
		int maxnum, divisor;  //declaring variables
		
		System.out.print("Please enter the max number: "); //statement to ask for max number
		
		maxnum = input.nextInt(); //sample size to input any number

		if(maxnum<0){ //statement checks if the maxnum is negative//

			do {  //the do while loop will execute will the user input 0 or positive number//
			
		     System.out.print("Invalid input. Please enter a valid max number (>=0): ");

		     maxnum = input.nextInt(); //sample size to input another number to continue//
			} while(maxnum<0); // checks again if negative
		}

		System.out.print("Please enter the divisor: "); //statement to ask for divisor
		divisor = input.nextInt(); //sample size to input any number
		
		if(divisor<=0){ //checks for negative number or zero//
			
			do {
				System.out.print("Invalid input. Please enter a valid divisor (>0): ");//get valid input from user//
				divisor = input.nextInt();
			}while(divisor <= 0); //checks for negative or zero//
           
	}   
	System.out.println("Multiples of "+ divisor +" between 1 and "+maxnum+" (inclusive) are:"); //statement to print out//

    int count = 0;// declares count variable to track the multiplies p rinted on console


    for(int i = 1; i <= maxnum; i++){// iterate from 1 to maxnum inputed

        if(i % divisor == 0){ // checks for divisible i.e for divisor or not by using % as given in problem


          System.out.println(i);// Displays the multiplier

            count++;  // counts every multiple  (increment by 1)

        }

    }

    

    if(count == 0)// Checks whether count will be 0 which means there are no multipliers


        System.out.println("No number were found.");//print statement if zero was inputed//

}

}
			