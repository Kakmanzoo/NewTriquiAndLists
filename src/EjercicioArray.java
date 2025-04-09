import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioArray {
    public static void main(String[] args) {
        Scanner poly = new Scanner(System.in);     
        
        //Le pedimos al usuario la fila que desea
        System.out.println("Digita el numero de fila  para el Fibonacci: ");
        int agua = poly.nextInt();


        //Creamos el Array para alamcenar la serie del Fibonacci
        ArrayList<Integer> Andres = new ArrayList<>();
        int num1 = 0 , num2 = 1, total;
        Andres.add(num1);
        Andres.add(num2);


        //Realizamos la operación fibonacci hasta donde el usuario lo solicito
        for(int i=1 ; i<=agua ; i++) {
            total = num2 + num1;
            num1 = num2;
            num2 = total;

            //Almacenamos los valores en la variable "total" hasta que "i" cumpla con la condición solicitada
            Andres.add(total);
        }
        System.out.println(Andres);

    }
}
