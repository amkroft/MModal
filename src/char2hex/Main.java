package char2hex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Candidate test for M*Modal
 * 
 * Takes a string of text and converts it to hex values as described
 *  by M*Modal's candidate test.
 * 
 * @author Amanda Kroft
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] table = new char[]{
			'e','t','a','o','i','n','s','h',
			'r','d','l','c','u','m','w','f',
			'g','y','p','b','v','k','j','x',
			'q','z'			
		};
		
		Conversion c = new Conversion(table);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter string to convert: ");
		String holder;
		try {
			holder = in.readLine();
			System.out.println("Converted string:\n\t"+c.toHex(holder));
		} catch (IOException e) {
			System.err.println("Error reading your input.  Exiting.");
			e.printStackTrace();
		}		
	}
	
}
