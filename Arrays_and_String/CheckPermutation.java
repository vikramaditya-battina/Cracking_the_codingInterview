package Arrays_and_String;
import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation {
	public static void main(String[] args) {
		assert isPermution1("vikram","marikv") == true;
		assert isPermutation("vikram", "marikv") == true;
		
		assert isPermution1("vikramaditya", "adityavikram") == true;
		assert isPermutation("vvvikram", "vikram") == false;
		System.out.println("success...");
	}
	
	//checks the permuation based on the Hash
	static boolean isPermution1(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str1.length(); i++) {
			if(map.containsKey(str1.charAt(i))) {
				map.put(str1.charAt(i), map.get(str1.charAt(i))+1);
				continue;
			}
			map.put(str1.charAt(i), 1);
		}
		
		for(int i = 0 ; i < str2.length(); i++) {
			if(!map.containsKey(str2.charAt(i))) {
				return false;
			}
			if(map.get(str2.charAt(i)) == 1) {
				map.remove(str2.charAt(i));
			}
			map.put(str2.charAt(i), map.get(str2.charAt(i))-1);
		}
		if(map.size() == 0) {
			return true;
		}
		return false;
	}
	
	//based on sorting
	static boolean isPermutation(String str1, String str2) {
		char s1Array[] = str1.toCharArray();
		char s2Array[] = str2.toCharArray();
		Arrays.sort(s1Array);
		Arrays.sort(s2Array);
		if(Arrays.equals(s1Array, s2Array)) {
			return true;
		}
		return false;
	}
}
