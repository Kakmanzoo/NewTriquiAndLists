
import java.util.ArrayList;
public class listas {
    
    
    public static void main(String[] args) {

        //crear arraylist con un tipo de dato String
        ArrayList<String> frutas = new ArrayList<>(); 

        //Agregar elementos
        frutas.add("Pera");
        frutas.add("Uva");
        frutas.add("Uchuba");
        frutas.add("Tomate");

        //Imprimir lista
        String fruta = frutas.get(2);
        System.out.println("Lista de frutas: " + fruta);

        //Obtener una fruta
        String fruit = frutas.get(2);
        System.out.println("Encontre esta fruta: " + fruit);


        //Modificar una fruta
        frutas.set(0, "Uva");
        System.out.println("Lista de frutas despues de ser modificada: " + frutas);


        //Buscar
        boolean contiene = frutas.contains("Uva");
        System.out.println("¿La fruta se encontro? " + contiene);


        //Eliminar lista
        frutas.remove("Tomate");
        System.out.println("Lista después de eliminar: " + frutas);

        //Obtener el tamaño
        int tamano = frutas.size();
        System.out.println("Tamaño de la lista: " + tamano);
    }
}