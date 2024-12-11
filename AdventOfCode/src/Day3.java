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
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void multiplication(String input) {
		
		String line = input;
		int index = 0;
		
		while(line.contains("mul(")) {
			
			
			
		}
		
	}

}
