import java.util.Scanner;

public class Llamadas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dia, turno;
        double minutos, tarifa = 0, costo = 0;

        System.out.print("¿Cual es la duracion de la llamada (en minutos)? ");
        minutos = sc.nextDouble();

        if (minutos <= 5) {
            tarifa = minutos * 1;
        } else if (minutos <= 8) {
            tarifa = 5 + (minutos - 5) * 0.8;
        } else if (minutos <= 10) {
            tarifa = 7.4 + (minutos - 8) * 0.7;
        } else {
            tarifa = 8.8 + ((minutos - 10) * 0.5);
        }

        System.out.println("¿En que dia realizo la llamada?");
        System.out.println("Escriba h para dia habil y d para domingo");
        dia = sc.next();

        if (dia.equals("h")) {
            System.out.println("¿En que horario se realizo la llamada?");
            System.out.println("Escriba m para matutino y v para vespertino");
            turno = sc.next();

            if (turno.equals("m")) {
                costo = tarifa + (tarifa * 0.15);
            } else if (turno.equals("v")) {
                costo = tarifa + (tarifa * 0.10);
            } else {
                System.out.println("Opción erronea en turno.");
            }
        } else if (dia.equals("d")) {
            costo = tarifa + (tarifa * 0.03);
        } else {
            System.out.println("Opcion erronea en dia.");
        }

        System.out.println("El costo total es de: " + costo);

        sc.close();
    }
}
