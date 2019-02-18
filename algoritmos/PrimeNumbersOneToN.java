import java.util.Scanner;
 
public class PrimeNumbersOneToN {
   //How to display all the prime numbers between 1 and n (n is the number, get the input from user)
   public static void main (String[] args){ 
      Scanner scanner = new Scanner(System.in);
      int i =0;
      int num =0;
      String  primeNumbers = "";
      System.out.println("Enter the value of n :");
      int n = scanner.nextInt();
      scanner.close();
      for (i = 1; i <= n; i++)  	   
      {   
         int counter=0;   
         for(num =i; num>=1; num--)
         {
     if(i%num==0)
     {
 counter = counter + 1;
     }
 }
 if (counter ==2)
 {
     primeNumbers = primeNumbers + i + " ";
 } 
      } 
      System.out.println("Prime numbers from 1 to n are :");
      System.out.println(primeNumbers);
   }
}
