package bootcamp;

import java.util.ArrayList;

public class SpecialOdometer {

	private int numOfDigits;
	private ArrayList<String> validDistances;

	public SpecialOdometer(int numOfDigits) throws Exception {
		if(numOfDigits>9 || numOfDigits<1)
			throw new Exception();
		init(numOfDigits);
	}

	private void init(int numOfDigits) {
		this.numOfDigits=numOfDigits;
		validDistances=new ArrayList<>();
		generateValidDistances("", '1', 0);
		//displayAllValidDistances();
	}

	private void displayAllValidDistances() {
		int pos=0;
		for(String str:validDistances)
			System.out.println((pos++)+" > "+str);
	}

	public boolean isValidDistance(String dist) {
		return validDistances.contains(dist);
	}

	private void generateValidDistances(String str,char startingDigit, int num) {
		if(num==this.numOfDigits) {
			validDistances.add(str);
			return;
		}
		while(startingDigit<='9') {
			generateValidDistances(str+startingDigit,(char)(startingDigit+1),num+1);
			startingDigit=(char)(startingDigit+1);
		}
	}

	public int DifferenceOfDistances(String distance1, String distance2) throws DistanceException {
		if(!isValidDistance(distance1) || !isValidDistance(distance2))
			throw new DistanceException();
		return Math.abs(validDistances.indexOf(distance1) - validDistances.indexOf(distance2));
	}

	public String nextReading(String reading) throws DistanceException {
		if(!isValidDistance(reading))
			throw new DistanceException();
		return nextNthReading(reading, 1);
	}



	public String prevReading(String reading) throws DistanceException {
		if(!isValidDistance(reading))
			throw new DistanceException();
		return prevNthReading(reading, 1);
	}



	public String nextNthReading(String reading, int n) throws DistanceException {
		if(!isValidDistance(reading))
			throw new DistanceException();
		int index = validDistances.indexOf(reading);
		int resIndex = (index+n)%validDistances.size();
		return validDistances.get(resIndex);
	}



	public String prevNthReading(String reading, int n) throws DistanceException {
		if(!isValidDistance(reading))
			throw new DistanceException();
		int index = validDistances.indexOf(reading);
		int resIndex = (validDistances.size()+index-(n%validDistances.size()))%validDistances.size();
		return validDistances.get(resIndex);
	}

}

class DistanceException extends Exception {
	private final static String msg="Distance is not valid!";
	@Override
	public String toString() {
		return this.msg;
	}
}

class Main {
	public static void main(String a[]) throws Exception {
		SpecialOdometer specialOdometer=new SpecialOdometer(5);
		System.out.println(specialOdometer.DifferenceOfDistances("12345","56789"));
		System.out.println(specialOdometer.nextReading("45678"));
		System.out.println(specialOdometer.prevReading("12345"));
		System.out.println(specialOdometer.nextNthReading("24579",126));
		System.out.println(specialOdometer.prevNthReading("25678",126));
		System.out.println();
	}
}
