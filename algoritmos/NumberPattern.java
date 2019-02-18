public class NumberPattern {
 // Write a program to print the pattern given below
 public static void main(String[] args) {
	 for (int x = 1; x <= 5; x++) {
	     for (int y = 1; y <= x; y++) {
	       System.out.print(y+" ");
	     }
	   System.out.println();
	 }
 } 
}
