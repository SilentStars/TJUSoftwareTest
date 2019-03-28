package com.houqinhan.homework2;
import org.junit.*;
import org.junit.Assert.*;

public class PrintPrimesTest {

    PrintPrimes getPrime;

    @Before
    public void init() {
        getPrime = new PrintPrimes();
    }

    @Test
    public void test() {
        Assert.assertEquals("2 3 5 ", getPrime.printPrimes(3));
        Assert.assertEquals("2 3 5 7 11 ", getPrime.printPrimes(5));
    }
}
