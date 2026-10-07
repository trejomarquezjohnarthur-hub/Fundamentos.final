import java.util.Scanner;

public class costo_electrico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double CARGO_FIJO = 95.0; // Cargo fijo especificado en la regla

        double lecturaAnterior;
        double lecturaActual;
        double consumo;

        // --- 1. VALIDACIÓN DE LECTURAS ---
        do {
            System.out.print("Ingresa la lectura anterior (>= 0): ");
            lecturaAnterior = scanner.nextDouble();
            if (lecturaAnterior < 0) {
                System.out.println("Error: La lectura no puede ser negativa.");
            }
        } while (lecturaAnterior < 0);

        do {
            System.out.print("Ingresa la lectura actual (>= lectura anterior, máx. 10,000 kWh de consumo): ");
            lecturaActual = scanner.nextDouble();
            
            // Calculamos temporalmente el consumo para validar el límite de 10,000 kWh
            consumo = calcularConsumo(lecturaAnterior, lecturaActual);

            if (lecturaActual < lecturaAnterior) {
                System.out.println("Error: La lectura actual debe ser mayor o igual que la anterior.");
            } else if (consumo > 10000) {
                System.out.println("Error: El consumo excede el límite máximo permitido de 10,000 kWh.");
            }
        } while (lecturaActual < lecturaAnterior || consumo > 10000);

        // --- 2. PROGRAMA DE APOYO ---
        System.out.print("¿La vivienda pertenece al programa de apoyo? (true/false): ");
        boolean tieneApoyo = scanner.nextBoolean();

        // --- 3. LLAMADA A LOS MÉTODOS OBLIGATORIOS ---
        double costoConsumo = calcularCostoConsumo(consumo);
        
        // El costo antes de impuesto incluye el costo por consumo más el cargo fijo
        double costoAntesImpuesto = costoConsumo + CARGO_FIJO;
        
        double descuento = calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo);
        
        // Base imponible: costo antes del impuesto menos el descuento (según regla de descuento)
        double baseImponible = costoAntesImpuesto - descuento;
        double impuesto = calcularImpuesto(baseImponible);
        
        double total = calcularTotal(costoConsumo, CARGO_FIJO, descuento, impuesto);

        // --- 4. MOSTRAR RESULTADOS ---
        mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total);

        scanner.close();
    }

    // --- MÉTODOS REQUERIDOS ---

    public static double calcularConsumo(double lecturaAnterior, double lecturaActual) {
        return lecturaActual - lecturaAnterior;
    }

    public static double calcularCostoConsumo(double consumo) {
        double costo = 0;

        if (consumo <= 150) {
            costo = consumo * 1.20;
        } else if (consumo <= 400) {
            // Primeros 150 a $1.20, el resto hasta 400 a $1.80
            costo = (150 * 1.20) + ((consumo - 150) * 1.80);
        } else {
            // Primeros 150 a $1.20, siguientes 250 a $1.80, y el exceso de 400 a $2.75
            costo = (150 * 1.20) + (250 * 1.80) + ((consumo - 400) * 2.75);
        }

        return costo;
    }

    public static double calcularDescuentoApoyo(double consumo, double costoAntesImpuesto, boolean tieneApoyo) {
        // Si pertenece al programa y consume 250 kWh o menos, recibe 30% sobre el costo antes del impuesto
        if (tieneApoyo && consumo <= 250) {
            return costoAntesImpuesto * 0.30;
        }
        return 0.0;
    }

    public static double calcularImpuesto(double baseImponible) {
        return baseImponible * 0.16; // 16% de impuesto
    }

    public static double calcularTotal(double costoConsumo, double cargoFijo, double descuento, double impuesto) {
        // Costo antes del impuesto (costoConsumo + cargoFijo) - descuento + impuesto
        return (costoConsumo + cargoFijo) - descuento + impuesto;
    }

    public static void mostrarRecibo(double consumo, double costoConsumo, double descuento, double impuesto, double total) {
        System.out.println("\n--- RECIBO DE CONSUMO ELÉCTRICO ---");
        System.out.println("Consumo total: " + consumo + " kWh");
        System.out.println("Costo por consumo (bloques): $" + costoConsumo);
        System.out.println("Cargo fijo: $95.0");
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Impuesto (16%): $" + impuesto);
        System.out.println("Total a pagar: $" + total);
    }
}