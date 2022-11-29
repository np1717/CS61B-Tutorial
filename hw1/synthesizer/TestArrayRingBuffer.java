package synthesizer;
import org.junit.Test;

import java.net.InetSocketAddress;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(17);
        arb.enqueue(23);
        assertEquals(arb.dequeue(),17);
        assertNotEquals(arb.dequeue(),17);

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
