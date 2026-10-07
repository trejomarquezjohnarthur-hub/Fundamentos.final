import java.util.Scanner;

public class ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int TAM = 4;
        int[][] matriz = new int[TAM][TAM];
        boolean matrizLlenada = false; // Control para validar si la matriz ya se rellenó
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE MATRIZ 4x4 ---");
            System.out.println("1. Rellenar TODA la matriz (sin valores repetidos)");
            System.out.println("2. Suma de cada una de las filas y columnas");
            System.out.println("3. Suma de una fila específica");
            System.out.println("4. Suma de una columna específica");
            System.out.println("5. Mayor y menor número con sus posiciones");
            System.out.println("6. Contar números pares");
            System.out.println("7. Contar números impares");
            System.out.println("8. Generar nueva matriz con el cuadrado de los valores");
            System.out.println("9. Sumar la diagonal principal");
            System.out.println("10. Sumar la diagonal inversa");
            System.out.println("11. Media de todos los valores de la matriz");
            System.out.println("12. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            // Verificación: Si no es la opción 1 ni 12, se requiere que la matriz esté llena
            if (!matrizLlenada && opcion != 1 && opcion != 12) {
                System.out.println("\n¡DEBES RELLENAR LA MATRIZ PRIMERO! Selecciona la opción 1.");
                continue;
            }

            // Si la matriz ya se rellenó y no es la opción 1 ni 12, mostramos la matriz original siempre
            if (matrizLlenada && opcion >= 2 && opcion <= 11) {
                mostrarMatriz(matriz);
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- RELLENANDO LA MATRIZ ---");
                    for (int i = 0; i < TAM; i++) {
                        for (int j = 0; j < TAM; j++) {
                            int valor;
                            boolean repetido;
                            do {
                                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                                valor = sc.nextInt();
                                repetido = existeEnMatriz(matriz, i, j, valor);

                                if (repetido) {
                                    System.out.println("Error: El número " + valor + " ya se encuentra en la matriz. Introduce otro.");
                                }
                            } while (repetido);

                            matriz[i][j] = valor;
                        }
                    }
                    matrizLlenada = true;
                    System.out.println("¡Matriz rellenada con éxito!");
                    break;

                case 2:
                    System.out.println("\n--- SUMA DE CADA FILA Y COLUMNA ---");
                    for (int i = 0; i < TAM; i++) {
                        int sumaFila = 0;
                        int sumaCol = 0;
                        for (int j = 0; j < TAM; j++) {
                            sumaFila += matriz[i][j];
                            sumaCol += matriz[j][i];
                        }
                        System.out.println("Suma de la Fila " + i + ": " + sumaFila);
                        System.out.println("Suma de la Columna " + i + ": " + sumaCol);
                    }
                    break;

                case 3:
                    System.out.println("\n--- SUMA DE UNA FILA ESPECÍFICA ---");
                    int filaElegida;
                    do {
                        System.out.print("Elige una fila (0 a " + (TAM - 1) + "): ");
                        filaElegida = sc.nextInt();
                        if (filaElegida < 0 || filaElegida >= TAM) {
                            System.out.println("Fila inválida. Debe estar entre 0 y " + (TAM - 1) + ".");
                        }
                    } while (filaElegida < 0 || filaElegida >= TAM);

                    int sumaFilaEsp = 0;
                    for (int j = 0; j < TAM; j++) {
                        sumaFilaEsp += matriz[filaElegida][j];
                    }
                    System.out.println("La suma de la fila " + filaElegida + " es: " + sumaFilaEsp);
                    break;

                case 4:
                    System.out.println("\n--- SUMA DE UNA COLUMNA ESPECÍFICA ---");
                    int colElegida;
                    do {
                        System.out.print("Elige una columna (0 a " + (TAM - 1) + "): ");
                        colElegida = sc.nextInt();
                        if (colElegida < 0 || colElegida >= TAM) {
                            System.out.println("Columna inválida. Debe estar entre 0 y " + (TAM - 1) + ".");
                        }
                    } while (colElegida < 0 || colElegida >= TAM);

                    int sumaColEsp = 0;
                    for (int i = 0; i < TAM; i++) {
                        sumaColEsp += matriz[i][colElegida];
                    }
                    System.out.println("La suma de la columna " + colElegida + " es: " + sumaColEsp);
                    break;

                case 5:
                    int mayor = matriz[0][0], menor = matriz[0][0];
                    int posFilaMayor = 0, posColMayor = 0;
                    int posFilaMenor = 0, posColMenor = 0;

                    for (int i = 0; i < TAM; i++) {
                        for (int j = 0; j < TAM; j++) {
                            if (matriz[i][j] > mayor) {
                                mayor = matriz[i][j];
                                posFilaMayor = i;
                                posColMayor = j;
                            }
                            if (matriz[i][j] < menor) {
                                menor = matriz[i][j];
                                posFilaMenor = i;
                                posColMenor = j;
                            }
                        }
                    }
                    System.out.println("\nNúmero mayor: " + mayor + " en la posición [" + posFilaMayor + "][" + posColMayor + "]");
                    System.out.println("Número menor: " + menor + " en la posición [" + posFilaMenor + "][" + posColMenor + "]");
                    break;

                case 6:
                    int pares = 0;
                    for (int i = 0; i < TAM; i++) {
                        for (int j = 0; j < TAM; j++) {
                            if (matriz[i][j] % 2 == 0) {
                                pares++;
                            }
                        }
                    }
                    System.out.println("\nCantidad de números pares: " + pares);
                    break;

                case 7:
                    int impares = 0;
                    for (int i = 0; i < TAM; i++) {
                        for (int j = 0; j < TAM; j++) {
                            if (matriz[i][j] % 2 != 0) {
                                impares++;
                            }
                        }
                    }
                    System.out.println("\nCantidad de números impares: " + impares);
                    break;

                case 8:
                    System.out.println("\n--- MATRIZ CON LOS CUADRADOS DE CADA VALOR ---");
                    int[][] matrizCuadrados = new int[TAM][TAM];
                    for (int i = 0; i < TAM; i++) {
                        for (int j = 0; j < TAM; j++) {
                            matrizCuadrados[i][j] = matriz[i][j] * matriz[i][j];
                            System.out.print(matrizCuadrados[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 9:
                    int sumaDiagonalPrincipal = 0;
                    for (int i = 0; i < TAM; i++) {
                        sumaDiagonalPrincipal += matriz[i][i];
                    }
                    System.out.println("\nSuma de la diagonal principal: " + sumaDiagonalPrincipal);
                    break;

                case 10:
                    int sumaDiagonalInversa = 0;
                    for (int i = 0; i < TAM; i++) {
                        sumaDiagonalInversa += matriz[i][TAM - 1 - i];
                    }
                    System.out.println("\nSuma de la diagonal inversa: " + sumaDiagonalInversa);
                    break;

                case 11:
                    double sumaTotal = 0;
                    for (int i = 0; i < TAM; i++) {
                        for (int j = 0; j < TAM; j++) {
                            sumaTotal += matriz[i][j];
                        }
                    }
                    double media = sumaTotal / (TAM * TAM);
                    System.out.println("\nLa media de todos los valores de la matriz es: " + media);
                    break;

                case 12:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 12);

        sc.close();
    }

    // Método auxiliar para verificar si un valor ya se encuentra en la matriz
    public static boolean existeEnMatriz(int[][] matriz, int filaActual, int colActual, int valor) {
        for (int i = 0; i <= filaActual; i++) {
            int limiteCol = (i == filaActual) ? colActual : matriz[i].length;
            for (int j = 0; j < limiteCol; j++) {
                if (matriz[i][j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método auxiliar para mostrar la matriz original
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("\nMatriz original:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}