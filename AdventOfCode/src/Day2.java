import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
	
	private static File myFile = new File("Day2Input.txt");
	
	public Day2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		try {
			
			Scanner input = new Scanner(myFile);
			
			for(int i = 0; input.hasNextLine(); i++) {
				
				list.add(new ArrayList<Integer>());
				
				String[] numbers = input.nextLine().split(" ");
				
				for(String number : numbers) {
					
					list.get(i).add(Integer.parseInt(number));
					
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numberOfSafeReports = 0;
		
		for(ArrayList<Integer> arrays : list) {
			
			boolean isSafe = isSafe(arrays);
			
			if(isSafe) numberOfSafeReports++;
			
			if(isSafe) {
				System.out.print("           ");
			} else {
				System.out.print("[NOT SAFE] ");
			}
			
			for(int number : arrays) {
				
				System.out.print(number + " ");
				
			}
			
			if(increasing(arrays)) System.out.print(" INCREASING ");
			if(decreasing(arrays)) System.out.print(" DECREASING ");
			if(correctDifferences(arrays) < 3) System.out.print(" NUMBER OF PROBLEM LEVELS: " + correctDifferences(arrays));
			
			System.out.println();
			
		}
		
		
		
		System.out.println("Number of Safe Reports: " + numberOfSafeReports);
		
	}

	public static boolean isSafe(ArrayList<Integer> list) throws IndexOutOfBoundsException{ 
		
		return (increasing(list) || decreasing(list)) && correctDifferences(list) < 3;
		
	}
	
	public static boolean increasing(ArrayList<Integer> list) {
		
		for(int i = 0; i < list.size() - 1; i++) {
			
			if(list.get(i) > list.get(i + 1)) return false;
			
		}
		
		return true;
	}
	
	public static boolean decreasing(ArrayList<Integer> list) {
		
		for(int i = 0; i < list.size() - 1; i++) {
			
			if(list.get(i) < list.get(i + 1)) return false;
			
		}
		
		return true;
	}
	
	public static int correctDifferences(ArrayList<Integer> list) {
		
		int problems = 0;
		
		for(int i = 0; i < list.size() - 1; i++) {
			
			if(Math.abs(list.get(i) - list.get(i + 1)) > 3 || Math.abs(list.get(i) - list.get(i + 1)) < 1) problems++;
			
		}
		
		return problems;
		
	}
	
}
