import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree {

	//I have made the assumption that all values must be separated by a comma, last element excluded. Moreover, an element can receive or be detracted of multiple indentations using multiple '[' or ']' on a single element (but there can not be spaces between the multiple parenthesis or it is considered part of the string 
	
	public static void main(String[] args){

		String input = ""; //manually insert input string here if console input is commented out
				
//###################### comment out this section if you don't want to manually input strings #####################
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		System.out.print("Insert pattern: ");
		try {
			input = reader.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
//##################################################################################################################
			
		if(verifyTree(input)) {
			printTree(input);
		}
		else {
			System.out.println("Invalid!");
		}
	}
	
	// This method prints the given tree on screen, if it has been verified to be an acceptable input
	public static void printTree(String input) {
		
		input=input.trim();
		String[] elements = input.split(","); // O(n) where n is length of string
		boolean first = true;
		int removeIndent = 0; // I introduce this variable to determine if an indent is to be removed or not, and it is an int value and not a boolean so multiple indents can be removed at once 
		String spaces = ""; // variable that determines the indentation given to the element
		for(int i=0;i<elements.length;i++) {
			String element = elements[i].trim(); //Removal of space before and after the element
			if(element.length()>0) { //I proceed to value a possible change of indentation of an element only if the element is not an empty space
				while(element.charAt(0) == '[') { //trimming of prefixed '['s and consequential increment of indentation
					if(first) {
						first=false;
					}
					else {
						spaces = spaces+"    ";
					}
					if(element.length()>1) { //verifying length of string prior to executing substring
						element = element.substring(1);
					}
					else {
						element = "";
						break;
					}
				}
				while(element.length()>0 && element.charAt(element.length()-1) == ']') { //trimming of suffixed ']'s and consequential marking for decrement of indentation
					removeIndent++;
					if(element.length()>1) { //verifying length of string prior to executing substring
						element = element.substring(0, element.length()-1);
					}
					else {
						element="";
						break;
					}
				}
				System.out.println(spaces+element);
				if(removeIndent>0 && i<elements.length-1) { //decrement of indentation for a total of removeIndent levels
					for(int k = 0; k<removeIndent; k++)
					spaces = spaces.substring(4,spaces.length());
					removeIndent = 0;
				}
			}
			else {
				System.out.println(spaces+element);
			}
		}
		
	}
	
	// This method verifies if the formatting of the given string can correctly forms a tree
	public static Boolean verifyTree(String given) {
		given=given.trim();
		if(given.charAt(0)=='[' && given.trim().charAt(given.length()-1)==']') {   //If the first and last chars of the string don't open and close the structure, it is invalid. 
			String[] elements = given.split(","); //O(n) where n is the length of the string.
			int verify = 0;
			int length = elements.length-1;
			int j = 0;
			for (int i=0; i<=length;i++) { //O(e) where "e" are the number of individual elements to print
				if (elements[i].trim().length() > 0) {
					int top = 0;
					int bottom = elements[i].trim().length()-1;
					while (elements[i].trim().charAt(top)=='[') {
						if(elements[i].trim().length()-top==1) { //verifying char top is pointing to prior incrementing it
							verify++;
							break;
						}
						verify++; 
						top++;
					} // increments for every opened [
					while (elements[i].trim().charAt(bottom)==']') {
						if(elements[i].trim().length()-bottom==elements[i].trim().length()) { //verifying char bottom is pointing to prior decrementing it
							verify--;
							break;
						}
						verify--;
						bottom--;
					} // decrements for every closed ]
				}
				j=i;
				if (verify<0) {
					break; // It is invalid if more parenthesis are closed than those that have been opened
				}
				if (verify==0 && i<length) {
					break; // I am assuming that when the first opened bracket closes, there can not be any more elements in the input string
				}
			}
			if (verify==0 && j == length) { // the structure of the input is correct and can be printed.
				return true;
			}
			else { // the structure of the input is invalid.
				return false;
			}
		}
		else {
			return false;
		}
		
	}

}
