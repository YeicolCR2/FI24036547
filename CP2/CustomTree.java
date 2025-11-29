import java.util.Stack;

public class CustomTree {

    private TreeNode _root;

    public CustomTree() {
        _root = null;
    }

    public void insert(double tf, String word) {
        _root = insert(_root, tf, word);
    }

    private TreeNode insert(TreeNode node, double tf, String word) {

        // Actualizar

        if (node == null) {
            return new TreeNode(tf, word);
        }


        if (tf < node.getTf()) {
            // getLeft() y setLeft()
            node.setLeft(insert(node.getLeft(), tf, word));
        }

        else if (tf > node.getTf()) {
            //  getRight() y setRight()
            node.setRight(insert(node.getRight(), tf, word));
        }

        else {
            // Usamos el método addWord() de TreeNode (que internamente hace push a la pila)
            node.addWord(word);
        }

        return node;
    }

    public String getInOrderTraversal() {
        return getInOrderTraversal(_root);
    }

    private String getInOrderTraversal(TreeNode root) {
        var builder = new StringBuilder();
        var stack = new Stack<TreeNode>();
        var node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            builder.append(node.getTf() + "\n ↳ " + node.getWords() + "\n\n");
            node = node.getRight();
        }
        return builder.toString();
    }
}
