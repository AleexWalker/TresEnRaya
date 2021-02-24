import java.util.Scanner;

public class TresEnRaya {
    private static char [][] tablero = new char [3][3];

    public static void jugarTresEnRaya(){
        inicializarTablero();
        jugador1();
    }
    public static void inicializarTablero() {
        for ( int fila=0; fila<3; fila++ )
            for ( int columna=0; columna<3; columna++ )
                tablero[fila][columna] = ' ';
    }

    public static void mostrarTablero() {
        System.out.println("  0  " + tablero[0][0] + "|" + tablero[0][1] + "|" + tablero[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + tablero[1][0] + "|" + tablero[1][1] + "|" + tablero[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + tablero[2][0] + "|" + tablero[2][1] + "|" + tablero[2][2]);
        System.out.println("     0 1 2 ");
    }

    public static void mostrarTablero2() {
        for ( int fila=0; fila<3; fila++ ) {
            System.out.print("\t"+fila+" ");
            for ( int columna=0; columna<3; columna++ ) {
                System.out.print( tablero[fila][columna] + " " );
            }
            System.out.println();
        }
        System.out.println("\t  0 1 2 ");
    }

    private static void jugador1(){

        mostrarTablero2();
        if (finalEmpate()) {
            System.out.println("¡LA PARTIDA HA TERMINADO EN EMPATE!");
            return;
        }

        Scanner teclado = new Scanner(System.in);
        String entrada;
        char punto = 'X';
        int coordX;
        int coordY;

        System.out.print("Coordenadas J1: ");
        entrada = teclado.nextLine();
        coordX = Integer.parseInt(entrada.substring(0, 1));
        coordY = Integer.parseInt(entrada.substring(1, 2));

        while ((coordX > 2 || coordY > 2) || entrada.length() > 2) {

            System.out.println("¡EL NÚMERO QUE ESTÁS INTRODUCIENDO ES DEMASIADO GRANDE JUGADOR 1!");
            System.out.print("Coordenadas J1: ");

            entrada = teclado.nextLine();
            coordX = Integer.parseInt(entrada.substring(0, 1));
            coordY = Integer.parseInt(entrada.substring(1, 2));

        }

        if (tablero[coordX][coordY] == '0' || tablero[coordX][coordY] == 'X') {
            do {
                System.out.println("COORDENADA OCUPADA, PRUEBA OTRA");
                mostrarTablero2();
                System.out.print("Coordenadas J1: ");
                entrada = teclado.nextLine();
                coordX = Integer.parseInt(entrada.substring(0, 1));
                coordY = Integer.parseInt(entrada.substring(1, 2));
            } while (tablero[coordX][coordY] == '0' || tablero[coordX][coordY] == 'X');
        }
        tablero[coordX][coordY] = punto;

        if (comprobacionJugador1())
            jugador2();
        else {
            mostrarTablero2();
            System.out.println("¡ENHORABUENA JUGADOR 1, HAS GANADO!");
        }
    }

    public static boolean comprobacionJugador1(){
        char jugador1 = 'X';
        boolean verificacion = false;

        //filas
        if (jugador1 == tablero[0][0] && jugador1 == tablero[0][1] && jugador1 == tablero[0][2])
            verificacion = true;
        if (jugador1 == tablero[1][0] && jugador1 == tablero[1][1] && jugador1 == tablero[1][2])
            verificacion = true;
        if (jugador1 == tablero[2][0] && jugador1 == tablero[2][1] && jugador1 == tablero[2][2])
            verificacion = true;

        //columnas
        if (jugador1 == tablero[0][0] && jugador1 == tablero[1][0] && jugador1 == tablero[2][0])
            verificacion = true;
        if (jugador1 == tablero[0][1] && jugador1 == tablero[1][1] && jugador1 == tablero[2][1])
            verificacion = true;
        if (jugador1 == tablero[0][2] && jugador1 == tablero[1][2] && jugador1 == tablero[2][2])
            verificacion = true;

        //diagonales
        if (jugador1 == tablero[0][0] && jugador1 == tablero[1][1] && jugador1 == tablero[2][2])
            verificacion = true;
        if (jugador1 == tablero[0][2] && jugador1 == tablero[1][1] && jugador1 == tablero[2][0])
            verificacion = true;

            /*if (verificacion) {
                mostrarTablero2();
                System.out.println("¡ENHORABUENA JUGADOR 1, HAS GANADO!");
            }*/
        return !verificacion;
    }

    public static boolean finalEmpate() {
        boolean bandera = true;
        for (int i = 0 ; i < tablero.length ; i++){
            for (int j = 0; j < tablero.length ; j++) {
                if (tablero[i][j] == ' ' ) {
                    i = tablero.length;
                    j = tablero.length;
                    bandera = false;
                }
            }
        }
        return bandera;
    }

        /*public static boolean comprobacionJugador1(){
        char jugador1 = 'X';

        //filas
        if (jugador1 == tablero[0][0] && jugador1 == tablero[0][1] && jugador1 == tablero[0][2])
            return true;
        if (jugador1 == tablero[1][0] && jugador1 == tablero[1][1] && jugador1 == tablero[1][2])
            return true;
        if (jugador1 == tablero[2][0] && jugador1 == tablero[2][1] && jugador1 == tablero[2][2])
            return true;

        //columnas
        if (jugador1 == tablero[0][0] && jugador1 == tablero[1][0] && jugador1 == tablero[2][0])
            return true;
        if (jugador1 == tablero[0][1] && jugador1 == tablero[1][1] && jugador1 == tablero[2][1])
            return true;
        if (jugador1 == tablero[0][2] && jugador1 == tablero[1][2] && jugador1 == tablero[2][2])
            return true;

        //diagonales
        if (jugador1 == tablero[0][0] && jugador1 == tablero[1][1] && jugador1 == tablero[2][2])
            return true;
        if (jugador1 == tablero[0][2] && jugador1 == tablero[1][1] && jugador1 == tablero[2][0])
            return true;

        if (comprobacionJugador1())
            System.out.println("¡ENHORABUENA JUGADOR 1, HAS GANADO!");
        else
            jugador2();
        return false;
        }*/

    private static void jugador2(){

        mostrarTablero2();
        if (finalEmpate()) {
            System.out.println("¡LA PARTIDA HA TERMINADO EN EMPATE!");
            return;
        }

        Scanner teclado = new Scanner(System.in);
        String entrada;
        char punto = '0';
        int coordX;
        int coordY;

        System.out.print("Coordenadas J2: ");
        entrada = teclado.nextLine();
        coordX = Integer.parseInt(entrada.substring(0, 1));
        coordY = Integer.parseInt(entrada.substring(1, 2));

        while ((coordX > 2 || coordY > 2) || entrada.length() > 2 ){

            System.out.println("¡EL NÚMERO QUE ESTÁS INTRODUCIENDO ES DEMASIADO GRANDE JUGADOR 2!");
            System.out.print("Coordenadas J2: ");
            entrada = teclado.next();
            coordX = Integer.parseInt(entrada.substring(0, 1));
            coordY = Integer.parseInt(entrada.substring(1, 2));

        }

        if (tablero[coordX][coordY] == 'X' || tablero[coordX][coordY] == '0') {
            do {
                System.out.println("COORDENADA OCUPADA, PRUEBA OTRA");
                mostrarTablero2();
                System.out.print("Coordenadas J2: ");
                entrada = teclado.nextLine();
                coordX = Integer.parseInt(entrada.substring(0, 1));
                coordY = Integer.parseInt(entrada.substring(1, 2));
            } while (tablero[coordX][coordY] == 'X' || tablero[coordX][coordY] == '0');
        }

        tablero[coordX][coordY] = punto;

        if (comprobacionJugador2())
            jugador1();
        else {
            mostrarTablero2();
            System.out.println("¡ENHORABUENA JUGADOR 2, HAS GANADO!");
        }
    }

    public static boolean comprobacionJugador2(){
        char jugador2 = '0';
        boolean verificacion = false;

        //filas
        if (jugador2 == tablero[0][0] && jugador2 == tablero[0][1] && jugador2 == tablero[0][2])
            verificacion = true;
        if (jugador2 == tablero[1][0] && jugador2 == tablero[1][1] && jugador2 == tablero[1][2])
            verificacion = true;
        if (jugador2 == tablero[2][0] && jugador2 == tablero[2][1] && jugador2 == tablero[2][2])
            verificacion = true;

        //columnas
        if (jugador2 == tablero[0][0] && jugador2 == tablero[1][0] && jugador2 == tablero[2][0])
            verificacion = true;
        if (jugador2 == tablero[0][1] && jugador2 == tablero[1][1] && jugador2 == tablero[2][1])
            verificacion = true;
        if (jugador2 == tablero[0][2] && jugador2 == tablero[1][2] && jugador2 == tablero[2][2])
            verificacion = true;

        //diagonales
        if (jugador2 == tablero[0][0] && jugador2 == tablero[1][1] && jugador2 == tablero[2][2])
            verificacion = true;
        if (jugador2 == tablero[0][2] && jugador2 == tablero[1][1] && jugador2 == tablero[2][0])
            verificacion = true;

            /*if (verificacion) {
                mostrarTablero2();
                System.out.println("¡ENHORABUENA JUGADOR 2, HAS GANADO!");
            }*/
        return !verificacion;
    }

        /*public static boolean comprobacionJugado2(){
        char jugador2 = '0';

        //filas
        if (jugador2 == tablero[0][0] && jugador2 == tablero[0][1] && jugador2 == tablero[0][2])
            return true;
        if (jugador2 == tablero[1][0] && jugador2 == tablero[1][1] && jugador2 == tablero[1][2])
            return true;
        if (jugador2 == tablero[2][0] && jugador2 == tablero[2][1] && jugador2 == tablero[2][2])
            return true;

        //columnas
        if (jugador2 == tablero[0][0] && jugador2 == tablero[1][0] && jugador2 == tablero[2][0])
            return true;
        if (jugador2 == tablero[0][1] && jugador2 == tablero[1][1] && jugador2 == tablero[2][1])
            return true;
        if (jugador2 == tablero[0][2] && jugador2 == tablero[1][2] && jugador2 == tablero[2][2])
            return true;

        //diagonales
        if (jugador2 == tablero[0][0] && jugador2 == tablero[1][1] && jugador2 == tablero[2][2])
            return true;
        if (jugador2 == tablero[0][2] && jugador2 == tablero[1][1] && jugador2 == tablero[2][0])
            return true;

        if (comprobacionJugador2())
            System.out.println("¡ENHORABUENA JUGADOR 2, HAS GANADO!");
        else
            jugador1();
            return false;
        }*/
}
