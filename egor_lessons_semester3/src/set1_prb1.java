
// libraries
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class set1_prb1 {
	
	public static String getCcCompany (String ccNum) {
		if (ccNum.charAt(0) == '4') {
			return "Visa";
		}
		
		String first2 = ccNum.substring(1);
		switch (first2) {
		case ("34"):
		case ("37"):
			return "Amex";
			break;
		case ("51"):
		case ("52"):
		case ("53"):
		case ("54"):
		case ("55"):
			return "Mastercard";
			break;
		default:
			return "Invalid";
		
		}
		
	}
	
	public static boolean validNum (long ccNum) {
		
		// declarations
		int lenCcNum = (int) Math.log10(ccNum) + 1;
		long toAdd;
		long pow10;
		int sum = 0;
		
		for (int i = 0; i < lenCcNum - 1; i++) {
			pow10 = (long) Math.pow(10, i + 1);
			toAdd = Math.floorMod(ccNum, pow10);
			System.out.printf("Cycle %d; Mod: %d.\n", i, toAdd);
			toAdd /= (pow10 / 10);
			toAdd += toAdd * (i % 2);
			System.out.printf("Cycle %d; toAdd %d.\n", i, toAdd);
			sum += (int) toAdd;
		}
		
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean checkValid (String ccNum) {
		
		// declarations
		String chars = "1234567890-";
		ArrayList<Integer> hyphenLoc = new ArrayList(0);
		boolean inChars;
		
		if (getCcCompany(ccNum).equals("Invalid")) {
			return false;
		}
		
		for (int i = 0; i < ccNum.length(); i++) {
			inChars = false;
			if (/*the char is not in chars*/) {
				return false;
			} else if (ccNum.charAt(i) == '-') {
				hyphenLoc.add(i + 1);
			}
		}
		
		for (int i = 1; i < hyphenLoc.size(); i++) {
			if (hyphenLoc.get(i - 1) + hyphenLoc.get(0) != hyphenLoc.get(i)) {
				return false;
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		// declarations
		String ccNumber;
		int ccLength;
		String ccCompany;
		boolean validNumber;

		// scanner 
		Scanner kb = new Scanner(System.in);
		
		// getting the credit card number
		System.out.printf("Enter a credit card number: ");
		ccNumber = kb.next();
		
		// getting the credit card's length
		ccLength = ccNumber.length();
		
		// getting the credit card company
		ccCompany = getCcCompany(ccNumber);
		
		if (ccCompany.equals("INVALID")) {
			System.out.println(ccCompany);
		} else {
			
			// checking for the credit card's validity
			isValid = validCheck(ccNumber);
			
			if (validNumber) {
				System.out.println(ccCompany);
			} else {
				System.out.println("INVALID_VALUE");
			}
		}
	}

}
