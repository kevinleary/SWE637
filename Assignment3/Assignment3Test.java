package Assignment3;

import static org.junit.Assert.*;
import org.junit.Test;

public class Assignment3Test {

    // This test passes
    @Test
    public void testPrintHelpMessage() {
        // Since printHelpMessage() only prints to the console, we cannot assert its output.
        // We can only ensure it does not throw any exceptions when called.
        Assignment3.printHelpMessage();
    }

    // This test passes
    @Test
    public void testSanitize() {
        String input = "1, 2.5, abc, 3.0, 4.5";
        String cleaned = Assignment3.sanitize(input);
        assertEquals("1 2.5 3.0 4.5", cleaned);
    }

    // This test passes
    @Test
    public void testGetMeanValue() {
        String[] numbers = {"1", "2", "3"};
        double result = Assignment3.getMeanValue(numbers);
        assertEquals(2.0, result, 0.001);
    }

    // This test passes
    @Test
    public void testGetMedianValue() {
        String[] numbers = {"1", "2", "3", "4", "5"};
        double result = Assignment3.getMedianValue(numbers);
        assertEquals(3.0, result, 0.001);
    }

    // This test passes
    @Test
    public void testMedianGetMidValue() {
        // This method is private, so we'll indirectly test it through getMedianValue()
        String[] numbers = {"1", "2", "3", "4"};
        double result = Assignment3.getMedianValue(numbers);
        assertEquals(2.5, result, 0.001);
    }

    // This test passes
    @Test
    public void testGetModeList() {
        String[] numbers = {"1", "2", "2", "3", "4", "4", "5"};
        String result = Assignment3.getModeList(numbers);
        assertEquals("2 4", result);
    }

    // This test passes
    @Test
    public void testMakeUniform() {
        // This method is called within getModeList(), so we'll indirectly test it
        String[] numbers = {"1.0", "2.0", "3.0"};
        Assignment3.makeUniform(numbers);
        assertArrayEquals(new String[]{"1", "2", "3"}, numbers);
    }

    // This test passes
    @Test
    public void testModePopulateMap() {
        // This method is called within getModeList(), so we'll indirectly test it
        String[] numbers = {"1", "2", "2", "3", "4", "4", "4", "5"};
        Assignment3.makeUniform(numbers);
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        Assignment3.modePopulateMap(numbers, map);
        assertEquals(1, (int) map.get("1"));
        assertEquals(2, (int) map.get("2"));
        assertEquals(1, (int) map.get("3"));
        assertEquals(3, (int) map.get("4"));
        assertEquals(1, (int) map.get("5"));
    }

    // This test passes
    @Test
    public void testModeGetOrderedMode() {
        // This method is called within getModeList(), so we'll indirectly test it
        String mode = "2 4 1 3";
        String result = Assignment3.modeGetOrderedMode(mode);
        assertEquals("1 2 3 4", result);
    }

    // This test passes
    @Test
    public void testGetStandardDeviationValue() {
        String[] numbers = {"1", "2", "3", "4", "5"};
        double result = Assignment3.getStandardDeviationValue(numbers);
        assertEquals(1.41, result, 0.001); // Approximately square root of 2
    }
}