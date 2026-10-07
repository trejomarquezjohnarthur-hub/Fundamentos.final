import java.util.Scanner;

public class Cine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Qué día es hoy? (ej. miercoles, jueves): ");
        String dia = sc.next().toLowerCase();
        System.out.print("¿Cuántas personas son?: ");
        int personas = sc.nextInt();
        System.out.print("¿Tienes membresía? (si/no): ");
        String membresia = sc.next().toLowerCase();
        
        double total = 0;
        
        if (dia.equals("miercoles")) {
            total = personas * 30.0;
        } else if (dia.equals("jueves")) {
            int parejas = personas / 2;
            int sueltos = personas % 2;
            total = (parejas * 75.0) + (sueltos * 50.0);
        } else {
            total = personas * 50.0;
        }
        
        if (membresia.equals("si")) {
            total = total * 0.90; // 10% de descuento
        }
        
        System.out.println("El total a pagar es: $" + total);
        sc.close();
    }
}