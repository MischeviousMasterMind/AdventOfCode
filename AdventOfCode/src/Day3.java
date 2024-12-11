import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

	private static File myFile = new File ("Day3Input.txt");
	
	
	public Day3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<String>();
		
		try {
			
			Scanner input = new Scanner(myFile);
			
			while(input.hasNextLine()) {
				
				list.add(input.nextLine());
				
			}
			
			int total = 0;
			int index = 1;
			
			for(String line : list) {
				
				total += compute(line);
				
				System.out.println();
				System.out.println("[" + index + "] --------------- " + total);
				System.out.println();
				
				index++;
				
			}
			
			System.out.println("The total is: " + total);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static int compute(String input) {
		
		int total = 0;
		
		String line = input;
		int index = 0;
		
		while(line.contains("mul(") && index < line.length() - 4) {
			
			int increments = 0;
			
			String data = "";
			
			index = line.indexOf("mul(") + 4;
			
			while(!line.substring(index, index + 1).equals(")") && increments < 7) {
				
				data += line.substring(index, index + 1);
				index++;
				increments++;
				
			}
			
			if(data.contains(",")) {
				
				
				String[] numbers = data.split(",");
				
				try {
					total += Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
					
					System.out.print("mul(" +  numbers[0] + "," + numbers[1] + ")");
					
					for(int i = 0; i < 20 - increments - 5; i++) System.out.print(" ");
					
					System.out.println(total);
					
				} catch(NumberFormatException e) {
					
					System.out.println("BREAK!");
				}
			
			}
			
			line = line.substring(index);
			
		}
		
		return total;
		
	}

}
