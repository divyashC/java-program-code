package concepts;

public class IntCharPyramidPattern {
	
	public static void main(String args[]) {
		
		int i, j, r;
		
		r = 6;
		
		for (i=0; i<r; i++) {
			
			char ch = 'A';
			
			for (j=(r-1); j>i; j--) {
				System.out.print("  ");
			}
			
			for (j=1; j<=(i+1); j++) {
				System.out.print(j + " ");
			}
			
			
			for (j=1; j<=(i+1); j++) {
				System.out.print(ch + " ");
				ch++;
			}
			
			System.out.println();
			
		}
		
	}

}