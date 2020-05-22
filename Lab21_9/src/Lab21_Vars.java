import java.util.*;


public class Lab21_Vars {

	public static void main(String[] args) {

		int i = 0;
		int j = 0;
		int var0, var1;
		
		// Fix 1: Correctly typecast 5.0 to an int so it can assigned to var3.
		int var2 = 0, var3 = (int)5.0;//inserted an (int) to properly 
		                              // assign var3
		//int var2 = 0, var3 = 5.0;//
		
		// Fix 2: Correctly declare a variable as an array.
		int[] arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};// inserted [] to declare array
		
		//int arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};//
		
		double[] arrd0 = {0.0, 1.0, 2.0, 3.0, 4.0};
		
		// Fix 3: What's wrong with temp? Fix it.
		int temp = 0;// temp variable is to be declared before the 
		             // if statement not inside the if
		if(i < j) {
			System.out.println("Temp is " + temp);
		} else {
			temp = 1;
			System.out.println("Temp is " + temp);
		}
		//if (i < j) {
			//int temp = 0;
		//	System.out.println("Temp is " + temp);
		//} else {
			//temp = 1;//
			//System.out.println("Temp is " + temp);//
		//}//
		
		// Fix 4: Correctly calculate square of sums and print it as total.
		int total = 0;// this variable is to declared before the 
		              // for loop and not inside// 
		for(i = 0; i < 10; i++) {
			total += i*i;
		}
		
		//for (int i = 0; i < 10; i++) {
		//	int total = 0;
		//	total += i*i;//
		//}
		
		System.out.println("i value is " + i);
		System.out.println("Total is " + total);
		
		// Fix 5: Figure out the logical error in lines 36-42, and correct it.
		
		Cheese jack;
		Cheese monterey = new Cheese("Monterey");
		jack = monterey;
		//THE ERROR WAS BECAUSE THERE IS NO CLASS named Cheese.java
		
		System.out.println("Monterey name is: ");
		System.out.println("Monterey name is " + monterey.getName());		
		jack.setName("Jack");

		
	    System.out.println("Jack name is " + jack.getName());
	  
	    System.out.println("Monterey name is still " + monterey.getName());
	
		// Fix 6: Make the following code shorter by combining redundant 
		//        (unnecessary/duplicate) statements
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = input.nextInt();// This line of code is needed to be able to input and later print out
		                           // the first number (Fix 7)
		
		{
			System.out.print("Enter second number: "); //These two lines of code need to be outside of the if 
			int num2 = input.nextInt();// statement so that user can input the second number
			        
			
			        if(num1 > var3)
			        	System.out.println("First is greater"); //This line goes after the if statement when num1 is greater than the var3
			        else
			        	System.out.println("First is Less than or equal");// The num1 is equal to first or less
			        
			        
			        if(num2 < var3)
			        	System.out.println("Second is Less"); //The second number is less than  var3
			        else
			        	System.out.println("Second is greater than or equal to");// Then the num2 is greater or equal than var3
			        
			     System.out.println("The first number was " + num1);// This prints out the num1
			     
			
		// if (input.nextInt() > var3) { //
		//System.out.print("Enter second number: ");//
		// int num2 = input.nextInt(); //
			
			//System.out.println("First is greater");//
			//if (num2 < var3)//
			//	System.out.println("Second is Less than");//
		//	else
	//			System.out.println("Second is Greater or equal");//
	//	} else {
		//	System.out.print("Enter second number: ");
		//	int num2 = input.nextInt();
		//	System.out.println("First is Less than or equal");
		//	if (num2 < var3)
		//		System.out.println("Second is Less than");
		//	else
		//		System.out.println("Second is Greater or equal");
		}
		
		// Fix 7: Print out the first number entered by the user
		//        (Hint - You will need to modify the above code)
		
	}

}
