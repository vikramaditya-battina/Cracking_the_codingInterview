package Arrays_and_String;
import java.util.Arrays;
import java.util.HashMap;

public class IsUnique {
	
	public static void main(String[] args) {
		assert isUniqueString("vikram") == true;
		assert isUniqueString2("vikram") == true;
		
		assert isUniqueString("vicky") == true;
		assert isUniqueString2("vicky") == true;
		
		assert isUniqueString("vikramaditya") == false;
		assert isUniqueString2("vikramaditya") == false;
		
		assert isUniqueString("nikil")==false;
		assert isUniqueString2("nikil") == false;
		
		System.out.println("Success...");
	}
	
	static boolean isUniqueString(String str) {
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for(int i = 0 ; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				return false;
			}
			map.put(str.charAt(i), true);
		}
		return true;
	}
	
	static boolean isUniqueString2(String str) {
		char[] cArray = str.toCharArray();
		Arrays.sort(cArray);
		for(int i = 0 ; i < cArray.length-1; i++) {
			if(cArray[i] == cArray[i+1]) {
				return false;
			}
		}
		return true;
	}
}
