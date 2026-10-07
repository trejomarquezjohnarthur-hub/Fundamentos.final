import java.util.Scanner;

public class Contro_de_velocidad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int velocidad, velocidadEvaluada, resultado;
        boolean esCumpleanos;

        System.out.print("Velocidad registrada: ");
        velocidad = sc.nextInt();

        System.out.print("¿Es tu cumpleaños? (true/false): ");
        esCumpleanos = sc.nextBoolean();

        velocidadEvaluada = velocidad;

        if (esCumpleanos) {
            velocidadEvaluada = velocidad - 5;
        }

        if (velocidadEvaluada <= 60) {
            resultado = 0;
        } else if (velocidadEvaluada <= 80) {
            resultado = 1;
        } else {
            resultado = 2;
        }

        System.out.println("Resultado (0=sin multa, 1=pequeña, 2=grande): " + resultado);

        sc.close();
    }
}