public class CustomStack {

    private StackNode _head;

    public CustomStack() {
        _head = null;
    }

    public void push(String word) {
        var node = new StackNode(word);

        // Actualizar
        if (this._head != null) {

            node.setNext(this._head);
        }


        _head = node;
    }

    public String pop() {
        String word = null;

        // Actualizar
        if (this._head != null) {

            word = this._head.getWord();


            this._head = this._head.getNext();
        }
        return word;
    }

    public int size() {
        var length = 0;

        // Actualizar
        StackNode current = this._head;
        while (current != null) {
            length++;
            // getNext()
            current = current.getNext();
        }

        return length;
    }

    public String getWords() {
        var builder = new StringBuilder("(" + size() + ") [");
        for (var word = pop(); word != null; word = pop()) {
            builder.append(" " + word);
        }
        builder.append(" ]");
        return builder.toString();
    }
}