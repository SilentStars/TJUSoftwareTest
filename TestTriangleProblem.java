package cn.tjusic.st.Lab1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//public class TestTriangleProblem {
//    TriangleProblem tri;
//    @Before
//    public void set() {
//        tri = new TriangleProblem();
//    }
//
//    @Test
//    public void testLab() {
//        assertTrue(tri.findSolution(51));
//        assertTrue(tri.findSolution(23));
//        assertFalse(tri.findSolution(84));
//        assertTrue(tri.findSolution(2));
//        assertFalse(tri.findSolution(4));
//        assertFalse(tri.findSolution(35));
//    }
//}

@RunWith(Parameterized.class)
public class TestTriangleProblem {
    private Integer inputNumber;
    private Boolean expectedResult;
    private TriangleProblem tri;

    @Before
    public void initialize() {
        tri = new TriangleProblem();
    }

    public TestTriangleProblem(Integer inputNumber, Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection triangleProblen() {
        return Arrays.asList(new Object[][]{
                { 51, true },
                { 23, true },
                { 84, false },
                { 2, true },
                { 4, false },
                { 35, false }
        });
    }

    @Test
    public void testTriangleProblem() {
        System.out.println("Parameterized Number is : " + inputNumber);
        assertEquals(expectedResult, tri.findSolution(inputNumber));
    }
}
