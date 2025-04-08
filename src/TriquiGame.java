import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TriquiGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean JugarDeNuevo = false;

            do {

            char[][] tablero = inicializarTablero();
            char jugadorActual = 'X';
            boolean juegoGanado = false;
            int movimientos = 0;

            while (!juegoGanado && movimientos < 9) {
                imprimirTablero(tablero);
                System.out.println("Jugador: " + jugadorActual + ", es tu turno");

                int[] jugada = obtenerMovimiento(scanner, tablero);
                int fila = jugada[0];
                int columna = jugada[1];

                //Poner la marca del jugador Actual
                tablero[fila][columna] = jugadorActual;
                movimientos++;

                //Verificar ganador
                if(validarJugador(tablero, jugadorActual)) {
                    imprimirTablero(tablero);
                    System.out.println("Felicidades " + jugadorActual + " fuiste el ganador!");
                    juegoGanado = true;
                } else if (movimientos == 9) {
                    imprimirTablero(tablero);
                    System.out.println("Empate");
                }
                
                //cambiar jugador
                jugadorActual = cambiarJugador(jugadorActual);

            }


        //Preguntar si el jugador quiere jugar otra vez
           System.out.println("¿Quieres jugar de nuevo :D?");
           System.out.println("Si/No"); 
           JugarDeNuevo = scanner.next().toLowerCase().charAt(0) == 's';

        }while (!JugarDeNuevo);
            System.out.println("Gracias por jugar!");


        }

    

    //Metodo para inicializar el tablero
    public static char[][] inicializarTablero() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    //Metodo para imprimir el tablero
    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tablero[i][0] + "|" + tablero[i][1] + "|" + tablero[i][2]);

            if (i < 2) {
                System.out.println("------+------+----");
            }
        }

    }

    //Método para validar jugadas
    public static int[] obtenerMovimiento(Scanner scanner, char[][] tablero){
        int fila, columna;

        while(true){
            try{
                System.out.print("Fila (1-3): ");
                fila =scanner.nextInt()-1;
                System.out.print("Columna (1-3): ");
                columna =scanner.nextInt()-1;

                //Validacion de posición (dentro del tablero ) - casila vacia
                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' '){
                    return new int[]{fila,columna};
                } else {
                    System.out.println("Movimiento no válido");
                }


            } catch(Exception e){
                System.out.println("Entrada no válida, ingrese un numero entre 1 y 3 ");
                scanner.nextLine();
            }

        }
    }

    // Metodo cambiar de Juagador
    public static char cambiarJugador(char jugadorActual){
        return (jugadorActual== 'X') ? 'O' : 'X';
    }

    //Validar ganador
    public static boolean validarJugador (char[][] tablero, char jugador ){
        for(int i = 0; i <3 ; i++) {
            if (
                //Filas
                tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador
                        //Columnas
                        || tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador

            ) {
                return true;
            }
        }
            //Validar diagonales
            return  tablero[0][0] == jugador &&  tablero[1][1] == jugador && tablero[2][2] == jugador ||
                    tablero[0][2] == jugador &&  tablero[1][1] == jugador && tablero[2][0] == jugador;

    }

}