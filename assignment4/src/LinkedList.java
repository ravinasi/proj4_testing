import java.util.NoSuchElementException;

public class LinkedList {

    protected Link head; // A pointer to the first link in the list
    protected Link nextLink;

    public LinkedList() {
        head = null;
        nextLink = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean hasNext() {
        return nextLink != null;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Trying to get elements after reaching the end of the list!!!");
        }
        Object toReturn = nextLink.getData();
        nextLink = nextLink.getNext();
        return toReturn;
    }

    public void reset() {
        // A method to reset the nextLink object to the head of the list.
        nextLink = head;
    }

    public int size() {
        // An extremely inefficient method to check the size of the list by
        // traversing all elements as from the first element.

        int size = 0;
        // Note the unusual bodiless for loop - try to think how it operates!
        for (Link currLink = head; currLink != null; currLink = currLink.getNext(), size++);

        return size;
    }

    public void append(Object toAppend) {
        // An extremely inefficient method to append objects at the end of the
        // list, by traversing all elements as from the first element.

        if (isEmpty()) {
            head = new Link(toAppend);
            nextLink = head;
        }
        else {
            // Finding the last element in the list:
            Link currLink = head;
            while (currLink.getNext() != null) {
                currLink = currLink.getNext();
            }

            // Adding a new link with the new data after the last link in the
            // list:
            currLink.setNext(new Link(toAppend));
        }
    }

    protected static class Link {
        // An internal class that defines "Link" objects.
        private Object data;
        private Link next;


        public Link(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Link getNext() {
            return next;
        }

        public void setNext(Link next) {
            this.next = next;
        }
    }

}