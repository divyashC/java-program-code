package pattern_practice;

public class CharIntPyramid {

public static void main(String[] args) {
		
		int i, j, r;
		r = 5;
		
		
		for (i=0; i<r; i++) {
			
			char ch = 'E';
			
			for (j=(r-1); j>i; j--) {
				System.out.print("  ");
				ch--;
			}
			
			for (j=0; j<=i; j++) {
				System.out.print(ch + " ");
				ch--;
			}
			
			for (j=(i+1); j>=1; j--) {
				System.out.print(j + " ");
			}
			
			System.out.println();
			
		}
		
	}
	
}
