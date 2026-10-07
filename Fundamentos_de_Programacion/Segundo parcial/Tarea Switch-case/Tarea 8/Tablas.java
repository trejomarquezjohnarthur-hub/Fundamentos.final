import java.util.Scanner;

public class Tablas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        
        do {
            System.out.print("Ingresa un número para ver su tabla (0 para salir): ");
            n = sc.nextInt();
            
            if (n != 0) {
                System.out.println("--- Tabla del " + n + " ---");
                for (int i = 1; i <= 10; i++) {
                    System.out.println(n + " x " + i + " = " + (n * i));
                }
                System.out.println();
            }
        } while (n != 0);
        
        System.out.println("Programa terminado.");
        sc.close();
    }
}