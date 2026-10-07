import java.util.Scanner;

public class Areas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menú de Áreas:\n1. Cuadrado\n2. Rectángulo\n3. Triángulo\n4. Círculo");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        double area;
        
        switch (opcion) {
            case 1:
                System.out.print("Lado del cuadrado: ");
                double lado = sc.nextDouble();
                System.out.println("El área es: " + (lado * lado));
                break;
            case 2:
                System.out.print("Base y altura del rectángulo: ");
                double baser = sc.nextDouble();
                double alturar = sc.nextDouble();
                System.out.println("El área es: " + (baser * alturar));
                break;
            case 3:
                System.out.print("Base y altura del triángulo: ");
                double baset = sc.nextDouble();
                double alturat = sc.nextDouble();
                System.out.println("El área es: " + ((baset * alturat) / 2));
                break;
            case 4:
                System.out.print("Radio del círculo: ");
                double radio = sc.nextDouble();
                System.out.println("El área es: " + (Math.PI * radio * radio));
                break;
            default:
                System.out.println("Opción inválida.");
        }
        sc.close();
    }
}