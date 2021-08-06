package DSC30.PA1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IntStackTest {
    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        IntStack i = new IntStack(4);
    }

    @Test
    public void test2() {
        IntStack s = new IntStack(10);
        int[] push = { 1, 2, 3, 4, 5, 6, 7, 8 };
        s.multiPush(push);
        assertEquals(s.size(), push.length);
        int[] pop = s.multiPop(3);
        int[] realPop = { 8, 7, 6 };
        assertArrayEquals(realPop, pop);
        assertEquals(s.peek(), s.pop());
    }
}
