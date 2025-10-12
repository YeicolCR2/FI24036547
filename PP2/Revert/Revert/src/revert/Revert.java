package revert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Stack;

/**
 * Clase Revert
 * Lee el contenido del archivo "input.txt", lo invierte utilizando una Pila (Stack)
 * de caracteres, y escribe el resultado invertido en el archivo "output.txt".
 */
public class Revert {

    // Nombres de los archivos
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) {
        // 1. Crear la pila para almacenar los caracteres
        Stack<Character> stack = new Stack<>();

        // 2. Leer el archivo de entrada e ingresar los caracteres a la pila
        System.out.println("Leyendo el archivo: " + INPUT_FILE + "...");
        readAndPushToStack(stack);
        System.out.println("Lectura completada. Pila llenada con " + stack.size() + " caracteres.");

        // 3. Vaciar la pila y escribir el con tenido invertido en el archivo de salida
        System.out.println("Escribiendo el contenido invertido en: " + OUTPUT_FILE + "...");
        popAndWriteToFile(stack);
        System.out.println("Proceso completado. El contenido del archivo ha sido invertido exitosamente.");
    }

    private static void readAndPushToStack(Stack<Character> stack) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            int charCode;
            // El método read() de BufferedReader devuelve un entero (el código del carácter), 
            while ((charCode = reader.read()) != -1) {
                // Se convierte el código entero al tipo Character y se ingresa a la pila
                char character = (char) charCode;
                stack.push(character);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de entrada: " + e.getMessage());
        }
    }

    private static void popAndWriteToFile(Stack<Character> stack) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE, false))) { // El 'false' asegura que se sobreescriba el archivo
            
            // Mientras la pila no esté vacía
            while (!stack.isEmpty()) {
                // Extraer el elemento de la cima (pop)
                char character = stack.pop();
                // Escribir el carácter en el archivo
                writer.print(character);
            }
            
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de salida: " + e.getMessage());
        }
    }
}