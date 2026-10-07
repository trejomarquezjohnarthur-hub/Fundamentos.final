import java.util.Scanner;

public class Patrones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el número de líneas (n): ");
        int n = sc.nextInt();
        
        System.out.println("\n--- Patrón 1 (Cuadrado) ---");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\n--- Patrón 2 (Pirámide Invertida) ---");
        for (int i = 1; i <= n; i++) {
            // Imprimir espacios
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            // Imprimir asteriscos
            for (int j = 1; j <= (2 * (n - i) + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println("\n--- Patrón 3 (Pirámide Normal) ---");
        for (int i = 1; i <= n; i++) {
            // Imprimir espacios
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Imprimir asteriscos
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        sc.close();
    }
}