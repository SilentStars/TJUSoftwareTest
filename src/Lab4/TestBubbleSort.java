package Lab4;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestBubbleSort {
    @Test
    public void testBubbleSort() {
        assertEquals(true, Arrays.equals(BubbleSort.BubbleSort(new int[]{3, 5, 7, 1, 5, 2}),
                new int[]{1, 2, 3, 5, 5, 7}));
        assertEquals(true, Arrays.equals(BubbleSort.BubbleSort(new int[]{2, -1, 15, -4, 5, 2, 0, 7}),
                new int[]{-4, -1, 0, 2, 2, 5, 7, 15}));
        assertEquals(true, Arrays.equals(BubbleSort.BubbleSort(new int[]{0}), new int[]{0}));
    }
}



