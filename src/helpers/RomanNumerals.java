package helpers;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
	private static Map<Integer, String> numberMap = new LinkedHashMap<Integer, String>();
	static {
		numberMap.put(1000, "M");
		numberMap.put(900, "CM");
		numberMap.put(500, "D");
		numberMap.put(400, "CD");
		numberMap.put(100, "C");
		numberMap.put(90, "XC");
		numberMap.put(50, "L");
		numberMap.put(40, "XL");
		numberMap.put(10, "X");
		numberMap.put(9, "IX");
		numberMap.put(5, "V");
		numberMap.put(4, "IV");
		numberMap.put(1, "I");
	}
	
	public static String convert(int num) {
		if (num < 1 || num > 3999) {
			throw new RuntimeException("Number outside valid Roman numeral range.");
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Map.Entry<Integer, String> entry : numberMap.entrySet()) {
			while (num >= entry.getKey()) {
				num -= entry.getKey();
				sb.append(entry.getValue());
			}
		}
		
		return sb.toString();
	}
}
