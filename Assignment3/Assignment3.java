import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Assignment3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (with or without decimal fractions):");
        String input = scanner.nextLine();

        double[] numbers = Arrays.stream(input.split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println("Compute numeric statistics:");
        System.out.println(" 1) Calculate Mean");
        System.out.println(" 2) Calculate Median");
        System.out.println(" 3) Calculate Mode");
        System.out.println(" 4) Calculate Standard Deviation");
        System.out.println(" 5) Print All Computed Averages");
        System.out.println(" 6) Quit");

        System.out.print("What do you want to do? ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                double mean = calculateMean(numbers);
                System.out.println("The Mean is: " + mean);
                break;
            case 2:
                double median = calculateMedian(numbers);
                System.out.println("The Median is: " + median);
                break;
            case 3:
                double mode = calculateMode(numbers);
                System.out.println("The Mode is: " + mode);
                break;
            case 4:
                double stdDev = calculateStandardDeviation(numbers);
                System.out.println("The Standard Deviation is: " + stdDev);
                break;
            case 5:
                mean = calculateMean(numbers);
                median = calculateMedian(numbers);
                mode = calculateMode(numbers);
                stdDev = calculateStandardDeviation(numbers);
                System.out.println("The Mean is: " + mean);
                System.out.println("The Median is: " + median);
                System.out.println("The Mode is: " + mode);
                System.out.println("The Standard Deviation is: " + stdDev);
                break;
            case 6:
                System.out.println("The response is: Good Bye :)");
                break;
            default:
                System.out.println("The response is: Invalid option");
        }
    }

    private static double calculateMean(double[] numbers) {
        return DoubleStream.of(numbers).average().orElse(0.0);
    }

    private static double calculateMedian(double[] numbers) {
        Arrays.sort(numbers);
        int length = numbers.length;
        if (length % 2 == 0) {
            return (numbers[length / 2 - 1] + numbers[length / 2]) / 2.0;
        } else {
            return numbers[length / 2];
        }
    }

    private static double calculateMode(double[] numbers) {
        // Implement mode calculation logic here
        // You can return a string with the mode values separated by spaces
//        double mode = Arrays.stream(numbers).max().getAsDouble();
        // Create a map to store the counts of each element in the array.
        Map<Double, Double> counts = new HashMap<>();

        // Iterate over the array and count the occurrences of each element.
        for (double element : numbers) {
            double count = counts.getOrDefault(element, Double.valueOf(0));
            counts.put(element, count + 1);
        }

        // Find the element with the highest count.
        double maxValue = 0;
        double maxCount = 0;
        for (Map.Entry<Double, Double> entry : counts.entrySet()) {
            double count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                maxValue = entry.getKey();
            }
        }

        // Return the mode, numbers list if there is no mode.
        //Convert to string? Test inputs show it listing the whole set if no mode found...
        return maxCount > 1 ? maxValue : numbers[count];
//        return mode;
    }

    private static double calculateStandardDeviation(double[] numbers) {
        double mean = calculateMean(numbers);
        double sumOfSquares = DoubleStream.of(numbers)
                .map(num -> Math.pow(num - mean, 2))
                .sum();
        return Math.sqrt(sumOfSquares / (numbers.length - 1));
    }
}