package Arrays_and_String;

public class StringRotation {
	public static void main(String args[]) {
		String str = "waterbottle";
		String rotstr = "erbottlewat";
		String dstr = str+str;
		int index = dstr.indexOf(rotstr);
		System.out.println("found index-->>"+index);
	}
}
