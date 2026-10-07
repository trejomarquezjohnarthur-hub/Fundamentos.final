import java.util.Scanner;

public class tareabidimensional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Matriz fija de 5x5
        int MAX_FILAS = 5;
        int MAX_COLS = 5;
        int[][] matriz = new int[MAX_FILAS][MAX_COLS];
        
        // Contadores para controlar cuántas filas y columnas tienen datos
        int filas = 0;
        int columnas = 0;
        
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE MATRICES (2D) ---");
            System.out.println("1. Configurar dimensiones e insertar elementos");
            System.out.println("2. Mostrar matriz");
            System.out.println("3. Ordenar elementos (Por filas)");
            System.out.println("4. Modificar elemento en (fila, columna)");
            System.out.println("5. Eliminar (limpiar a 0) un elemento");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // INSERTAR / LLENAR MATRIZ
                    System.out.print("Ingresa el número de filas (1 a " + MAX_FILAS + "): ");
                    int f = scanner.nextInt();
                    System.out.print("Ingresa el número de columnas (1 a " + MAX_COLS + "): ");
                    int c = scanner.nextInt();

                    if (f > 0 && f <= MAX_FILAS && c > 0 && c <= MAX_COLS) {
                        filas = f;
                        columnas = c;
                        System.out.println("Ingresa los elementos de la matriz:");
                        for (int i = 0; i < filas; i++) {
                            for (int j = 0; j < columnas; j++) {
                                System.out.print("Elemento [" + i + "][" + j + "]: ");
                                matriz[i][j] = scanner.nextInt();
                            }
                        }
                        System.out.println("¡Matriz cargada con éxito!");
                    } else {
                        System.out.println("Dimensiones fuera de rango.");
                    }
                    break;

                case 2: // MOSTRAR
                    if (filas == 0 || columnas == 0) {
                        System.out.println("La matriz está vacía.");
                    } else {
                        System.out.println("Matriz actual:");
                        for (int i = 0; i < filas; i++) {
                            for (int j = 0; j < columnas; j++) {
                                System.out.print(matriz[i][j] + "\t");
                            }
                            System.out.println();
                        }
                    }
                    break;

                case 3: // ORDENAR (Bubble Sort en cada fila)
                    if (filas == 0 || columnas == 0) {
                        System.out.println("La matriz está vacía.");
                    } else {
                        System.out.print("¿Deseas ordenar cada fila de forma (A)scendente o (D)escendente?: ");
                        char modo = scanner.next().toUpperCase().charAt(0);

                        if (modo == 'A' || modo == 'D') {
                            // Ordenamos cada fila individualmente usando el método Burbuja
                            for (int i = 0; i < filas; i++) {
                                for (int k = 0; k < columnas - 1; k++) {
                                    for (int j = 0; j < columnas - k - 1; j++) {
                                        boolean condicion = (modo == 'A') 
                                            ? (matriz[i][j] > matriz[i][j + 1]) 
                                            : (matriz[i][j] < matriz[i][j + 1]);

                                        if (condicion) {
                                            int aux = matriz[i][j];
                                            matriz[i][j] = matriz[i][j + 1];
                                            matriz[i][j + 1] = aux;
                                        }
                                    }
                                }
                            }
                            System.out.println("¡Filas de la matriz ordenadas correctamente!");
                        } else {
                            System.out.println("Opción de ordenamiento no válida.");
                        }
                    }
                    break;

                case 4: // MODIFICAR
                    if (filas == 0 || columnas == 0) {
                        System.out.println("La matriz está vacía.");
                    } else {
                        System.out.print("Ingresa el índice de fila (0 a " + (filas - 1) + "): ");
                        int posF = scanner.nextInt();
                        System.out.print("Ingresa el índice de columna (0 a " + (columnas - 1) + "): ");
                        int posC = scanner.nextInt();

                        if (posF >= 0 && posF < filas && posC >= 0 && posC < columnas) {
                            System.out.print("Ingresa el nuevo valor: ");
                            matriz[posF][posC] = scanner.nextInt();
                            System.out.println("¡Elemento modificado con éxito!");
                        } else {
                            System.out.println("Posición inválida.");
                        }
                    }
                    break;

                case 5: // ELIMINAR (Reiniciar posición a 0)
                    if (filas == 0 || columnas == 0) {
                        System.out.println("La matriz está vacía.");
                    } else {
                        System.out.print("Ingresa la fila a eliminar (0 a " + (filas - 1) + "): ");
                        int posF = scanner.nextInt();
                        System.out.print("Ingresa la columna a eliminar (0 a " + (columnas - 1) + "): ");
                        int posC = scanner.nextInt();

                        if (posF >= 0 && posF < filas && posC >= 0 && posC < columnas) {
                            matriz[posF][posC] = 0; // Se establece a 0 como valor nulo por defecto
                            System.out.println("¡Elemento reestablecido a 0 con éxito!");
                        } else {
                            System.out.println("Posición inválida.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}