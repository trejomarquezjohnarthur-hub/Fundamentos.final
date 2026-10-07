import java.util.Scanner;

public class Paqueteria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la zona (1=America del Norte, 2=America Central, 3=America del Sur, 4=Europa, 5=Asia): ");
        int zona = sc.nextInt();

        System.out.print("Ingrese el peso del paquete en kg: ");
        double pesoKg = sc.nextDouble();

        double costoGramo;
        boolean zonaValida = true;

        switch (zona) {
            case 1: costoGramo = 11; break;
            case 2: costoGramo = 10; break;
            case 3: costoGramo = 12; break;
            case 4: costoGramo = 25; break;
            case 5: costoGramo = 30; break;
            default:
                costoGramo = 0;
                zonaValida = false;
        }

        if (!zonaValida) {
            System.out.println("Zona invalida.");
        } else if (pesoKg > 5) {
            System.out.println("Paquete rechazado: supera el peso maximo permitido (5 kg).");
        } else {
            double pesoGramos = pesoKg * 1000;
            double total = pesoGramos * costoGramo;
            System.out.println("Costo total del envio: $" + total);
        }

        sc.close();
    }
}