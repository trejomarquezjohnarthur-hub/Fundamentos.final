import java.util.Scanner;

public class Ahorro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double deposito, ahorroAcumulado = 0;

        for (int mes = 1; mes <= 12; mes++) {
            System.out.print("Ingrese la cantidad depositada en el mes " + mes + ": ");
            deposito = sc.nextDouble();
            ahorroAcumulado = ahorroAcumulado + deposito;
            System.out.println("Ahorro acumulado hasta el mes " + mes + ": $" + ahorroAcumulado);
        }

        System.out.println("El ahorro total al final del año es: $" + ahorroAcumulado);
        sc.close();
    }
}