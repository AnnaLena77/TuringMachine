import java.util.*;
public class Main {
	
	public static void main (String [] args) {
		ArrayList<String> test1 = new ArrayList<String>();
		test1.add("0");
		TuringMachine tm = new TuringMachine(test1);
		
		// (memory, read) = (memory, write, step)
		// (0,1) = (0,1,"r")

		tm.addRule("01", "01r");
		tm.addRule("00", "00r");
		tm.addRule("0b", "1bl"); // Richtungswechsel
		tm.addRule("10", "01r");
		tm.addRule("11", "10l");
		tm.addRule("1b", "01r");
		
		//tm.addRule("10", "21l");
		//tm.addRule("11", "10l");
		//tm.addRule("1b", "01h");
		//tm.addRule("21", "21l");
		//tm.addRule("20", "20l");
		//tm.addRule("2b", "0br");
		
		 
		
		
		tm.start();
	}

}
