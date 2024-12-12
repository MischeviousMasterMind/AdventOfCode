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
				System.out.println("[" + index + "] ------------------------- " + total);
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
			
			line = line.substring(index);
			index = 0;
			
			boolean validFormat = true;
			
			int increments = 0;
			
			String data = "";
			
			index = line.indexOf("mul(") + 4;
			
			while(!line.substring(index, index + 1).equals(")")) {
				
				data += line.substring(index, index + 1);
				
				try {
					
					Integer.parseInt(line.substring(index, index + 1));
					
				} catch (NumberFormatException e) {
					
					if(!line.substring(index, index + 1).equals(",")) {
						
						validFormat = false;
						break;
					}
					
				}
				
				index++;
				increments++;
				
			}				
			
			String[] numbers = data.split(",");
			
			if(validFormat){
				try {
					
					total += Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
						
				} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
					
				}
			}
			
			
		}
			
			
		
		return total;
		
	}

	public String clean(String string) {
		
		if(!string.contains("do()")) return "";
		
		while(string.contains("don't()")){
			
			if(!string.contains("do()")) break;
			
			string.substring();
			
		}
		
		return string;
		
	}
	
}
