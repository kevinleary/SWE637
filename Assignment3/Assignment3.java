// Leary Kattupalli Vanka - Assignment 3
package Assignment3; 

// package servlet;

/** *****************************************************************
 @author Jorge L Martinez & Jeff Offutt
 Spring 2023
 Accepts a list of numbers, and computes average;
 either the mean, median, or mode
  ********************************************************************* */
// Import Libraries to read inputs
import java.util.Scanner;
import java.util.HashSet;

// Import Java Libraries
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

//Import Servlet Libraries
// import javax.servlet.*;
// import javax.servlet.http.*;
// import javax.servlet.annotation.WebServlet;

//Import Regex Libraries
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//***********************************************************************
// @WebServlet(name = "computeAverage", urlPatterns = {"/computeAverage"})

public class Assignment3 {
// static String servletName = "computeAverage";

/** ====================================================
 ====================================================
 * Four methods to print the front screen.
 * doGet(), printHead(), printBody(), printTail()
 ====================================================
 ==================================================== **/

/** *****************************************************
 * Prints an HTML page with a blank form.
 * Front end method
 ********************************************************* */
// public void doGet (HttpServletRequest request, HttpServletResponse response)
//     throws ServletException, IOException
// {
//    response.setContentType("text/html");
//    PrintWriter out = response.getWriter();
//    PrintHead(out);
//    PrintBody(out, "1 2.5 3 4.5 5", ""); // example inputs
//    PrintTail(out);
// }  // End doGet

/** *****************************************************
 * Prints the <head> of the HTML page, separate from the <body>.
 * Front end method
 ********************************************************* */
// private void PrintHead (PrintWriter out)
// {
//    out.println("<html>");
//    out.println("<head>");
//    out.println(" <meta charset=\"UTF-8\">");
//    out.println(" <title>Compute average</title>");
//    out.println(" ");
//    out.println("</head>");
// }  // End PrintHead

/** *****************************************************
 * Prints the <body> of the initial HTML page before
 * the user request
 * Front end method
 ********************************************************* */
// private void PrintBody (PrintWriter out, String numbers, String resultStr)
// {
//    String cleanInput = Arrays.toString(sanitize(numbers).split(" "));
//    resultStr = "Sanitized input: " +cleanInput+ "\n" +resultStr;

//    out.println("<body style='background-color:#fff5e6'>");
//    out.println("<h1 style='text-align:center'>Compute numeric statistics</h1>");
//    out.println("<p>");
//    out.println("  This is a micro web app for class use.<br/>");
//    out.println("  Enter numbers (with or without decimal fractions).<br/>");
//    out.println("  Separate by commas, spaces, or new lines.<br/>");
//    out.println("  Non-numbers are ignored.<br/>");
//    out.println("</p>");
//    out.println("<hr>     ");
//    out.println("<form id='form1' style='text-align:center' name='form1' method='post' action='" +servletName+ "'>");

//    out.println("  <table align='center'>");
//    out.println("  <tr>");
//    out.println("    <td>");
//    out.println("      <label for='numbers' style='text-align:center;'>Enter numbers:&emsp;</label>");
//    out.println("    </td><td>");
//    out.println("      <textarea autofocus name='numbers' id='numbers' rows='5' cols='30' value='string' placeholder='Enter numbers here' >"+numbers+"</textarea><br/>");
//    out.println("  </td></tr>");
//    out.println("  <tr>");
//    out.println("    <td>");
//    out.println("    </td><td>");
//    out.println("      <input type='submit' name='Operation' value='Mean'/>");
//    out.println("      &emsp;"); // spacer
//    out.println("      <input type='submit' name='Operation' value='Median'/>");
//    out.println("      &emsp;");
//    out.println("      <input type='submit' name='Operation' value='Mode'/>");
//    out.println("      &emsp;");
//    out.println("      <input type='submit' name='Operation' value='Reset'/>");
//    out.println("  </td></tr>");
//    out.println("  </table>");

//    out.println("  <br/>");
//    out.println("  <br/>");
//    out.println("  <br/>");
//    out.println("  <label for='stringOutput' style='text-align:center;font-weight:bold;font-size:110%'> Result</label><br/>");
//    out.println("  <textarea name='stringOutput' id='stringOutput' cols='90' rows='10' placeholder='---' disabled>" +resultStr+ "  </textarea><br/> ");
//    out.println("</form>");
//    out.println("<br/><br/>");
//    out.println("<p style='font-weight:75%;color:gray'>Jorge Martinez &amp; Jeff Offutt</p>");
//    out.println("</body>");
// } // End PrintBody

/** *****************************************************
 * Prints the bottom of the HTML page.
 * Front end method
 ********************************************************* */
// private void PrintTail (PrintWriter out)
// {
//    out.println("");
//    out.println("</html>");
// } // End PrintTail

/** ====================================================
 ====================================================
 * 10 methods to process the inputs
 * 1 front end: doPost(),
 * 1 principal "main" method: compute()
 * 2 methods to clean up the inputs
 *   sanitize(), makeUniform()
 * 1 method to compute the mean
 *   getMeanValue()
 * 2 method to compute the median
 *   getMedianValue(), medianGetMidValue()
 * 3 method to compute the mode
 *   getModeList(), modeGetOrderedMode(), modePopulateMap()
 ====================================================
 ==================================================== **/
/** *****************************************************
 * Converts the values in the form,
 * performs the operation indicated,
 * sends the results back to the client.
 * Front end method
 ********************************************************* */
// public void doPost (HttpServletRequest request, HttpServletResponse response)
//     throws ServletException, IOException
// {
//    response.setContentType("text/html");
//    PrintWriter out = response.getWriter();

//    // get input data
//    String numbers = request.getParameter("numbers");
//    String resultStr   = request.getParameter("stringOutput");
//    String operation   = request.getParameter("Operation");

//    PrintHead(out);
//    if (operation.equals("Reset"))
//       PrintBody(out, "", ""); // reprint the form, blank
//    else
//    {
//       resultStr = compute(numbers, operation);
//       PrintBody(out, numbers, resultStr);
//    }
//    PrintTail(out);
// }  // End doPost

