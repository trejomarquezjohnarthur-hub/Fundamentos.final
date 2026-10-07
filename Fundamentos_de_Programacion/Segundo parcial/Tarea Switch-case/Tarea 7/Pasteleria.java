import java.util.Scanner;

public class Pasteleria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        
        System.out.print("¿Qué sabor quieres (manzana, fresa, chocolate)?: ");
        String sabor = sc.next().toLowerCase();
        
        if (sabor.equals("manzana")) {
            total = 200;
        } else if (sabor.equals("fresa")) {
            total = 250;
        } else if (sabor.equals("chocolate")) {
            System.out.print("¿El chocolate es negro o blanco?: ");
            String tipoChoco = sc.next().toLowerCase();
            if (tipoChoco.equals("negro")) {
                total = 280;
            } else {
                total = 300;
            }
        }
        
        System.out.print("¿Añadir snack (si/no)?: ");
        if (sc.next().toLowerCase().equals("si")) {
            total += 25;
        }
        
        System.out.print("¿Personalizar con nombre (si/no)?: ");
        if (sc.next().toLowerCase().equals("si")) {
            total += 30;
        }
        
        System.out.println("El presupuesto total de la tarta es: $" + total);
        sc.close();
    }
}