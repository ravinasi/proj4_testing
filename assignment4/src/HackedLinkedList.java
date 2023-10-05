public class HackedLinkedList extends LinkedList{
    // This class shows why it is sometimes unsafe to use protected elements.
    // While the mother class did not supply direct access to the Link objects,
    // this class does, and doing so it allows to external users to cause Lists
    // to be in invalid states.

    public Link getNextLink() {
        return nextLink;
    }

}
