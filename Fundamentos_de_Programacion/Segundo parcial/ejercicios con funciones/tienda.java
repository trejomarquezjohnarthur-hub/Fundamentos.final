import java.util.Scanner;

public class tienda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- 1. DATOS DEL PRODUCTO 1 ---
        double precio1;
        int cantidad1;
        do {
            System.out.print("Producto 1 - Ingresa el precio (> 0): ");
            precio1 = scanner.nextDouble();
            if (precio1 <= 0) System.out.println("Error: El precio debe ser mayor que cero.");
        } while (precio1 <= 0);

        do {
            System.out.print("Producto 1 - Ingresa la cantidad (> 0): ");
            cantidad1 = scanner.nextInt();
            if (cantidad1 <= 0) System.out.println("Error: La cantidad debe ser un entero mayor que cero.");
        } while (cantidad1 <= 0);

        // --- 2. DATOS DEL PRODUCTO 2 ---
        double precio2;
        int cantidad2;
        do {
            System.out.print("\nProducto 2 - Ingresa el precio (> 0): ");
            precio2 = scanner.nextDouble();
            if (precio2 <= 0) System.out.println("Error: El precio debe ser mayor que cero.");
        } while (precio2 <= 0);

        do {
            System.out.print("Producto 2 - Ingresa la cantidad (> 0): ");
            cantidad2 = scanner.nextInt();
            if (cantidad2 <= 0) System.out.println("Error: La cantidad debe ser un entero mayor que cero.");
        } while (cantidad2 <= 0);

        // --- 3. DATOS DEL PRODUCTO 3 ---
        double precio3;
        int cantidad3;
        do {
            System.out.print("\nProducto 3 - Ingresa el precio (> 0): ");
            precio3 = scanner.nextDouble();
            if (precio3 <= 0) System.out.println("Error: El precio debe ser mayor que cero.");
        } while (precio3 <= 0);

        do {
            System.out.print("Producto 3 - Ingresa la cantidad (> 0): ");
            cantidad3 = scanner.nextInt();
            if (cantidad3 <= 0) System.out.println("Error: La cantidad debe ser un entero mayor que cero.");
        } while (cantidad3 <= 0);

        // --- 4. TIPO DE CLIENTE Y CÓDIGO POSTAL ---
        int tipoCliente;
        do {
            System.out.print("\nTipo de cliente (1: Regular, 2: Frecuente): ");
            tipoCliente = scanner.nextInt();
            if (tipoCliente != 1 && tipoCliente != 2) {
                System.out.println("Error: El tipo de cliente solo puede ser 1 o 2.");
            }
        } while (tipoCliente != 1 && tipoCliente != 2);

        scanner.nextLine(); // Limpiar búfer
        String codigoPostal;
        do {
            System.out.print("Ingresa el código postal (exactamente 5 dígitos): ");
            codigoPostal = scanner.nextLine().trim();
            if (!codigoPostal.matches("\\d{5}")) {
                System.out.println("Error: El código postal debe contener exactamente cinco dígitos numéricos.");
            }
        } while (!codigoPostal.matches("\\d{5}"));

        // --- LLAMADA A LOS MÉTODOS OBLIGATORIOS ---
        double sub1 = calcularSubtotalProducto(precio1, cantidad1);
        double sub2 = calcularSubtotalProducto(precio2, cantidad2);
        double sub3 = calcularSubtotalProducto(precio3, cantidad3);

        double subtotalGeneral = calcularSubtotalGeneral(sub1, sub2, sub3);
        double descuento = calcularDescuento(subtotalGeneral, tipoCliente);
        double subtotalConDescuento = subtotalGeneral - descuento;
        
        double envio = calcularEnvio(subtotalGeneral, codigoPostal);
        double impuesto = calcularImpuesto(subtotalConDescuento);
        double totalPagar = calcularTotal(subtotalGeneral, descuento, impuesto, envio);

        // --- 5. RESULTADOS ---
        System.out.println("\n--- RESUMEN DE LA COMPRA ---");
        System.out.println("Subtotal general: $" + subtotalGeneral);
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Costo de envío: $" + envio);
        System.out.println("Impuesto (16%): $" + impuesto);
        System.out.println("Total a pagar: $" + totalPagar);

        scanner.close();
    }

    // --- MÉTODOS REQUERIDOS ---

    public static double calcularSubtotalProducto(double precio, int cantidad) {
        return precio * cantidad;
    }

    public static double calcularSubtotalGeneral(double subtotal1, double subtotal2, double subtotal3) {
        return subtotal1 + subtotal2 + subtotal3;
    }

    public static double calcularDescuento(double subtotal, int tipoCliente) {
        if (tipoCliente == 2) {
            return subtotal * 0.10; // Cliente frecuente: 10%
        }
        return 0.0; // Cliente regular: 0%
    }

    public static double calcularEnvio(double subtotal, String codigoPostal) {
        // Aunque el código postal viene en el parámetro (exigido por la rúbrica), 
        // la regla de negocio del ejercicio depende puramente del subtotal:
        if (subtotal < 1000.0) {
            return 150.0;
        } else if (subtotal >= 1000.0 && subtotal < 3000.0) {
            return 80.0;
        } else {
            return 0.0; // Gratis si es igual o superior a 3000
        }
    }

    public static double calcularImpuesto(double subtotalConDescuento) {
        return subtotalConDescuento * 0.16; // 16% del subtotal con descuento
    }

    public static double calcularTotal(double subtotal, double descuento, double impuesto, double envio) {
        return subtotal - descuento + impuesto + envio;
    }
}