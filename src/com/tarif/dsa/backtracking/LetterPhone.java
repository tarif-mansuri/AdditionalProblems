package com.tarif.dsa.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

//	Problem Description
//	Given a digit string A, return all possible letter combinations that the number could represent.
//	
//	A mapping of digit to letters (just like on the telephone buttons) is given below.
//	
//	
//	
//	The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
//	
//	NOTE: Make sure the returned strings are lexicographically sorted.
//	
//	
//	
//	Problem Constraints
//	1 <= |A| <= 10
//	
//	
//	
//	Input Format
//	The only argument is a digit string A.
//	
//	
//	
//	Output Format
//	Return a string array denoting the possible letter combinations.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = "23"
//	Input 2:
//	
//	 A = "012"
//	
//	
//	Example Output
//	Output 1:
//	
//	 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
//	Output 2:
//	
//	 ["01a", "01b", "01c"]
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 There are 9 possible letter combinations.
//	Explanation 2:
//	
//	 Only 3 possible letter combinations.
//	
//	
//	
//	Expected Output
//	Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

public class LetterPhone {
	
	public void letterCombinationsUtil(String A, HashMap<Integer, String> keyMap, int index, ArrayList<String> ans, StringBuilder curr){
		if(index == A.length()) {
			ans.add(curr.toString());
			return;
		}
		int digitKey = A.charAt(index)-'0';
		String possiblechars = keyMap.get(digitKey);
		for(int i=0; i<possiblechars.length(); i++) {
			curr.append(possiblechars.charAt(i));
			letterCombinationsUtil(A, keyMap, index+1, ans, curr);
			curr.deleteCharAt(curr.length()-1);
		}
	}
	
	public ArrayList<String> letterCombinations(String A) {
		HashMap<Integer, String> letters = new HashMap<>();
		letters.put(0, "0");
		letters.put(1, "1");
		letters.put(2, "abc");
		letters.put(3, "def");
		letters.put(4, "ghi");
		letters.put(5, "jkl");
		letters.put(6, "mno");
		letters.put(7, "pqrs");
		letters.put(8, "tuv");
		letters.put(9, "wxyz");
		
		ArrayList<String> ans = new ArrayList<String>();
		letterCombinationsUtil(A, letters, 0, ans, new StringBuilder());
		return ans;
		
    }
	
	public static void main(String[] args) {
		LetterPhone letterPhone = new LetterPhone();
		ArrayList<String> ans = letterPhone.letterCombinations("23");
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
		}
	}

}
