package Arrays_and_String;

public class ZeroMatrix {
	public static void main(String args[]) {
		int len = 3;
		int matrix[][] = new int[len][len];
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[i].length; j++) {
				matrix[i][j] = 1;
			}
		}
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		printMatrix(matrix);
		zeroMatrix(matrix);
		System.out.println("--------");
		printMatrix(matrix);
	}
	
	public static void printMatrix(int matrix[][]) {
		for(int i=0; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void zeroMatrix(int matrix[][]) {
		int zero_col = 1;
		int zero_row = 1;
		
		//iterating over first row
		for(int i = 0 ; i  < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				zero_row = 0;
				break;
			}
		}
		
		//iterating over first column
		for(int i = 0 ; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				zero_col = 0;
				break;
			}
		}
		
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for(int i = 1 ; i < matrix.length; i++) {
			for(int j = 1; j < matrix[i].length; j++) {
				if(matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if(zero_col == 0) {
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if(zero_row == 0) {
			for(int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
	}
}
