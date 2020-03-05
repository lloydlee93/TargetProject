package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to handle reading barren land data and outputting area of fertile land.
 */
public class TargetProject {
    /**
     * Width of the land
     */
    private static final int WIDTH = 400;
    /**
     * Height of the land
     */
    private static final int HEIGHT = 600;

    /**
     * Main method to read from STDIN the coordinates of barren land and prints to STDOUT the fertile land.
     */
    public static void main(String args[]) {
        ArrayList<String> data = readFromSTDIN();
        List<int[]> barrenLandCoordinatesList = StringConverterUtility.getCoordinates(data);

        BarrenLandAnalysis barrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, barrenLandCoordinatesList);
        String fertileLand = barrenLandAnalysis.getFertileLandArea();

        System.out.println(String.format("List of fertile land is: %s.", fertileLand));
        System.out.println("***************************************************************************************************************");
        System.out.println("***************************************************************************************************************");
    }

    /**
     * Reads the data from STDIN.
     * @return an ArrayList of Strings from the data read from STDIN.
     */
    public static ArrayList<String> readFromSTDIN() {
        ArrayList<String> results = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        System.out.println("***************************************************************************************************************");
        System.out.println("***************************************************************************************************************");
        System.out.println("Please enter 4 coordinates for the barren rectangles that are separated by spaces. Enter Nothing once complete:");

        while(shouldContinue) {
            String input = scanner.nextLine();
            if(input.equals("")){
                scanner.close();
                shouldContinue = false;
            } else {
                results.add(input);
            }
        }

        return results;
    }
}



