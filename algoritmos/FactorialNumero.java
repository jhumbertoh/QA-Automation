import java.util.Scanner;

public class FactorialNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ej.: El factorial de 5 es: 5*4*3*2*1
        long factorial=1;
        int num;
	String cad = ""; 
        Scanner numero = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        num = numero.nextInt();
        for (int i = num; i > 0; i--) {
            factorial = factorial * i;
	    cad = cad + (i + "*");
        }
	cad = cad.substring(0, cad.length() - 1);
	System.out.println("El factorial de " + num + " es: " + cad + " = " + factorial);
    }
}
//Recursive:
/*public int factorial (double numero) {
  if (numero==0)
    return 1;
  else
    return numero * factorial(numero-1);
}
*/
