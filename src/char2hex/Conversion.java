package char2hex;

import java.util.HashMap;

/*
 * Class for all conversion of characters and strings.
 * Includes string -> binary, binary -> hex, and 
 * adding in any necessary padding and spacing.
 * 
 * @author Amanda Kroft
 */
public class Conversion {
	private char[] table;
	private HashMap<Character, String> map;
	private HashMap<String, Character> hexMap;
	
	public Conversion(char[] table){
		this.table = table;
		map = new HashMap<Character, String>();
		hexMap = new HashMap<String, Character>();
		createBinary();
		createHexMap();
	}
	
	//Generates the binary value for each char and saves in HashMap
	private void createBinary(){
		//Find highest power of 2 to be used
		int highestPower = -1;
		while(Math.pow(2,highestPower) < table.length){
			highestPower++;
		}
		highestPower--;
		
		//Convert to binary and store in map
		int intHolder;
		String strHolder;
		for(int i = 0; i < table.length; i++){
			strHolder = "";
			intHolder = i+1;
			for(int j = highestPower; j >= 0; j--){
				if(Math.pow(2, j) <= intHolder){
					strHolder += "1";
					intHolder = intHolder - (int)Math.pow(2,j);
				}else if(strHolder != "")
					strHolder += "0";
				
			}
			map.put(table[i], strHolder);
		}
	}
	
	private void createHexMap(){
		hexMap.put("0001", '1');
		hexMap.put("0010", '2');
		hexMap.put("0011", '3');
		hexMap.put("0100", '4');
		hexMap.put("0101", '5');
		hexMap.put("0110", '6');
		hexMap.put("0111", '7');
		hexMap.put("1000", '8');
		hexMap.put("1001", '9');
		hexMap.put("1010", 'a');
		hexMap.put("1011", 'b');
		hexMap.put("1100", 'c');
		hexMap.put("1101", 'd');
		hexMap.put("1110", 'e');
		hexMap.put("1111", 'f');
	}
	
	//Converts String to binary value using binary map
	public String toBinaryString(String s){
		String result = "";
		for(char c : s.toCharArray()){
			result += map.get(c);
		}
		return result;
	}
	
	//Pads in zeros and adds spaces to binary string
	public String polishString(String s){
		String result = "";
		
		if(s.length() % 4 != 0){
			for(int i = 0; i < s.length() % 4; i++){
				s+="0";
			}
		}
		
		for(int i = 0; i < s.length(); i+=4){
			result += s.substring(i, i+4)+" ";
		}
		
		return result.trim();
	}

	//Converts binary string to hex values using hexMap
	public String binaryToHex(String binary){
		String hex = "";
		String[] holder = binary.split(" ");
		for(String s : holder){
			hex += hexMap.get(s);
		}
		return hex;
	}
	
	//Pads in a zero if needed, adds in "0x", and adds in spaces to hex string
	public String polishHex(String s){
		String result = "";
		if(s.length() % 2 == 1)
			s+="0";
		
		for(int i =0; i < s.length(); i+=2){
			result += "0x"+s.substring(i,i+2)+" ";
		}
		return result.trim();
	}
	
	//Combines together the string -> binary -> hex and polishing
	public String toHex(String s){
		String result;
		
		result = toBinaryString(s);
		result = polishString(result);
		result = binaryToHex(result);
		result = polishHex(result);
		
		return result;
	}
	
	//Returns the map of characters to binary values
	public HashMap<Character, String> getMap(){
		HashMap<Character, String> clone = new HashMap<Character, String>();
		for(char c : map.keySet()){
			clone.put(c, map.get(c));
		}
		return clone;
	}
}
