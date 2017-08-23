package Arrays_and_String;

public class URLify {
	public static void main(String[] args) {
		runTestCases();
	}
	public static void runTestCases() {
		myAssert("vikram  aditya battina ", "vikram%20%20aditya%20battina%20");
		myAssert("  vikram  aditya  ", "%20%20vikram%20%20aditya%20%20");
		myAssert("  a", "%20%20a");
		myAssert("a  ", "a%20%20");
		myAssert("  a ", "%20%20a%20");
	}
	
	public static void myAssert(String input, String output) {
		if(URLify(input).equals(output)) {
			System.out.println(input+" "+output+"-->>Pass");
		}else {
			System.out.println(input+" "+output+"-->> Fail( "+ URLify(input)+" )");
		}
	}
	public static String URLify(String url) {
		//count spaces
		int sp_count = 0;
		for(int i = 0 ; i < url.length(); i++) {
			if(url.charAt(i) != ' ') {
				continue;
			}
			sp_count++;
		}
		char newarray[] = new char[url.length()+2*sp_count];
		for(int i = 0 ; i < url.length(); i++) {
			newarray[i] = url.charAt(i);
		}
		
		int read = url.length()-1;
		int write = newarray.length-1;
		while(read >= 0) {
			if( newarray[read] == ' ') {
				newarray[write] = '0';
				newarray[write-1] = '2';
				newarray[write-2] = '%';
				write = write-3;
				read--;
			}else {
				newarray[write] = newarray[read];
				write--;
				read--;
			}
		}
		return new String(newarray);
	}
}
