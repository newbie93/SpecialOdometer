package bootcamp;

import java.util.ArrayList;

public class SpecialOdometer {
	
	private int numOfDigits;
	private ArrayList<String> validDistances;
	
	public SpecialOdometer(int numOfDigits) {
		this.numOfDigits=numOfDigits;
		validDistances=new ArrayList<>();
		generateValidDistances("", '1', 0);
		//for(String str:validDistances)
		//	System.out.println(str);
	}
	
	private void generateValidDistances(String str,char startingDigit, int num) {
		if(num==this.numOfDigits) {
			validDistances.add(str);
			return;
		}
		while(startingDigit<='9')
			generateValidDistances(str+startingDigit,(startingDigit=(char)(startingDigit+1)),num+1);
	}
}

class Main {
	public static void main(String a[]) {
			//ystem.out.println(x);
		SpecialOdometer specialOdometer=new SpecialOdometer(8);
	}
}
