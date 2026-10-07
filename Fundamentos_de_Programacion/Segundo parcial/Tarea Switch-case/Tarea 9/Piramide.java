import java.util.Scanner;

public class Piramide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el número de líneas (n): ");
        int n = sc.nextInt();
        
        for (int fila = 1; fila <= n; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print(col + " ");
            }
            System.out.println(); // Salto de línea
        }
        
        sc.close();
    }
}