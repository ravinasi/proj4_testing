import org.junit.jupiter.api.function.Executable;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void isEmpty() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
        list.append("Element");
        assertFalse(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void hasNext() {
        LinkedList list = new LinkedList();
        // add 5 arguments to the list
        for (int i = 0; i<5 ; i++)
            list.append(i);

        // checks the function hasNext
        for (int i =0 ; i<5 ; i++) {
            assertTrue(list.hasNext());
            list.next();
        }

        assertFalse(list.hasNext());

    }

    @org.junit.jupiter.api.Test
    void next() {
        LinkedList list = new LinkedList();
        for (int i = 0 ; i<5 ; i++)
            list.append(i);
        for (int i = 0 ; i<5 ; i++)
            assertSame(list.next(),i);
    }

    @org.junit.jupiter.api.Test
    void reset() {
        LinkedList list = new LinkedList();
        for (int i = 0 ; i<5 ; i++)
            list.append(i);
        list.next();
        list.next();
        assertNotEquals(0,list.next());
        list.reset();
        assertEquals(0,list.next());
    }

    @org.junit.jupiter.api.Test
    void size() {
       checkSize(0);
       checkSize(1);
       checkSize(10);
    }

    @org.junit.jupiter.api.Test
    void nextException(){
        LinkedList list = new LinkedList();
        // add 5 arguments to the list
        for (int i = 0; i<5 ; i++)
            list.append(i);
        for (int i = 0 ; i < 5; i++)
            list.next();
        Throwable exception = assertThrows(RuntimeException.class, () -> { list.next();});
        assertEquals("Trying to get elements after reaching the end of the list!!!", exception.getMessage());
    }

    void checkSize(int size) {
        LinkedList list = new LinkedList();
        for (int i =0 ; i < size ; i++)
            list.append(i);
        assertEquals(list.size(),size);
    }
}