    /** *****************************************************
     * Converts the values in the form,
     * performs the operation indicated,
     * sends the results back to the client.
     * Back end method
     ********************************************************* */
    public static void compute(String[] args)
    {
        String numbers = "";
        int statType = 0;

        for (int i = 0; i < args.length; i++) {
            if ("-ln".equals(args[i]) || "--list-of-numbers".equals(args[i])) {
                if (i + 1 < args.length) {
                    numbers = args[i + 1];
                    i++; // Skip the next argument
                }
            } else if ("-sm".equals(args[i]) || "--statistics-mode".equals(args[i])) {
                if (i + 1 < args.length) {
                    try {
                        statType = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid arguments");
                        printHelpMessage();
                        return;
                    }
                    i++; // Skip the next argument
                }
            } else if ("-im".equals(args[i]) || "--interactive-mode".equals(args[i])) {
                interactiveMode();
                return; // Exit the program
            } else if ("-h".equals(args[i]) || "--help".equals(args[i])) {
                printHelpMessage();
                return; // Exit the program
            }
        }

        if (statType == 0) {
            System.out.println("Incorrect flags");
            printHelpMessage();
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("Missing arguments");
            printHelpMessage();
            return;
        }

        String cleanInputStr = sanitize(numbers);

        if (cleanInputStr.isEmpty()) {
            System.out.println("Missing argument(s)");
            printHelpMessage();
            return;
        }

        String[] cleanInput = cleanInputStr.split(" ");

        switch (statType) {
            case 1:
                double mean = getMeanValue(cleanInput);
                System.out.println("The Mean is: " + mean);
                break;
            case 2:
                double median = getMedianValue(cleanInput);
                System.out.println("The Median is: " + median);
                break;
            case 3:
                String mode = getModeList(cleanInput);
                System.out.println("The Mode is: " + mode);
                break;
            case 4:
                double stdDeviation = getStandardDeviationValue(cleanInput);
                System.out.println("The Standard Deviation is: " + stdDeviation);
                break;
            case 5:
                mean = getMeanValue(cleanInput);
                median = getMedianValue(cleanInput);
                mode = getModeList(cleanInput);
                stdDeviation = getStandardDeviationValue(cleanInput);
                System.out.println("The Mean is: " + mean);
                System.out.println("The Median is: " + median);
                System.out.println("The Mode is: " + mode);
                System.out.println("The Standard Deviation is: " + stdDeviation);
                break;
            default:
                System.out.println("Invalid option");
                printHelpMessage();
                break;
        }
    }

