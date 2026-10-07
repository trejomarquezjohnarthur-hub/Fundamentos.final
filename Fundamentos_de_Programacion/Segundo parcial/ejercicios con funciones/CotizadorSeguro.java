import java.util.Scanner;

public class CotizadorSeguro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Lectura y validación del valor del vehículo (> 0)
        double valorVehiculo;
        do {
            System.out.print("Ingresa el valor del vehículo (> 0): ");
            valorVehiculo = scanner.nextDouble();
            if (valorVehiculo <= 0) {
                System.out.println("Error: El valor debe ser mayor a cero.");
            }
        } while (valorVehiculo <= 0);

        // 2. Lectura y validación de la edad (18 a 100)
        int edad;
        do {
            System.out.print("Ingresa la edad del conductor (18-100): ");
            edad = scanner.nextInt();
            if (edad < 18 || edad > 100) {
                System.out.println("Error: La edad debe estar entre 18 y 100 años.");
            }
        } while (edad < 18 || edad > 100);

        // 3. Lectura y validación de accidentes (>= 0)
        int accidentes;
        do {
            System.out.print("Ingresa la cantidad de accidentes reportados (>= 0): ");
            accidentes = scanner.nextInt();
            if (accidentes < 0) {
                System.out.println("Error: El número de accidentes no puede ser negativo.");
            }
        } while (accidentes < 0);

        // 4. Sistema de seguridad adicional
        System.out.print("¿Tiene sistema de seguridad adicional? (true/false): ");
        boolean tieneSeguridad = scanner.nextBoolean();

        // --- LLAMADA A LOS MÉTODOS OBLIGATORIOS ---
        double tarifaBase = calcularTarifaBase(valorVehiculo);
        double recargoEdad = calcularRecargoPorEdad(tarifaBase, edad);
        double recargoAccidentes = calcularRecargoPorAccidentes(tarifaBase, accidentes);
        
        // El subtotal es la tarifa base más los recargos
        double subtotalAcumulado = tarifaBase + recargoEdad + recargoAccidentes;
        double descuento = calcularDescuentoSeguridad(subtotalAcumulado, tieneSeguridad);
        
        double costoFinal = calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento);

        // Resultados
        System.out.println("\n--- RESUMEN DE COTIZACIÓN ---");
        System.out.println("Tarifa base: $" + tarifaBase);
        System.out.println("Recargo por edad: $" + recargoEdad);
        System.out.println("Recargo por accidentes: $" + recargoAccidentes);
        System.out.println("Descuento por seguridad: $" + descuento);
        System.out.println("Costo final de la póliza: $" + costoFinal);

        scanner.close();
    }

    // --- MÉTODOS REQUERIDOS ---

    public static double calcularTarifaBase(double valorVehiculo) {
        return valorVehiculo * 0.04; // 4% del valor (cuidado: no es 0.4 que sería 40%)
    }

    public static double calcularRecargoPorEdad(double tarifaBase, int edad) {
        if (edad < 25) {
            return tarifaBase * 0.20; // 20% de recargo
        } else if (edad > 60) {
            return tarifaBase * 0.10; // 10% de recargo
        }
        return 0.0; // Entre 25 y 60 años no hay recargo
    }

    public static double calcularRecargoPorAccidentes(double tarifaBase, int accidentes) {
        return tarifaBase * 0.08 * accidentes; // 8% por cada accidente
    }

    public static double calcularDescuentoSeguridad(double subtotal, boolean tieneSeguridad) {
        if (tieneSeguridad) {
            return subtotal * 0.05; // 5% de descuento sobre el total acumulado
        }
        return 0.0;
    }

    public static double calcularCostoFinal(double tarifaBase, double recargoEdad, double recargoAccidentes, double descuento) {
        return (tarifaBase + recargoEdad + recargoAccidentes) - descuento;
    }
}