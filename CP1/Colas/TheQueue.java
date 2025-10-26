import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

/**
 * TheQueue
 * ----------------------------------------------------------------
 * Errores de consola al compilar:
 * C:\Users\Games\IdeaProjects\CasoPractico1(Estructura de datos)\FI24036547\CP1\Colas\TheQueue.java:52:26
 * java: cannot find symbol
 * symbol:   class Random
 * location: class TheQueue<Type>
 * ----------------------------------------------------------------
 *  Improvement
 *  Acomodar el método dequeue() para que funcione correctamente.
 *  Acomodar el método getFront() para que funcione correctamente.
 *  No usar condicionales
 *  Editar el metodo pool y el peak.
 *  ----------------------------------------------------------------
 *  Updates
 *  Los metodos dequeue() y getFront() fueron modificados para utilizar los metodos poll() y peek() de la clase Deque respectivamente.
 *  El metodo getCodons() funcione correctamente con el cambio aplicado.
 *  Un codon es una secuencia de tres nucleotidos.
 */


public class TheQueue<Type> implements TheQueueInterface<Type> {

    private Deque<Type> _queue;

    public TheQueue() {
        _queue = new ArrayDeque<Type>();
    }

    public void enqueue(Type item) {
        _queue.add(item);
    }

    public Type dequeue() {
        return _queue.poll();
    }

    public Type getFront() {
        return _queue.peek();
    }

    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    public int getSize() {
        return _queue.size();
    }

    public String[] getCodons() {
        var size = _queue.size();
        String[] codons = new String[size / 3];
        // Construir codones
        for (int i = 0; i < codons.length; i++) {
            String n1 = (String) dequeue();
            String n2 = (String) dequeue();
            String n3 = (String) dequeue();

            codons[i] = n1 + n2 + n3;
        }
        return codons;
    }

    public String print() {
        return _queue.toString();
    }

    public static void main(String[] args) {
        var amount = Integer.parseInt(args[0]);
        String[] nucleotides = {
                "A", // [0]
                "C", // [1]
                "G", // [2]
                "T", // [3]
        };
        TheQueueInterface<String> queue = new TheQueue<String>();
        var random = new Random(); // Error: cannot find symbol --> import java.util.Random;
        for (; amount > 0; amount--) {
            var index = random.nextInt(4);
            var amino = nucleotides[index];
            queue.enqueue(amino);
        }
        System.out.println("Filled {full}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
        System.out.println("\ngetCodons() → " + Arrays.toString(queue.getCodons()));
        System.out.println("\nEnd {empty}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
    }
}