    /** *****************************************************
     * extracts valid strings and returns them in a single space separated string
     * @param s raw unfiltered string
     * @return returns valid String or empty string if initial is less than 1
     * Back end method
     ********************************************************* */
    public static String sanitize(String s)
    {
        String allowedChars = "(-?[0-9]+\\.[0-9]+)|(-?[0-9]+)"; // allows decimals 12.0 12.00 etc only
        Pattern pattern = Pattern.compile(allowedChars);
        Matcher matcher = pattern.matcher(s);
        String cleanList = "";
        while (matcher.find())
        {
            cleanList = cleanList+ ' ' +(matcher.group());
        }
        return (cleanList.length()<1)?"":cleanList.substring(1).trim().replaceAll(" +", " ");
    }

    /** *****************************************************
     * modifies incoming array, replacing all .0 by integer representation
     * @param numbers arrays with ints or doubles
     * Back end method
     ********************************************************* */
    public static void makeUniform(String [] numbers)
    {
        for (int i=0 ; i< numbers.length; i++)
        {
            double db = Double.parseDouble(numbers[i]);
            numbers[i] = (0==(db - (int)db))? // if its a double of the form _.0
                    (int)db + "": // then grab the integer part and use that
                    db + ""; // it was _.xxxx so it was a double and should stay
        }
    }

    /** *****************************************************
     * @requires array not empty, otherwise the mean will be zero
     * @param numbers array of int numbers in a string format
     * @return the mean or average sum of all numbers divided by number of values
     * Back end method
     ********************************************************* */
    public static double getMeanValue(String [] numbers) throws ArithmeticException
    {
        double total = 0.0;
        if (numbers.length < 1)
            return 0;
        for (String i : numbers)
        {
            total += Double.parseDouble(i);
            if (total == Double.POSITIVE_INFINITY || total == Double.NEGATIVE_INFINITY)
            {
                throw new ArithmeticException("overflow");
            }
        }
        return(total/numbers.length);
    }

    /** *****************************************************
     * Returns the median of an array of numbers
     * Back end method
     ********************************************************* */
    public static double getMedianValue(String [] numbers)
    {
        List <Double> doubleList = new ArrayList<>();
        for (String i : numbers)
            doubleList.add(Double.parseDouble(i));
        Collections.sort(doubleList);
        int sz = doubleList.size();
        switch (sz)
        {
            case 0: //empty list
                return 0.0;
            case 1:
                return doubleList.get(0); // only one value
        }
        if  (sz % 2 == 0) // the list length is even;
            return medianGetMidValue(doubleList, sz);
        // length is odd so just return the element in the the middle
        return doubleList.get(sz/2);
    }  // end getMedianValue()

    /** *****************************************************
     * @param doubleList list of doubles
     * @param sz size of the list
     * @return the mid value of 2 numbers
     * Back end method
     ********************************************************* */
    private static double medianGetMidValue(List<Double> doubleList, int sz)
    {
        double left  = doubleList.get(sz/2-1);
        double right = doubleList.get(sz/2);
        if (left == right)
            return left; // could return either
        //since they are different subtract the smaller from the larger
        double difference = (left > right)? left-right : right-left;
        return (left > right)? right+(difference/2) : left+(difference/2);
    }

    /** *****************************************************
     * @param numbers String [] of decimal or int values
     * @return an array of numbers that occur the most often
     * Back end method
     ********************************************************* */
    public static String getModeList(String [] numbers)
    {
        Map <String,Integer> map = new HashMap<>();
        String mode = "";
        makeUniform(numbers);
        modePopulateMap(numbers, map);
        Integer max =  Collections.max(map.values());
        for (String k : map.keySet())
        {
            mode = (map.get(k)==max)? mode + " " + k:mode;
        }
        return modeGetOrderedMode(mode);
    }

