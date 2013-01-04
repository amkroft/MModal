package unittests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import char2hex.Conversion;

public class Testing {
	
	Conversion c = new Conversion(new char[]{
			'e','t','a','o','i','n','s','h',
			'r','d','l','c','u','m','w','f',
			'g','y','p','b','v','k','j','x',
			'q','z'			
		});

	@Test
	public void testBinary(){
		HashMap<Character, String> results = c.getMap();
		
		assertTrue(results.get('e').equals("1") && results.get('t').equals("10")
				&& results.get('a').equals("11") && results.get('o').equals("100")
				&& results.get('i').equals("101") && results.get('n').equals("110")
				&& results.get('s').equals("111") && results.get('h').equals("1000")
				&& results.get('r').equals("1001") && results.get('d').equals("1010")
				&& results.get('l').equals("1011") && results.get('c').equals("1100")
				&& results.get('u').equals("1101") && results.get('m').equals("1110")
				&& results.get('w').equals("1111") && results.get('f').equals("10000")
				&& results.get('g').equals("10001") && results.get('y').equals("10010")
				&& results.get('p').equals("10011") && results.get('b').equals("10100")
				&& results.get('v').equals("10101") && results.get('k').equals("10110")
				&& results.get('j').equals("10111") && results.get('x').equals("11000")
				&& results.get('q').equals("11001") && results.get('z').equals("11010"));
	}
	
	@Test
	public void testBinaryString(){
		String test = "test";
		String result = c.toBinaryString(test);
		String expected = "10111110";
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void testInsertSpaces(){
		String test = "10111001001000100111";
		String result = c.polishString(test);
		String expected = "1011 1001 0010 0010 0111";
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void testInsertZeros(){
		String test = "1";
		String result = c.polishString(test);
		String expected = "1000";
		assertTrue(expected.equals(result));
		
		test = "11";
		result = c.polishString(test);
		expected = "1100";
		assertTrue(expected.equals(result));
		
		test = "111";
		result = c.polishString(test);
		expected = "1110";
		assertTrue(expected.equals(result));
		
		test = "1111";
		result = c.polishString(test);
		expected = "1111";
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void testHex(){
		String test = "1011 1000";
		String result = c.binaryToHex(test);
		String expected = "b8";
		assertTrue(expected.equals(result));
		
		test = "1011 1001 0010 0010 0111";
		result = c.binaryToHex(test);
		expected = "b9227";
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void testPolishHex(){
		String test ="b8";
		String result = c.polishHex(test);
		String expected = "0xb8";
		assertTrue(expected.equals(result));
		
		test ="b9227";
		result = c.polishHex(test);
		expected = "0xb9 0x22 0x70";
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void testFinal(){
		String test ="tao";
		String result = c.toHex(test);
		String expected = "0xb8";
		assertTrue(expected.equals(result));
		
		test ="taoohra";
		result = c.toHex(test);
		expected = "0xb9 0x22 0x70";
		assertTrue(expected.equals(result));
		
		test ="amanda";
		result = c.toHex(test);
		expected = "0xfb 0xd5 0x80";
		assertTrue(expected.equals(result));
	}
}
