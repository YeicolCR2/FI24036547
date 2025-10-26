/**
 * Numbers
 * ----------------------------------------------------------------
 error: Class names, 'Numbers', are only accepted if annotation processing is explicitly requested
 1 error
 PS C:\Users\Games\IdeaProjects\CasoPractico1(Estructura de datos)\FI24036547\CP1\Recursividad> javac Numbers.java
 Numbers.java:6: error: non-static method round(double) cannot be referenced from a static context
 return round((z + Math.sqrt(4 + Math.pow(z, 2))) / 2);
 ^
 Numbers.java:10: error: non-static method round(double) cannot be referenced from a static context
 return round(recursive(z, N) / recursive(z, N - 1));
 ^
 Numbers.java:14: error: non-static method round(double) cannot be referenced from a static context
 return round(iterative(z, N) / iterative(z, N - 1));
 ^
 3 errors
 * ----------------------------------------------------------------
 *  Improvement
 * - Optimizar el metodo iterative para que funcione correctamente
 *
 *  ----------------------------------------------------------------
 *  Updates
 * implementar el mismo algortimo de modo iterativo
 * ----------------------------------------------------------------
 * chatbot
 *
 * GhatGPT
 * Donde esta el error de compilacion?
 * El compilador te indica que el método round no puede ser  Para corregirlo,
 * llamado desde el contexto estático del main (a través de los métodos públicos de la clase).
 * debemos hacerlo un método de utilidad static.
 *
 */

public class Numbers {

    private static double N = 25;

    public static double formula(double z) {
        return round((z + Math.sqrt(4 + Math.pow(z, 2))) / 2);
    }

    public static double recursive(double z) {
        return round(recursive(z, N) / recursive(z, N - 1));
    }

    public static double iterative(double z) {
        return round(iterative(z, N) / iterative(z, N - 1));
    }

    private static double recursive(double z, double n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return z * recursive(z, n - 1) + recursive(z, n - 2);    } //implementacion correcta

    private static double iterative(double z, double n) {
        // Casos Base: Manejados fuera del bucle.
        if (n == 0 || n == 1) {
            return 1;
        }

        // Inicializar los dos primeros valores de la secuencia.
        double n_minus_2 = 1.0; // Representa f(z, 0)
        double n_minus_1 = 1.0; // Representa f(z, 1)
        double current_value = 0.0;

        // Empezamos desde i=2 hasta el índice 'n'.
        for (int i = 2; i <= n; i++) {
            // Calcular el valor actual: z * f(n-1) + f(n-2)
            current_value = z * n_minus_1 + n_minus_2;

            // Desplazar los valores para la siguiente iteración.
            n_minus_2 = n_minus_1;
            n_minus_1 = current_value;
        }

        return current_value;
    }
    private static double round(double value) { //cambio a static
        var ROUND = 10000000000.0;
        return Math.round(value * ROUND) / ROUND;
    }

    public static void main(String[] args) {
        String[] metallics = {
                "Platinum", // [0]
                "Golden", // [1]
                "Silver", // [2]
                "Bronze", // [3]
                "Copper", // [4]
                "Nickel", // [5]
                "Aluminum", // [6]
                "Iron", // [7]
                "Tin", // [8]
                "Lead", // [9]
        };
        for (var z = 0; z < metallics.length; z++) {
            System.out.println("\n[" + z + "] " + metallics[z]);
            System.out.println(" ↳ formula(" + z + ")   ≈ " + formula(z));
            System.out.println(" ↳ recursive(" + z + ") ≈ " + recursive(z));
            System.out.println(" ↳ iterative(" + z + ") ≈ " + iterative(z));
        }
    }
}
