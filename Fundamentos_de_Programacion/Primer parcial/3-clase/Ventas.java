import java.util.Scanner;

public class Ventas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String venta;
        int v1 = 0, v2 = 0, v3 = 0;
        double ven1 = 0, ven2 = 0, ven3 = 0, monto, total;

        System.out.println("Escribe 's' si hay venta y 'n' si no hay:");
        venta = sc.next();

        while (venta.equals("s")) {
            System.out.print("Ingresa el monto de la venta: ");
            monto = sc.nextDouble();

            if (monto > 1000) {
                v1++;
                ven1 += monto;
            } else if (monto >= 500) {
                v2++;
                ven2 += monto;
            } else {
                v3++;
                ven3 += monto;
            }

            System.out.println("¿Escribe 's' si hay otra venta y 'n' si no hay?");
            venta = sc.next();
        }

        total = ven1 + ven2 + ven3;

        System.out.println("Las ventas mayores a 1000 fueron: " + v1 + " y el monto es de: " + ven1);
        System.out.println("Las ventas mayores o iguales a 500 y menores a 1000 son: " + v2 + " y el monto es de: " + ven2);
        System.out.println("Las ventas menores de 500 son: " + v3 + " y el monto es de: " + ven3);
        System.out.println("El monto total es de: " + total);

        sc.close();
    }
}
