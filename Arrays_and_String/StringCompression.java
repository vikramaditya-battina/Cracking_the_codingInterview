package Arrays_and_String;

public class StringCompression {
	public static void main(String[] args) {
		System.out.println(getCompressedString("aaabbbccc"));
	}
	
	public static String getCompressedString(String str) {
		int cLen = compressLength(str);
		System.out.println(cLen);
		if(cLen >= str.length()) {
			return str;
		}
		char arr[] = new char[cLen];
		int count = 1;
		int write =0;
		for(int read = 0; read < str.length()-1; read++) {
			if(str.charAt(read) == str.charAt(read+1)) {
				count++;
			}else {
				arr[write] = str.charAt(read);
				String cnt = String.valueOf(count);
				cnt.getChars(0, cnt.length(), arr, write+1);
				write = write+cnt.length()+1;
				count = 1;
			}
		}
		arr[write] = str.charAt(str.length()-1);
		String cnt = String.valueOf(count);
		cnt.getChars(0, cnt.length(), arr, write+1);
		return new String(arr);
	}
	
	public static int compressLength(String str) {
	    int cLen = 0;
	    int count=1;
		for(int read = 0 ;read < str.length()-1; read++) {
		   if(str.charAt(read) == str.charAt(read+1)) {
			   count++;
		   }else {
			   cLen += String.valueOf(count).length()+1;
			   count=1;
		   }
	   }
	   cLen += String.valueOf(count).length()+1;
	   return cLen;
	}
}
