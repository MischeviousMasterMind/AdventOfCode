import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Day1 {

	static File myFile = new File("Day1Input.txt"); 

	public Day1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// declaration of two integer ArrayLists used to store the two different lists
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		try {
			
			System.out.println("Currently scanning [" + myFile + "]...");
			Scanner input = new Scanner(myFile);
			
			// scans the input file and stores the numbers into the two lists
			while(input.hasNextLine()) {
				
				list1.add(input.nextInt());
				System.out.print(list1.get(list1.size() - 1) + "   ");
				
				list2.add(input.nextInt());
				System.out.println(list2.get(list2.size() - 1));
				
			}
			
			System.out.println("Finished scanning!");
			System.out.println();
			
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Now sorting...");
		
		// sorts the ArrayLists in ascending order using a Comparator object and the sort method in ArrayLists
		Comparator<Integer> ascending = (a, b) -> {return a - b;};
		
		list1.sort(ascending);
		list2.sort(ascending);
		
		// prints out the sorted lists to confirm
		for(int i = 0; i < list1.size(); i++) {
			
			System.out.print(list1.get(i) + "   ");
			System.out.println(list2.get(i));
			
		}
		
		// declares and initializes total distance
		int totalDistance = 0;
		
		System.out.println("Calculating total distance...");
		
		// adds up the absolute difference of elements with the same index from the two different lists
		for(int i = 0; i < list1.size(); i++) {
			
			totalDistance += Math.abs(list1.get(i) - list2.get(i));
			
		}
		
		// prints out the answer
		System.out.println("Total distance: " + totalDistance);
		
		int index = 0;
		int similarityScore = 0;
		
		for(int obj : list1) {
			
			int count = 0;
			
			while(obj >= list2.get(index) && index < list2.size()){
				
				if(obj == list2.get(index)) count++;
				index++;
				
			}
			
			similarityScore += obj * count;
			
		}
		
		System.out.println("Similarity Score: " + similarityScore);
		
	}
	
	
}
