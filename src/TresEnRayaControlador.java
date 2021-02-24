import java.util.InputMismatchException;

public class TresEnRayaControlador {
    public static void main( String[] args ) {
        try {

            do
                TresEnRaya.jugarTresEnRaya();
            while (!TresEnRaya.finalEmpate() && !TresEnRaya.comprobacionJugador1() && !TresEnRaya.comprobacionJugador2());

        } catch (InputMismatchException e) {
            System.out.println("¡HAS INTRODUCIDO UN DATO ERRÓNEO!");
        } catch (NumberFormatException e){
            System.out.println("¡HAS INTRODUCIDO UN CARÁCTER INVÁLIDO O NEGATIVO");
        }
    }
}
