import java.util.Scanner;

public class Banquetes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el numero de personas en el banquete ");
        int personas = sc.nextInt();
         if(personas>200&&personas>300){
            int c=personas*80;
            System.out.println("El costo total del banquete es " +c);
         }else if (personas>300){
            int c=personas*75;
            System.out.println("El costo total del banquete es "+c);
         }else {
            int c=personas*95;
            System.out.println("El costo total del banquete es "+c);}

    }
}
