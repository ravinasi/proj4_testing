public class Main4 {
    public static void main(String[] args) {
        // Normal usage:
        System.out.println("Creating a new empty list.");
        LinkedList list = new LinkedList();
        System.out.println("List size: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        System.out.println("Adding to the list the Objects \"A\", \"B\", and \"C\".");
        list.append("A");
        list.append("B");
        list.append("C");
        System.out.println("List size: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        System.out.println("Traversing the list and printing all its elements:");
        list.reset();
        while (list.hasNext()) {
            System.out.println(list.next());
        }

        // Now using a class which inherited the LinkedList class, and allows
        // to create an illegal cyclic list:
        HackedLinkedList hackedList = generateCyclicList();

        // Trying to loop over all elements will cause an infinite loop, unless
        // we limit the number of iterations:
        System.out.println("Traversing the hacked list and printing all its elements:");
        hackedList.reset();
        int maxIters = 10;
        int currIter = 0;
        while (currIter < maxIters && hackedList.hasNext()) {
            System.out.println(hackedList.next());
            currIter++;
        }
    }

    public static HackedLinkedList generateCyclicList() {
        HackedLinkedList list = new HackedLinkedList();
        for (int i = 0; i < 5; i++) {
            list.append(i);
        }

        // Obtaining a pointer to the second list element:
        list.reset();
        LinkedList.Link p = list.getNextLink().getNext();

        // Obtaining a pointer to the last element in the list, and setting
        // it's "next" to be p:
        LinkedList.Link q = p.getNext().getNext().getNext();
        q.setNext(p);

        return list;
    }

    public static boolean isCyclic(LinkedList list) {
        // Bonus question: write here a code that checks if a given list is
        // cyclic, i.e. if there is a link in the list that his "next" pointer
        // points into some previous link in the list.

        // TODO: edit the code to return the correct answer, and write a
        //  corresponding test.
        return false;
    }
}