    /** *****************************************************
     * @param mode unordered mode as a String
     * @return mode in an array in order
     * Back end method
     ********************************************************* */
    public static String modeGetOrderedMode(String mode)
    {
        String [] arr = mode.trim().split(" ");
        List <Double> l = new ArrayList<>();
        for (String s : arr)
        {
            l.add(Double.parseDouble(s));
        }
        Collections.sort(l);
        for (int i=0 ; i<l.size() ; i++)
        {
            arr[i] = l.get(i)+"";
        }
        makeUniform(arr);
        return(Arrays.toString(arr).
                replace("[", "").
                replace("]", "").
                replace(",", " ").
                replaceAll(" +", " "));
    }

    public static double getStandardDeviationValue(String[] numbers) {
        if (numbers.length < 2) {
            return 0.0; // Standard deviation is undefined for less than two numbers
        }

        double mean = getMeanValue(numbers); // Calculate the mean
        double sumOfSquaredDifferences = 0.0;

        for (String numStr : numbers) {
            double num = Double.parseDouble(numStr);
            double difference = num - mean;
            sumOfSquaredDifferences += difference * difference;
        }

        double variance = sumOfSquaredDifferences / (numbers.length);
        return (double) Math.round(Math.sqrt(variance) * 100)/100; // Standard deviation is the square root of the variance
    }

    /** *****************************************************
     * @param numbers input array with string representing numbers
     * @param map the map that will be created with the number that represents the
     *      number of times the value appears in the original Array.
     * Back end method
     ********************************************************* */
    public static void modePopulateMap(String[] numbers, Map<String, Integer> map)
    {
        for (String s : numbers)
        {
            if(map.containsKey(s)) // key was present
                map.put(s, map.get(s)+1);
            else
                map.put(s,1);
        }
    }

    public static void printHelpMessage() {
        System.out.println("java computeAverageCLI");
        System.out.println("   Arguments");
        System.out.println("       -ln, --list-of-numbers");
        System.out.println("              List of numbers to compute statistics with");
        System.out.println("       -sm, --statistics-mode");
        System.out.println("              Statitics to apply to the list of numbers. Options are:");
        System.out.println("              1. Calculate Mean");
        System.out.println("              2. Calculate Median");
        System.out.println("              3. Calculate Mode");
        System.out.println("              4. Print All Computed Averages");
        System.out.println("   -im, --interactive-mode");
        System.out.println("          Enter interactive mode for real-time input and calculations");
        System.out.println("       -h, --help");
        System.out.println("              Prints this message");
    }

    public static void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers (with or without decimal fractions):");
        String inputNumbers = scanner.nextLine();

        String[] cleanInput = sanitize(inputNumbers).split(" ");

//        while (true) {
            System.out.println("Compute numeric statistics:");
            System.out.println("  1) Calculate Mean");
            System.out.println("  2) Calculate Median");
            System.out.println("  3) Calculate Mode");
            System.out.println("  4) Calculate Standard Deviation");
            System.out.println("  5) Print All Computed Averages");
            System.out.println("  6) Quit");
            System.out.print("What do you want to do? ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                Double.parseDouble(cleanInput[0]);
            } catch(Exception NumberFormatException) {
                return;
            }

            switch (choice) {
                case 1:
                    double mean = getMeanValue(cleanInput);
                    System.out.println("The Mean is: " + mean);
                    break;
                case 2:
                    double median = getMedianValue(cleanInput);
                    System.out.println("The Median is: " + median);
                    break;
                case 3:
                    String mode = getModeList(cleanInput);
                    System.out.println("The Mode is: " + mode);
                    break;
                case 4:
                    double stdDeviation = getStandardDeviationValue(cleanInput);
                    System.out.println("The Standard Deviation is: " + stdDeviation);
                    break;
                case 5:
                    mean = getMeanValue(cleanInput);
                    median = getMedianValue(cleanInput);
                    mode = getModeList(cleanInput);
                    stdDeviation = getStandardDeviationValue(cleanInput);
                    System.out.println("The Mean is: " + mean);
                    System.out.println("The Median is: " + median);
                    System.out.println("The Mode is: " + mode);
                    System.out.println("The Standard Deviation is: " + stdDeviation);
                    break;
                case 6:
                    System.out.println("The response is: Good Bye :)");
                    return;
                default:
                    System.out.println("The response is: Invalid option");
                    break;
            }
//        }
    }
    public static void main(String[] args) {
        compute(args);

    }

}  // End class
