public class CustomQueue {

    private QueueNode _head;

    public CustomQueue() {
        _head = null;
    }

    public void enqueue(int index) {
        var node = new QueueNode(index);

        // Actualizar
        if (this._head == null) {
            this._head = node;
        } else {

            QueueNode current = this._head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(node);
        }
    }

    public int dequeue() {
        var index = -1;

        // Actualizar
        if (this._head != null) {

            index = this._head.getIndex();

            this._head = this._head.getNext();
        }

        return index;

    }

    public int getSize() {
        var size = 0;

        // Actualizar
        QueueNode current = this._head;
        while (current != null) {
            size++;
            //  getNext()
            current = current.getNext();
        }
        return size;
    }

    public String getIndexes() {
        var builder = new StringBuilder();
        for (var index = dequeue(); index > -1; index = dequeue()) {
            builder.append(" " + index);
        }
        return builder.toString();
    }
}
