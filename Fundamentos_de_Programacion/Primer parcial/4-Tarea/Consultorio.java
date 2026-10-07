import java.util.Scanner;

public class Consultorio{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCitas, i;
        double precioCita = 0, totalPagado;

        System.out.print("¿A qué número de cita va el paciente? ");
        numCitas = sc.nextInt();

        totalPagado = 0;

        for (i = 1; i <= numCitas; i++) {
            if (i <= 3) {
                precioCita = 900;
            } else if (i <= 5) {
                precioCita = 800;
            } else if (i <= 8) {
                precioCita = 600;
            } else {
                precioCita = 500;
            }
            totalPagado = totalPagado + precioCita;
        }

        System.out.println("a) Costo de la cita número " + numCitas + ": $" + precioCita);
        System.out.println("b) Total pagado en el tratamiento hasta esta cita: $" + totalPagado);

        sc.close();
    }
}