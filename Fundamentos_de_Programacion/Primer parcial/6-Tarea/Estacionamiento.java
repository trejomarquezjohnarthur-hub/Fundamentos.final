import java.util.Scanner;

public class Estacionamiento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero de horas que estuvo el vehiculo: ");
        int horas = sc.nextInt();

        double costo;

        if (horas <= 0) {
            System.out.println("Numero de horas invalido.");
        } else {
            if (horas <= 2) {
                costo = horas * 30;
            } else if (horas <= 5) {
                costo = 2 * 30 + (horas - 2) * 25;
            } else if (horas <= 10) {
                costo = 2 * 30 + 3 * 25 + (horas - 5) * 20;
            } else {
                costo = 380;
            }
            System.out.printf("El costo total a pagar es: $%.2f%n", costo);
        }

        sc.close();
    }
}