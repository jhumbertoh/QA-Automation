import java.util.Scanner;
 
public class FibonacciSeriesOne {
 public static void main(String[] args){
 System.out.println("Enter Iteration to print Fibonacci Series");
 FibonacciCheck.checkFibonacci(new Scanner(System.in).nextInt());
 }
}
 
class FibonacciCheck {
 public static void checkFibonacci(int number){
 int first=0,second=1;
 int third=0;
 int i=1;
 System.out.print("Fibonacci Series upto: "+number+" is ");
 System.out.print(first+","+second+",");
 while(i<=number){
 third=first+second;
 System.out.print(third+",");
 first=second;
 second=third;
 ++i;
 }
 }
}
