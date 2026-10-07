import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        double num1 = sc.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double num2 = sc.nextDouble();
        System.out.print("Introduce la operación (+, -, *, /): ");
        char op = sc.next().charAt(0);
        
        switch (op) {
            case '+': System.out.println("Resultado: " + (num1 + num2)); break;
            case '-': System.out.println("Resultado: " + (num1 - num2)); break;
            case '*': System.out.println("Resultado: " + (num1 * num2)); break;
            case '/': 
                if (num2 != 0) {
                    System.out.println("Resultado: " + (num1 / num2));
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
                break;
            default: System.out.println("Operador no válido.");
        }
        sc.close();
    }
}