import java.util.Scanner;

public class becas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la edad del estudiante: ");
        int edad = sc.nextInt();
        System.out.print("Ingrese el promedio del estudiante: ");
        double promedio = sc.nextDouble();

        double beca = 0;
        boolean tieneBeca = true;

        if (edad > 18) {
            if (promedio >= 9) {
                beca = 10000;
            } else if (promedio >= 7.5) {
                beca = 8000;
            } else if (promedio >= 6) {
                beca = 5000;
            } else {
                tieneBeca = false;
            }
        } else {
            if (promedio >= 9) {
                beca = 8000;
            } else if (promedio >= 8) {
                beca = 6000;
            } else if (promedio >= 6) {
                beca = 4000;
            } else {
                tieneBeca = false;
            }
        }

        if (tieneBeca) {
            System.out.printf("El estudiante recibira una beca de: $%.2f%n", beca);
        } else {
            System.out.println("No cumple con el promedio minimo. Se le enviara carta de invitacion.");
        }

        sc.close();
    }
}