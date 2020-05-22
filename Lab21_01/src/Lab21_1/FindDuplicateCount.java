package Lab21_1;
import java.util.Scanner;

public class FindDuplicateCount {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2}; //there is a total of 11 index
		
		for(int i=0; i<arr.length; i++){ // i represents the index

			int c = 0; // c represents the duplicates

			for(int j=i+1; j<arr.length; j++){ // j represents the index adding 1 to it

			if(arr[i]==arr[j])  //if value equals to the value

			c++; //counts the duplicates//

			}

			if(c==0) // if zero duplicates then prints statement below//                    

			System.out.println("There are no duplicates with value "+arr[i]+" beyond index "+i);

			else if(c==1) //if there is 1 duplicate of the value then prints the statement below//

			System.out.println("There is only "+c+" more occurances of value "+arr[i]+" starting index "+i);

			else //if more that one duplicate of the value then prints the statement below//

			System.out.println("There are "+c+" more occurances of value "+arr[i]+" starting index "+i);


			}

	}

}
