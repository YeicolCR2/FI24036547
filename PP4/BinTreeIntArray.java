
import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {

        // Actualizar


            int i = 0;
            while (i < _tree.length) {
                if (_tree[i] == null) {      // posición vacía → insertar
                    _tree[i] = value;
                    break;
                } else if (value < _tree[i]) {
                    i = 2 * i + 1;           // ir a left
                } else {
                    i = 2 * i + 2;           // ir a right
                }
            }

            System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));

    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        var stack = new Stack<Integer>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int i = stack.pop();

            if (i >= _tree.length || _tree[i] == null)
                continue;

            System.out.print(_tree[i] + " ");


            int right = 2 * i + 2;
            int left = 2 * i + 1;

            if (right < _tree.length && _tree[right] != null)
                stack.push(right);
            if (left < _tree.length && _tree[left] != null)
                stack.push(left);
        }

        System.out.println();
    }


    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        var stack1 = new Stack<Integer>();
        var stack2 = new Stack<Integer>();

        stack1.push(0);

        while (!stack1.isEmpty()) {
            int i = stack1.pop();

            if (i >= _tree.length || _tree[i] == null)
                continue;

            stack2.push(i);

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < _tree.length && _tree[left] != null)
                stack1.push(left);
            if (right < _tree.length && _tree[right] != null)
                stack1.push(right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(_tree[stack2.pop()] + " ");
        }

        System.out.println();
    }


    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
