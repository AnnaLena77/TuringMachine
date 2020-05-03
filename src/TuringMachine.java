import java.util.*;
public class TuringMachine {
	private ArrayList<String> band;
	private HashMap<String, String> rules = new HashMap<String, String>();
	
	private String memory = "1";
	private int currentPosition = 0;
	
	public TuringMachine(ArrayList<String> band) {
		this.band = band;
	}
	
	public void start() {
		boolean work = true;
		while (work){
			// lesen neuen Status
			String newState = readNewStatus();
			
			// schauen ob neuer Status einen wert in den regeln hat
			String toWrite = rules.get(newState);
			if (toWrite != null) {
				
				
				// memory/write/step
				// 1. write 
				String writeValue = String.valueOf(toWrite.charAt(1));
				try {
					band.set(currentPosition, writeValue);
				}
				catch(Exception e) {
					// wenn außerhalb des Index
					if (currentPosition < 0) {
						// Potentiell, wenn b to write, no write at all
						band.add(0, writeValue);
					}
					else if (currentPosition >= band.size()) {
						// Potentiell, wenn b to write, no write at all
						band.add(writeValue);
					}
				}
				
				// 2. save memory
				memory = String.valueOf(toWrite.charAt(0));
				
				// 3. step to next position
				char step = toWrite.charAt(2);
				switch(step) {
					case('r'):
						currentPosition ++;
						break;
					case('l'):
						currentPosition --;
						break;
				}
			}
			else {
				work = false;
			}
			
			System.out.println(Collections.reverse(band).toString());
		}
	
	}
	
	public void addRule(String readState, String writeState) {
		rules.put(readState, writeState);
	}

	private String readNewStatus() {
		// 01 --> memoryValueXReadValue
		String newState = "";
		newState += memory;
		
		try {
			newState += band.get(currentPosition);
		}
		catch (Exception e) {
			newState += "b";
		}
		
		
		return newState;
	}
	
}
