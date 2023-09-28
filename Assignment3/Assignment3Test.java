package Assignment3;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Assignment3Test {

    @BeforeEach
    void setUp() {
        double[] numbers1 = {1,2,3,4,5,6};
        double[] numbers2 = {-100000,0,100000};
        double[] numbers3 = {1,2,2,1,3,3};

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGetMeanValue() {
        String numbers = "1 2 3";
        assertEquals("The Mean is: 2.0", Assignment3.compute(numbers, "Mean"));
    }

    @Test
    void testCalculateMedian() {
        String numbers = "1 1 2 3 4 4 5 5";
        assertEquals("The Median is: 3.5" , Assignment3.compute(numbers, "Median"));
    }

    @Test
    void testCalculateMode() {
        String numbers = "-1000000 0 1000000";
        assertEquals("The Mode is: -1000000 0 1000000", Assignment3.compute(numbers, "Mode"));
    }
}