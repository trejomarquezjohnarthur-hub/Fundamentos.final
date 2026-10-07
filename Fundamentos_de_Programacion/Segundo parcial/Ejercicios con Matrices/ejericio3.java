import java.util.Scanner;

public class ejericio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de estudiantes (N): ");
        int n = sc.nextInt();
        System.out.print("Ingrese la cantidad de exámenes (M): ");
        int m = sc.nextInt();

        double[][] calificaciones = new double[n][m];

        // Lectura de calificaciones
        System.out.println("\n--- INGRESO DE CALIFICACIONES ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Estudiante " + (i + 1) + ":");
            for (int j = 0; j < m; j++) {
                double nota;
                do {
                    System.out.print("  Examen " + (j + 1) + " (0 a 10): ");
                    nota = sc.nextDouble();
                    if (nota < 0 || nota > 10) {
                        System.out.println("  Nota inválida. Debe estar entre 0 y 10.");
                    }
                } while (nota < 0 || nota > 10);
                calificaciones[i][j] = nota;
            }
        }

        // Mostrar matriz original
        System.out.println("\n--- TABLA DE CALIFICACIONES ---");
        System.out.print("Estudiante\t");
        for (int j = 0; j < m; j++) {
            System.out.print("Examen " + (j + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("Est. " + (i + 1) + "\t\t");
            for (int j = 0; j < m; j++) {
                System.out.print(calificaciones[i][j] + "\t\t");
            }
            System.out.println();
        }

        // 1. Calcular el promedio de cada uno de los N estudiantes
        double[] promediosEstudiantes = new double[n];
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < m; j++) {
                suma += calificaciones[i][j];
            }
            promediosEstudiantes[i] = suma / m;
        }

        System.out.println("\n--- PROMEDIOS DE CADA ESTUDIANTE ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Estudiante %d: %.2f\n", (i + 1), promediosEstudiantes[i]);
        }

        // 2. Estudiantes con promedio entre 9 y 10 (Generar nueva matriz)
        int contSobresalientes = 0;
        for (int i = 0; i < n; i++) {
            if (promediosEstudiantes[i] >= 9.0 && promediosEstudiantes[i] <= 10.0) {
                contSobresalientes++;
            }
        }

        System.out.println("\n--- ESTUDIANTES CON MEJOR CALIFICACIÓN (PROMEDIO ENTRE 9 Y 10) ---");
        if (contSobresalientes > 0) {
            // Matriz nueva: Filas = alumnos con nota [9,10], Columnas = M exámenes + 1 (para guardar el promedio al final)
            double[][] matrizSobresalientes = new double[contSobresalientes][m + 1];
            int idx = 0;

            for (int i = 0; i < n; i++) {
                if (promediosEstudiantes[i] >= 9.0 && promediosEstudiantes[i] <= 10.0) {
                    for (int j = 0; j < m; j++) {
                        matrizSobresalientes[idx][j] = calificaciones[i][j];
                    }
                    matrizSobresalientes[idx][m] = promediosEstudiantes[i];
                    System.out.printf("Estudiante %d -> Promedio: %.2f\n", (i + 1), promediosEstudiantes[i]);
                    idx++;
                }
            }
        } else {
            System.out.println("No hay estudiantes con promedio entre 9.0 y 10.0.");
        }

        // 3. Estudiantes con promedio inferior a 7.0 (Generar nueva matriz)
        int contReprobados = 0;
        for (int i = 0; i < n; i++) {
            if (promediosEstudiantes[i] < 7.0) {
                contReprobados++;
            }
        }

        System.out.println("\n--- ESTUDIANTES CON PROMEDIO INFERIOR A 7.0 ---");
        if (contReprobados > 0) {
            // Matriz nueva: Filas = alumnos con nota < 7, Columnas = M exámenes + 1
            double[][] matrizReprobados = new double[contReprobados][m + 1];
            int idx = 0;

            for (int i = 0; i < n; i++) {
                if (promediosEstudiantes[i] < 7.0) {
                    for (int j = 0; j < m; j++) {
                        matrizReprobados[idx][j] = calificaciones[i][j];
                    }
                    matrizReprobados[idx][m] = promediosEstudiantes[i];
                    System.out.printf("Estudiante %d -> Promedio: %.2f\n", (i + 1), promediosEstudiantes[i]);
                    idx++;
                }
            }
        } else {
            System.out.println("No hay estudiantes con promedio inferior a 7.0.");
        }

        // Promedios por examen (por columnas)
        double[] promediosExamenes = new double[m];
        for (int j = 0; j < m; j++) {
            double suma = 0;
            for (int i = 0; i < n; i++) {
                suma += calificaciones[i][j];
            }
            promediosExamenes[j] = suma / n;
        }

        // 4 y 5. Examen con promedio más alto y más bajo
        double maxPromExamen = promediosExamenes[0];
        double minPromExamen = promediosExamenes[0];

        for (int j = 1; j < m; j++) {
            if (promediosExamenes[j] > maxPromExamen) {
                maxPromExamen = promediosExamenes[j];
            }
            if (promediosExamenes[j] < minPromExamen) {
                minPromExamen = promediosExamenes[j];
            }
        }

        System.out.println("\n--- ANÁLISIS POR EXAMEN ---");
        System.out.print("Examen(es) con el promedio MÁS ALTO (Promedio: " + String.format("%.2f", maxPromExamen) + "): ");
        for (int j = 0; j < m; j++) {
            if (promediosExamenes[j] == maxPromExamen) {
                System.out.print("Examen " + (j + 1) + " ");
            }
        }
        System.out.println();

        System.out.print("Examen(es) con el promedio MÁS BAJO (Promedio: " + String.format("%.2f", minPromExamen) + "): ");
        for (int j = 0; j < m; j++) {
            if (promediosExamenes[j] == minPromExamen) {
                System.out.print("Examen " + (j + 1) + " ");
            }
        }
        System.out.println();

        sc.close();
    }
}