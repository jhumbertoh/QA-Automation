public class ReverseStringOther {
 //How to reverse a String in Java?
 public static void main(String[] args) {
	 String input="Software Testing Material";
	 StringBuilder input1 = new StringBuilder();
	 input1.append(input);
	 input1=input1.reverse(); 
	 for (int i=0;i<input1.length();i++)
	 System.out.print(input1.charAt(i));
 }
 
}
