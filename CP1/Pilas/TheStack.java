import java.util.Random;
import java.util.Stack;


/**
 * TheStack
 * ----------------------------------------------------------------
 * TheStack.java:4: error: TheStack is not abstract and does not override abstract method size() in TheStackInterface
 * public class TheStack<Type> implements TheStackInterface<Type> {
 * TheStack.java:35: error: size() in TheStack cannot implement size() in TheStackInterface
 * public int size() {
 * return type int is not compatible with Integer
 * TheStack.java:31: error: empty() in TheStack cannot implement empty() in TheStackInterface
 * public boolean empty() {
 return type boolean is not compatible with Boolean
 3 errors
 * ----------------------------------------------------------------
 *  Improvement
 *  Arreglar el push para que funcione correctamente con la capacidad.
 * Retornar un valorBoolean
 *  ----------------------------------------------------------------
 *  Updates
 * El metodo push, modificar el pool y peek
 */


public class TheStack<Type> implements TheStackInterface<Type> {

    private Stack<Type> _stack;

    private Integer _capacity;

    public TheStack(Integer capacity) {
        _stack = new Stack<Type>();
        _capacity = capacity;
    }

    public Boolean push(Type item) {
        var available = _stack.size() < _capacity;
        if (available) {
            _stack.push(item); // Llamada recursiva corregida
        }
        return available;
    }

    public Type pop() { // manejar el caso de pila vacía
        if (_stack.isEmpty()) {
            return null;
        }
        return _stack.pop();
    }

    public Type peek() {    //manejar el caso de pila vacía
        if (_stack.isEmpty()) {
            return null;
        }
        return _stack.peek();
    }

    public Boolean empty() {
        return _stack.isEmpty();
    }

    public Integer size() { // Integer en lugar de int
        return _stack.size();
    }

    public String print() {
        return _stack.toString();
    }

    public static void main(String[] args) {
        var capacity = Integer.parseInt(args[0]);
        TheStackInterface<Double> stack = new TheStack<Double>(capacity);
        System.out.println("Pushing {capacity + 1}");
        var random = new Random();
        for (var n = 0; n <= capacity; n++) {
            var number = random.nextDouble();
            var pushed = stack.push(number);
            System.out.println(" ↳ push(" + number + ") → " + pushed);
        }
        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
        System.out.println();
        System.out.println("Popping {capacity + 1}");
        for (var n = 0; n <= capacity; n++) {
            var popped = stack.pop();
            System.out.println(" ↳ pop() → " + popped);
        }
        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
    }
}
