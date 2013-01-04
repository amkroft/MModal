package char2hex;

import javax.swing.JOptionPane;

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
		
		//http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
		String holder = (String)JOptionPane.showInputDialog(null,"Enter string to convert:","M*Modal Test",JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showMessageDialog(null,"Converted String:\n"+c.toHex(holder),"Results",JOptionPane.PLAIN_MESSAGE);
		
	}
	
}
