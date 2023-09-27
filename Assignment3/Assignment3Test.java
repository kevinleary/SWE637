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
    void testCalculateMean() {
        double[] numbers = {1, 1, 2, 3, 4, 4, 5, 5};
//        double[] numbers = {1,2,2,1,3,3};

        Assignment3.calculateMean(numbers);
        assertEquals(3.125, Assignment3.calculateMean(numbers));
    }

    @Test
    void testCalculateMedian() {
        double[] numbers = {1, 1, 2, 3, 4, 4, 5, 5};
//        double[] numbers = {-1000000, 0, 1000000};

        Assignment3.calculateMedian(numbers);
        assertEquals(3.5 , Assignment3.calculateMedian(numbers));
    }

    @Test
    void testCalculateMode() {
        double[] numbers = {-1000000, 0, 1000000};

        Assignment3.calculateMode(numbers);
        assertEquals(-1000000, 0, 1000000 , Assignment3.calculateMode(numbers));
    }

    @Test
    void testCalculateStandardDeviation() {

    }
}