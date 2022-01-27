package pattern_practice;

public class CharTriangle {

	public static void main(String[] args) {
		
		int i, j, r;
		r = 5;
		
		for (i=0; i<r; i++) {
			
			char ch = 'A';
			
			for (j=0; j<=i; j++) {
				System.out.print(ch + " ");
				ch++;
			}
			
			System.out.println();
			
		}
		
	}
	
}