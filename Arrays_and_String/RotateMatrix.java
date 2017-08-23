package Arrays_and_String;

/*
 * Idea 
 * Transpose the matrix
 * Reverse each Row
 *  Another Approach is to reverse it in each layers
 */
public class RotateMatrix {
	public static void main(String args[]) {
	    int matrix_len = 3;
	    int matrix[][] = new int[matrix_len][matrix_len];
	    int val = 1;
	    for(int i = 0; i < matrix_len; i++) {
	    	for(int j=0; j < matrix_len; j++) {
	    		matrix[i][j] = val;
	    		val++;
	    	}
	    }
	    rotate(matrix);
	    for(int i = 0 ; i < matrix.length; i++) {
	    	StringBuilder builder = new StringBuilder();
	    	for(int j = 0 ; j < matrix.length; j++) {
	    		System.out.print(matrix[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	}
	
	public static void rotate(int matrix[][]) {
		int len = matrix.length;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i+1; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp; 
			}
		}
		
		for(int i = 0 ; i < matrix.length; i++) {
			int arr[] = matrix[i];
			for(int j = 0 ; j < arr.length/2; j++) {
			    int temp = arr[j];
			    arr[j] = arr[arr.length-1-j];
			    arr[arr.length-1-j] = temp;
			}
		}
	}
	
}


