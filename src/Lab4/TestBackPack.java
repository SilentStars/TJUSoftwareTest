package Lab4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBackPack {
    private int m,n;
    private int w[], p[], c[][];

    @Before
    public void setUp() {
        m = 10;
        n = 3;
        w = new int[] {3, 4, 5};
        p = new int[] {4, 5, 6};
    }
    @Test
    public void testBackPack() {
        assertEquals(11, this.c[n][m]);
    }
}
